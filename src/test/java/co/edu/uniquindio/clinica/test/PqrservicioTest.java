package co.edu.uniquindio.clinica.test;
import co.edu.uniquindio.clinica.dto.PQRS.ItemPqrsAdminDTO;
import co.edu.uniquindio.clinica.dto.PQRS.ItemPqrsPacDTO;
import co.edu.uniquindio.clinica.dto.PQRS.RegistroRespuestaDTO;
import co.edu.uniquindio.clinica.modelo.Enum.EstadoPqrs;
import co.edu.uniquindio.clinica.servicios.interfaces.PqrsServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@SpringBootTest
@Transactional
public class PqrservicioTest {

    @Autowired
    PqrsServicio pqrsServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void listarPQRSTest() throws Exception {
        List<ItemPqrsAdminDTO> listarPQRS= pqrsServicio.listarPQRS();
        Assertions.assertEquals(10, listarPQRS.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void cambiarEstadoPQRSTest() {
        int codigoPQRS = 1;
        EstadoPqrs estadoPQRS = EstadoPqrs.NUEVO;
        Assertions.assertDoesNotThrow(() -> pqrsServicio.cambiarEstadoPQRS(codigoPQRS, estadoPQRS));
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void listarPQRSPacienteTest() throws Exception {
        int codigoPaciente = 1;
        List<ItemPqrsPacDTO> listarPQRSPaciente = pqrsServicio.listarPQRSPaciente(codigoPaciente);
        Assertions.assertEquals(2, listarPQRSPaciente.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void registroPQRSDTOTest() throws Exception {
        RegistroRespuestaDTO registroPQRSDTO = new RegistroRespuestaDTO(
                3,
                "Disguto con el servicio prestado"
        );
        int resultado = pqrsServicio.crearPQRS(registroPQRSDTO);
        Assertions.assertEquals(1, resultado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void verDetallePQRSTest() throws Exception {
        int codigoPQRS = 1;
        pqrsServicio.verDetallePqrs(codigoPQRS);
        System.out.println();
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void responderPQRSTest() throws Exception {
        RegistroRespuestaDTO registroRespuestaPQRSDTO = new RegistroRespuestaDTO(
                2,
                "Muy mal servicio"
        );

        pqrsServicio.crearPQRS(registroRespuestaPQRSDTO);
    }



}