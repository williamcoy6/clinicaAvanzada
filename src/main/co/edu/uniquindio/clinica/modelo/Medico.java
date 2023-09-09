package clinicaAvanzada.src.main.co.edu.uniquindio.clinica.modelo;

public class Medico extends Usuario implements Serializable{

    Private Especializacion especializacion;


    @OneToMany(mappedBy = "medico")
    private List<Cita> citas;

}
