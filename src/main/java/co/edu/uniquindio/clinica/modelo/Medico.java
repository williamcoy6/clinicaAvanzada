package co.edu.uniquindio.clinica.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Medico extends Usuario implements Serializable {

    private Especializacion especializacion;

    @OneToMany(mappedBy = "medico")
    private List<Cita> citas;

    @OneToMany(mappedBy = "medico")
    private List<Horario> horarios;

    @OneToMany(mappedBy = "medico")
    private List<DiaLibre> diaLibres;

}
