package co.edu.uniquindio.clinica.dto.PQRS;

import java.time.LocalDateTime;
import java.util.List;

public record InfoPQRSDTO(
        int codigo,
        int codifoCita,
        String estado,
        String motivo,
        String nombrePaciente,
        String nombreMedico,
        LocalDateTime fecha,

        List<RespuestaDTO> mensajes) {
}


