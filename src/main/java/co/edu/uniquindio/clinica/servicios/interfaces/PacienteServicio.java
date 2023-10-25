package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.paciente.*;
import co.edu.uniquindio.clinica.modelo.Enum.Especializacion;

import java.time.LocalDateTime;
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

    public int responderPQRS(RespuestaPacientePqrsDTO respuestaPacientePqrsDTO) throws Exception ;

    public List<ItemCitaPacienteDTO> listarCitasPaciente(int codigoPaciente) throws Exception;

    void filtrarCitasPorFecha()throws Exception;

    public List<ItemMedicoCitaDTO> filtrarMedicoCita(Especializacion especialidad, LocalDateTime fecha)throws Exception;

    void verDetalleCita()throws Exception;
}
