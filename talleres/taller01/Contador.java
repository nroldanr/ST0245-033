
/**
 * Write a description of class Contador here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Contador
{
   private int cont;
   private String id;
   
   Contador(String id)
   {
    this.id = id;
    }
   void incrementar(){
       cont += 1;
    }
   int incrementos(){
     return cont;
    } 
   public String toString(){
       String info = "El id es: "  +id;
       return info;
    } 
}

