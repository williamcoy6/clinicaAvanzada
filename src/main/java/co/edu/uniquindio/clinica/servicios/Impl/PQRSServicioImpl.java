
package co.edu.uniquindio.clinica.servicios.Impl;


import co.edu.uniquindio.clinica.Repositorios.*;
import co.edu.uniquindio.clinica.dto.PQRS.*;
import co.edu.uniquindio.clinica.modelo.Entidades.Pqrs;
import co.edu.uniquindio.clinica.modelo.Enum.EstadoPqrs;
import co.edu.uniquindio.clinica.servicios.interfaces.PqrsServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PQRSServicioImpl implements PqrsServicio {

    private final PQRSRepo pqrsRepo;
    //private final PacienteRepo pacienteRepo;
    //private final MensajeRepo mensajeRepo;
    //private final CuentaRepo cuentaRepo;
    //private final CitaRepo citaRepo;


    @Override
    public List<ItemPqrsAdminDTO> listarPQRS() {
        List<Pqrs> listaPqrs = pqrsRepo.findAll();
        List<ItemPqrsAdminDTO> respuesta = new ArrayList<>();

        for (Pqrs p : listaPqrs) {
            respuesta.add(new ItemPqrsAdminDTO(
                    p.getCodigo(),
                    p.getEstadoPqrs(),
                    p.getFechaCreacion(),
                    p.getCita().getPaciente().getNombre()
            ));
        }

        return respuesta;
    }
/*
    @Override
    public void cambiarEstadoPQRS(int codigoPQRS, EstadoPqrs estadoPQRS) throws Exception {
        Optional<Pqrs> opcional = pqrsRepo.findById(codigoPQRS);

        if (opcional.isEmpty()) {
            throw new Exception("No existe un PQRS para este caso " + codigoPQRS);
        }

        Pqrs pqrs = opcional.get();
        pqrs.setEstadoPqrs(estadoPQRS);

        pqrsRepo.save(pqrs);
    }

    @Override
    public List<ItemPqrsPacDTO> listarPQRSPaciente(int codigoPaciente) throws Exception {

        if (pacienteRepo.findById(codigoPaciente).isEmpty()) {
            throw new Exception("No hay pacientes registrados con ese codigo");
        }
        List<Pqrs> listaPqrs = pqrsRepo.listarPqrsPendiente(codigoPaciente);
        if (listaPqrs.isEmpty()) {
            throw new Exception("EL paciente no tiene pqrs registradas");
        }
        return listaPqrs.stream().map(pq -> new ItemPqrsPacDTO(
                pq.getCodigo(),
                pq.getEstadoPqrs(),
                pq.getMotivo(),
                pq.getFechaCreacion()
        )).toList();
    }

    @Override
    public int crearPQRS(RegistroRespuestaDTO registroPQRSDTO) throws Exception {
        return 0;
    }

    @Override
    public int respuestaPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception {
        return 0;
    }


    @Override
    public int crearPQRS(RegistroPqrsDTO registroPQRSDTO) {

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
        pqrs.setEstadoPqrs(EstadoPqrs.EN_PROCESO);
        pqrs.setCita(citaRepo.getReferenceById(registroPQRSDTO.codigoCita()));

        pqrsRepo.save(pqrs);
        return 1;
    }



    @Override
    public InfoPQRSDTO2 verDetallePQRS(int codigoPQRS) throws Exception {
        Optional<Pqrs> opcional = pqrsRepo.findById(codigoPQRS);

        if (opcional.isEmpty()) {
            throw new Exception("No existe un PQRS con el código " + codigoPQRS);
        }

        Pqrs buscado = opcional.get();
        List<Mensaje> mensajes = mensajeRepo.findAllByPqrsCodigo(codigoPQRS);

        return new InfoPQRSDTO2(
                buscado.getCodigo(),
                buscado.getCita().getCodigo(),
                buscado.getCita().getPaciente().getNombre(),
                buscado.getCita().getMedico().getNombre(),
                buscado.getTipo(),
                buscado.getMotivo(),
                buscado.getFechaCreacion(),
                convertirRespuestasDTO(mensajes)
        );
    }
     */
    /*
    private List<RespuestaDTO> convertirRespuestasDTO(List<Mensaje> mensajes) {
        return mensajes.stream().map(m -> new RespuestaDTO(
                m.getCodigo(),
               // m.getCuenta().getCorreo(),
                m.getFecha(),
                m.getMensaje()
        )).toList();
    }




    @Override
    public int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception {
        Optional<Pqrs> opcionalPQRS = pqrsRepo.findById(registroRespuestaDTO.codigo());

        if (opcionalPQRS.isEmpty()) {
            throw new Exception("No existe un PQRS con el código " + registroRespuestaDTO.codigo());
        }

        Optional<Cuenta> opcionalCuenta = cuentaRepo.findById(registroRespuestaDTO.codigo());

        if (opcionalCuenta.isEmpty()) {
            throw new Exception("No existe una cuenta con el código " + registroRespuestaDTO.codigo());
        }

        Optional<Mensaje> opcionalMensaje = mensajeRepo.findById(registroRespuestaDTO.codigo());

        Mensaje mensajeNuevo = new Mensaje();
        mensajeNuevo.setPqrs(opcionalPQRS.get());
        mensajeNuevo.setFecha(LocalDateTime.now());
        //mensajeNuevo.setCuenta(opcionalCuenta.get());
        mensajeNuevo.setMensaje(registroRespuestaDTO.mensaje());

        Mensaje respuesta = mensajeRepo.save(mensajeNuevo);

        return respuesta.getCodigo();
    }
*/

}

