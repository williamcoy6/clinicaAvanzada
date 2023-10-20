package co.edu.uniquindio.clinica.modelo.Entidades;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@MappedSuperclass
public class Cuenta implements Serializable {



        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @EqualsAndHashCode.Include
        private int codigo;

        @Column(nullable = false, length = 50, unique = true)
        private String correo;

        @Column(nullable = false)
        @Lob
        private String contrasena;

}
