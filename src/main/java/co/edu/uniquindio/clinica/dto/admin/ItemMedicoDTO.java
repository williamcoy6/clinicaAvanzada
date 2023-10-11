package co.edu.uniquindio.clinica.dto.admin;

import co.edu.uniquindio.clinica.modelo.Enum.Especializacion;

public record ItemMedicoDTO(int codigo,
                            String cedula,
                            String nombre,
                            String urlFoto,
                            Especializacion especialidad) {
}
