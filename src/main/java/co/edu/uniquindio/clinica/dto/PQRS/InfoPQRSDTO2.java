package co.edu.uniquindio.clinica.dto.PQRS;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record InfoPQRSDTO2(
                           int codigo,
                           @NotBlank int codifoCita,
                           @NotNull String estado,
                           @NotBlank String motivo,
                           @NotBlank String nombrePaciente,
                           @NotBlank String nombreMedico,
                           @NotNull LocalDateTime fecha,

                           List<RespuestaDTO> mensajes) {
}
