package co.edu.uniquindio.clinica.modelo;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cita implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String codigo;
    @Column(nullable = false)
    private LocalDateTime fechaCreacion;
    @Column(nullable = false)
    private LocalDateTime fechaCita;
    @Column(nullable = false)
    private String motivo;

    private EstadoCita estadoCita;

    @OneToOne(mappedBy = "cita")
    private Atencion atencion;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Medico medico;


}
