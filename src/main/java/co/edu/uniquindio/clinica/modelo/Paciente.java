package co.edu.uniquindio.clinica.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
public class Paciente extends Usuario implements Serializable {

    private String codigo;
    @Column(nullable = false)
    private LocalDate fechaNacimiento;
    @Column(nullable = false)
    private String alergias;

    private Eps eps;

    private TipoSangre tipoSangre;

    @OneToMany(mappedBy = "paciente")
    private List<Cita> citas;
}
