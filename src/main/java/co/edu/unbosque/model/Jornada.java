package co.edu.unbosque.model;

/**
 * Clase Jornada
 */
public class Jornada {
	/**
	 * Atributos
	 */
	private Arbitro arbitro;
	private Equipo equipo1;
	private Equipo equipo2;

	public Jornada(Arbitro arbitro, Equipo equipo1, Equipo equipo2) {
		this.arbitro = arbitro;
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
	}

	public Arbitro getArbitro() {
		return arbitro;
	}

	public void setArbitro(Arbitro arbitro) {
		this.arbitro = arbitro;
	}

	public Equipo getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}

	public Equipo getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}

	@Override
	public String toString() {
		return "Jornada{" +
				"arbitro=" + arbitro +
				", equipo1=" + equipo1 +
				", equipo2=" + equipo2 +
				'}';
	}
}
