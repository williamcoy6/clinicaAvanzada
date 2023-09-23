package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.medico.DetalleAtencionMedicaDTO;
import co.edu.uniquindio.clinica.dto.medico.DiaLibreDTO;
import co.edu.uniquindio.clinica.dto.medico.ItemCitaDTO;
import co.edu.uniquindio.clinica.dto.medico.RegistroAtencionDTO;

import java.util.List;

public interface MedicoServicio {

    List<ItemCitaDTO> listarCitasPendientes(int codigoMedico) throws Exception;

    int atenderCita(RegistroAtencionDTO registroAtencionDTO) throws Exception;

    List<ItemCitaDTO> listarHistorialAtencionesPaciente(int codigoPaciente) throws Exception;

    // void listarCitasPaciente()throws Exception; //historial médico

    int agendarDiaLibre(DiaLibreDTO diaLibreDTO)throws Exception;

    List<ItemCitaDTO> listarCitasRealizadasMedico(int codigoMedico)throws Exception;

    DetalleAtencionMedicaDTO verDetalleAtencion(int codigoCita) throws Exception;
}
