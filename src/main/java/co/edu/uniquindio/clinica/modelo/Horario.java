package co.edu.uniquindio.clinica.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Horario implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String codigo;
    private String dia;
    private String horaInicio;
    private String horaFin;

    @ManyToOne
    private Medico medico;

}
