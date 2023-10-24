package co.edu.uniquindio.clinica.dto.admin;

import java.time.LocalDateTime;

public record ConsultaDTO(
        int codigo,
        String cedulaPaciente,
        String nombrePaciente,
        LocalDateTime fechaConsulta,
        String motivo
) {
}
