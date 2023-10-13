package co.edu.uniquindio.clinica.dto.admin;

import co.edu.uniquindio.clinica.modelo.Enum.Ciudad;

public record DetalleUsuarioDTO(
                                String nombre,
                                String correo,

                                String password,

                                String cedula,
                                String celular,
                                String direccion,
                                String urlFoto,
                                Ciudad ciudad) {
}
