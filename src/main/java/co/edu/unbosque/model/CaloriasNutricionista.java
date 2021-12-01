package co.edu.unbosque.model;

import java.util.*;

public class CaloriasNutricionista {

    private List<Comida> menu;
    private Double maxCalorias;

    private List<Comida> resultado;

    public CaloriasNutricionista(List<Comida> menu, Double maxCalorias) {
        this.menu = menu;
        this.maxCalorias = maxCalorias;
        this.menu.sort((o1, o2) -> o1.getCalorias().compareTo(o2.getCalorias()));
        resultado = new ArrayList<>();
    }


    private Double sumatoriaCalorias() {
        Double sum = 0D;
        for (Comida comida : this.resultado)
            sum += comida.getCalorias();

        return sum;
    }

    private void algorítmica(int aux, int pl) {
        if (this.sumatoriaCalorias() >= this.maxCalorias) {
            return;
        } else {
            double sum = sumatoriaCalorias();
            if (this.menu.get(pl).getCalorias() <= this.maxCalorias
                    && sum <= this.maxCalorias
                    && !this.resultado.contains(this.menu.get(pl))
                    && this.menu.get(pl).getCalorias() + sum <= this.maxCalorias) {
                this.resultado.add(this.menu.get(pl));
            } else {
                pl--;
            }

            if (aux + 1 <= this.menu.size() - 1) {
                algorítmica(aux + 1, pl);
            }
        }
    }


    public Map<String, Object> calcularPlatos() {
        this.algorítmica(0, this.menu.size() - 1);

        if (this.sumatoriaCalorias() < maxCalorias)
            this.resultado.clear();

        Map<String, Object> res = new LinkedHashMap<>();
        res.put("list", resultado);
        res.put("total", this.sumatoriaCalorias());

        return res;
    }
}
