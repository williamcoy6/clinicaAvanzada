package co.edu.uniquindio.clinica.modelo.Entidades;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

//@Entity
@Getter
@Setter
@NoArgsConstructor
public class Mensaje implements Serializable {
    /*

    @Id
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false, length = 300)
    private String mensaje;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @ManyToOne
    private Pqrs pqrs;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Administrador administrador;

    @ManyToOne
    private Medico medico;

    @OneToOne
    private Mensaje mensajeClase;

     */

}
