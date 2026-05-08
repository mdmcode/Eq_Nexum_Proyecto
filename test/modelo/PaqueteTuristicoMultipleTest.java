package modelo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class PaqueteTuristicoMultipleTest {

    @Test
    public void calcularValorUnidadMultiple() {
        ArrayList<Destino> destinos = new ArrayList<>();
        destinos.add(new Destino("Bogota", 2, new LinkedList<>(), true));
        destinos.add(new Destino("Medellin", 3, new LinkedList<>(), true));

        PaqueteTuristicoMultiple paquete = new PaqueteTuristicoMultiple("Obsequio",
                "P002", "Paquete Multiple", "Recreacion", "Descripcion",
                "Bogota", destinos, true, true, true, true, false, 1000, 1);

        assertEquals(5020, paquete.calcularValorUnidad());
        assertEquals("Bogota", paquete.obtenerDestinoInicial().getNombreLugar());
        assertEquals("Medellin", paquete.obtenerDestinoFinal().getNombreLugar());
    }
}
