package co.edu.uniquindio.clinica.dto.email;

public record EmailDTO(
        String remitente,
        String destinatario,
        String asunto,
        String mensaje
) {
}