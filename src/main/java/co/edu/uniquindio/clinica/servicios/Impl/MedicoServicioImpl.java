package co.edu.uniquindio.clinica.servicios.Impl;


import co.edu.uniquindio.clinica.Repositorios.*;
import co.edu.uniquindio.clinica.dto.admin.ConsultaDTO;
import co.edu.uniquindio.clinica.dto.medico.DetalleAtencionMedicaDTO;
import co.edu.uniquindio.clinica.dto.medico.DiaLibreDTO;
import co.edu.uniquindio.clinica.dto.medico.ItemCitaDTO;
import co.edu.uniquindio.clinica.dto.medico.RegistroAtencionDTO;
import co.edu.uniquindio.clinica.servicios.interfaces.MedicoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MedicoServicioImpl implements MedicoServicio {

    private final MedicoRepo medicoRepo;
    private final PacienteRepo pacienteRepo;
    private final Dialibre diaLibreRepo;
    private final CitaRepo citaRepo;

    @Override
    public List<ConsultaDTO> listarCitasPendientes(int codigoMedico) throws Exception {
        return null;
    }

    @Override
    public List<ItemCitaDTO> atenderCita(RegistroAtencionDTO registroAtencionDTO, int codigoCita) throws Exception {
        return null;
    }

    @Override
    public List<ItemCitaDTO> listarHistorialAtencionesPaciente(int codigoPaciente) throws Exception {
        return null;
    }

    @Override
    public int agendarDiaLibre(DiaLibreDTO diaLibreDTO) throws Exception {
        return 0;
    }

    @Override
    public List<ItemCitaDTO> listarCitasRealizadasMedico(int codigoMedico) throws Exception {
        return null;
    }

    @Override
    public DetalleAtencionMedicaDTO verDetalleAtencion(int codigoCita) throws Exception {
        return null;
    }

/*

    @Override
    public List<ConsultaDTO> listarCitasPendientes(int codigoMedico) throws Exception {
        if (medicoExiste(codigoMedico).isEmpty()) {
            throw new Exception("No existe un medico con el código " + codigoMedico);
        }

        if (medicoItsActive(codigoMedico) == null) {
            throw new Exception("El medico con e codigo " + codigoMedico +" no existe ");
        }

        List<ConsultaDTO> listaConsultaDTOS = new ArrayList<>();
        for (Cita c : citaRepo.findCitasPendientesByMedico(codigoMedico)) {
            ConsultaDTO itemConsultaDTO = new ConsultaDTO(
                    c.getCodigo(),
                    c.getPaciente().getCedula(),
                    c.getPaciente().getNombre(),
                    c.getFechaCita(),
                    c.getMotivo()
            );
            listaConsultaDTOS.add(itemConsultaDTO);
        }

        return listaConsultaDTOS;
    }

    @Override
    public List<ItemCitaDTO> atenderCita(RegistroAtencionDTO registroAtencionDTO, int codigoCita) throws Exception {
        if (citaRepo.findById(codigoCita).isEmpty()){
            throw new Exception("No se ha encontrado citas registradas con el  codigo"+ codigoCita);
        }

        Optional<Cita> cita = citaRepo.findById(codigoCita);

        if (registroAtencionDTO.notasMedicas().isEmpty()){
            throw new Exception("El campo de notas medicas no puede estar vacio");
        }

        if (registroAtencionDTO.diagnostico().isEmpty()){
            throw new Exception( "El campo diagnostico no puede estar vacio");
        }

        if (registroAtencionDTO.tratamiento().isEmpty()){
            throw new Exception("El campo tratamieno no puede estar vacio");
        }

        if (registroAtencionDTO.descripcionReceta().isEmpty()){
            throw new Exception("Por favor añada la descripcion de la receta");
        }

        Atencion atencionMedica = new Atencion();
        atencionMedica.setDiagnostico(registroAtencionDTO.diagnostico());
        atencionMedica.setTratamiento(registroAtencionDTO.tratamiento());
        atencionMedica.setNotasMedicas(registroAtencionDTO.notasMedicas());

        atencionMedica.setCita(cita.get());


        FormulacionMedica formulacionMedica = new FormulacionMedica();
        formulacionMedica.setDescripcion(registroAtencionDTO.descripcionReceta());


        List<Medicamento> medicamentoList = new ArrayList<>();
        for (MedicamentoDTO medicamentoDTO : registroAtencionDTO.medicamentos()) {
            Medicamento medicamento = new Medicamento();
            medicamento.setNombre(medicamentoDTO.nombre());
            medicamento.setCantidad(medicamentoDTO.cantidad());
            medicamento.setViaAdministracion(medicamentoDTO.uso());
            medicamento.setDosis(medicamentoDTO.dosis());
            medicamentoList.add(medicamento);
        }



    @Override
    public List<ItemCitaDTO> listarHistorialAtencionesPaciente(int codigoPaciente) throws Exception {
        if (pacienteExiste (codigoPaciente).isEmpty()){
            throw new Exception("No existe un paciente con ese codigo: " + codigoPaciente);
        }

        List<ItemCitaDTO> listaItemCitaDTO = new ArrayList<>();
        for (Cita c : citaRepo.findCitasCompletadasByPaciente(codigoPaciente)) {
            ItemCitaDTO itemCitaDTO = new ItemCitaDTO(
                    c.getCodigo(),
                    c.getPaciente().getCedula(),
                    c.getPaciente().getNombre(),
                    c.getMedico().getNombre(),
                    c.getMedico().getEspecializacion(),
                    c.getEstadoCita(),
                    c.getFechaCita(),
                    c.getMotivo()
            );
            listaItemCitaDTO.add(itemCitaDTO);
        }
        return listaItemCitaDTO;
    }

    @Override
    public int agendarDiaLibre(DiaLibreDTO diaLibreDTO) throws Exception {
        return 0;
    }

    @Override
    public int agendarDiaLibre(DiaLibreDTO diaLibreDTO, int codigoMedico) throws Exception {
        if (medicoExiste(codigoMedico).isEmpty()) {
            throw new Exception("No existe un medico con el código " + codigoMedico);
        }

        if (medicoItsActive(codigoMedico) == null) {
            throw new Exception("El medico no se encuentra " + codigoMedico);
        }

        Optional<Medico> medico = medicoRepo.findById(codigoMedico);
        DiaLibre diaLibre = new DiaLibre();
        if (medico.isPresent()) {
            diaLibre.setFecha(diaLibreDTO.fecha());
            diaLibre.setMedico(medico.get());
        }


        try {
            diaLibreRepo.save(diaLibre);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<ItemConsultaDTO> listarCitasRealizadasMedico(int codigoMedico) throws Exception {
        if (medicoExiste(codigoMedico).isEmpty()) {
            throw new Exception("No existe un medico con el código " + codigoMedico);
        }

        if (medicoItsActive(codigoMedico) == null) {
            throw new Exception("El medico no se encuentra " + codigoMedico);
        }

        ArrayList<ItemConsultaDTO> listaCitasMedico = new ArrayList<>();

        List<Cita> citas =medicoRepo.listasCitas(codigoMedico);

        for (Cita c : citas) {
            System.out.println("Esl estado es: " + c.getEstado());
            ItemConsultaDTO itemConsultaDTO = new ItemConsultaDTO(
                    c.getCodigo(),
                    c.getPaciente().getCedula(),
                    c.getPaciente().getNombre(),
                    c.getFechaCita(),
                    c.getMotivo()
            );
            listaCitasMedico.add(itemConsultaDTO);
        }

        return listaCitasMedico;
    }

    @Override
    public DetalleAtencionMedicaDTO verDetalleAtencion(int codigoCita) throws Exception {
        return null;
    }

    private Medico medicoItsActive(int codigoMedico) {
        return medicoRepo.findActivo(codigoMedico);
    }

    private Optional<Medico> medicoExiste(int codigoMedico) {
        return medicoRepo.findById(codigoMedico);
    }

        public MedicamentoDTO obtenerMedicamento(int codigoMedicamento) throws Exception {
            Optional<Medicamento> medicamento = medicamentoRepo.findById(codigoMedicamento);
            if (medicamento.isEmpty()){
                throw new Exception("El medicamento no existe");
            }
            MedicamentoDTO medicamentoDTO = new MedicamentoDTO(
                    medicamento.get().getNombre(),
                    medicamento.get().getCantidad(),
                    medicamento.get().getViaAdministracion(),
                    medicamento.get().getDosis()
            );

            return medicamentoDTO;
        }

     */

}
