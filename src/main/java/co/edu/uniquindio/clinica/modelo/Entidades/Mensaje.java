package co.edu.uniquindio.clinica.modelo.Entidades;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Mensaje implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false, length = 300)
    private String mensaje;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @ManyToOne
    private Pqrs pqrs;


 //   no se como corregir el maped by de cuenta,
   // en el diagrama no tenemos cuenta
    @OneToOne
    @JoinColumn(name = "cuenta_codigo", nullable = false)
    private Cuenta cuenta;

    @OneToOne
    private Mensaje mensajeClase;


}
