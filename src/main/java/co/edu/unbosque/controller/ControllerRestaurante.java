package co.edu.unbosque.controller;

import co.edu.unbosque.model.Comidas;
import co.edu.unbosque.model.Plato;
import co.edu.unbosque.model.dto.ComidasDaoImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ControllerRestaurante implements Initializable {

    @FXML
    private TableColumn<?, ?> coCaloriasCalcular;

    @FXML
    private TableColumn<?, ?> coCaloriasRegister;

    @FXML
    private TableColumn<?, ?> coNombreCalcular;

    @FXML
    private TableColumn<String, ?> coNombreRegister;

    @FXML
    private TableView<Plato> tableCalcular;

    @FXML
    private TextField txtCaloriasCalcular;

    @FXML
    private TableView<Plato> tableRegister;

    @FXML
    private TextField txtCaloriasRegister;

    @FXML
    private TextField txtNombreRegister;

    @FXML
    private Text txtCalorias;

    private List<Plato> elementos = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            coNombreRegister.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            coCaloriasRegister.setCellValueFactory(new PropertyValueFactory<>("calorias"));
            coNombreCalcular.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            coCaloriasCalcular.setCellValueFactory(new PropertyValueFactory<>("calorias"));
        } catch (Exception ignored) {
        }
    }

    @FXML
    public void register() {
        try {
            String nombre = this.txtNombreRegister.getText();
            String calorias = this.txtCaloriasRegister.getText();
            if (!Objects.equals(nombre, "") && !Objects.equals(calorias, "")) {
                elementos.add(new Plato(nombre, Double.parseDouble(calorias)));
                addTableRegister(elementos);
            } else {
                this.mostrarAlertWarning("Ingrese valores validos");
            }
        } catch (NumberFormatException ex) {
            this.mostrarAlertWarning("Los tiene que ser numéricos");
        }
    }

    public void calcularPromedio() {
        try {
            String txt = this.txtCaloriasCalcular.getText();
            if (elementos.size() > 1) {
                if (!Objects.equals(txt, "")) {
                    double calorias = Double.parseDouble(txt);

                    Plato[] miarray = new Plato[elementos.size()];
                    miarray = elementos.toArray(miarray);

                    Comidas m_base = new Comidas(calorias + calorias * 0.1, miarray.length);
                    Comidas m_opt = new Comidas(calorias + calorias * 0.1, miarray.length);

                    ComidasDaoImpl comidasDao = new ComidasDaoImpl(m_base, m_opt);

                    comidasDao.asignarPlatos(miarray, false);
                    txtCalorias.setText(String.valueOf(comidasDao.caloriasNum()));
                    this.addTableCalcular(comidasDao.platos_all());
                } else {
                    this.mostrarAlertWarning("Ingrese valores validos");
                }
            } else {
                this.mostrarAlertWarning("Solo hay un plato disponible");
            }
        } catch (NumberFormatException ex) {
            this.mostrarAlertWarning("Los tiene que ser numéricos");
        }
    }

    private void addTableRegister(List<Plato> platos) {
        ObservableList<Plato> list = FXCollections.observableArrayList(platos);
        tableRegister.setItems(list);
    }

    @FXML
    private void addTableCalcular(Plato[] platos) {
        ObservableList<Plato> list = FXCollections.observableArrayList(platos);
        tableCalcular.setItems(list);
    }

    @FXML
    public void home() throws IOException {
        Main.setRoot("index");
    }

    @FXML
    public void mostrarAlertWarning(String text) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setTitle("Advertencia");
        alert.setContentText(text);
        alert.showAndWait();
    }
}
