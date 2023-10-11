package co.edu.uniquindio.clinica.Repositorios;

import co.edu.uniquindio.clinica.modelo.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, String> {
    /*
    @Query("SELECT u from Paciente u WHERE u.correo= :correo") // el :correo hace referencia al parámetro
    Usuario buscarUsuario(String correo);

    @Query ("SELECT u FROM Paciente u WHERE u.codigo = :codigo")
    Usuario buscarUsuarioCodigo (int codigo);

    Optional<Usuario> findByCorreo(String correo);
     */
}

