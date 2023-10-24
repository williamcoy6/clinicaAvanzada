package co.edu.uniquindio.clinica.servicios.Impl;

import co.edu.uniquindio.clinica.Repositorios.*;
import co.edu.uniquindio.clinica.dto.Cita.EmailDTO;
import co.edu.uniquindio.clinica.dto.paciente.*;
import co.edu.uniquindio.clinica.modelo.Entidades.*;
import co.edu.uniquindio.clinica.modelo.Enum.Eps;
import co.edu.uniquindio.clinica.modelo.Enum.EstadoCita;
import co.edu.uniquindio.clinica.modelo.Enum.EstadoPqrs;
import co.edu.uniquindio.clinica.servicios.interfaces.EmailServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.PacienteServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PacienteServicioImpl implements PacienteServicio {

    private final PacienteRepo pacienteRepo;
    private final EpsRepo epsRepo;
    private final CitaRepo citaRepo;
    private final MedicoRepo medicoRepo;
    private final AdministradorRepo administradorRepo;
    private final PQRSRepo pqrsRepo;
    private final EmailServicio emailServicio;
    private final RespuestaAdminRepo respuestaAdminRepo;
    private final AnswerPatRepo answerPatRepo;

    private Eps buscarEps(int eps) {
        return epsRepo.buscarEps(eps);
    }
    private boolean estaRepetidaCedula(String cedula) { return pacienteRepo.buscarPorCedula(cedula) != null;}
    private boolean estaRepetidoCorreo(String correo) { return pacienteRepo.buscarPorCorreo(correo) != null;}

    @Override
    public int registrarse(RegistroPacienterDTO userDTO) throws Exception {

        Paciente paciente = new Paciente();

        if (estaRepetidaCedula(userDTO.cedula())) {
            throw new Exception("La cédula ya se encuentra registrada");
        }
        if (estaRepetidoCorreo(userDTO.correo())) {
            throw new Exception("El correo ya se encuentra registrado");
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordEncriptada = passwordEncoder.encode(userDTO.contrasena());

        paciente.setContrasena(passwordEncriptada);
        paciente.setCorreo(userDTO.correo());
        paciente.setNombre(userDTO.nombre());
        paciente.setCedula(userDTO.cedula());
        // paciente.setCorreo(userDTO.correo());
        paciente.setCelular(userDTO.celular());
        // paciente.setContrasena(userDTO.contrasena());
        paciente.setUrlFoto(userDTO.urlFoto());
        paciente.setCiudad(userDTO.ciudad());
        paciente.setAlergias(userDTO.alergias());
        paciente.setFechaNacimiento(userDTO.fechaNacimiento());

        Paciente pacienteNew = pacienteRepo.save(paciente);

        return pacienteNew.getCodigo();
    }

    @Override
    public int editarPerfil(int codigo, DetallePacienteDTO detallePacienteDTO) throws Exception {

        Optional<Paciente> opcional = pacienteRepo.findById(codigo);
        Paciente buscado = opcional.get();

        if (opcional.isEmpty()) {
            throw new Exception("No existe un paciente con el codigo: " + codigo);
        }

        if (estaRepetidoCorreo(detallePacienteDTO.correo()) && (!buscado.getCorreo().equals(detallePacienteDTO.correo()))) {
            throw new Exception("El correo ya se encuentra registrado");
        }
        if (estaRepetidaCedula(detallePacienteDTO.cedula()) && (!buscado.getCedula().equals(detallePacienteDTO.cedula()))) {
            throw new Exception("La cedula ya se encuentra registrada");
        }

        buscado.setCelular(detallePacienteDTO.telefono());
        buscado.setNombre(detallePacienteDTO.nombre());
        buscado.setCedula(detallePacienteDTO.cedula());
        buscado.setUrlFoto(detallePacienteDTO.urlFoto());
        buscado.setEps(buscarEps(detallePacienteDTO.eps().ordinal())); // por definir
        buscado.setAlergias(detallePacienteDTO.alergias());
        buscado.setFechaNacimiento(detallePacienteDTO.fechaNacimiento());
        buscado.setTipoSangre(detallePacienteDTO.tipoSangre());
        buscado.setCiudad(detallePacienteDTO.ciudad());
        buscado.setCorreo(detallePacienteDTO.correo());

        pacienteRepo.save(buscado);

        return buscado.getCodigo();
    }

    @Override
    public void eliminarCuenta(int cedula) throws Exception {

        Optional<Paciente> optional = pacienteRepo.findById(cedula);

        if (optional.isEmpty()) {
            throw new Exception("No hay un usuario con la cedula: " + cedula);
        }

        Paciente buscado = optional.get();
        pacienteRepo.delete(buscado);
    }

    @Override
    public int agendarCita(CitaPacienteDTO citaDTO) throws Exception {

        Optional<Medico> medico = medicoRepo.findById(citaDTO.codigoMedico());
        Optional<Paciente> paciente = pacienteRepo.findById(citaDTO.codigoPaciente());

        if (medico.isEmpty()) {
            throw new Exception("No existe el medico con el código " + citaDTO.codigoMedico());
        }
        if (paciente.isEmpty()) {
            throw new Exception("No existe el  paciente con código " + citaDTO.codigoPaciente());
        }
        long numeroCitasActivas = citaRepo.countAllByPacienteIdAndEstadoCita(citaDTO.codigoPaciente(), EstadoCita.PENDIENTE);

        if (numeroCitasActivas >= 3) {
            throw new Exception("El numero de citas ha programar, máximo pueden ser 3");
        }

        Cita citaNueva = new Cita();

        citaNueva.setMotivo(citaDTO.motivo());
        citaNueva.setFechaCreacion(LocalDateTime.now());
        citaNueva.setFechaCita(citaDTO.fecha());
        citaNueva.setMedico(medico.get());
        citaNueva.setPaciente(paciente.get());
        citaNueva.setEstadoCita(EstadoCita.PENDIENTE);

        Cita citaRegistrada = citaRepo.save(citaNueva);

        emailServicio.EnviarEmail(new EmailDTO("Agendamiento de Cita", paciente.get().getCorreo(), "Haz agendado una cita para el " + citaRegistrada.getFechaCita() + " Motivo: " + citaRegistrada.getMotivo() + " con el especialista en " + citaRegistrada.getMedico().getEspecializacion() + " " + citaRegistrada.getMedico().getNombre()));

        emailServicio.EnviarEmail(new EmailDTO("Agendamiento de Cita", medico.get().getCorreo(), "Se ha agendada " + citaRegistrada.getFechaCita() + " Motivo: " + citaRegistrada.getMotivo() + " Nombre del Paciente: " + paciente.get().getNombre()));

        return citaRegistrada.getCodigo();
    }

    @Override
    public int crearPQRS(PqrsPacienteDTO pqrsPacienteDTO) throws Exception {

        List<Administrador> administradorList = administradorRepo.findAll();

        if (administradorList.isEmpty()) {
            throw new Exception("No hay administradores");
        }

        Optional<Cita> opcional = citaRepo.findById(pqrsPacienteDTO.codigoCita());

        if (opcional.isEmpty()) {
            throw new Exception("No existe la cita con el código " + pqrsPacienteDTO.codigoCita());
        }

        List<Pqrs> pqrsList = pqrsRepo.findAllByCita_Paciente_IdAndEstadoPqrsEquals(opcional.get().getPaciente().getCodigo(), EstadoPqrs.NUEVO);

        if (pqrsList.size() >= 2) {
            throw new Exception("Solo puedes tener 2 pqrs por el momento");
        }

        Pqrs pqrsNew = new Pqrs();
        Cita buscado = opcional.get();

        pqrsNew.setEstadoPqrs(EstadoPqrs.NUEVO);
        pqrsNew.setFechaCreacion(LocalDateTime.now());
        pqrsNew.setMotivo(pqrsPacienteDTO.motivo());
        pqrsNew.setCita(buscado);

        Pqrs pqrsRegistrada = pqrsRepo.save(pqrsNew);

        for (Administrador admin : administradorList) {
            emailServicio.EnviarEmail(new EmailDTO("Nuevo PQRS", admin.getCorreo(), pqrsRegistrada.getMotivo()));
        }

        return pqrsRegistrada.getCodigo();

    }

    @Override
    public int responderPQRS(RespuestaPacientePqrsDTO respuestaPacientePqrsDTO) throws Exception {

        Optional<Pqrs> opcionalPqrs = pqrsRepo.findById(respuestaPacientePqrsDTO.codigoPqrs());
        if (opcionalPqrs.isEmpty()) { throw new Exception("No existe este pqrs"); }

        Optional<RespuestaAdmin> respuestaAdmin = respuestaAdminRepo.findById(respuestaPacientePqrsDTO.respuestaAdmin());
        if (respuestaAdmin.isEmpty()) { throw new Exception("No existe una respuesta con ese código"); }

        Optional<Paciente> paciente = pacienteRepo.findById(respuestaPacientePqrsDTO.codigoPaciente());
        if (paciente.isEmpty()) { throw new Exception("No existe el paciente"); }

        if (opcionalPqrs.get().getEstadoPqrs().equals(EstadoPqrs.EN_PROCESO)) {

            Paciente buscadoPaciente = paciente.get();
            RespuestaAdmin answerAdmin = respuestaAdmin.get();
            RespuestaPaciente answerPaci = new RespuestaPaciente();

            answerPaci.setRespuestaAdmin(answerAdmin);
            answerPaci.setFecha(LocalDateTime.now());
            answerPaci.setPqrs(opcionalPqrs.get());
            answerPaci.setMensaje(respuestaPacientePqrsDTO.mensaje());

            answerPaci.setPaciente(buscadoPaciente);

            RespuestaPaciente respuestaPacienteRegistrada = answerPatRepo.save(answerPaci);

            emailServicio.EnviarEmail(new EmailDTO("Respuesta al paciente", answerAdmin.getAdministrador().getCorreo(), respuestaPacienteRegistrada.getMensaje()));

            return respuestaPacienteRegistrada.getId();

        } else {
            throw new Exception("Su estado es: " + opcionalPqrs.get().getEstadoPqrs()+ " por lo tanto no es posible una respuesta");
        }
    }

    @Override
    public List<ItemCitaPacienteDTO> listarCitasPaciente(int codigoPaciente) throws Exception {

        List<Cita> citasPaciente = citaRepo.findByPaciente_Codigo(codigoPaciente);

        if (citasPaciente.isEmpty()) {
            throw new Exception("No hay citas");
        }

        List<ItemCitaPacienteDTO> respuesta = new ArrayList<>();

        for (Cita cita : citasPaciente) {
            respuesta.add(new ItemCitaPacienteDTO(cita.getMotivo(), cita.getFechaCreacion(), cita.getFechaCita(), cita.getEstadoCita(), cita.getMedico().getNombre()));
        }

        return respuesta;
    }



    @Override
    public void filtrarCitasPorFecha() throws Exception {

    }
    @Override
    public void enviarLinkRecuperacion() throws Exception {

    }@Override
    public void listarPQRSPaciente() throws Exception {

    }
    @Override
    public void cambiarPassword() throws Exception {

    }
    @Override
    public void filtrarCitasPorMedico() throws Exception {

    }
    @Override
    public void verDetalleCita() throws Exception {

    }


}

