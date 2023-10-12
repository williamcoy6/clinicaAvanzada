package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.paciente.*;

import java.util.List;

public interface PacienteServicio {

    int registrarse(RegistroPacienterDTO registroPacienteDTO) throws Exception;

    int editarPerfil(int codigo, DetallePacienteDTO detallePacienteDTO)throws Exception;

    void eliminarCuenta(int codigoPaciente)throws Exception;

    void enviarLinkRecuperacion()throws Exception;

    void cambiarPassword()throws Exception;

    public int agendarCita(CitaPacienteDTO citaDTO) throws Exception;

    public int crearPQRS(PqrsPacienteDTO pqrsPacienteDTO)throws Exception;

    void listarPQRSPaciente()throws Exception;

    void responderPQRS()throws Exception;

    public List<ItemCitaPacienteDTO> listarCitasPaciente(int codigoPaciente) throws Exception;

    void filtrarCitasPorFecha()throws Exception;

    void filtrarCitasPorMedico()throws Exception;

    void verDetalleCita()throws Exception;
}
