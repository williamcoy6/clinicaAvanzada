package co.edu.uniquindio.clinica.dto.admin;

import co.edu.uniquindio.clinica.modelo.Enum.Ciudad;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record DetalleUsuarioDTO(@NotBlank
                                String nombre,
                                @NotBlank
                                @Email(message = "Ingrese un correo valido")
                                String correo,

                                @NotBlank String password,

                                @NotBlank
                                @Length(max = 10, message = "Dijite una cedula valida")
                                String cedula,
                                @NotBlank String celular,
                                @NotBlank String direccion,
                                String urlFoto,
                                @NotNull Ciudad ciudad) {
}
