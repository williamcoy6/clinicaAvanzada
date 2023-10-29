package co.edu.uniquindio.clinica.dto.medico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DetalleAtencionMedicaDTO(
        @NotBlank int codigoCita,
        @NotBlank String nombrePaciente,
        @NotBlank String nombreMedico,
        @NotNull String especialidad,
        @NotNull LocalDate fechaAtencion,
        @NotBlank String tratamiento,
        String notaMedica,
        String diagnostico
) {
}
