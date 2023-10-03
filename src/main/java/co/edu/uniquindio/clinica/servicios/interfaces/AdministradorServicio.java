package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.Cita.CitaDTOAdmin;
import co.edu.uniquindio.clinica.dto.PQRS.InfoPQRSDTO;
import co.edu.uniquindio.clinica.dto.PQRS.ItemPqrsTDO;
import co.edu.uniquindio.clinica.dto.PQRS.RegistroRespuestaDTO;
import co.edu.uniquindio.clinica.dto.admin.*;
import co.edu.uniquindio.clinica.modelo.EstadoPqrs;

import java.util.List;

public interface    AdministradorServicio {


    int crearMedico(RegistroMedicoDTO medico) throws Exception;

    int actualizarMedico(DetalleMedicoDTO medicoDTO) throws Exception;

    void eliminarMedico(int codigo) throws Exception;

    List<ItemMedicoDTO> listarMedicos() throws Exception;

    DetalleMedicoDTO obtenerMedico(int codigo) throws Exception;

    List<ItemPqrsTDO> listarPQRS() throws Exception;

    String responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception;

    InfoPQRSDTO verDetallePQRS(int codigo) throws Exception;

    void cambiarEstadoPQRS(int codigoPQRS, EstadoPqrs estadoPQRS)throws Exception;

    List<CitaDTOAdmin> listarCitas() throws Exception;

    int crearUsuario(RegistroUserDTO userDTO) throws Exception;

    String actualizarUsuario(DetalleUsuarioDTO detalleUsuarioDTO) throws Exception;

    void eliminarUsuario(String cedula) throws Exception;



}
