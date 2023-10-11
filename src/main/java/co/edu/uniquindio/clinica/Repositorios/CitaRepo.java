package co.edu.uniquindio.clinica.Repositorios;

import co.edu.uniquindio.clinica.modelo.Entidades.Cita;
import co.edu.uniquindio.clinica.modelo.Enum.EstadoCita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitaRepo extends JpaRepository<Cita, Integer> {

    List<Cita> findByPaciente_Codigo(int codigo);

    @Query("select count(c) from Cita c where c.paciente.codigo =:idPaciente and c.estadoCita = :estadoCita")
    Long countAllByPacienteIdAndEstadoCita(int idPaciente, EstadoCita estadoCita);
}
