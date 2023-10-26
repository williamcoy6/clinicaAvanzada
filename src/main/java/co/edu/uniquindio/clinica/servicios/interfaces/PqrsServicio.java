package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.PQRS.*;
import co.edu.uniquindio.clinica.modelo.Enum.EstadoPqrs;

import java.util.List;

public interface PqrsServicio {

    List<ItemPqrsAdminDTO> listarPQRS();

    void cambiarEstadoPQRS(int codigoPQRS, EstadoPqrs estadoPQRS) throws Exception;

    List<ItemPqrsPacDTO> listarPQRSPaciente(int codigoPaciente) throws Exception;

    int crearPQRS(RegistroRespuestaDTO registroPQRSDTO) throws Exception;

    int respuestaPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception;


    int crearPQRS(RegistroPqrsDTO registroPQRSDTO);

    InfoPQRSDTO2 verDetallePQRS(int codigoPQRS) throws Exception;

    int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception;
}
