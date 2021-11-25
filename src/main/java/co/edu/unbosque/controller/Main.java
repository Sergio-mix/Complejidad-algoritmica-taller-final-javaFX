package co.edu.unbosque.controller;

import co.edu.unbosque.model.CaloriasNutricionista;
import co.edu.unbosque.model.Comida;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Comida> comidas = new ArrayList<>();
        comidas.add(new Comida("a", 100D));
        comidas.add(new Comida("b", 200D));
        comidas.add(new Comida("c", 421D));
        comidas.add(new Comida("d", 10D));
        comidas.add(new Comida("e", 423D));
        comidas.add(new Comida("f", 178D));
        comidas.add(new Comida("g", 323D));

        CaloriasNutricionista calorias = new CaloriasNutricionista(comidas, 600D);
        System.out.println(calorias.calcularPlatos().get("total"));
        System.out.println(calorias.calcularPlatos().get("list"));

    }
}
