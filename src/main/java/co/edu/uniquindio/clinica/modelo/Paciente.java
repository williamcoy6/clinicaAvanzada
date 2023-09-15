package co.edu.uniquindio.clinica.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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

    //Private Eps eps;
    //Private TipoSangre tipoSangre;
    private LocalDate fechaNacimiento;
    private String alergias;

    @OneToMany(mappedBy = "paciente")
    private List<Cita> citas;
}
