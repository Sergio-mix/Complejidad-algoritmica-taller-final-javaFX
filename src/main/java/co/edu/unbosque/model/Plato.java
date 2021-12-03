
package co.edu.unbosque.model;

import java.util.Objects;

/**
 * Clase plato
 */
public class Plato {

    private String nombre;
    private Double calorias;

    /**
     * Constructor de la clase
     * @param nombre
     * @param Calorias
     */
    public Plato(String nombre, Double Calorias) {
        this.nombre = nombre;
        this.calorias = Calorias;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * getCalorias
     * @return
     */
    public Double getCalorias() {
        return calorias;
    }

    /**
     * Metodo para validar si el plato se encuentra
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Plato other = (Plato) obj;

        return Objects.equals(this.calorias, other.calorias);
    }

    /**
     * Devuelve un string con el conmbre del plato y su total de calorias
     * @return
     */
    @Override
    public String toString() {
        return "Plato{" +
                "nombre='" + nombre + '\'' +
                ", Calorias=" + calorias +
                '}';
    }
}
