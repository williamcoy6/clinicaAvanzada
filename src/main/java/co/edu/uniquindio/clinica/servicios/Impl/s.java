package co.edu.uniquindio.clinica.servicios.Impl;

import co.edu.uniquindio.clinica.dto.PQRS.*;
import co.edu.uniquindio.clinica.modelo.entidades Cuenta;
import co.edu.uniquindio.clinica.modelo.entidades.Mensaje;
import co.edu.uniquindio.clinica.modelo.entidades.Pqrs;
import co.edu.uniquindio.clinica.modelo.enums.EstadoPQRS;
import co.edu.uniquindio.clinica.Repositorios.*;
import co.edu.uniquindio.clinica.servicios.interfaces.PQRSServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PQRSServicioImpl implements PQRSServicio {

    private final PQRSRepo pqrsRepo;
    private final PacienteRepo pacienteRepo;
    private final MensajeRepo mensajeRepo;
    private final CuentaRepo cuentaRepo;
    private final CitaRepo citaRepo;

    @Override
    public List<ItemPQRSAdminDTO> listarPQRS() {
        List<Pqrs> listaPqrs = pqrsRepo.findAll();
        List<ItemPQRSAdminDTO> respuesta = new ArrayList<>();

        for (Pqrs p : listaPqrs) {
            respuesta.add(new ItemPQRSAdminDTO(
                    p.getCodigo(),
                    p.getCita().getPaciente().getNombre(),
                    p.getFechaCreacion(),
                    p.getEstado()
            ));
        }

        return respuesta;
    }

    @Override
    public void cambiarEstadoPQRS(int codigoPQRS, EstadoPQRS estadoPQRS) throws Exception {
        Optional<Pqrs> opcional = pqrsRepo.findById(codigoPQRS);

        if (opcional.isEmpty()) {
            throw new Exception("No existe un PQRS con el código " + codigoPQRS);
        }

        Pqrs pqrs = opcional.get();
        pqrs.setEstado(estadoPQRS);

        pqrsRepo.save(pqrs);
    }

    @Override
    public List<ItemPQRSPacienteDTO> listarPQRSPaciente(int codigoPaciente) throws Exception {

        if (pacienteRepo.findById(codigoPaciente).isEmpty()){
            throw new Exception("No hay pacientes registrados con ese codigo");
        }
        List<Pqrs> listaPqrs = pqrsRepo.listarPqrsPendiente(codigoPaciente);
        if (listaPqrs.isEmpty()){
            throw new Exception("EL paciente no tiene pqrs registradas");
        }
        return listaPqrs.stream().map(pq -> new ItemPQRSPacienteDTO(
                pq.getCodigo(),
                pq.getEstado(),
                pq.getMotivo(),
                pq.getFechaCreacion()
        )).toList();
    }

    @Override
    public int crearPQRS(RegistroPQRSDTO registroPQRSDTO){

        if (registroPQRSDTO.codigoCita() <= 0) {
            throw new IllegalArgumentException("El código de cita debe ser un valor positivo.");
        }

        if (registroPQRSDTO.mensaje() == null || registroPQRSDTO.mensaje().isEmpty()) {
            throw new IllegalArgumentException("El mensaje no puede estar vacío.");
        }

        if (citaRepo.findById(registroPQRSDTO.codigoCita()).isEmpty()) {
            throw new IllegalArgumentException("No existe una cita con el codigo enviado");
        }

        Pqrs pqrs = new Pqrs();
        pqrs.setMotivo(registroPQRSDTO.mensaje());
        pqrs.setFechaCreacion(LocalDateTime.now());
        pqrs.setEstado(EstadoPQRS.EN_PROCESO);
        pqrs.setCita(citaRepo.getReferenceById(registroPQRSDTO.codigoCita()));

        pqrsRepo.save(pqrs);
        return 1;
    }

    @Override
    public DetallePQRSDTO verDetallePQRS(int codigoPQRS) throws Exception {
        Optional<Pqrs> opcional = pqrsRepo.findById(codigoPQRS);

        if (opcional.isEmpty()) {
            throw new Exception("No existe un PQRS con el código " + codigoPQRS);
        }

        Pqrs buscado = opcional.get();
        List<Mensaje> mensajes = mensajeRepo.findAllByPqrsCodigo(codigoPQRS);

        return new DetallePQRSDTO(
                buscado.getCodigo(),
                buscado.getFechaCreacion(),
                buscado.getCita().getCodigo(),
                buscado.getCita().getPaciente().getNombre(),
                buscado.getCita().getMedico().getNombre(),
                buscado.getMotivo(),
                buscado.getEstado(),
                convertirRespuestasDTO(mensajes)
        );
    }

    private List<RespuestaDTO> convertirRespuestasDTO(List<Mensaje> mensajes) {
        return mensajes.stream().map(m -> new RespuestaDTO(
                m.getCodigo(),
                m.getCuenta().getCorreo(),
                m.getFechaCreacion(),
                m.getMensaje()
        )).toList();
    }

    @Override
    public int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception {
        Optional<Pqrs> opcionalPQRS = pqrsRepo.findById(registroRespuestaDTO.codigoPQRS());

        if (opcionalPQRS.isEmpty()) {
            throw new Exception("No existe un PQRS con el código " + registroRespuestaDTO.codigoPQRS());
        }

        Optional<Cuenta> opcionalCuenta = cuentaRepo.findById(registroRespuestaDTO.codigoCuenta());

        if (opcionalCuenta.isEmpty()) {
            throw new Exception("No existe una cuenta con el código " + registroRespuestaDTO.codigoCuenta());
        }

        Optional<Mensaje> opcionalMensaje = mensajeRepo.findById(registroRespuestaDTO.codigoMensaje());

        Mensaje mensajeNuevo = new Mensaje();
        mensajeNuevo.setPqrs(opcionalPQRS.get());
        mensajeNuevo.setFechaCreacion(LocalDateTime.now());
        mensajeNuevo.setCuenta(opcionalCuenta.get());
        mensajeNuevo.setMensaje(registroRespuestaDTO.mensaje());
        if (opcionalMensaje.isEmpty()) {
            mensajeNuevo.setMensajePadre(null);
        } else {
            mensajeNuevo.setMensajePadre(opcionalMensaje.get());
        }

        Mensaje respuesta = mensajeRepo.save(mensajeNuevo);

        return respuesta.getCodigo();
    }

}