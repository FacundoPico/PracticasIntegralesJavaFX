/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Utils.Serializacion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Facun
 */
public class Reserva implements Serializable{
    private static final long serialVersionUID = 1L;
    private Habitacion habitacion;
    private Cliente cliente;
    private Date fecha;
    private List<Cliente> listaClientes;
    private Serializacion s;
    

    
    
    public Reserva(Habitacion habitacion, Cliente cliente, Date fecha) {
   
        this.habitacion = habitacion;
        this.cliente = cliente;
        this.fecha = fecha;
        
        
    }
public String getNombre() {
        return cliente.getNombre();
    }

    public int getNumeroHab() {
        return habitacion.getNumeroHab();   // Ajustalo según el nombre real
    }

    public Date getFecha() {
        return fecha;
    }
  
 
    
    
    
  
    
    
    
    
}
