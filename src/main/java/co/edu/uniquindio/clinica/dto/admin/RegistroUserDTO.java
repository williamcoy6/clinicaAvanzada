package co.edu.uniquindio.clinica.dto.admin;

import co.edu.uniquindio.clinica.modelo.Ciudad;

public record RegistroUserDTO(int codigo,
                              String nombre,
                              String correo,
                              String cedula,
                              String celular,
                              String direccion,
                              String contrasena,
                              String urlFoto,
                              Ciudad ciudad) {
}
