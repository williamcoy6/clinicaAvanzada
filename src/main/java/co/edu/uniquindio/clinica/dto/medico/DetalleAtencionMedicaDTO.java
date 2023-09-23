package co.edu.uniquindio.clinica.dto.medico;

import java.time.LocalDate;

public record DetalleAtencionMedicaDTO(
        int codigoCita,
        String nombrePaciente,
        String nombreMedico,
        String especialidad,
        LocalDate fechaAtencion,
        String tratamiento,
        String notaMedica,
        String diagnostico
) {
}
