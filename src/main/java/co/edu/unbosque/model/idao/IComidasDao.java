package co.edu.unbosque.model.idao;

import co.edu.unbosque.model.Comidas;
import co.edu.unbosque.model.Plato;

public interface IComidasDao {

    void add_A(Plato e);

    void add_B(Plato e);

    void clear_B();

    void remove_A(Plato e);

    boolean exists_A(Plato e);

    void asignarPlatos(Plato[] elementos);

}
