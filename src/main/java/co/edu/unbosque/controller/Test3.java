package co.edu.unbosque.controller;

import co.edu.unbosque.model.Campo;
import co.edu.unbosque.model.dto.CampoDaoImpl;

import java.util.Map;

public class Test3 {
    private static int ANCHO = 4;
    private static int ALTO = 4;
    private static int destinoFilas = 0;
    private static int destinoColumnas = 0;
    private static int aux = 0;

    public static void main(String[] args) throws Exception {
        Campo campo = new Campo(1, 2);
        CampoDaoImpl rama = new CampoDaoImpl(destinoFilas, destinoColumnas, campo, ANCHO, ALTO, 1, 0);
        Map<String, Object> map = rama.inicial();

        aux = (int) map.get("n");
        imprimirMatriz((Campo) map.get("ob"));
    }

    private static void imprimirMatriz(Campo posicion) {
        int n = 0;
        while (aux > n) {
            for (int i = 0; i < ANCHO; i++) {
                for (int j = 0; j < ALTO; j++) {
                    if (i == destinoFilas && j == destinoColumnas) {
                        System.out.print("-" + " ");
                    } else if (i == posicion.getPosicionFila() && j == posicion.getPosicionColumna()) {
                        System.out.print("X" + " ");
                    } else {
                        System.out.print("0" + " ");
                    }
                }
                System.out.println();
            }
            System.out.println();
            posicion = posicion.getPadre();
            n++;
        }
    }
}
