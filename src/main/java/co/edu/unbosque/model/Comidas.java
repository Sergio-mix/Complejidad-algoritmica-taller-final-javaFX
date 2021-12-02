
package co.edu.unbosque.model;

public class Comidas {

    private Double maximoCalorias;
    private Plato[] platos;
    private Double calorias;


    public Comidas(Double maximoCalorias, int numElementos) {
        this.maximoCalorias = maximoCalorias;
        this.platos = new Plato[numElementos];
        this.calorias = 0D;
    }

    public Double getMaximoCalorias() {
        return maximoCalorias;
    }

    public Plato[] getPlatos() {
        return platos;
    }

    public Double getCalorias() {
        return calorias;
    }

    public void setCalorias(Double calorias) {
        this.calorias = calorias;
    }

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
