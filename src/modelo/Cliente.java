package modelo;

public class Cliente {
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
        this.tipoIdentificacion = tipoIdentificacion;
        this.numeroIdentificacion = numeroIdentificacion;
        this.empresa = empresa;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.nombreContacto = nombreContacto;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public char getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(char tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
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
