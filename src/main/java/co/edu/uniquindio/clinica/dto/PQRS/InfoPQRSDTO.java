package co.edu.uniquindio.clinica.dto.PQRS;

import co.edu.uniquindio.clinica.modelo.Enum.Especializacion;
import co.edu.uniquindio.clinica.modelo.Enum.EstadoPqrs;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public record InfoPQRSDTO(int codigo,
                          EstadoPqrs estado,
                          String motivo,
                          String nombrePaciente,
                          String nombreMedico,
                          Especializacion especializacion,
                          LocalDateTime fecha,
                          ArrayList<Object> objects) {


}
