package co.edu.uniquindio.clinica.controladores;

import co.edu.uniquindio.clinica.dto.paciente.DetallePacienteDTO;
import co.edu.uniquindio.clinica.dto.paciente.ItemCitaPacienteDTO;
import co.edu.uniquindio.clinica.dto.paciente.RegistroPacienterDTO;
import co.edu.uniquindio.clinica.dto.token.MensajeDTO;
import co.edu.uniquindio.clinica.servicios.Impl.PacienteServicioImpl;
import co.edu.uniquindio.clinica.servicios.interfaces.PacienteServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

@RequestMapping("/api/pacientes")
public class PacienteController  {

    private  final PacienteServicio pacienteServicio;



    @DeleteMapping("/eliminar/{codigo}")
    public ResponseEntity<MensajeDTO<String>> eliminarCuenta(@PathVariable int codigo) throws
            Exception{
        pacienteServicio.eliminarCuenta(codigo);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Paciente eliminado correctamete")
        );
    }
    @GetMapping("/listar-todos")
    public ResponseEntity<MensajeDTO<List<ItemCitaPacienteDTO>>> listarTodos(){
        return ResponseEntity.ok().body( new MensajeDTO<>(false, pacienteServicio.listarTodos()) );
    }

    @PutMapping("/editar-perfil")
    public ResponseEntity<MensajeDTO<String>> editarPerfil(@Valid @RequestBody DetallePacienteDTO
                                                                   pacienteDTO) throws Exception{
        pacienteServicio.editarPerfil(pacienteDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "paciente actualizado correctamente"));

    }

}