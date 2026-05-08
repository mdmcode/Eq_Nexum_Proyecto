package modelo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class PaqueteTuristicoUnicoTest {

    @Test
    public void calcularValorUnidadUnico() {
        ArrayList<Destino> destinos = new ArrayList<>();
        destinos.add(new Destino("Bogota", 2, new LinkedList<>(), true));
        destinos.add(new Destino("Medellin", 3, new LinkedList<>(), true));

        PaqueteTuristicoUnico paquete = new PaqueteTuristicoUnico("Hotel Central", "Buffet",
                "P001", "Paquete Unico", "Recreacion", "Descripcion",
                "Bogota", destinos, true, true, true, true, false, 1000, 2);

        assertEquals(5000, paquete.calcularValorUnidad());
        assertEquals(10000, paquete.calcularValorTotal());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nombreMinimo10Caracteres() {
        new PaqueteTuristicoUnico("Hotel Central", "Buffet",
                "P001", "Corto", "Recreacion", "Descripcion",
                "Bogota", new ArrayList<>(), true, true, true, true, false, 1000, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void descripcionMaximo500Caracteres() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 501; i++) {
            sb.append('a');
        }
        new PaqueteTuristicoUnico("Hotel Central", "Buffet",
                "P001", "Paquete Unico", "Recreacion", sb.toString(),
                "Bogota", new ArrayList<>(), true, true, true, true, false, 1000, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void tarifaDiaMayorCero() {
        new PaqueteTuristicoUnico("Hotel Central", "Buffet",
                "P001", "Paquete Unico", "Recreacion", "Descripcion",
                "Bogota", new ArrayList<>(), true, true, true, true, false, 0, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cantidadUnidadesMinimoUno() {
        new PaqueteTuristicoUnico("Hotel Central", "Buffet",
                "P001", "Paquete Unico", "Recreacion", "Descripcion",
                "Bogota", new ArrayList<>(), true, true, true, true, false, 1000, 0);
    }
}
