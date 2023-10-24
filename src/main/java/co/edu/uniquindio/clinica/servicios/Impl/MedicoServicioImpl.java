//package co.edu.uniquindio.clinica.servicios.Impl;
//
//
////import co.edu.uniquindio.clinica.dto.admin.ItemConsultaDTO;
//import co.edu.uniquindio.clinica.dto.medico.DiaLibreDTO;
//import co.edu.uniquindio.clinica.dto.medico.RegistroAtencionDTO;
////import co.edu.uniquindio.clinica.dto.paciente.ItemCitaDTO;
////import co.edu.uniquindio.clinica.dto.paciente.MedicamentoDTO;
////import co.edu.uniquindio.clinica.modelo.entidades.*;
//import co.edu.uniquindio.clinica.Repositorios.*;
//import co.edu.uniquindio.clinica.servicios.interfaces.MedicoServicio;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//
//@Service
//@RequiredArgsConstructor
//public class MedicoServicioImpl implements MedicoServicio {
//
//    private final MedicoRepo medicoRepo;
//    private final PacienteRepo pacienteRepo;
//    private final PacienteServicioImpl pacienteServicio;
//    private final DiaLibreRepo diaLibreRepo;
//
//    private final CitaRepo citaRepo;
//    private final MedicamentoRepo medicamentoRepo;
//
//    private final AtencionRepo atencionMedicaRepo;
//
//
//    @Override
//    public List<ItemConsultaDTO> listarCitasPendientes(int codigoMedico) throws Exception {
//        if (medicoExiste(codigoMedico).isEmpty()) {
//            throw new Exception("No existe un medico con el código " + codigoMedico);
//        }
//
//        if (medicoItsActive(codigoMedico) == null) {
//            throw new Exception("El medico no se encuentra " + codigoMedico);
//        }
//
//        List<ItemConsultaDTO> listaItemConsultaDTOS = new ArrayList<>();
//        for (Cita c : citaRepo.findCitasPendientesByMedico(codigoMedico)) {
//            ItemConsultaDTO itemConsultaDTO = new ItemConsultaDTO(
//                    c.getCodigo(),
//                    c.getPaciente().getCedula(),
//                    c.getPaciente().getNombre(),
//                    c.getFechaCita(),
//                    c.getMotivo()
//            );
//            listaItemConsultaDTOS.add(itemConsultaDTO);
//        }
//
//        return listaItemConsultaDTOS;
//    }
//
//    @Override
//    public int atenderCita(RegistroAtencionDTO registroAtencionDTO, int codigoCita) throws Exception {
//        if (citaRepo.findById(codigoCita).isEmpty()){
//            throw new Exception("No hay citas registradas con ese codigo");
//        }
//
//        Optional<Cita> cita = citaRepo.findById(codigoCita);
//
//        if (registroAtencionDTO.notasMedicas().isEmpty()){
//            throw new Exception("Por favor añada las notas medicas");
//        }
//
//        if (registroAtencionDTO.diagnostico().isEmpty()){
//            throw new Exception("Por favor añada el diagnostico");
//        }
//
//        if (registroAtencionDTO.tratamiento().isEmpty()){
//            throw new Exception("Por favor añada el tratamienot");
//        }
//
//        if (registroAtencionDTO.descripcionReceta().isEmpty()){
//            throw new Exception("Por favor añada la descripcion de la receta");
//        }
//
//        if (registroAtencionDTO.motivoIncapacidad().isEmpty()){
//            throw new Exception("Por favor añada el motivo de la incapacidad");
//        }
//
//        if (registroAtencionDTO.fechaInicioIncapacidad() == null){
//            throw new Exception("Por favor añada la fecha de inicio de incapacidad");
//        }
//
//        if (registroAtencionDTO.fechaFinIncapacidad() == null){
//            throw new Exception("Por favor añada la fecha de fin de incapacidad");
//        }
//
//        AtencionMedica atencionMedica = new AtencionMedica();
//        atencionMedica.setDiagnostico(registroAtencionDTO.diagnostico());
//        atencionMedica.setTratamiento(registroAtencionDTO.tratamiento());
//        atencionMedica.setNotas(registroAtencionDTO.notasMedicas());
//
//        atencionMedica.setCita(cita.get());
//
//        Incapacidad incapacidad = new Incapacidad();
//        incapacidad.setMotivo(registroAtencionDTO.motivoIncapacidad());
//        incapacidad.setFechaInicio(registroAtencionDTO.fechaInicioIncapacidad());
//        incapacidad.setFechaFin(registroAtencionDTO.fechaFinIncapacidad());
//
//        atencionMedica.setIncapacidad(incapacidad);
//
//        RecetaMedica recetaMedica = new RecetaMedica();
//        recetaMedica.setDescripcion(registroAtencionDTO.descripcionReceta());
//
//        List<Medicamento> medicamentoList = new ArrayList<>();
//        for (MedicamentoDTO medicamentoDTO : registroAtencionDTO.medicamentos()) {
//            Medicamento medicamento = new Medicamento();
//            medicamento.setNombre(medicamentoDTO.nombre());
//            medicamento.setCantidad(medicamentoDTO.cantidad());
//            medicamento.setViaAdministracion(medicamentoDTO.viaAdministracion());
//            medicamento.setDosis(medicamentoDTO.dosis());
//            medicamentoList.add(medicamento);
//        }
//
//        recetaMedica.setMedicamentos(medicamentoList);
//        atencionMedica.setRecetaMedica(recetaMedica);
//        atencionMedicaRepo.save(atencionMedica);
//
//        return 0;
//    }
//
//
//    @Override
//    public List<ItemCitaDTO> listarHistorialAtencionesPaciente(int codigoPaciente) throws Exception {
//        if (pacienteServicio.pacienteExiste(codigoPaciente).isEmpty()) {
//            throw new Exception("No existe un paciente con ese codigo: " + codigoPaciente);
//        }
//
//        List<ItemCitaDTO> listaItemCitaDTO = new ArrayList<>();
//        for (Cita c : citaRepo.findCitasCompletadasByPaciente(codigoPaciente)) {
//            ItemCitaDTO itemCitaDTO = new ItemCitaDTO(
//                    c.getCodigo(),
//                    c.getMedico().getNombre(),
//                    c.getMedico().getEspecialidad(),
//                    c.getFechaCita(),
//                    c.getMotivo()
//            );
//            listaItemCitaDTO.add(itemCitaDTO);
//        }
//        return listaItemCitaDTO;
//    }
//
//    @Override
//    public int agendarDiaLibre(DiaLibreDTO diaLibreDTO, int codigoMedico) throws Exception {
//        if (medicoExiste(codigoMedico).isEmpty()) {
//            throw new Exception("No existe un medico con el código " + codigoMedico);
//        }
//
//        if (medicoItsActive(codigoMedico) == null) {
//            throw new Exception("El medico no se encuentra " + codigoMedico);
//        }
//
//        Optional<Medico> medico = medicoRepo.findById(codigoMedico);
//        DiaLibre diaLibre = new DiaLibre();
//        if (medico.isPresent()) {
//            diaLibre.setFecha(diaLibreDTO.fecha());
//            diaLibre.setMedico(medico.get());
//        }
//
//
//        try {
//            diaLibreRepo.save(diaLibre);
//            return 1;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return 0;
//        }
//    }
//
//    @Override
//    public List<ItemConsultaDTO> listarCitasRealizadasMedico(int codigoMedico) throws Exception {
//        if (medicoExiste(codigoMedico).isEmpty()) {
//            throw new Exception("No existe un medico con el código " + codigoMedico);
//        }
//
//        if (medicoItsActive(codigoMedico) == null) {
//            throw new Exception("El medico no se encuentra " + codigoMedico);
//        }
//
//        ArrayList<ItemConsultaDTO> listaCitasMedico = new ArrayList<>();
//
//        List<Cita> citas =medicoRepo.listasCitas(codigoMedico);
//
//        for (Cita c : citas) {
//            System.out.println("Esl estado es: " + c.getEstado());
//            ItemConsultaDTO itemConsultaDTO = new ItemConsultaDTO(
//                    c.getCodigo(),
//                    c.getPaciente().getCedula(),
//                    c.getPaciente().getNombre(),
//                    c.getFechaCita(),
//                    c.getMotivo()
//            );
//            listaCitasMedico.add(itemConsultaDTO);
//        }
//
//        return listaCitasMedico;
//    }
//
//    private Medico medicoItsActive(int codigoMedico) {
//        return medicoRepo.findActivo(codigoMedico);
//    }
//
//    private Optional<Medico> medicoExiste(int codigoMedico) {
//        return medicoRepo.findById(codigoMedico);
//    }
//
//
//    public MedicamentoDTO obtenerMedicamento(int codigoMedicamento) throws Exception {
//        Optional<Medicamento> medicamento = medicamentoRepo.findById(codigoMedicamento);
//        if (medicamento.isEmpty()){
//            throw new Exception("El medicamento no existe");
//        }
//        MedicamentoDTO medicamentoDTO = new MedicamentoDTO(
//                medicamento.get().getNombre(),
//                medicamento.get().getCantidad(),
//                medicamento.get().getViaAdministracion(),
//                medicamento.get().getDosis()
//        );
//
//        return medicamentoDTO;
//    }
//}