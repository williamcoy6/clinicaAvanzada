package co.edu.uniquindio.clinica.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Medicamento extends JpaRepository<Medicamento, Integer> {
}
