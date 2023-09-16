package co.edu.uniquindio.clinica.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class Pqrs implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String codigo;
    private LocalDate fechaCreacion;
    private String tipo;
    private String motivo;

    //private EstadoPqrs estadoPqrs;

    @OneToMany(mappedBy = "pqrs")
    private List<Mensaje> mensajes;
    @ManyToOne
    private Cita cita;
}
