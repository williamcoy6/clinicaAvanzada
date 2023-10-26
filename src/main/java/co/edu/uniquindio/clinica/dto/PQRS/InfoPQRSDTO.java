package co.edu.uniquindio.clinica.dto.PQRS;

import co.edu.uniquindio.clinica.modelo.Enum.Especializacion;
import co.edu.uniquindio.clinica.modelo.Enum.EstadoCita;
import co.edu.uniquindio.clinica.modelo.Enum.EstadoPqrs;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public record InfoPQRSDTO(int codigo,
                          EstadoPqrs estado,
                          String motivo,
                          String nombrePaciente,
                          String nombreMedico,
                          Especializacion especializacion,
                          LocalDateTime fecha,
                          ArrayList<Object> objects)  {

}


