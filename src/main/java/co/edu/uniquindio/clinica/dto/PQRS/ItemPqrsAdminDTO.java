package co.edu.uniquindio.clinica.dto.PQRS;

import co.edu.uniquindio.clinica.modelo.Enum.EstadoPqrs;

import java.time.LocalDateTime;

public record ItemPqrsAdminDTO(
        int codigo,
        EstadoPqrs estadoPqrs,
        LocalDateTime fecha,
        String nombrePaciente) {
}

