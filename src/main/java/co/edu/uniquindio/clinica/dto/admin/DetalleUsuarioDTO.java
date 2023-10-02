package co.edu.uniquindio.clinica.dto.admin;

import co.edu.uniquindio.clinica.modelo.Ciudad;

public record DetalleUsuarioDTO(
                                String nombre,
                                String correo,
                                String cedula,
                                String celular,
                                String direccion,
                                String urlFoto,
                                Ciudad ciudad) {
}
