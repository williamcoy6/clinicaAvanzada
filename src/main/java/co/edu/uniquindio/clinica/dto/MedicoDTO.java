package co.edu.uniquindio.clinica.dto;

import java.util.List;

public record MedicoDTO(String nombre,
                        String cedula,
                        int codigoCiudad,
                        int codigoEspecialidad,
                        String telefono,
                        String correo,
                        String password,
                        List< HorarioDTO > horarios) {
}
