package modelo;

import java.io.Serializable;

public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    private char tipoIdentificacion;
    private String numeroIdentificacion;
    private boolean empresa;
    private String nombre;
    private String email;
    private String telefono;
    private String nombreContacto;
    private double porcentajeDescuento;

    public Cliente(char tipoIdentificacion, String numeroIdentificacion, boolean empresa, String nombre,
                   String email, String telefono, String nombreContacto, double porcentajeDescuento) {
        setTipoIdentificacion(tipoIdentificacion);
        setNumeroIdentificacion(numeroIdentificacion);
        this.empresa = empresa;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.nombreContacto = nombreContacto;
        setPorcentajeDescuento(porcentajeDescuento);
    }

    public char getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(char tipoIdentificacion) {
        char valor = Character.toUpperCase(tipoIdentificacion);
        if (valor != 'C' && valor != 'N') {
            throw new IllegalArgumentException("tipoIdentificacion debe ser C o N");
        }
        this.tipoIdentificacion = valor;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        if (numeroIdentificacion == null || numeroIdentificacion.isBlank()) {
            throw new IllegalArgumentException("numeroIdentificacion es obligatorio");
        }
        String valor = numeroIdentificacion.trim();
        if (tipoIdentificacion == 'C' && valor.length() < 6) {
            throw new IllegalArgumentException("numeroIdentificacion para cédula mínimo 6 dígitos");
        }
        if (tipoIdentificacion == 'N' && valor.length() != 9) {
            throw new IllegalArgumentException("numeroIdentificacion para NIT debe tener 9 dígitos");
        }
        this.numeroIdentificacion = valor;
    }

    public boolean isEmpresa() {
        return empresa;
    }

    public void setEmpresa(boolean empresa) {
        this.empresa = empresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        if (porcentajeDescuento < 0.0 || porcentajeDescuento > 70.0) {
            throw new IllegalArgumentException("porcentajeDescuento debe estar entre 0.0 y 70.0");
        }
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "tipoIdentificacion=" + tipoIdentificacion +
                ", numeroIdentificacion='" + numeroIdentificacion + '\'' +
                ", empresa=" + empresa +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", nombreContacto='" + nombreContacto + '\'' +
                ", porcentajeDescuento=" + porcentajeDescuento +
                '}';
    }
}
