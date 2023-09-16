package co.edu.uniquindio.clinica.dto;

import java.time.LocalDateTime;

public record PQRSDTOAdmin<LocalDateTime>(int codigo, String estado, LocalDateTime fecha, String nombrePaciente) {
}
