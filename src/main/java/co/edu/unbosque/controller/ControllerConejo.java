package co.edu.unbosque.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;

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

    public void calcular(){

    }

    /**
     * Método para abrir la ventana principal
     * @throws IOException
     */
    @FXML
    public void home() throws IOException {
        Main.setRoot("index");
    }
}
