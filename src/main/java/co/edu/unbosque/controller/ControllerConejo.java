package co.edu.unbosque.controller;

import co.edu.unbosque.components.ObjectView;
import co.edu.unbosque.model.Campo;
import co.edu.unbosque.model.dto.CampoDaoImpl;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class ControllerConejo {
    @FXML
    private VBox container;

    @FXML
    private TextField txtAlto;

    @FXML
    private TextField txtAncho;

    @FXML
    private TextField txtColumnaActual;

    @FXML
    private TextField txtColumnasDestino;

    @FXML
    private TextField txtFilaActual;

    @FXML
    private TextField txtFilaDestino;

    @FXML
    private TextField txtSaltoP;

    @FXML
    private TextField txtSaltoQ;

    private int aux = 0;

    @FXML
    public void calcular() {
        try {
            String txtAltoT = txtAlto.getText();
            String txtAnchoT = txtAncho.getText();
            String txtColumnaActualT = txtColumnaActual.getText();
            String txtColumnasDestinoT = txtColumnasDestino.getText();
            String txtFilaActualT = txtFilaActual.getText();
            String txtFilaDestinoT = txtFilaDestino.getText();
            String txtSaltoPT = txtSaltoP.getText();
            String txtSaltoQT = txtSaltoQ.getText();

            if (!Objects.equals(txtAltoT, "") && !Objects.equals(txtAnchoT, "")
                    && !Objects.equals(txtColumnaActualT, "")
                    && !Objects.equals(txtColumnasDestinoT, "") && !Objects.equals(txtFilaActualT, "")
                    && !Objects.equals(txtFilaDestinoT, "") && !Objects.equals(txtSaltoPT, "")
                    && !Objects.equals(txtSaltoQT, "")) {

                Integer alto = Integer.parseInt(txtAltoT);
                Integer ancho = Integer.parseInt(txtAnchoT);
                Integer columnaActual = Integer.parseInt(txtColumnaActualT);
                Integer columnasDestino = Integer.parseInt(txtColumnasDestinoT);
                Integer filaActual = Integer.parseInt(txtFilaActualT);
                Integer filaDestino = Integer.parseInt(txtFilaDestinoT);
                Integer saltoP = Integer.parseInt(txtSaltoPT);
                Integer saltoQ = Integer.parseInt(txtSaltoQT);

                Campo campo = new Campo(
                        filaActual, columnaActual
                );

                CampoDaoImpl rama = new CampoDaoImpl(
                        filaDestino, columnasDestino,
                        campo, ancho, alto,
                        saltoP, saltoQ
                );

                Map<String, Object> map = rama.inicial();
                if (map != null) {
                    aux = (int) map.get("n");
                    matriz((Campo) map.get("ob"), ancho, alto, filaDestino, columnasDestino);
                }else{
                    ObjectView.mostrarAlertInfo("Valores no validos");
                }
            } else {
                ObjectView.mostrarAlertInfo("Hay campos vacíos");
            }
        } catch (RuntimeException e) {
            ObjectView.mostrarAlertInfo("Valores no validos");
        }
    }

    @FXML
    private void matriz(Campo posicion, int ancho, int alto, int destinoFilas, int destinoColumnas) {
        try {
            this.container.getChildren().clear();
            int n = 0;

            GridPane gridPane = ObjectView.gridPane_v2();

            String[][] matriz = new String[ancho][alto];

            while (aux > n) {
                for (int i = 0; i < ancho; i++) {
                    for (int j = 0; j < alto; j++) {
                        if (i == destinoFilas && j == destinoColumnas) {
                            matriz[i][j] = "-";
                        } else if (i == posicion.getPosicionFila() && j == posicion.getPosicionColumna()) {
                            matriz[i][j] = "x";
                        } else if (matriz[i][j] != "x")
                            matriz[i][j] = "0";
                    }
                }
                posicion = posicion.getPadre();
                n++;
            }

            for (int i = 0; i < ancho; i++) {
                for (int j = 0; j < alto; j++) {
                    if (matriz[i][j].equals("-")) {
                        gridPane.add(ObjectView.text("#d41913", "x", 20), j, i);
                    } else if (matriz[i][j].equals("x")) {
                        gridPane.add(ObjectView.text("#2ade5a", "#", 20), j, i);
                    } else {
                        gridPane.add(ObjectView.text("#FFFFFF", "0", 20), j, i);
                    }
                }
            }

            this.add(gridPane);
        } catch (RuntimeException e) {
            ObjectView.mostrarAlertInfo("Valores no validos");
        }
    }

    /**
     * Método para abrir la ventana principal
     *
     * @throws IOException
     */
    @FXML
    public void home() throws IOException {
        Main.setRoot("index");
    }

    private void add(Object ob) {
        this.container.getChildren().add((Node) ob);
    }
}
