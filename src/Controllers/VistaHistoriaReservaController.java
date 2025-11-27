/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import Models.GestorReservas;
import Models.Reserva;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Facun
 */
public class VistaHistoriaReservaController implements Initializable{
    private GestorReservas gr;
    private VistaHabitacionesController ventanaPrincipal;

    public VistaHabitacionesController getVentanaPrincipal() {
        return ventanaPrincipal;
    }

    public void setVentanaPrincipal(VistaHabitacionesController ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }
    
    
    public GestorReservas getGr() {
        return gr;
    }

    public void setGr(GestorReservas gr) {
        this.gr = gr;
        actualziarTabla();
    }
    
      
    @FXML
    private TableColumn<Reserva, String> colCliente;

    @FXML
    private TableColumn<Reserva, Date> colDate;

    @FXML
    private TableColumn<Reserva, Integer> colHab;

    @FXML
    private TableView<Reserva> tblHistorico;
    
     public void actualziarTabla(){
        tblHistorico.getItems().clear();
        tblHistorico.getItems().addAll(gr.getListaReserva()); //agregar habs
        tblHistorico.refresh();
     }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colCliente.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colHab.setCellValueFactory(new PropertyValueFactory<>("numeroHab"));
        

    }    
    
}
