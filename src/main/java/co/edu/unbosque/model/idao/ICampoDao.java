package co.edu.unbosque.model.idao;

import co.edu.unbosque.model.Campo;

import java.util.Map;

public interface ICampoDao {

    Map<String, Object> inicial();

    int[] aR_IZ(int posicionFilas, int posicionColumnas);

    int[] aR_DE(int posicionFilas, int posicionColumnas);

    int[] aB_IZ(int posicionFilas, int posicionColumnas);

    int[] aB_DE(int posicionFilas, int posicionColumnas);

    int[] iZ_AR(int posicionFilas, int posicionColumnas);

    int[] iZ_AB(int posicionFilas, int posicionColumnas);

    int[] dE_AR(int posicionFilas, int posicionColumnas);

    int[] dE_AB(int posicionFilas, int posicionColumnas);

    int[] verificarPosicion(Campo campo, String direccion);

    Campo seleccion(Campo campo);

    Boolean validar(Campo campo, Campo hijo);

    Integer obtenerAltura(Campo campo);

    Boolean verificar(Campo campo);

    Campo desplazar(Campo campo, String direccion);

    Campo salto(Campo campo) throws Exception;

}
