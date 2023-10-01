package co.edu.uniquindio.clinica.dto.admin;

import co.edu.uniquindio.clinica.modelo.Ciudad;
import co.edu.uniquindio.clinica.modelo.Especializacion;
import co.edu.uniquindio.clinica.modelo.EstadoMedico;

import java.time.LocalTime;
import java.util.ArrayList;

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
                               ArrayList<Object> objects) {

}
