package co.edu.uniquindio.clinica.dto.medico;

import co.edu.uniquindio.clinica.modelo.EstadoCita;

import java.time.LocalDate;

public record ItemCitaDTO(String codigoCita,
                          String cedulaPaciente,
                          String nombrePaciente,
                          String nombreMedico,
                          String especialidad,
                          EstadoCita estadoCita,
                          LocalDate fecha,
                          String motivo) {
}
