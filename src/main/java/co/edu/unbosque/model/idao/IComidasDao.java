package co.edu.unbosque.model.idao;

import co.edu.unbosque.model.Plato;

public interface IComidasDao {
    /**
     * agregar plato
     * @param e
     */
    void add_A(Plato e);

    /**
     * Agregar plato
     * @param e
     */
    void add_B(Plato e);

    /**
     * vaciar las calorias
     */
    void clear_B();

    /**
     * Elimiar plato
     * @param e
     */
    void remove_A(Plato e);

    /**
     * Verifica si existe un plato
     * @param e
     * @return
     */
    boolean exists_A(Plato e);

    /**
     * Asignar las comidas a los platos
     * @param platosBase
     * @param estado
     */
    void asignarPlatos(Plato[] platosBase, boolean estado);

}
