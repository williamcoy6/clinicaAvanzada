package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.admin.ConsultaDTO;
import co.edu.uniquindio.clinica.dto.medico.DetalleAtencionMedicaDTO;
import co.edu.uniquindio.clinica.dto.medico.DiaLibreDTO;
import co.edu.uniquindio.clinica.dto.medico.ItemCitaDTO;
import co.edu.uniquindio.clinica.dto.medico.RegistroAtencionDTO;

import java.util.List;

public interface MedicoServicio {

    List<ConsultaDTO> listarCitasPendientes(int codigoMedico) throws Exception;

    List<ItemCitaDTO> atenderCita(RegistroAtencionDTO registroAtencionDTO, int codigoCita) throws Exception;

    List<ItemCitaDTO> listarHistorialAtencionesPaciente(int codigoPaciente) throws Exception;

    int agendarDiaLibre(DiaLibreDTO diaLibreDTO)throws Exception;

    List<ItemCitaDTO> listarCitasRealizadasMedico(int codigoMedico)throws Exception;

    DetalleAtencionMedicaDTO verDetalleAtencion(int codigoCita) throws Exception;

}
