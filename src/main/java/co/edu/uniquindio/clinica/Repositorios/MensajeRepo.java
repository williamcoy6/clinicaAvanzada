package co.edu.uniquindio.clinica.Repositorios;

import co.edu.uniquindio.clinica.modelo.Entidades.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensajeRepo extends JpaRepository<Mensaje, Integer> {
}