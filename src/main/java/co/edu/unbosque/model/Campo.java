package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase campo
 */
public class Campo {
    private Campo padre;
    private List<Campo> hijos;
    private int fila;
    private int columna;
    private boolean estado;
    private int n;

    /**
     * Constructor de la clase
     * @param fila
     * @param columna
     */
    public Campo(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
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
    public int getFila() {
        return fila;
    }

    /**
     * getPosicionColumna
     * @return int
     */
    public int getColumna() {
        return columna;
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
                ", posicionFila=" + fila +
                ", posicionColumna=" + columna +
                ", estado=" + estado +
                ", altura=" + n +
                '}';
    }
}
