package co.edu.uniquindio.clinica.modelo.Entidades;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Atencion implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String codigo;
    @Column(nullable = false)
    private String diagnostico;
    @Column(nullable = false)
    private String tratamiento;
    @Column(nullable = false)
    private String notasMedicas;

    @OneToOne
    @JoinColumn(name = "cita_codigo", referencedColumnName = "codigo", nullable = false)
    private Cita cita;

}
