package co.edu.unbosque.model;

/**
 * Clase Arbitro
 */
public class Arbitro {
	private String nombre;
	private String region;
	private Integer partidos;
	private Double puntuacionRecibida;

	/**
	 * Constructor de la clase
	 */
	public Arbitro(String nombre, String region, Integer partidos, Double puntuacionRecibida) {
		this.nombre = nombre;
		this.region = region;
		this.partidos = partidos;
		this.puntuacionRecibida = puntuacionRecibida;
	}

	/**
	 * getRegion
	 * @return
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * setRegion
	 * @param region
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * getPartidos
	 * @return
	 */
	public int getPartidos() {
		return partidos;
	}

	/**
	 * setPartidos
	 * @param partidos
	 */
	public void setPartidos(int partidos) {
		this.partidos = partidos;
	}

	/**
	 * getPuntuacionRecibida
	 * @return
	 */
	public double getPuntuacionRecibida() {
		return puntuacionRecibida;
	}

	/**
	 * setPuntuacionRecibida
	 * @param rmd
	 */
	public void setPuntuacionRecibida(double rmd) {
		this.puntuacionRecibida = rmd;
	}

	/**
	 * getNombre
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * setNombre
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Arbitro{" +
				"nombre='" + nombre + '\'' +
				", region='" + region + '\'' +
				", partidos=" + partidos +
				", puntuacionRecibida=" + puntuacionRecibida +
				'}';
	}
}
