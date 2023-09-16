package co.edu.uniquindio.clinica.modelo;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@MappedSuperclass
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario extends Cuenta implements Serializable {

    private String codigo;
    private String cedula;
    private String nombre;
    private String telefono;
    @Lob
    @Column(nullable = false)
    private String urlFoto;

    private Ciudad ciudad;

}
