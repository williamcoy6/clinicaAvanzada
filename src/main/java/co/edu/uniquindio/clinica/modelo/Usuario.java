package co.edu.uniquindio.clinica.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario extends Cuenta implements Serializable {

    private int codigo;
    @Column(nullable = false, length = 10, unique = true)
    private String cedula;
    @Column(nullable = false, length = 200)
    private String nombre;
    @Column(nullable = false, length = 10)
    private String celular;
    @Column(nullable = false, length = 50)
    private String correo;
    @Column(nullable = false, length = 200)
    private String direccion;
    @Column(nullable = false, length = 200)
    private String contrasena;
    @Lob
    @Column(nullable = false)
    private String urlFoto;
    private Ciudad ciudad;


}
