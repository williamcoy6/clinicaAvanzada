package co.edu.uniquindio.clinica.modelo;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.EqualsAndHashCode;

import java.util.List;

public enum Ciudad {

    CALI,
    MEDELLIN,
    ARMENIA,
    MANIZALES,
    PEREIRA,
    BOGOTA,
    BARRANQUILLA;
/*
    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    @OneToMany(mappedBy = "ciudad")
    private List<Usuario> usuarios;
*/


}
