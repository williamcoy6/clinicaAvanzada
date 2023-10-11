package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.paciente.DetallePacienteDTO;
import co.edu.uniquindio.clinica.dto.paciente.RegistroPacienterDTO;

public interface PacienteServicio {

    int registrarse(RegistroPacienterDTO registroPacienteDTO) throws Exception;

    int editarPerfil(int codigo, DetallePacienteDTO detallePacienteDTO)throws Exception;

    void eliminarCuenta(int codigoPaciente)throws Exception;

    void enviarLinkRecuperacion()throws Exception;

    void cambiarPassword()throws Exception;

    void agendarCita()throws Exception;

    void crearPQRS()throws Exception;

    void listarPQRSPaciente()throws Exception;

    void responderPQRS()throws Exception;

    void listarCitasPaciente()throws Exception;

    void filtrarCitasPorFecha()throws Exception;

    void filtrarCitasPorMedico()throws Exception;

    void verDetalleCita()throws Exception;
}
