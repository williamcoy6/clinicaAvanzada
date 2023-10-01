package co.edu.uniquindio.clinica.servicios.Impl;

import co.edu.uniquindio.clinica.Repositorios.MedicoRepo;
import co.edu.uniquindio.clinica.dto.*;
import co.edu.uniquindio.clinica.dto.admin.DetalleMedicoDTO;
import co.edu.uniquindio.clinica.dto.admin.ItemMedicoDTO;
import co.edu.uniquindio.clinica.dto.admin.RegistroMedicoDTO;
import co.edu.uniquindio.clinica.modelo.EstadoMedico;
import co.edu.uniquindio.clinica.modelo.Medico;
import co.edu.uniquindio.clinica.servicios.interfaces.AdministradorServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdministradorServicioImpl implements AdministradorServicio {

    private final MedicoRepo medicoRepo;

    @Override
    public int crearMedico(RegistroMedicoDTO medicoDTO) throws Exception {

        Medico medico = new Medico();

        medico.setNombre(medicoDTO.nombre());
        medico.setCedula(medicoDTO.cedula() );
        medico.setCorreo(medicoDTO.correo());
        medico.setCelular(medicoDTO.celular());
        medico.setDireccion(medicoDTO.direccion());
        medico.setContrasena(medicoDTO.password());
        medico.setEspecializacion(medicoDTO.especializacion());
        medico.setUrlFoto(medicoDTO.urlFoto());
        medico.setCiudad(medicoDTO.cuidad());
        medico.setHoraInicio(medicoDTO.horaInicio());
        medico.setHoraFin(medicoDTO.horaFin());
        medico.setEstadoMedico(medicoDTO.estadoMedico());

        Medico medicoNuevo = medicoRepo.save(medico);

        return medicoNuevo.getCodigo();
    }

    @Override
    public int actualizarMedico(DetalleMedicoDTO medicoDTO) throws Exception {

        Optional<Medico> opcional =medicoRepo.findById(medicoDTO.codigo());

        if( opcional.isEmpty() ){
            throw new Exception("No existe un médico con el código "+medicoDTO.codigo());
        }

        Medico buscado = opcional.get();

        buscado.setNombre(medicoDTO.nombre());
        buscado.setCedula(medicoDTO.cedula() );
        buscado.setCorreo(medicoDTO.correo());
        buscado.setCelular(medicoDTO.celular());
        buscado.setDireccion(medicoDTO.direccion());
        buscado.setEspecializacion(medicoDTO.especializacion());
        buscado.setUrlFoto(medicoDTO.urlFoto());
        buscado.setCiudad(medicoDTO.cuidad());
        buscado.setHoraInicio(medicoDTO.horaInicio());
        buscado.setHoraFin(medicoDTO.horaFin());

        medicoRepo.save(buscado);

        return buscado.getCodigo();
    }

    @Override
    public void eliminarMedico(int codigo) throws Exception {

        Optional<Medico> optional = medicoRepo.findById(codigo);

        if(optional.isEmpty()){
            throw new Exception ("No hay medico con el codigo: "+ codigo);
        }

        Medico buscado = optional.get();
        buscado.setEstadoMedico(EstadoMedico.INACTIVO);
        medicoRepo.save(buscado);

    }

    @Override
    public List<ItemMedicoDTO> listarMedicos() throws Exception {

        List<Medico> medicos = medicoRepo.findAll();

        if(medicos.isEmpty()){
            throw new Exception("No hay registro de medicos");
        }

        List<ItemMedicoDTO> respuesta = new ArrayList<>();

        for(Medico m: medicos){
            respuesta.add(new ItemMedicoDTO(
                    m.getCodigo(),
                    m.getCedula(),
                    m.getNombre(),
                    m.getUrlFoto(),
                    m.getEspecializacion()));
        }

        return respuesta;
    }

    @Override
    public DetalleMedicoDTO obtenerMedico(int codigo) throws Exception {

        Optional<Medico> opcional =medicoRepo.findById(codigo);

        if( opcional.isEmpty() ){
            throw new Exception("No existe un médico con el código "+codigo);
        }

        Medico buscado = opcional.get();

        return new DetalleMedicoDTO(
                buscado.getCodigo(),
                buscado.getNombre(),
                buscado.getCorreo(),
                buscado.getCedula(),
                buscado.getCelular(),
                buscado.getDireccion(),
                buscado.getEspecializacion(),
                buscado.getHoraInicio(),
                buscado.getHoraFin(),
                buscado.getUrlFoto(),
                buscado.getCiudad(),
                new ArrayList<>()
        );
    }

    @Override
    public List<PQRSDTOAdmin> listarPQRS() throws Exception {
        return null;
    }

    @Override
    public String responderPQRS(int codigo) throws Exception {
        return null;
    }

    @Override
    public InfoPQRSDTO verDetallePQRS(int codigo) throws Exception {
        return null;
    }

    @Override
    public List<CitaDTOAdmin> listarCitas() throws Exception {
        return null;
    }

    @Override
    public int crearUsuario() throws Exception {
        return 0;
    }

    @Override
    public int actualizarUsuario() throws Exception {
        return 0;
    }

    @Override
    public int eliminarUsuario() throws Exception {
        return 0;
    }


}
