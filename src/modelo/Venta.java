package modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Venta implements Serializable {
    private static final long serialVersionUID = 1L;

    private int numero;
    private LocalDateTime fechaHoraGeneracion;
    private LocalDateTime fechaHoraActualizacion;
    private Cliente suCliente;
    private ArrayList<PaqueteTuristico> susPaquetesTuristicos;
    private char estado;

    public Venta(int numero, LocalDateTime fechaHoraGeneracion, LocalDateTime fechaHoraActualizacion,
                 Cliente suCliente, ArrayList<PaqueteTuristico> susPaquetesTuristicos, char estado) {
        this.numero = numero;
        this.fechaHoraGeneracion = fechaHoraGeneracion;
        this.fechaHoraActualizacion = fechaHoraActualizacion;
        this.suCliente = suCliente;
        this.susPaquetesTuristicos = susPaquetesTuristicos;
        setEstado(estado);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDateTime getFechaHoraGeneracion() {
        return fechaHoraGeneracion;
    }

    public void setFechaHoraGeneracion(LocalDateTime fechaHoraGeneracion) {
        this.fechaHoraGeneracion = fechaHoraGeneracion;
    }

    public LocalDateTime getFechaHoraActualizacion() {
        return fechaHoraActualizacion;
    }

    public void setFechaHoraActualizacion(LocalDateTime fechaHoraActualizacion) {
        this.fechaHoraActualizacion = fechaHoraActualizacion;
    }

    public Cliente getSuCliente() {
        return suCliente;
    }

    public void setSuCliente(Cliente suCliente) {
        this.suCliente = suCliente;
    }

    public ArrayList<PaqueteTuristico> getSusPaquetesTuristicos() {
        return susPaquetesTuristicos;
    }

    public void setSusPaquetesTuristicos(ArrayList<PaqueteTuristico> susPaquetesTuristicos) {
        this.susPaquetesTuristicos = susPaquetesTuristicos;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        char valor = Character.toUpperCase(estado);
        if (valor != 'A' && valor != 'P' && valor != 'C') {
            throw new IllegalArgumentException("estado debe ser A, P o C");
        }
        this.estado = valor;
    }

    public int calcularCantidadTotalUnidadesPaquetes() {
        if (susPaquetesTuristicos == null) {
            return 0;
        }
        int totalUnidades = 0;
        for (PaqueteTuristico paquete : susPaquetesTuristicos) {
            totalUnidades += paquete.getCantidadUnidades();
        }
        return totalUnidades;
    }

    public int calcularValorTotalPaquetes() {
        if (susPaquetesTuristicos == null) {
            return 0;
        }
        int total = 0;
        for (PaqueteTuristico paquete : susPaquetesTuristicos) {
            total += paquete.calcularValorTotal();
        }
        return total;
    }

    public int calcularValorDescuento() {
        double porcentaje = suCliente == null ? 0.0 : suCliente.getPorcentajeDescuento();
        return (int) Math.round(calcularValorTotalPaquetes() * (porcentaje / 100.0));
    }

    public int calcularValorTotalPagar() {
        return calcularValorTotalPaquetes() - calcularValorDescuento();
    }

    @Override
    public String toString() {
        return "Venta{" +
                "numero=" + numero +
                ", fechaHoraGeneracion=" + fechaHoraGeneracion +
                ", fechaHoraActualizacion=" + fechaHoraActualizacion +
                ", suCliente=" + suCliente +
                ", susPaquetesTuristicos=" + susPaquetesTuristicos +
                ", estado=" + estado +
                '}';
    }
}
