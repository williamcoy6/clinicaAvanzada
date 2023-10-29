package co.edu.uniquindio.clinica.dto.PQRS;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RespuestaDTO (
        @NotBlank int codigoMensaje,
        @NotBlank String mensaje,
        java.time.LocalDateTime nombreUsuario,
        @NotBlank String fecha)
{
}
