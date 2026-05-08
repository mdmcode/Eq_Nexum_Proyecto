package modelo;

import java.util.ArrayList;

public class PaqueteTuristico {
    protected String codigo;
    protected String nombre;
    protected String tipologiaTurismo;
    protected String descripcion;
    protected String origen;
    protected ArrayList<Destino> susDestinos;
    protected boolean hotel;
    protected boolean alimentacion;
    protected boolean alimentacionTodo;
    protected boolean vuelo;
    protected boolean asistencia;
    protected int tarifaDia;
    protected int cantidadUnidades;

    public PaqueteTuristico(String codigo, String nombre, String tipologiaTurismo, String descripcion, String origen,
                            ArrayList<Destino> susDestinos, boolean hotel, boolean alimentacion,
                            boolean alimentacionTodo, boolean vuelo, boolean asistencia, int tarifaDia,
                            int cantidadUnidades) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipologiaTurismo = tipologiaTurismo;
        this.descripcion = descripcion;
        this.origen = origen;
        this.susDestinos = susDestinos;
        this.hotel = hotel;
        this.alimentacion = alimentacion;
        this.alimentacionTodo = alimentacionTodo;
        this.vuelo = vuelo;
        this.asistencia = asistencia;
        this.tarifaDia = tarifaDia;
        this.cantidadUnidades = cantidadUnidades;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipologiaTurismo() {
        return tipologiaTurismo;
    }

    public void setTipologiaTurismo(String tipologiaTurismo) {
        this.tipologiaTurismo = tipologiaTurismo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public ArrayList<Destino> getSusDestinos() {
        return susDestinos;
    }

    public void setSusDestinos(ArrayList<Destino> susDestinos) {
        this.susDestinos = susDestinos;
    }

    public boolean isHotel() {
        return hotel;
    }

    public void setHotel(boolean hotel) {
        this.hotel = hotel;
    }

    public boolean isAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(boolean alimentacion) {
        this.alimentacion = alimentacion;
    }

    public boolean isAlimentacionTodo() {
        return alimentacionTodo;
    }

    public void setAlimentacionTodo(boolean alimentacionTodo) {
        this.alimentacionTodo = alimentacionTodo;
    }

    public boolean isVuelo() {
        return vuelo;
    }

    public void setVuelo(boolean vuelo) {
        this.vuelo = vuelo;
    }

    public boolean isAsistencia() {
        return asistencia;
    }

    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }

    public int getTarifaDia() {
        return tarifaDia;
    }

    public void setTarifaDia(int tarifaDia) {
        this.tarifaDia = tarifaDia;
    }

    public int getCantidadUnidades() {
        return cantidadUnidades;
    }

    public void setCantidadUnidades(int cantidadUnidades) {
        this.cantidadUnidades = cantidadUnidades;
    }

    public int calcularDuracionTotalDias() {
        if (susDestinos == null) {
            return 0;
        }
        int totalDias = 0;
        for (Destino destino : susDestinos) {
            totalDias += destino.getDiasPermanencia();
        }
        return totalDias;
    }

    public int calcularValorUnidad() {
        return 0;
    }

    public int calcularValorTotal() {
        return calcularValorUnidad() * cantidadUnidades;
    }

    @Override
    public String toString() {
        return "PaqueteTuristico{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", tipologiaTurismo='" + tipologiaTurismo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", origen='" + origen + '\'' +
                ", susDestinos=" + susDestinos +
                ", hotel=" + hotel +
                ", alimentacion=" + alimentacion +
                ", alimentacionTodo=" + alimentacionTodo +
                ", vuelo=" + vuelo +
                ", asistencia=" + asistencia +
                ", tarifaDia=" + tarifaDia +
                ", cantidadUnidades=" + cantidadUnidades +
                '}';
    }
}
