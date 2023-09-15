package co.edu.uniquindio.clinica.modelo;

public enum TipoSangre {

    A_POSITIVO(nombre: "A+"),
    A_NEGATIVO(nombre: "A-"),
    B_POSITIVO(nombre: "B+"),

    B_NEGATIVO(nombre: "B-");


    private String nombre;
    TipoSangre(String nombre){
        this.nombre = nombre;
    }

}
