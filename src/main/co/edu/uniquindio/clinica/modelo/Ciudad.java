package clinicaAvanzada.src.main.co.edu.uniquindio.clinica.modelo;

public class Ciudad {

    @OneToMany(mappedBy = "ciudad")
    private List<Usuario> usuarios;
    private String nombre;


}
