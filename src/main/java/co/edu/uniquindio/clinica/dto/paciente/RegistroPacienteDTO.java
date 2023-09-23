package co.edu.uniquindio.clinica.dto.paciente;

public record RegistroPacienteDTO(String nombre,
                                  String correo,
                                  String cedula,
                                  String celular,
                                  String direccion,
                                  String contraseña) {
}
