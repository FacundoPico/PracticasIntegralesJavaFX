/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javafxejsistemadereservas;

import Controllers.VistaHabitacionesController;
import Controllers.VistaHistoriaReservaController;
import Models.GestorReservas;
import Utils.paths;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;



/**
 *
 * @author Facun
 */
public class JavaFXEJsistemadeReservas extends Application{
    public static JavaFXEJsistemadeReservas app;
    private VistaHabitacionesController vistaPrinCont;
    private GestorReservas gr;
    
    
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        app = this;
        FXMLLoader loader = new FXMLLoader(getClass().getResource(paths.VistaReserva));
        AnchorPane pane = loader.load();
        
        vistaPrinCont = loader.getController();
        
        gr = new GestorReservas();
        
        vistaPrinCont.setGr(gr);
        
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
        
        public void abrirVentanaHistorico(){
           
         FXMLLoader loader = new FXMLLoader(getClass().getResource(paths.VistaHistorial));
        try {
            AnchorPane pane = loader.load();
            VistaHistoriaReservaController cVistaHistorico = loader.getController();
            cVistaHistorico.setGr(gr);
            cVistaHistorico.setVentanaPrincipal(vistaPrinCont);
            
            Scene scene = new Scene(pane);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
            
        
        } catch (IOException ex) {
            System.getLogger(JavaFXEJsistemadeReservas.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
         
            
            
            
            
        }
        
        
        
        
        
        
        
    
    
}
