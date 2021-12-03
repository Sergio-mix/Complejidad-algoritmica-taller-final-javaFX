module COMPLEJIDAD.ALGORITMICA.TALLER.FINAL {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    exports co.edu.unbosque.controller;
    exports co.edu.unbosque.model;
    opens co.edu.unbosque.controller to javafx.fxml;
    opens co.edu.unbosque.model to javafx.fxml;
}