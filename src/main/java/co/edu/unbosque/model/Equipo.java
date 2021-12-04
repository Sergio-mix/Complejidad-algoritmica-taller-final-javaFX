package co.edu.unbosque.model;

/**
 * Clase Equipo
 */
public class Equipo {
	/**
	 * Atributo
	 */
	private String nombre;
	private String region;


	public Equipo(String nombre, String region) {
		this.nombre = nombre;
		this.region = region;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "Equipo{" +
				"nombre='" + nombre + '\'' +
				", region='" + region + '\'' +
				'}';
	}
}
