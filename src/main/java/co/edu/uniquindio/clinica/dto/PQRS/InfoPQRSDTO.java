package co.edu.uniquindio.clinica.dto.PQRS;

import co.edu.uniquindio.clinica.modelo.Especializacion;
import co.edu.uniquindio.clinica.modelo.EstadoPqrs;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public record InfoPQRSDTO(String codigo,
                          EstadoPqrs estado,
                          String motivo,
                          String nombrePaciente,
                          String nombreMedico,
                          Especializacion especializacion,
                          LocalDate fecha,
                          // List<RegistroRespuestaDTO>mensajes
                          ArrayList<Object> objects) {


}
