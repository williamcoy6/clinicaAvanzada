package co.edu.uniquindio.clinica.dto.medico;

import co.edu.uniquindio.clinica.modelo.Enum.EstadoCita;

public record ItemCitaDTO(int codigoCita,
                          String cedulaPaciente,
                          String nombrePaciente,
                          String nombreMedico,
                          co.edu.uniquindio.clinica.modelo.Enum.@jakarta.validation.constraints.NotNull Especializacion especialidad,
                          EstadoCita estadoCita,
                          java.time.LocalDateTime fecha,
                          String motivo) {
}
