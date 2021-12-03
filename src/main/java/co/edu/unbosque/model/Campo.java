package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.List;

public class Campo {
    private Campo padre;
    private List<Campo> hijos;
    private int posicionFila;
    private int posicionColumna;
    private boolean estado;
    private int n;

    public Campo(int posicionFila, int posicionColumna) {
        this.posicionFila = posicionFila;
        this.posicionColumna = posicionColumna;
        hijos = new ArrayList<>();
    }

    public Campo getPadre() {
        return padre;
    }

    public void setPadre(Campo padre) {
        this.padre = padre;
    }

    public List<Campo> getHijos() {
        return hijos;
    }

    public int getPosicionFila() {
        return posicionFila;
    }

    public int getPosicionColumna() {
        return posicionColumna;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "Campo{" +
                "padre=" + padre +
                ", hijos=" + hijos +
                ", posicionFila=" + posicionFila +
                ", posicionColumna=" + posicionColumna +
                ", estado=" + estado +
                ", altura=" + n +
                '}';
    }
}
