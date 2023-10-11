package co.edu.uniquindio.clinica.servicios.Impl;

import co.edu.uniquindio.clinica.Repositorios.EpsRepo;
import co.edu.uniquindio.clinica.Repositorios.PacienteRepo;
import co.edu.uniquindio.clinica.dto.paciente.DetallePacienteDTO;
import co.edu.uniquindio.clinica.dto.paciente.RegistroPacienterDTO;
import co.edu.uniquindio.clinica.modelo.Eps;
import co.edu.uniquindio.clinica.modelo.Paciente;
import co.edu.uniquindio.clinica.servicios.interfaces.PacienteServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PacienteServicioImpl implements PacienteServicio {

    private final PacienteRepo pacienteRepo;
    private final EpsRepo epsRepo;

    @Override
    public int registrarse(RegistroPacienterDTO userDTO) throws Exception {
        /*
        if( estaRepetidaCedula(userDTO.cedula()) ){
            throw new Exception("La cédula ya se encuentra registrada");
        }
        if( estaRepetidoCorreo(userDTO.correo()) ){
            throw new Exception("El correo ya se encuentra registrado");
        */
        Paciente paciente = new Paciente();

        paciente.setNombre(userDTO.nombre());
        paciente.setCedula(userDTO.cedula());
        paciente.setCorreo(userDTO.correo());
        paciente.setCelular(userDTO.celular());
        paciente.setContrasena(userDTO.contrasena());
        paciente.setUrlFoto(userDTO.urlFoto());
        paciente.setCiudad(userDTO.ciudad());
        paciente.setAlergias(userDTO.alergias());
        paciente.setFechaNacimiento(userDTO.fechaNacimiento());

        Paciente pacienteNew = pacienteRepo.save(paciente);

        return pacienteNew.getCodigo();
    }

    /*
    private boolean estaRepetidaCedula(String cedula) {
        return pacienteRepo.findByCedula(cedula) != null;
    }
    private boolean estaRepetidoCorreo(String correo) {
        return pacienteRepo.findByCedula(correo) != null;
    }
    */
    private Eps buscarEps(int eps) {
        return epsRepo.buscarEps(eps);
    }

    @Override
    public int editarPerfil(int codigo, DetallePacienteDTO detallePacienteDTO) throws Exception {

        Optional<Paciente> opcional = pacienteRepo.findById(codigo);

        if (opcional.isEmpty()) {
            throw new Exception("No existe un paciente con el codigo: " + codigo);
        }

        Paciente buscado = opcional.get();

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

        if(optional.isEmpty()){
            throw new Exception ("No hay un usuario con la cedula: "+ cedula);
        }

        Paciente buscado = optional.get();
        pacienteRepo.delete(buscado);
    }


    @Override
    public void enviarLinkRecuperacion() throws Exception {

    }

    @Override
    public void cambiarPassword() throws Exception {

    }

    @Override
    public void agendarCita() throws Exception {

    }

    @Override
    public void crearPQRS() throws Exception {

    }

    @Override
    public void listarPQRSPaciente() throws Exception {

    }

    @Override
    public void responderPQRS() throws Exception {

    }

    @Override
    public void listarCitasPaciente() throws Exception {

    }

    @Override
    public void filtrarCitasPorFecha() throws Exception {

    }

    @Override
    public void filtrarCitasPorMedico() throws Exception {

    }

    @Override
    public void verDetalleCita() throws Exception {

    }


}

