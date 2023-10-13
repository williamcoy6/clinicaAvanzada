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
    private String codigo;
    @Column(nullable = false)
    private String mensaje;

    private LocalDateTime fecha;

    @ManyToOne
    private Pqrs pqrs;

    @ManyToOne
    private Cuenta cuenta;

    @OneToOne
    private Mensaje mensajeClase;


}