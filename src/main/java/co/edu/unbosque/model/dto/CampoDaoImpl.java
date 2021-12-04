package co.edu.unbosque.model.dto;

import co.edu.unbosque.model.Campo;
import co.edu.unbosque.model.idao.ICampoDao;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Clase CampoDaoImpl
 */
public class CampoDaoImpl implements ICampoDao {
    /**
     * Atributos
     */
    private final String[] direcciones =
            {
                    "aR_IZ", "aR_DE", "aB_IZ", "aB_DE",
                    "iZ_AR", "iZ_AB", "dE_AR", "dE_AB"
            };
    private Campo campoSolucionado;
    private Campo main;
    private int aux = Integer.MAX_VALUE;
    private final int destinoFilas;
    private final int destinoColumnas;
    private final int ANCHO;
    private final int ALTO;
    private final int p;
    private final int q;

    /**
     * Constructor de la clase
     *
     * @param posDestinoFilas
     * @param posDestinoColumnas
     * @param campoRaiz
     * @param ancho
     * @param alto
     * @param saltoP
     * @param saltoQ
     */
    public CampoDaoImpl(int posDestinoFilas, int posDestinoColumnas, Campo campoRaiz, int ancho, int alto, int saltoP,
                        int saltoQ) {
        this.destinoFilas = posDestinoFilas;
        this.destinoColumnas = posDestinoColumnas;
        this.ANCHO = ancho;
        this.ALTO = alto;
        this.main = campoRaiz;
        this.p = saltoP;
        this.q = saltoQ;
    }

