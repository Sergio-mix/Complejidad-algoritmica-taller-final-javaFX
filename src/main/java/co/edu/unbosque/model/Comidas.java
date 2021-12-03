
package co.edu.unbosque.model;

/**
 * Clase Comidas
 */
public class Comidas {

    private Double maximoCalorias;
    private Plato[] platos;
    private Double calorias;

    /**
     * Constructor
     * @param maximoCalorias
     * @param numElementos
     */
    public Comidas(Double maximoCalorias, int numElementos) {
        this.maximoCalorias = maximoCalorias;
        this.platos = new Plato[numElementos];
        this.calorias = 0D;
    }

    /**
     * getMaximoCalorias
     * @return
     */
    public Double getMaximoCalorias() {
        return maximoCalorias;
    }

    /**
     * getPlatos
     * @return
     */
    public Plato[] getPlatos() {
        return platos;
    }

    /**
     * getCalorias
     * @return
     */
    public Double getCalorias() {
        return calorias;
    }

    /**
     * setCalorias
     * @param calorias
     */
    public void setCalorias(Double calorias) {
        this.calorias = calorias;
    }

    /**
     * Metodo para mostrar las comidas con el numero total de calorias
     * @return
     */
    public String toString() {
        StringBuilder cadena = new StringBuilder();
        for (Plato elemento : this.platos) {
            if (elemento != null) {
                cadena.append(elemento).append("\n");
            }
        }
        cadena.append("Total Calorias: ").append(getCalorias()).append("\n");
        return cadena.toString();
    }

}
