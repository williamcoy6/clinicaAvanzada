package co.edu.uniquindio.clinica.Repositorios;

import co.edu.uniquindio.clinica.modelo.Eps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EpsRepo extends JpaRepository<Eps, Integer> {

    @Query("select e from Eps e where e.id = :id")
    default Eps buscarEps(int id) {
        return null;
    }

}
