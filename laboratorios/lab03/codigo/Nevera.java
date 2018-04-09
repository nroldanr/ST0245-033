
/**
 * Write a description of class Nevera here.
 *
 * @author Esteban Quintero y Nicolas Roldan.
 * @version Abril 2018
 */

public class Nevera
{
  public int id;
  public String descripcion;
  
  public Nevera(int num, String nom){
        descripcion = nom;
        id = num;
  }
  public String toString(){
        return "(" + id + ", " + descripcion + ")";
  }
}
