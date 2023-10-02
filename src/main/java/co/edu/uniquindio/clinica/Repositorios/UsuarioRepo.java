package co.edu.uniquindio.clinica.Repositorios;

import co.edu.uniquindio.clinica.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, String> {
}
