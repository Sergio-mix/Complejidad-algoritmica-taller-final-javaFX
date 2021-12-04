package co.edu.unbosque.controller;

import co.edu.unbosque.components.ObjectView;
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

/**
 * Clase ControllerRestaurante
 */
public class ControllerRestaurante implements Initializable {
    /**
     * Atributos
     */
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

    /**
     * Método que inicializa componentes antes de todo
     *
     * @param location
     * @param resources
     */
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

    /**
     * Permite enviar información y registrar el nombre de la comida y sus calorías
     */
    @FXML
    public void register() {
        try {
            String nombre = this.txtNombreRegister.getText();
            String calorias = this.txtCaloriasRegister.getText();

            double calorias1 = Double.parseDouble(calorias);
            if (!Objects.equals(nombre, "") && !Objects.equals(calorias, "")) {
                if (calorias1 > 0) {


                    elementos.add(new Plato(nombre, Double.parseDouble(calorias)));
                    addTableRegister(elementos);
                } else {
                    ObjectView.mostrarAlertWarning("Por favor ingrese valores positivos");
                }
            } else {
                ObjectView.mostrarAlertWarning("Ingrese valores validos");
            }
        } catch (NumberFormatException ex) {
            ObjectView.mostrarAlertWarning("Los tiene que ser numéricos");
        }
    }


    /**
     * Permite calcular el promedio de las calorías de los platos
     */
    public void calcularPromedio() {
        try {
            String txt = this.txtCaloriasCalcular.getText();
            if (elementos.size() > 1) {
                if (!Objects.equals(txt, "")) {
                    double calorias = Double.parseDouble(txt);

                    Plato[] miarray = new Plato[elementos.size()];
                    Plato[] miarray2 = new Plato[elementos.size()];
                    miarray = elementos.toArray(miarray);

                    Comidas m_base = new Comidas(calorias + calorias * 0.1, miarray.length);
                    Comidas m_opt = new Comidas(calorias + calorias * 0.1, miarray.length);

                    ComidasDaoImpl comidasDao = new ComidasDaoImpl(m_base, m_opt);

                    comidasDao.asignarPlatos(miarray, false);
                    txtCalorias.setText(String.valueOf(comidasDao.caloriasNum()));
                    this.addTableCalcular(comidasDao.platos_all());
                } else {
                    ObjectView.mostrarAlertWarning("Ingrese valores validos");
                }
            } else {
                ObjectView.mostrarAlertWarning("Solo hay un plato disponible");
            }
        } catch (NumberFormatException ex) {
            ObjectView.mostrarAlertWarning("Los tiene que ser numéricos");
        }
    }

    /**
     * Agrega los platos a la tabla
     *
     * @param platos
     */
    private void addTableRegister(List<Plato> platos) {
        ObservableList<Plato> list = FXCollections.observableArrayList(platos);
        tableRegister.setItems(list);
    }

    /**
     * Agrega los datos a la tabla
     *
     * @param platos
     */
    @FXML
    private void addTableCalcular(Plato[] platos) {
        ObservableList<Plato> list = FXCollections.observableArrayList(platos);
        tableCalcular.setItems(list);
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
}
