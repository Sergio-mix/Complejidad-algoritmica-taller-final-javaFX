package co.edu.unbosque.controller;

import javafx.fxml.FXML;

import java.io.IOException;

public class ControllerIndex {

    @FXML
    public void openRestaurante() throws IOException {
        Main.setRoot("restaurante");
    }
}
