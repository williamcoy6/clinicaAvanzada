package co.edu.uniquindio.clinica.dto.PQRS;

public record RespuestaDTO (
        int codigoMensaje,
        String mensaje,
        java.time.LocalDateTime nombreUsuario,
        String fecha)
{
}
