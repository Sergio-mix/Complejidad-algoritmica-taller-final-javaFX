package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase campo
 */
public class Campo {
    private Campo padre;
    private List<Campo> hijos;
    private int posicionFila;
    private int posicionColumna;
    private boolean estado;
    private int n;

    /**
     * Constructor de la clase
     * @param posicionFila
     * @param posicionColumna
     */
    public Campo(int posicionFila, int posicionColumna) {
        this.posicionFila = posicionFila;
        this.posicionColumna = posicionColumna;
        hijos = new ArrayList<>();
    }

    /**
     * getPadre
     * @return Campo
     */
    public Campo getPadre() {
        return padre;
    }

    /**
     * setPadre
     * @param padre
     */
    public void setPadre(Campo padre) {
        this.padre = padre;
    }

    /**
     * getHijos
     * @return List<Campo>
     */
    public List<Campo> getHijos() {
        return hijos;
    }

    /**
     * getPosicionFila
     * @return int
     */
    public int getPosicionFila() {
        return posicionFila;
    }

    /**
     * getPosicionColumna
     * @return int
     */
    public int getPosicionColumna() {
        return posicionColumna;
    }

    /**
     * isEstado
     * @return boolean
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * setEstado
     * @param estado
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * getN
     * @return int
     */
    public int getN() {
        return n;
    }

    /**
     * setN
     * @param n
     */
    public void setN(int n) {
        this.n = n;
    }

    /**
     * Metodo devuelve string de las caracteristicas en el campo
     * @return String
     */
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
