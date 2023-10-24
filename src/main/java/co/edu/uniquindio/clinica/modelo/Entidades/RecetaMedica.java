package co.edu.uniquindio.clinica.modelo.Entidades;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.util.List;

public class RecetaMedica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(length = 400)
    private String descripcion;
    @OneToOne
    @JoinColumn(name = "atencion_codigo", nullable = false)
    private AtencionMedica atencionMedica;

    @ManyToMany(mappedBy = "recetasMedicas")
    private List<Medicamento> medicamentos;
 



}

}