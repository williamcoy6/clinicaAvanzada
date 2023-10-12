package co.edu.uniquindio.clinica.Repositorios;

import co.edu.uniquindio.clinica.modelo.Entidades.Pqrs;
import co.edu.uniquindio.clinica.modelo.Enum.EstadoPqrs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PQRSRepo extends JpaRepository<Pqrs, Integer> {

    List<Pqrs> findAllByCita_Paciente_Id(int idPaciente);

    List<Pqrs> findAllByCita_Paciente_IdAndEstadoPqrsEquals(int idPaciente, EstadoPqrs estadoPqrs);
}