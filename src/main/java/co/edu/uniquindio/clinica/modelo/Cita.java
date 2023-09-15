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
public class Cita implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String id;


    //private Estado_Cita estadoCita;

/*
    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Medico medico;

    //public Cita() {
    //}
    /*
 */
}
