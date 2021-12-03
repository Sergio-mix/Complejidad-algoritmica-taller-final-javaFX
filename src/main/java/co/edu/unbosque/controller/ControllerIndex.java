package co.edu.unbosque.controller;

import javafx.fxml.FXML;

import java.io.IOException;

/**
 * Clase ControllerIndex
 */
public class ControllerIndex {
    /**
     * Metodo para abrir ventana principal
     * @throws IOException
     */
    @FXML
    public void openRestaurante() throws IOException {
        Main.setRoot("restaurante");
    }
}
