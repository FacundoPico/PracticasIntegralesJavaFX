/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Utils.Serializacion;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Facun
 */
public class GestorReservas {
    
    private Serializacion s = new Serializacion();
    private List<Cliente> listaClientes;
    private List<Reserva> listaReserva;
    private List<Habitacion> listaHabitaciones;
    
    

    public GestorReservas() {
        listaClientes = s.deserializarObjeto("archivoCliente.dat", listaClientes);
        listaReserva = s.deserializarObjeto("listaReserva.dat", listaReserva);
        listaHabitaciones = s.deserializarObjeto("habitaciones.dat", listaHabitaciones);
    }

    public boolean  crearReserva(Habitacion habitacion, Cliente cliente, Date fecha) {
        
        if (habitacion.isOcupada()) {
            return false; 
        }

        Reserva r = new Reserva(habitacion, cliente, fecha);

        habitacion.setOcupada(true);

        listaClientes.add(cliente);
        listaReserva.add(r);
        s.serializarObjeto("listaReserva.dat", listaReserva);
        s.serializarObjeto("archivoCliente.dat",listaClientes);

        return true;
    }
    
    public  void crearUnicasHabitaciones(){
       Habitacion h1 = new Habitacion(1, Tipo.DOBLE);
       Habitacion h2 = new Habitacion(2, Tipo.FAMILIAR);
       Habitacion h3 = new Habitacion(22, Tipo.DOBLE);
       Habitacion h4 = new Habitacion(31, Tipo.SINGULAR);
       Habitacion h5 = new Habitacion(141, Tipo.FAMILIAR);
       s.serializarObjeto("habitaciones.dat", listaHabitaciones);


    }
    
    public List<Habitacion> habitacionesDisponibles(){
       List<Habitacion> habDispo = new ArrayList<>();
        for (Habitacion h : habDispo) {
            if(!h.isOcupada()){
                habDispo.add(h);
            }
            
        }
       return habDispo;
    }
    
}
