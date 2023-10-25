package co.edu.uniquindio.clinica.Repositorios;

import co.edu.uniquindio.clinica.modelo.Entidades.Medico;
import co.edu.uniquindio.clinica.modelo.Enum.Especializacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepo extends JpaRepository<Medico, Integer> {
    /*
            //@Query("select m from Medico m where m.email = :email")
            Medico findByEmail(int email);

            //@Query("select m from Medico m where m.cedula = :cedula")
            Medico findByCedula(int cedula);

    */
    @Query("select m from Medico m where m.especializacion = :especialidad")
    List<Medico> obtenerMedicoEspecialidad(Especializacion especialidad);
}