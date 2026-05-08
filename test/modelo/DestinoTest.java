package modelo;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class DestinoTest {

    @Test
    public void crearDestinoValido() {
        LinkedList<String> atractivos = new LinkedList<>();
        atractivos.add("Museo");
        Destino destino = new Destino("Bogota", 2, atractivos, true);
        assertEquals(2, destino.getDiasPermanencia());
        assertEquals("Bogota", destino.getNombreLugar());
    }

    @Test(expected = IllegalArgumentException.class)
    public void diasPermanenciaMinimoUno() {
        new Destino("Bogota", 0, new LinkedList<>(), false);
    }
}
