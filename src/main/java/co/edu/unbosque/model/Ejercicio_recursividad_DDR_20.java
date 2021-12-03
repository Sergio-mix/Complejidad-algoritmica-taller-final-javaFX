package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio_recursividad_DDR_20 {
	public static Jornada jornada;
	public static Arbitro arbitro1;
	public static Scanner leer;
	public static ArrayList<Puntuacion> puntuacionList =  new ArrayList<Puntuacion>();

	public static void main(String[] args) {
		jornada = new Jornada();
		int n = 4;
		int m = 2;

		ArrayList<Arbitro> arbitroList = new ArrayList<Arbitro>();
		ArrayList<Equipo> equipoList = new ArrayList<Equipo>();

		equipoList = crearEquipos(n, equipoList);
		arbitroList = crearArbitros(n, arbitroList);
		arbitroList = evaluarArbitros(equipoList, arbitroList);


	}

//	public static void combinacionesSuma(int numero, ArrayList<Arbitro> arbitro, int suma) {
//
//		// Caso base
//		if (suma == numero) {
//
//			// Muestro los numeros
//			System.out.println(arbitro);
//
//		} else {
//			for (int i = 1; i <= numero; i++) {
//				suma += i;
//				// Si la suma es mayor que el numero no hacemos la recursividad
//				if (suma <= numero) {
//					// añado el numero
//					arbitro.add(i);
//					combinacionesSuma(numero, arbitro, suma);
//					// elimino el numero
//					arbitro.remove(arbitro.indexOf(i));
//				}
//				// deshago la suma
//				suma -= i;
//
//			}
//
//		}
//
//	}

	public static double randomArbitrary(int min, int max) {
		return Math.random() * (max - min) + min;
	}

	public static ArrayList<Equipo> crearEquipos(int n, ArrayList<Equipo> equipoList) {
		String region = "";
		leer =  new Scanner(System.in);
		for (int i = 0; i < n; i++) {
			Equipo equipo = new Equipo();
			System.out.println("Equipo: " + i+" annada region:");
			region = leer.nextLine();
			equipo.setRegion(region);

			equipoList.add(equipo);

		}
		return equipoList;
	}

	public static ArrayList<Arbitro> crearArbitros(int n, ArrayList<Arbitro> arbitroList) {
		String region = "";
		String nombre ="";
		leer =  new Scanner(System.in);
		for (int i = 0; i < n; i++) {
			Arbitro arbitro = new Arbitro();
			System.out.println("Arbitro " + i + "region :");
			region = leer.nextLine();
			System.out.println("Arbitro " + i + "Nombre :");
			nombre = leer.nextLine();
			arbitro.setRegion(region);
			arbitro.setNombre(nombre);
			arbitroList.add(arbitro);

		}
		return arbitroList;
	}

	public static ArrayList<Arbitro> evaluarArbitros(ArrayList<Equipo> equipoList, ArrayList<Arbitro> arbitroList) {
		leer =  new Scanner(System.in);
		for (int i = 0; i < arbitroList.size(); i++) {
			for(int j=0; j< equipoList.size(); j++) {
				Puntuacion puntuacion1 = new Puntuacion();
				System.out.println("equipo "+i+" califique al arbitro de 0 a 10: "+j);
				int puntuacion = leer.nextInt();
				int anteriorPuntuacion = (int) arbitroList.get(i).getPuntuacionRecibida();
				arbitroList.get(i).setPuntuacionRecibida(puntuacion+anteriorPuntuacion);
				puntuacion1.setArbitro(arbitroList.get(i));
				puntuacion1.setEquipo(equipoList.get(j));
				puntuacion1.setPuntuacion(puntuacion);
				
				puntuacionList.add(puntuacion1);
			}
		
			
		}
		return arbitroList;
	}
	public static ArrayList<Jornada> crearJornada (ArrayList<Equipo>equipoList, ArrayList<Arbitro> arbitroList, int num_jornada){
		leer =  new Scanner(System.in);
		ArrayList<Jornada>jornadaList = new ArrayList<Jornada>();
		
		for (int i = 0; i < arbitroList.size(); i++) {
			for(int j=0; j< equipoList.size(); j++) {
				if(!arbitroList.get(i).getRegion().equals(equipoList.get(j).getRegion())) {
//					if() {
//
//					}
				}
			}
		
			
		}
		
		return jornadaList;
	}


}
