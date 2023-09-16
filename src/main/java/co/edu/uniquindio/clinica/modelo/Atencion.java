package co.edu.uniquindio.clinica.modelo;

import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

public class Atencion implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String codigo;

private String diagnostico;
private String tratamiento;
private String notasMedicas;

@OneToOne
private Cita cita;


}
