package co.edu.uniquindio.clinica.modelo;

public class Cita {

    private Estado_Cita estadoCita;


    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Medico medico;
}
