package modelo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClienteTest {

    @Test
    public void crearClienteValido() {
        Cliente cliente = new Cliente('C', "123456", false, "Juan Perez", "jp@mail.com",
                "3001234567", "Juan Perez", 10.0);
        assertEquals('C', cliente.getTipoIdentificacion());
        assertEquals("123456", cliente.getNumeroIdentificacion());
        assertEquals(10.0, cliente.getPorcentajeDescuento(), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void tipoIdentificacionInvalido() {
        new Cliente('X', "123456", false, "Juan Perez", "jp@mail.com",
                "3001234567", "Juan Perez", 10.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void numeroIdentificacionCedulaCorto() {
        new Cliente('C', "123", false, "Juan Perez", "jp@mail.com",
                "3001234567", "Juan Perez", 10.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void numeroIdentificacionNitLongitudIncorrecta() {
        new Cliente('N', "12345678", true, "Empresa SAS", "info@mail.com",
                "601234567", "Contacto", 15.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void porcentajeDescuentoFueraRango() {
        new Cliente('C', "123456", false, "Juan Perez", "jp@mail.com",
                "3001234567", "Juan Perez", 80.0);
    }

    // Nueva prueba para ID negativo
    @Test(expected = IllegalArgumentException.class)
    public void crearClienteConIdNegativo_debeLanzarExcepcion() {
        new Cliente('C', "-1", false, "Juan Perez", "jp@mail.com",
                "3001234567", "Juan Perez", 5.0);
    }
}
