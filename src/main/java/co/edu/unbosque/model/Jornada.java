package co.edu.unbosque.model;

/**
 * Clase Jornada
 */
public class Jornada {
	/**
	 * Atributos
	 */
	private int jornada;
	private int puntuacionMax;
	private Arbitro arbitro;
	private Equipo equipo1;
	private Equipo equipo2;

	/**
	 * getJornada
	 * @return
	 */
	public int getJornada() {
		return jornada;
	}

	/**
	 * setJornada
	 * @param jornada
	 */
	public void setJornada(int jornada) {
		this.jornada = jornada;
	}

	/**
	 * getPuntuacionMax
	 * @return
	 */
	public int getPuntuacionMax() {
		return puntuacionMax;
	}

	/**
	 * setPuntuacionMax
	 * @param puntuacionMax
	 */
	public void setPuntuacionMax(int puntuacionMax) {
		this.puntuacionMax = puntuacionMax;
	}

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
	 * getEquipo1
	 * @return
	 */
	public Equipo getEquipo1() {
		return equipo1;
	}

	/**
	 * setEquipo1
	 * @param equipo1
	 */
	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}

	/**
	 * getEquipo2
	 * @return
	 */
	public Equipo getEquipo2() {
		return equipo2;
	}

	/**
	 * setEquipo2
	 * @param equipo2
	 */
	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}

	

}
