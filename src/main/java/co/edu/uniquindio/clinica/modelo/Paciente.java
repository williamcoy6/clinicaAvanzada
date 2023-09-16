package co.edu.uniquindio.clinica.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Paciente extends Usuario implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String codigo;
    private LocalDate fechaNacimiento;
    private String alergias;
    private Eps eps;
    private TipoSangre tipoSangre;

    @OneToMany(mappedBy = "paciente")
    private List<Cita> citas;
}
