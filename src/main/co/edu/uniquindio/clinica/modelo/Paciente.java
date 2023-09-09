package clinicaAvanzada.src.main.co.edu.uniquindio.clinica.modelo;

import java.time.LocalDate;

public class Paciente extends Usuario implements Serializable{

    Private Eps eps;
    Private TipoSangre tipoSangre;
    private LocalDate fechaNacimiento;
    private String alergias;

    @OneToMany(mappedBy = "paciente")
    private List<Cita> citas;
}
