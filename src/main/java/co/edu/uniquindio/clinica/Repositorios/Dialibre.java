package co.edu.uniquindio.clinica.Repositorios;

import co.edu.uniquindio.clinica.modelo.Entidades.DiaLibre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Dialibre extends JpaRepository<DiaLibre, Integer> {

}