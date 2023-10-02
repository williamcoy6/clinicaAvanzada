package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.admin.RegistroUserDTO;

public interface PacienteServicio {

    int registrarse(RegistroUserDTO registroPacienteDTO) throws Exception;

    int editarPerfil(int codigoPaciente, RegistroUserDTO registroPacienteDTO)throws Exception;

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
