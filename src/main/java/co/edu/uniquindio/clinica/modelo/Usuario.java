package co.edu.uniquindio.clinica.modelo;

public class Usuario extends Cuenta{

    @ManytoOne
    private Ciudad cuidad;

}
