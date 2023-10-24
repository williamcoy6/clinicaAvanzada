package co.edu.uniquindio.clinica.dto.PQRS;

import co.edu.uniquindio.clinica.modelo.Enum.EstadoPqrs;

import java.time.LocalDateTime;

public record ItemPqrsPacDTO(

        int codigo,
        EstadoPqrs estadoPqrs,

        String respuesta,

        LocalDateTime fecha


) {
}
