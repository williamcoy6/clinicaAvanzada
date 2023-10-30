package co.edu.uniquindio.clinica.dto.PQRS;

import co.edu.uniquindio.clinica.modelo.Enum.EstadoPqrs;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ItemPqrsPacDTO(

        @NotBlank int codigo,
        @NotNull EstadoPqrs estadoPqrs,

        @NotBlank String respuesta,

        @NotNull LocalDateTime fecha

) {
}
