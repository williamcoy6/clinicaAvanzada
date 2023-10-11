package co.edu.uniquindio.clinica.dto.admin;

import co.edu.uniquindio.clinica.modelo.Enum.Ciudad;
import co.edu.uniquindio.clinica.modelo.Enum.Especializacion;

import java.time.LocalTime;
import java.util.List;

public record DetalleMedicoDTO(int codigo,
                               String nombre,
                               String correo,
                               String cedula,
                               String celular,
                               String direccion,
                               Especializacion especializacion,
                               LocalTime horaInicio,
                               LocalTime horaFin,
                               String urlFoto,
                               Ciudad cuidad,
                               List<HorarioDTO>horarios
) {

}
