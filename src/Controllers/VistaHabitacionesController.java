/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import Models.Cliente;
import Models.GestorReservas;
import Models.Habitacion;
import Models.Reserva;
import Models.Tipo;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafxejsistemadereservas.JavaFXEJsistemadeReservas;

/**
 * FXML Controller class
 *
 * @author Facun
 */
public class VistaHabitacionesController implements Initializable {
private GestorReservas gr;

    public GestorReservas getGr() {
        return gr;
    }

    public void setGr(GestorReservas gr) {
        this.gr = gr;
        actualziarTabla();
    }

    
    @FXML
    private TableColumn<Habitacion, Tipo> ColTipo;

    @FXML
    private TableColumn<Habitacion, Integer> colNumero;

    @FXML
    private TableColumn<Habitacion, Boolean> colOcupado;

    @FXML
    private TableView<Habitacion> tblDisponibles;

    @FXML
    private TextField txtDNI;

    @FXML
    private TextField txtNombre;

    @FXML
    void btnAbrirReservas(ActionEvent event) {
        JavaFXEJsistemadeReservas.app.abrirVentanaHistorico();
    }

    @FXML
    void btnLiberar(ActionEvent event) {

    }

    @FXML
    void btnReservar(ActionEvent event) {
        try{
           Habitacion h = tblDisponibles.getSelectionModel().getSelectedItem();
           Cliente c = new Cliente(txtNombre.getText(),Integer.parseInt(txtDNI.getText()));
          if (gr.crearReserva(h, c, new Date())){
              System.out.println("reserva realizada");
          }
           
        }catch(Exception e){
        e.printStackTrace();
        }
        actualziarTabla();
    }
    
    
    public void actualziarTabla(){
        tblDisponibles.getItems().clear();
        tblDisponibles.getItems().addAll(gr.getHabDispo()); //agregar habs
        
        tblDisponibles.refresh();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colNumero.setCellValueFactory(new PropertyValueFactory<>("numeroHab"));
        colOcupado.setCellValueFactory(new PropertyValueFactory<>("ocupada"));
        ColTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
      
    }    
    
}
