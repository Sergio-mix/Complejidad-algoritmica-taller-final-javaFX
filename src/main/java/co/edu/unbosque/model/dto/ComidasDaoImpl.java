package co.edu.unbosque.model.dto;

import co.edu.unbosque.model.Comidas;
import co.edu.unbosque.model.Plato;
import co.edu.unbosque.model.idao.IComidasDao;

import java.util.Arrays;

/**
 * Clase ComidasDaoImpl
 */
public class ComidasDaoImpl implements IComidasDao {

    private Comidas comidas_A;
    private Comidas comidas_B;

    /**
     * Constructor de la clase
     * @param comidas_A
     * @param comidas_B
     */
    public ComidasDaoImpl(Comidas comidas_A, Comidas comidas_B) {
        this.comidas_A = comidas_A;
        this.comidas_B = comidas_B;
    }

    /**
     * Metodo para agregar el plato a las comidas
     * @param e
     */
    @Override
    public void add_A(Plato e) {
        for (int i = 0; i < this.comidas_A.getPlatos().length; i++) {
            if (this.comidas_A.getPlatos()[i] == null) {
                this.comidas_A.getPlatos()[i] = e;
                this.comidas_A.setCalorias(this.comidas_A.getCalorias() + e.getCalorias());
                break;
            }
        }
    }

    /**
     * Metodo para agregar el plato a las comidas
     * @param e
     */
    @Override
    public void add_B(Plato e) {
        for (int i = 0; i < this.comidas_B.getPlatos().length; i++) {
            if (this.comidas_B.getPlatos()[i] == null) {
                this.comidas_B.getPlatos()[i] = e;
                this.comidas_B.setCalorias(this.comidas_B.getCalorias() + e.getCalorias());
                break;
            }
        }
    }

    /**
     * Metodo para vaciar las calorias de un plato
     */
    @Override
    public void clear_B() {
        this.comidas_B.setCalorias(0D);
        Arrays.fill(this.comidas_B.getPlatos(), null);
    }

    /**
     * Metodo que permite eliminar eliminar un plato de la comida
     * @param e
     */
    @Override
    public void remove_A(Plato e) {
        for (int i = 0; i < this.comidas_A.getPlatos().length; i++) {
            if (this.comidas_A.getPlatos()[i].equals(e)) {
                this.comidas_A.getPlatos()[i] = null;
                this.comidas_A.setCalorias(this.comidas_A.getCalorias() - e.getCalorias());
                break;
            }
        }
    }

    /**
     * Metodo que verifica si existen platos
     * @param e
     * @return
     */
    @Override
    public boolean exists_A(Plato e) {
        for (Plato elemento : this.comidas_A.getPlatos()) {
            if (elemento != null && elemento.equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Este metodo permite asignar la comida a los platos
     * @param elementos
     * @param llena
     */
    @Override
    public void asignarPlatos(Plato[] elementos, boolean llena) {
        if (llena) {
            if (this.comidas_A.getCalorias() > this.comidas_B.getCalorias()) {

                Plato[] elementosMochBase = this.comidas_A.getPlatos();
                this.clear_B();

                for (Plato e : elementosMochBase) {
                    if (e != null) {
                        this.add_B(e);
                    }
                }
            }
        } else {
            for (Plato elemento : elementos) {
                if (!this.exists_A(elemento)) {
                    if (this.comidas_A.getMaximoCalorias() > this.comidas_A.getCalorias() + elemento.getCalorias()) {
                        this.add_A(elemento);
                        this.asignarPlatos(elementos, false);
                        this.remove_A(elemento);
                    } else {
                        this.asignarPlatos(elementos, true);
                    }
                }
            }
        }
    }


    /**
     * getComidas_B
     * @return
     */
    public Comidas getComidas_B() {
        return comidas_B;
    }

    /**
     * platos_all
     * @return
     */
    public Plato[] platos_all() {
        return comidas_B.getPlatos();
    }

    /**
     * caloriasNum
     * @return
     */
    public Double caloriasNum() {
        return comidas_B.getCalorias();
    }

}
