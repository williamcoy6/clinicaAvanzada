package co.edu.uniquindio.clinica.Repositorios;

import co.edu.uniquindio.clinica.modelo.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepo extends JpaRepository<Medico, String> {
    @Repository
    public interface MedicoRepositorio extends JpaRepository<Medico, String> {

        //@Query("select m from Medico m where m.email = :email")
        Medico findByEmail(String email);

        //@Query("select m from Medico m where m.cedula = :cedula")
        Medico findByCedula(String cedula);
    }
}