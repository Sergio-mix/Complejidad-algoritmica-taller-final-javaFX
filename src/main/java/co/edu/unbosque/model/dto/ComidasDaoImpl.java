package co.edu.unbosque.model.dto;

import co.edu.unbosque.model.Comidas;
import co.edu.unbosque.model.Plato;
import co.edu.unbosque.model.idao.IComidasDao;

import java.util.Arrays;

public class ComidasDaoImpl implements IComidasDao {

    private Comidas comidas_A;
    private Comidas comidas_B;

    public ComidasDaoImpl(Comidas comidas_A, Comidas comidas_B) {
        this.comidas_A = comidas_A;
        this.comidas_B = comidas_B;
    }


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

    @Override
    public void clear_B() {
        this.comidas_B.setCalorias(0D);
        Arrays.fill(this.comidas_B.getPlatos(), null);
    }

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

    @Override
    public boolean exists_A(Plato e) {
        for (Plato elemento : this.comidas_A.getPlatos()) {
            if (elemento != null && elemento.equals(e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void asignarPlatos(Plato[] elementos) {
        for (Plato elemento : elementos) {
            if (!this.exists_A(elemento)) {
                if (this.comidas_A.getMaximoCalorias() > this.comidas_A.getCalorias() + elemento.getCalorias()) {
                    this.add_A(elemento);
                    this.asignarPlatos(elementos);
                    this.remove_A(elemento);
                } else {
                    this.asignarPlatos(elementos);
                }
            }
        }
    }

    public Comidas getComidas_B() {
        return comidas_B;
    }

}
