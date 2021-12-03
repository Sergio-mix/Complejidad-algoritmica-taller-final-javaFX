package co.edu.unbosque.model;

public class Arbitro {
	private String region;
	private String nombre;
	private int partidos;
	private double puntuacionRecibida;
	
	
	public Arbitro() {

	}
	
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public int getPartidos() {
		return partidos;
	}
	public void setPartidos(int partidos) {
		this.partidos = partidos;
	}
	public double getPuntuacionRecibida() {
		return puntuacionRecibida;
	}
	public void setPuntuacionRecibida(double rmd) {
		this.puntuacionRecibida = rmd;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	

}
