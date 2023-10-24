package co.edu.uniquindio.clinica.dto.medico;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.List;

public record RegistroAtencionDTO(

        @NotBlank(message = "El campo es obligatorio, no debe estar vacio")
        int codigoCita,
        @NotBlank(message = "El campo es obligatorio")
        int codigoMedico,
        @Length(max = 400, message = "Los campos no pueden superar los 400 caracteres")
        String notasMedicas,
        @Length(max = 400, message = "Los campos no pueden superar los 400 caracteres")
        String tratamiento,
        @Length(max = 400, message = "Los campos no pueden superar los 400 caracteres")
        String diagnostico

        @NotEmpty(message = "El campo es obligatorio, no debe estar vacio")
        List<MedicamentoDTO> medicamentos,
        @NotBlank(message = "El campo es obligatorio, no debe estar vacio")
        @Length(max = 400, message = "El motivo no debe superar los 400 caracteres")
        String motivoIncapacidad,

        @Length(max = 400, message = "La descripción  no puede superar los 400 caracteres")
        String descripcionReceta,
        @NotNull(message = "Ingrese la fecha de inicio de la incapacidad")
        @FutureOrPresent(message = "La fecha de inicio de la incapacidad debe ser actual o en el posterior ")
        LocalDate fechaInicioIncapacidad,
        @NotNull(message = "Ingrese la fecha de fin de la incapacidad")
        @Future(message = "La fecha de fin de la incapacidad debe ser en el posterior a la actual ")
        LocalDate fechaFinIncapacidad

) {
}
