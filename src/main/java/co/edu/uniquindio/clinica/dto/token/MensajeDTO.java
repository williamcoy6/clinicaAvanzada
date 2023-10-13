package co.edu.uniquindio.clinica.dto.token;
public record MensajeDTO<T>(
        boolean error,
        T respuesta
) {
}