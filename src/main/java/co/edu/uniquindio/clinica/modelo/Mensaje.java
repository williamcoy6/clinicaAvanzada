package co.edu.uniquindio.clinica.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Mensaje implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String codigo;
    private String mensaje;

    @ManyToOne
    private Pqrs pqrs;

    //@ManyToOne
    //private Cuenta cuenta;

    @OneToOne
    private Mensaje mensajeClase;

}
