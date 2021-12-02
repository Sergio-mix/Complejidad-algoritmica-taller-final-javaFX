package co.edu.unbosque.controller;

import co.edu.unbosque.model.Plato;
import co.edu.unbosque.model.Comidas;
import co.edu.unbosque.model.dto.ComidasDaoImpl;

public class Main {
    public static void main(String[] args) {

        Plato[] elementos = {
                new Plato("a", 100D),
                new Plato("b", 200D),
                new Plato("c", 320D),
                new Plato("d", 600D),
                new Plato("e", 780D)
        };

        Comidas m_base = new Comidas(400D + 400D * 0.1, elementos.length);
        Comidas m_opt = new Comidas(400D + 400D * 0.1, elementos.length);

        ComidasDaoImpl comidasDao = new ComidasDaoImpl(m_base, m_opt);
        comidasDao.asignarPlatos(elementos);

        System.out.println(comidasDao.getComidas_B());
    }
}
