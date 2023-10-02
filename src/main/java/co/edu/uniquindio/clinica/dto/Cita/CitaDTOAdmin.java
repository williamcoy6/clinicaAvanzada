package co.edu.uniquindio.clinica.dto.Cita;

import co.edu.uniquindio.clinica.modelo.Especializacion;
import co.edu.uniquindio.clinica.modelo.EstadoCita;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record CitaDTOAdmin(String codigoCita,
                           String cedulaPaciente,
                           String nombrePaciente,
                           String nombreMedico,
                           LocalDateTime fecha,
                           Especializacion especializacion,
                           EstadoCita estadoCita ) {

}
