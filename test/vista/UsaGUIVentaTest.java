package vista;

import modelo.Cliente;
import modelo.Destino;
import modelo.PaqueteTuristico;
import modelo.PaqueteTuristicoMultiple;
import modelo.PaqueteTuristicoUnico;
import modelo.Venta;
import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UsaGUIVentaTest {

    @Test
    public void generarNumeroVentaRetornaSiguienteConsecutivo() throws Exception {
        UsaGUIVenta app = crearAppSinInicializarGUI();
        ArrayList<Venta> ventas = new ArrayList<>();
        ventas.add(crearVentaConPaquete(3, 'A', crearPaqueteUnico()));
        ventas.add(crearVentaConPaquete(7, 'P', crearPaqueteMultiple()));

        assertEquals(8, app.generarNumeroVenta(ventas));
    }

    @Test
    public void consultarVentaDadaPosicionInvalida() throws Exception {
        UsaGUIVenta app = crearAppSinInicializarGUI();
        ArrayList<Venta> ventas = new ArrayList<>();
        ventas.add(crearVentaConPaquete(1, 'A', crearPaqueteUnico()));

        assertEquals("Posición inválida.", app.consultarVentaDadaPosicion(ventas, 'X'));
    }

    @Test
    public void consultarVentasDadaCategoriaPaqueteFiltraCorrectamente() throws Exception {
        UsaGUIVenta app = crearAppSinInicializarGUI();
        ArrayList<Venta> ventas = new ArrayList<>();
        ventas.add(crearVentaConPaquete(1, 'A', crearPaqueteUnico()));
        ventas.add(crearVentaConPaquete(2, 'A', crearPaqueteMultiple()));

        String resultado = app.consultarVentasDadaCategoriaPaquete(ventas, "UNICO");

        assertTrue(resultado.contains("Venta 1"));
        assertFalse(resultado.contains("Venta 2"));
    }

    @Test
    public void actualizarVentaCambiaEstado() throws Exception {
        UsaGUIVenta app = crearAppSinInicializarGUI();
        ArrayList<Venta> ventas = new ArrayList<>();
        Venta venta = crearVentaConPaquete(10, 'A', crearPaqueteUnico());
        ventas.add(venta);

        String resultado = app.actualizarVenta(ventas, 10, 'C');

        assertEquals("Venta actualizada.", resultado);
        assertEquals('C', venta.getEstado());
    }

    @Test
    public void consultarVentaDadoNumeroNoEncontrada() throws Exception {
        UsaGUIVenta app = crearAppSinInicializarGUI();
        ArrayList<Venta> ventas = new ArrayList<>();
        ventas.add(crearVentaConPaquete(4, 'A', crearPaqueteUnico()));

        assertEquals("Venta no encontrada.", app.consultarVentaDadoNumero(ventas, 9));
    }

    private UsaGUIVenta crearAppSinInicializarGUI() throws Exception {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
        return (UsaGUIVenta) unsafe.allocateInstance(UsaGUIVenta.class);
    }

    private Venta crearVentaConPaquete(int numero, char estado, PaqueteTuristico paquete) {
        Cliente cliente = new Cliente('C', "123456", false, "Juan Perez", "jp@mail.com",
                "3001234567", "Juan Perez", 10.0);
        ArrayList<PaqueteTuristico> paquetes = new ArrayList<>();
        paquetes.add(paquete);
        LocalDateTime ahora = LocalDateTime.of(2024, 1, 1, 10, 0);
        return new Venta(numero, ahora, ahora, cliente, paquetes, estado);
    }

    private PaqueteTuristicoUnico crearPaqueteUnico() {
        ArrayList<Destino> destinos = new ArrayList<>();
        destinos.add(new Destino("Bogota", 2, new LinkedList<>(), true));
        return new PaqueteTuristicoUnico("Hotel Central", "Buffet",
                "PU01", "Paquete Unico", "Recreacion", "Descripcion",
                "Bogota", destinos, true, true, true, true, false, 1000, 1);
    }

    private PaqueteTuristicoMultiple crearPaqueteMultiple() {
        ArrayList<Destino> destinos = new ArrayList<>();
        destinos.add(new Destino("Bogota", 2, new LinkedList<>(), true));
        destinos.add(new Destino("Medellin", 1, new LinkedList<>(), true));
        return new PaqueteTuristicoMultiple("Obsequio",
                "PM01", "Paquete Multiple", "Recreacion", "Descripcion",
                "Bogota", destinos, true, true, true, true, false, 1000, 1);
    }
}
