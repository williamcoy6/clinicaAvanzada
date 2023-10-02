package co.edu.uniquindio.clinica.dto.PQRS;

import co.edu.uniquindio.clinica.modelo.EstadoPqrs;

public record ItemPqrsTDO<LocalDateTime>(String codigo,
                                         EstadoPqrs estado,
                                         String motivo,
                                         LocalDateTime fechaCreacion,
                                         String nombrePaciente) {

}
