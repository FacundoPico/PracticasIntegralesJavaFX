/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * @author Facundo Pico
 */
public class Serializacion <T> {   
    /*
    esta es una clase creado a fin de resolver la guia de ejercicos de javafx , sirve unicamente
    para listas, no para Entidades individuales.
    su implementacion es declarandola como un atributo y generando la clase en su constructor(new Serializacion).
    la clase del objeto a serializar debe implementar: implements Serializable. 
    aparte la clase deberia usar el metodo private static final long serialVersionUID = 1
    
    */
public void serializarObjeto(String archivo,List<T> Aserializar){ 
 
    ObjectOutputStream oos = null;
    try{
    FileOutputStream fos = new FileOutputStream(archivo);
    oos = new ObjectOutputStream(fos);
    oos.writeObject(Aserializar);                         
}catch(IOException e){
    System.out.println("error al serializar" + e.getMessage());
    
}finally{
    try{
    if(oos!= null)oos.close();
} catch(IOException e){
    
}
}
} 
    
public List deserializarObjeto(String archivo,List<T> deserializado){
    ObjectInputStream ois =null; 
    
    try{
        FileInputStream fis = new FileInputStream(archivo);
        ois = new ObjectInputStream(fis);
        deserializado = (List)ois.readObject();
        System.out.println(" persona deserializada correctamente");
        
        
    }catch(FileNotFoundException e){
         System.out.println("archivo no encontrado"+ e.getMessage() );
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("archivo no encotrado"+ e.getMessage() );
    } finally{
        try{
            if(ois != null)ois.close();
            
        }catch(IOException e){
            
        }
    }
    return deserializado;


    
}
}
