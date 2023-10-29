package co.edu.uniquindio.clinica.Repositorios;

import co.edu.uniquindio.clinica.modelo.Entidades.Cita;
import co.edu.uniquindio.clinica.modelo.Enum.EstadoCita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CitaRepo extends JpaRepository<Cita, Integer> {

    List<Cita> findByPaciente_Codigo(int codigo);

    @Query("select count(c) from Cita c where c.paciente.codigo =:idPaciente and c.estadoCita = :estadoCita")
    Long countAllByPacienteIdAndEstadoCita(int idPaciente, EstadoCita estadoCita);

    // Seleccionar las citas completadas de un paciente por el nombre del medico y fecha
    @Query("select c from Cita c where c.paciente.codigo = :codigoPaciente and c.estadoCita = 'COMPLETADA' "  + "and c.medico.nombre like %:nombreMedico% and c.fechaCita = :fechaCita")
    List<Cita> findCitasCompletadasByPacienteAndNombreMedicoAndFechaCita(int codigoPaciente, String nombreMedico, LocalDateTime fechaCita);

    @Query("select c from Cita c where c.medico. codigo = :codigoMedico and c.fechaCita = :fechaDeseada")
    List<Cita> obtenerCitasFecha(int codigoMedico, LocalDateTime fechaDeseada);


    /*
    @Query("select count(c) from Cita c where c.paciente.codigo = :codigoPaciente and c.estadoCita = 'PROGRAMADA'")
    int countCitasPendientesByPaciente(int codigoPaciente);

    // Seleccionar las citas completadas de un paciente por el nombre del medico
    @Query("select c from Cita c where c.paciente.codigo = :codigoPaciente and c.estadoCita = 'COMPLETADA' " +
            "and c.medico.nombre like %:nombreMedico%")
    List<Cita> findCitasCompletadasByPacienteAndNombreMedico(int codigoPaciente, String nombreMedico);

    // Seleccionar las citas completadas de un paciente por fecha
    @Query("select c from Cita c where c.paciente.codigo = :codigoPaciente and c.estadoCita = 'COMPLETADA' " +
            "and c.fechaCita = :fechaCita")
    List<Cita> findCitasCompletadasByPacienteAndFechaCita(int codigoPaciente, LocalDateTime fechaCita);

    @Query("select c from Cita c where c.medico.codigo = :codigoMedico and c.estadoCita = 'PROGRAMADA'")
    List<Cita> findCitasPendientesByMedico(int codigoMedico);

    @Query("select c from Cita c where c.paciente.codigo = :codigoPaciente and c.estadoCita = 'COMPLETADA'")
    List<Cita> findCitasCompletadasByPaciente(int codigoPaciente);

     */

}
