package co.edu.unbosque.model;

/**
 * Clase Puntuacion
 */
public class Puntuacion {
	/**
	 * Atributos
	 */
	private Arbitro arbitro;
	private Equipo equipo;
	private int puntuacion;


	/**
	 * getArbitro
	 * @return
	 */
	public Arbitro getArbitro() {
		return arbitro;
	}

	/**
	 * setArbitro
	 * @param arbitro
	 */
	public void setArbitro(Arbitro arbitro) {
		this.arbitro = arbitro;
	}

	/**
	 * getEquipo
	 * @return
	 */
	public Equipo getEquipo() {
		return equipo;
	}

	/**
	 * SetEquipo
	 * @param equipo
	 */
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	/**
	 * getPuntuacion
	 * @return
	 */
	public int getPuntuacion() {
		return puntuacion;
	}

	/**
	 * setPuntuacion
	 * @param puntuacion
	 */
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	

}
