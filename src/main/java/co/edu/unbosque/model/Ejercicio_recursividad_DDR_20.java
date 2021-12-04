package co.edu.unbosque.model;

import java.util.*;

public class Ejercicio_recursividad_DDR_20 {
    public static Jornada jornada;
    public static Arbitro arbitro1;
    public static Scanner leer;
    public static List<Puntuacion> puntuacionList = new ArrayList<>();

    public static void main(String[] args) {
//        jornada = new Jornada();
        int n = 4;
        int a = 2;

        List<Arbitro> arbitroList = new ArrayList<>();
        List<Equipo> equipoList = new ArrayList<>();
        List<Jornada> jornada = new ArrayList<>();

        equipoList = crearEquipos(n, equipoList);
        arbitroList = crearArbitros(n, arbitroList);
        arbitroList = evaluarArbitros(equipoList, arbitroList);
        jornada = crearJornada(equipoList, arbitroList);
        jornada.forEach(System.out::println);

    }

    public static List<Equipo> crearEquipos(int n, List<Equipo> equipoList) {
        leer = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.println("Nombre: " + i + " añada Nombre:");
            String nombre = leer.nextLine();

            System.out.println("Equipo: " + i + " añada region:");
            String region = leer.nextLine();

            Equipo equipo = new Equipo(nombre, region);
            equipoList.add(equipo);
        }
        return equipoList;
    }

    public static List<Arbitro> crearArbitros(int n, List<Arbitro> arbitroList) {
        String region = "";
        String nombre = "";
        leer = new Scanner(System.in);
        for (int i = 1; i <= n; i++) {
            System.out.println("Arbitro " + i + " Nombre :");
            nombre = leer.nextLine();
            System.out.println("Arbitro " + i + " Region :");
            region = leer.nextLine();
            Arbitro arbitro = new Arbitro(nombre, region, 0, 0D);
            arbitroList.add(arbitro);
        }

        return arbitroList;
    }

    public static List<Arbitro> evaluarArbitros(List<Equipo> equipoList, List<Arbitro> arbitroList) {
        leer = new Scanner(System.in);
        for (int i = 0; i < arbitroList.size(); i++) {
            for (int j = 0; j < equipoList.size(); j++) {
                Puntuacion puntuacion1 = new Puntuacion();
                System.out.println("equipo " + i + " califique al arbitro de 0 a 10: " + j);
                int puntuacion = leer.nextInt();
                int anteriorPuntuacion = (int) arbitroList.get(i).getPuntuacionRecibida();
                arbitroList.get(i).setPuntuacionRecibida(puntuacion + anteriorPuntuacion);
                puntuacion1.setArbitro(arbitroList.get(i));
                puntuacion1.setEquipo(equipoList.get(j));
                puntuacion1.setPuntuacion(puntuacion);

                puntuacionList.add(puntuacion1);
            }
        }
        return arbitroList;
    }

    public static List<Jornada> crearJornada(List<Equipo> equipoList, List<Arbitro> arbitroList) {
        leer = new Scanner(System.in);
        int x = 0;
        List<Jornada> jornadaList = new ArrayList<>();

        while (arbitroList.size() > x) {
            for (int i = 0; i <= arbitroList.size(); i++) {
                for (int j = 0; j <= equipoList.size(); j++) {
                    for (int h = 0; h <= equipoList.size(); h++) {
                        if (!arbitroList.get(i).getRegion().equals(equipoList.get(j).getRegion())) {
                            if (!arbitroList.get(i).getRegion().equals(equipoList.get(h).getRegion())) {
                                if (!equipoList.get(j).getRegion().equals(equipoList.get(h).getRegion())) {

                                    System.out.println("Arbitro  " + arbitroList.get(i).getRegion()
                                            + " equipos " + equipoList.get(j).getRegion() + " versus " + equipoList.get(h).getRegion());

                                    Jornada jornada = new Jornada(arbitroList.get(i), equipoList.get(j), equipoList.get(h));

                                    if (!jornadaList.contains(jornada)) {
                                        if (validar(jornadaList, jornada.getArbitro())) {
                                            jornadaList.add(jornada);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            x++;
        }

        return jornadaList;
    }

    private static Boolean validar(List<Jornada> jornadas, Arbitro arbitro) {
        for (Jornada jornada : jornadas) {
            if (jornada.getArbitro() == arbitro) {
                return true;
            }
        }
        return false;
    }
}