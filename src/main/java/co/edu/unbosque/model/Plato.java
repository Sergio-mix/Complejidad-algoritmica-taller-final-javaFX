
package co.edu.unbosque.model;

import java.util.Objects;

public class Plato {

    private String nombre;
    private Double calorias;

    public Plato(String nombre, Double Calorias) {
        this.nombre = nombre;
        this.calorias = Calorias;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getCalorias() {
        return calorias;
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

        return Objects.equals(this.calorias, other.calorias);
    }

    @Override
    public String toString() {
        return "Plato{" +
                "nombre='" + nombre + '\'' +
                ", Calorias=" + calorias +
                '}';
    }
}
