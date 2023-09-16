package co.edu.uniquindio.clinica.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Entity
@Getter
@Setter
public class Cita implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String id;

    private String fechaCreacion;
    private String fechaCita;
    private String motivo;


    private EstadoCita estadoCita;

    @OneToOne(mappedBy = "cita")
    private Atencion atencion;


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
