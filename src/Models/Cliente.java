/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.io.Serializable;

/**
 *
 * @author Facun
 */
public class Cliente implements Serializable{
    private static final long serialVersionUID = 1L;
    private String nombre;
    private int dni;

    public Cliente(String nombre, int dni) {
         setNombre(nombre);
        setDni(dni);
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        if(!nombre.isEmpty()){
        this.nombre = nombre;
        }else{
            System.out.println("Incorrecto");
        }
    }

    public int getDni() {
        return dni;
    }

    private void setDni(int dni) {
        if(dni != 0){
        this.dni = dni;
        }
    }
    
    
}
