package modelo;

import java.io.Serializable;
import java.util.LinkedList;

public class Destino implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombreLugar;
    private int diasPermanencia;
    private LinkedList<String> atractivos;
    private boolean atractivosIncluidos;

    public Destino(String nombreLugar, int diasPermanencia, LinkedList<String> atractivos,
                   boolean atractivosIncluidos) {
        this.nombreLugar = nombreLugar;
        setDiasPermanencia(diasPermanencia);
        this.atractivos = atractivos;
        this.atractivosIncluidos = atractivosIncluidos;
    }

    public String getNombreLugar() {
        return nombreLugar;
    }

    public void setNombreLugar(String nombreLugar) {
        this.nombreLugar = nombreLugar;
    }

    public int getDiasPermanencia() {
        return diasPermanencia;
    }

    public void setDiasPermanencia(int diasPermanencia) {
        if (diasPermanencia < 1) {
            throw new IllegalArgumentException("diasPermanencia debe ser mínimo 1");
        }
        this.diasPermanencia = diasPermanencia;
    }

    public LinkedList<String> getAtractivos() {
        return atractivos;
    }

    public void setAtractivos(LinkedList<String> atractivos) {
        this.atractivos = atractivos;
    }

    public boolean isAtractivosIncluidos() {
        return atractivosIncluidos;
    }

    public void setAtractivosIncluidos(boolean atractivosIncluidos) {
        this.atractivosIncluidos = atractivosIncluidos;
    }

    @Override
    public String toString() {
        return "Destino{" +
                "nombreLugar='" + nombreLugar + '\'' +
                ", diasPermanencia=" + diasPermanencia +
                ", atractivos=" + atractivos +
                ", atractivosIncluidos=" + atractivosIncluidos +
                '}';
    }
}
