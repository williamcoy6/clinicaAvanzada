package co.edu.uniquindio.clinica.modelo.Entidades;

import co.edu.uniquindio.clinica.modelo.Entidades.Cita;
import co.edu.uniquindio.clinica.modelo.Enum.EstadoPqrs;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Pqrs implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(nullable = false)
    private String tipo;

    @Lob
    @Column(nullable = false)
    private String motivo;

    @Column(nullable = false)
    private EstadoPqrs estadoPqrs;
/*
    @OneToMany(mappedBy = "pqrs")
    private List<Mensaje> mensajes;

 */

    @ManyToOne
    @JoinColumn(name = "cita_codigo", nullable = false)
    private Cita cita;


}
