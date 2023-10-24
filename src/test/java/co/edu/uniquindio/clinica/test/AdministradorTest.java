package co.edu.uniquindio.clinica.test;


//import co.edu.uniquindio.clinica.dto.ItemPqrsDTO;
import co.edu.uniquindio.clinica.dto.admin.ItemMedicoDTO;
import co.edu.uniquindio.clinica.dto.admin.RegistroMedicoDTO;
//import co.edu.uniquindio.clinica.modelo.enums.Ciudad;
//import co.edu.uniquindio.clinica.modelo.enums.Dia;
//import co.edu.uniquindio.clinica.modelo.enums.Especialidad;
//import co.edu.uniquindio.clinica.modelo.enums.EstadoPqrs;
import co.edu.uniquindio.clinica.servicios.interfaces.AdministradorServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
public class AdministradorTest {

    @Autowired
    private AdministradorServicio administradorServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearMedicoTest() {

        List<RegistroHorarioDTO> horarios = new ArrayList<>();

        horarios.add(new RegistroHorarioDTO(Dia.LUNES, LocalTime.of(7, 33, 0), LocalTime.of(8, 0, 0)));
        RegistroMedicoDTO registroMedicoDTO = new RegistroMedicoDTO("12345",
                "alejandro zapata",
                "foto_url",
                Ciudad.ARMENIA,
                "3102423689",
                "abc@gmail.com",
                50000,
                "pass_encriptada",
                Especialidad.PEDIATRIA,
                horarios);

        try {
            int codigoAdmin = administradorServicio.crearMedico(registroMedicoDTO);

            Assertions.assertNotEquals(0, codigoAdmin);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarMedicoTest() throws Exception {
        ActualizarMedicoDTO actualizarMedicoDTO = administradorServicio.obtenerMedico(1);

        ActualizarMedicoDTO nuevo = new ActualizarMedicoDTO(
                actualizarMedicoDTO.cedula(),
                actualizarMedicoDTO.nombre(),
                "otra foto",
                actualizarMedicoDTO.ciudad(),
                actualizarMedicoDTO.telefono(),
                actualizarMedicoDTO.email(),
                actualizarMedicoDTO.especialidad(),
                actualizarMedicoDTO.precioConsulta(),
                actualizarMedicoDTO.horarioDTO(),
                actualizarMedicoDTO.estado()
        );

        try {
            administradorServicio.actualizarMedico(1, nuevo);

            ActualizarMedicoDTO actualizado = administradorServicio.obtenerMedico(1);

            Assertions.assertEquals("otra foto", actualizado.foto());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerMedico() {

        try {
            ActualizarMedicoDTO actualizarMedicoDTO = administradorServicio.obtenerMedico(1);
            Assertions.assertEquals("Dr. Juan Perez", actualizarMedicoDTO.nombre());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarMedico() {
        try {
            administradorServicio.eliminarMedico(1);

            ActualizarMedicoDTO actualizarMedicoDTO = administradorServicio.obtenerMedico(1);
            Assertions.assertFalse(actualizarMedicoDTO.estado());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarMedicos() {
        List<ItemMedicoDTO> listaMedicos;
        try {
            listaMedicos = administradorServicio.listarMedicos();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals(5,listaMedicos.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarPqrs() {
        List<ItemPqrsDTO> listaPqrs;
        try {
            listaPqrs = administradorServicio.listarPqrs();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals(5,listaPqrs.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void cambiarEstadoPqrs() {

        try {
            administradorServicio.cambiarEstadoPqrs(new EstadoPqrsDTO(
                    1,
                    EstadoPqrs.ARCHIVADO
            ));

            Optional<ItemPqrsDTO> optional = administradorServicio.listarPqrs().stream().filter(p -> p.codigoRadicacion() == 1).findFirst();

            Assertions.assertEquals(EstadoPqrs.ARCHIVADO, optional.get().estadoPqrs());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void mostrarDetalleConsultaPqrs() {

        try {
            DetalleConsultaPqrsDTO detalleConsultaPqrsDTO = administradorServicio.mostrarDetalleConsultaPqrs(1);

            Assertions.assertEquals("Gripe comun", detalleConsultaPqrsDTO.diagnostico());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void responderPqrs() {

        RespuestaAdminPqrsDTO respuestaAdminPqrsDTO = new RespuestaAdminPqrsDTO(1, 1, "Estamos tramitando su pqrs");

        try {
            int codigoRespuestaPqrs = administradorServicio.responderPqrs(respuestaAdminPqrsDTO);

            Assertions.assertNotEquals(0, codigoRespuestaPqrs);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCitas() {
        List<ItemCitaAdminDTO> citaAdminDTOList;
        try {
            citaAdminDTOList = administradorServicio.listarCitas();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals(5,citaAdminDTOList.size());

    }
}