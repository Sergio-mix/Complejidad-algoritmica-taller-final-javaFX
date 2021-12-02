
package co.edu.unbosque.model;

import java.util.Objects;

public class Plato {

    private String nombre;
    private Double Calorias;

    public Plato(String nombre, Double Calorias) {
        this.nombre = nombre;
        this.Calorias = Calorias;
    }

    public Double getCalorias() {
        return Calorias;
    }

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

        return Objects.equals(this.Calorias, other.Calorias);
    }

    @Override
    public String toString() {
        return "Plato{" +
                "nombre='" + nombre + '\'' +
                ", Calorias=" + Calorias +
                '}';
    }
}