    /**
     * Metodo que guarda el estado del salto inicial
     *
     * @return Map<String, Object>
     */
    @Override
    public Map<String, Object> inicial() {
        Map<String, Object> map = new LinkedHashMap<>();
        try {
            salto(main);
            if (campoSolucionado == null) {
                return null;
            } else {
                map.put("ob", campoSolucionado);
                map.put("n", campoSolucionado.getN());
            }
            return map;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Metodo el cual evalua la posicion de arriba izquierda
     *
     * @param posicionFilas
     * @param posicionColumnas
     * @return int[]
     */
    @Override
    public int[] aR_IZ(int posicionFilas, int posicionColumnas) {
        int[] posiciones = new int[2];
        if (posicionFilas - p < 0)
            return null;
        if (posicionColumnas - q < 0)
            return null;
        posiciones[0] = posicionFilas - p;
        posiciones[1] = posicionColumnas - q;
        return posiciones;
    }

    /**
     * Metodo el cual evalua la posicion de arriba derecha
     *
     * @param posicionFilas
     * @param posicionColumnas
     * @return int[]
     */
    @Override
    public int[] aR_DE(int posicionFilas, int posicionColumnas) {
        int[] posiciones = new int[2];
        if (posicionFilas - p < 0)
            return null;
        if (posicionColumnas + q > ANCHO - 1)
            return null;
        posiciones[0] = posicionFilas - p;
        posiciones[1] = posicionColumnas + q;
        return posiciones;
    }

    /**
     * Metodo el cual evalua la posicion de abajo izquierda
     *
     * @param posicionFilas
     * @param posicionColumnas
     * @return int[]
     */
    @Override
    public int[] aB_IZ(int posicionFilas, int posicionColumnas) {
        int[] posiciones = new int[2];
        if (posicionFilas + p > ALTO - 1)
            return null;
        if (posicionColumnas + q > ANCHO - 1)
            return null;
        posiciones[0] = posicionFilas + p;
        posiciones[1] = posicionColumnas + q;
        return posiciones;
    }

    /**
     * Metodo el cual evalua la posicion de abajo derecha
     *
     * @param posicionFilas
     * @param posicionColumnas
     * @return int[]
     */
    @Override
    public int[] aB_DE(int posicionFilas, int posicionColumnas) {
        int[] posiciones = new int[2];
        if (posicionFilas + p > ALTO - 1)
            return null;
        if (posicionColumnas + q > ANCHO - 1)
            return null;
        posiciones[0] = posicionFilas + p;
        posiciones[1] = posicionColumnas + q;
        return posiciones;
    }

    /**
     * Metodo el cual evalua la posicion de izquierda arriba
     *
     * @param posicionFilas
     * @param posicionColumnas
     * @return int[]
     */
    @Override
    public int[] iZ_AR(int posicionFilas, int posicionColumnas) {
        int[] posiciones = new int[2];
        if (posicionColumnas - p < 0)
            return null;
        if (posicionFilas - q < 0)
            return null;
        posiciones[0] = posicionFilas - q;
        posiciones[1] = posicionColumnas - p;
        return posiciones;
    }

    /**
     * Metodo el cual evalua la posicion de izquierda abajo
     *
     * @param posicionFilas
     * @param posicionColumnas
     * @return int[]
     */
    @Override
    public int[] iZ_AB(int posicionFilas, int posicionColumnas) {
        int[] posiciones = new int[2];
        if (posicionColumnas - p < 0)
            return null;
        if (posicionFilas + q > ALTO - 1)
            return null;
        posiciones[0] = posicionFilas + q;
        posiciones[1] = posicionColumnas - p;
        return posiciones;
    }

    /**
     * Metodo el cual evalua la posicion de derecha arriba
     *
     * @param posicionFilas
     * @param posicionColumnas
     * @return int[]
     */
    @Override
    public int[] dE_AR(int posicionFilas, int posicionColumnas) {
        int[] posiciones = new int[2];
        if (posicionColumnas + p > ANCHO - 1)
            return null;
        if (posicionFilas - q < 0)
            return null;
        posiciones[0] = posicionFilas - q;
        posiciones[1] = posicionColumnas + p;
        return posiciones;
    }

    /**
     * Metodo el cual evalua la posicion de derecha abajo
     *
     * @param posicionFilas
     * @param posicionColumnas
     * @return int[]
     */
    @Override
    public int[] dE_AB(int posicionFilas, int posicionColumnas) {
        int[] posiciones = new int[2];
        if (posicionColumnas + p > ANCHO - 1)
            return null;
        if (posicionFilas + q > ALTO - 1)
            return null;
        posiciones[0] = posicionFilas + q;
        posiciones[1] = posicionColumnas + p;
        return posiciones;
    }

    /**
     * Metodo el cual verifica la posicion al evaluar la direccion y el campo del mismo
     *
     * @param campo
     * @param direccion
     * @return int[]
     */
    @Override
    public int[] verificarPosicion(Campo campo, String direccion) {
        int fila = campo.getPosicionFila();
        int columna = campo.getPosicionColumna();
        return switch (direccion) {
            case "aR_IZ" -> this.aR_IZ(fila, columna);
            case "aR_DE" -> this.aR_DE(fila, columna);
            case "aB_IZ" -> this.aB_IZ(fila, columna);
            case "aB_DE" -> this.aB_DE(fila, columna);
            case "iZ_AR" -> this.iZ_AR(fila, columna);
            case "iZ_AB" -> this.iZ_AB(fila, columna);
            case "dE_AR" -> this.dE_AR(fila, columna);
            case "dE_AB" -> this.dE_AB(fila, columna);
            default -> null;
        };
    }

    /**
     * Metodo el cual hace la seleccion de la mejor casilla en el campo
     *
     * @param campo
     * @return Campo
     */
    @Override
    public Campo seleccion(Campo campo) {
        Campo aux = null;
        int masCercano = Integer.MAX_VALUE;
        for (int i = 0; i < campo.getHijos().size(); i++) {
            if (!campo.getHijos().get(i).isEstado()) {
                int sumaPosiciones = campo.getHijos().get(i).getPosicionColumna()
                        + campo.getHijos().get(i).getPosicionFila();
                int sumaPosicionesDestino = destinoFilas + destinoColumnas;
                int suma = Math.abs(sumaPosicionesDestino - sumaPosiciones);
                if (suma < masCercano) {
                    aux = campo.getHijos().get(i);
                    masCercano = suma;
                }
            }
        }
        if (aux == null && campo.getPadre() != null) {
            return seleccion(campo.getPadre());
        }
        return aux;
    }

    /**
     * Metodo el cual valida Campo padre vs el campo hijo
     *
     * @param campo
     * @param hijo
     * @return Boolean
     */
    @Override
    public Boolean validar(Campo campo, Campo hijo) {
        if (campo.getHijos().size() == 0) return false;
        for (int i = 0; i < campo.getHijos().size(); i++) {
            if (campo.getHijos().get(i).getPosicionFila() == hijo.getPosicionFila()
                    && campo.getHijos().get(i).getPosicionColumna() == hijo.getPosicionColumna()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo el cual obtiene la altura deacuerdo al campo y valores ingresados
     *
     * @param campo
     * @return Integer
     */
    @Override
    public Integer obtenerAltura(Campo campo) {
        int contador = 1;
        Campo aux = campo;
        while (aux.getPadre() != null) {
            aux = aux.getPadre();
            contador++;
        }
        return contador;
    }

    /**
     * Metodo que verifica la posicion evaluando el destino de filas y columnas
     *
     * @param campo
     * @return Boolean
     */
    @Override
    public Boolean verificar(Campo campo) {
        if (campo.getPosicionFila() == destinoFilas && campo.getPosicionColumna() == destinoColumnas) {
            campoSolucionado = campo;
            aux = campo.getN();
            return true;
        }
        return false;
    }

    /**
     * Metodo que realiza el desplazamiento verificando el campo y su direccion
     *
     * @param campo
     * @param direccion
     * @return Campo
     */
    @Override
    public Campo desplazar(Campo campo, String direccion) {
        int[] posicionesNuevas = verificarPosicion(campo, direccion);
        if (posicionesNuevas != null) {
            Campo nuevoHijo = new Campo(posicionesNuevas[0], posicionesNuevas[1]);
            nuevoHijo.setPadre(campo);
            return nuevoHijo;
        }
        return null;
    }

    /**
     * Metodo que al realizar el salto devuelve el campo padre
     *
     * @param campo
     * @return Campo
     * @throws Exception
     */
    @Override
    public Campo salto(Campo campo) {
        try {
            campo.setEstado(true);
            if (campo.getN() < aux) {
                for (String movimiento : direcciones) {
                    Campo h = desplazar(campo, movimiento);
                    if (h != null) {
                        if (campo.getPadre() == null) {
                            if (!validar(campo, h)) {
                                h.setN(obtenerAltura(h));
                                verificar(h);
                                campo.getHijos().add(h);
                            }

                        } else if (!(campo.getPadre().getPosicionFila() == h.getPosicionFila()
                                && campo.getPadre().getPosicionColumna() == h.getPosicionColumna()))
                            if (!validar(campo, h)) {
                                h.setN(obtenerAltura(h));
                                verificar(h);
                                campo.getHijos().add(h);
                            }
                    }
                }
                Campo aux = seleccion(campo);
                if (aux != null) {
                    salto(aux);
                }
            } else {
                salto(campo.getPadre());
            }
            return campo;
        } catch (Exception e) {
            return null;
        }
    }
}
