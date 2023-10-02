package co.edu.uniquindio.clinica.dto.admin;

import co.edu.uniquindio.clinica.modelo.Ciudad;
import co.edu.uniquindio.clinica.modelo.Especializacion;
import co.edu.uniquindio.clinica.modelo.EstadoMedico;

import java.time.LocalTime;

public record RegistroMedicoDTO(String nombre,
                                String correo,
                                String cedula,
                                String celular,
                                String direccion,
                                String password,
                                Especializacion especializacion,
                                LocalTime horaInicio,
                                LocalTime horaFin,
                                String urlFoto,
                                Ciudad cuidad,
                                EstadoMedico estadoMedico) {
}
