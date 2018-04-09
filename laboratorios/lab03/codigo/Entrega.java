
/**
 * Write a description of class Entrega here.
 *
 * @author Esteban Quintero y Nicolas Roldan.
 * @version Abril 2018
 */

import java.util.*;

public class Entrega
{
 public Solicitud pedidor;
 public LinkedList<Nevera> neveras;
 
 public Entrega(Solicitud s){
     neveras = new LinkedList<>();
     pedidor = s;
 }
 
 public void add(Nevera nevera){
     neveras.add(nevera);
 }
    
 public String toString(){
     String s = pedidor.nombre + "-> ";
     for(int i = 0; i < neveras.size(); i++){
         s += neveras.get(i).toString() + " ";
     }
     return s;
 }

}
