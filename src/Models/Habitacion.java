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
public class Habitacion implements Serializable{
    private static final long serialVersionUID = 1L;
   private int numeroHab;
   private Tipo tipo;
   private boolean ocupada;

    public Habitacion(int numeroHab, Tipo tipo) {
        this.numeroHab = numeroHab;
        this.tipo = tipo;
        this.ocupada = false;
    }

    public int getNumeroHab() {
        return numeroHab;
    }

    public void setNumeroHab(int numeroHab) {
        this.numeroHab = numeroHab;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
   
   
   
}
