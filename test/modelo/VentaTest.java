package modelo;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class VentaTest {

    @Test
    public void calcularTotalesVenta() {
        Cliente cliente = new Cliente('C', "123456", false, "Juan Perez", "jp@mail.com",
                "3001234567", "Juan Perez", 10.0);

        ArrayList<Destino> destinos = new ArrayList<>();
        destinos.add(new Destino("Bogota", 2, new LinkedList<>(), true));
        PaqueteTuristicoUnico paquete = new PaqueteTuristicoUnico("Hotel Central", "Buffet",
                "P001", "Paquete Unico", "Recreacion", "Descripcion",
                "Bogota", destinos, true, true, true, true, false, 1000, 2);

        ArrayList<PaqueteTuristico> paquetes = new ArrayList<>();
        paquetes.add(paquete);

        LocalDateTime ahora = LocalDateTime.now();
        Venta venta = new Venta(1, ahora, ahora, cliente, paquetes, 'A');

        assertEquals(2, venta.calcularCantidadTotalUnidadesPaquetes());
        assertEquals(4000, venta.calcularValorTotalPaquetes());
        assertEquals(400, venta.calcularValorDescuento());
        assertEquals(3600, venta.calcularValorTotalPagar());
    }

    @Test(expected = IllegalArgumentException.class)
    public void estadoVentaInvalido() {
        new Venta(1, LocalDateTime.now(), LocalDateTime.now(), null, new ArrayList<>(), 'X');
    }
}
