package co.edu.uniquindio.clinica.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Horario implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String codigo;
    @Column(nullable = false)
    private LocalDate dia;
    @Column(nullable = false)
    private String horaInicio;
    @Column(nullable = false)
    private String horaFin;

    @ManyToOne
    private Medico medico;

}
