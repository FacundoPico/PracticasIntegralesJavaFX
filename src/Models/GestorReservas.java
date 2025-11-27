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
    private List<Habitacion> habDispo;
    
    

    public GestorReservas() {
        listaClientes = new ArrayList<>();
        listaHabitaciones = new ArrayList<>();
        listaReserva = new ArrayList<>();
        listaHabitaciones=s.deserializarObjeto("habitaciones.dat", listaHabitaciones);
        listaClientes = s.deserializarObjeto("archivoCliente.dat", listaClientes);
        listaReserva = s.deserializarObjeto("listaReserva.dat", listaReserva);
        
        habDispo = habitacionesDisponibles();
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
        s.serializarObjeto("habitaciones.dat", listaHabitaciones);
        habDispo = habitacionesDisponibles();

        return true;
    }
    
    public  void crearUnicasHabitaciones(){
    
    listaHabitaciones = new ArrayList<>();
    listaHabitaciones.add(new Habitacion(1, Tipo.DOBLE));
    listaHabitaciones.add(new Habitacion(2, Tipo.FAMILIAR));
    listaHabitaciones.add(new Habitacion(22, Tipo.DOBLE));
    listaHabitaciones.add(new Habitacion(31, Tipo.SINGULAR));
    listaHabitaciones.add(new Habitacion(141, Tipo.FAMILIAR));
      s.serializarObjeto("habitaciones.dat", listaHabitaciones);


    }

    
    private List<Habitacion> habitacionesDisponibles(){
       List<Habitacion> habDispon = new ArrayList<>();
       if(listaHabitaciones != null){
        for (Habitacion h : listaHabitaciones) {
            if(h.isOcupada()== false){
                habDispon.add(h);
            }
        }
        }
       return habDispon;
    }
    
    
    // public void existeCliente(){

//}

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Reserva> getListaReserva() {
        return listaReserva;
    }

    public void setListaReserva(List<Reserva> listaReserva) {
        this.listaReserva = listaReserva;
    }

    public List<Habitacion> getHabDispo() {
        return habDispo;
    }

    public void setHabDispo(List<Habitacion> habDispo) {
        this.habDispo = habDispo;
    }
    
    
    
}
