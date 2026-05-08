package modelo;

public final class PaqueteTuristicoMultiple extends PaqueteTuristico {
    private String obsequio;

    public PaqueteTuristicoMultiple(String obsequio, String codigo, String nombre,
                                    String tipologiaTurismo, String descripcion, String origen,
                                    java.util.ArrayList<Destino> susDestinos, boolean hotel,
                                    boolean alimentacion, boolean alimentacionTodo, boolean vuelo,
                                    boolean asistencia, int tarifaDia, int cantidadUnidades) {
        super(codigo, nombre, tipologiaTurismo, descripcion, origen, susDestinos, hotel,
                alimentacion, alimentacionTodo, vuelo, asistencia, tarifaDia, cantidadUnidades);
        this.obsequio = obsequio;
    }

    public String getObsequio() {
        return obsequio;
    }

    public void setObsequio(String obsequio) {
        this.obsequio = obsequio;
    }

    @Override
    public int calcularValorUnidad() {
        int duracionTotal = calcularDuracionTotalDias();
        int cantidadDestinos = susDestinos == null ? 0 : susDestinos.size();
        double incremento = tarifaDia * 0.01 * cantidadDestinos;
        return (int) Math.round((tarifaDia * duracionTotal) + incremento);
    }

    public Destino obtenerDestinoInicial() {
        if (susDestinos == null || susDestinos.isEmpty()) {
            return null;
        }
        return susDestinos.get(0);
    }

    public Destino obtenerDestinoFinal() {
        if (susDestinos == null || susDestinos.isEmpty()) {
            return null;
        }
        return susDestinos.get(susDestinos.size() - 1);
    }

    @Override
    public String toString() {
        return "PaqueteTuristicoMultiple{" +
                "obsequio='" + obsequio + '\'' +
                ", " + super.toString() +
                '}';
    }
}
