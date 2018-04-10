import java.util.HashMap;

/**
 * Write a description of class Taller09 here.
 *
 * @author Esteban Quintero y Nicolas Roldan.
 * @version Abril 2018
 */
public class Taller9
{
   //pedrito 2
 public static void agregar(HashMap empresas,String key, String value){
     empresas.put(key, value);
 } 
 //pedrito 3
 public static void buscar(HashMap empresas,String key){
     System.out.println(empresas.get(key));
 }
 //pedrito 4
 public static boolean contienekey(HashMap empresas,String value){
     return empresas.containsKey(value);
 }
 
 public static boolean contienePais(HashMap empresas,String value){
       return empresas.containsValue(value);
   }
 
 public static void main(String[] args) {
        HashMap<String, String> empresas = new HashMap<>();
        agregar(empresas, "google", "Estados Unidos");
        agregar(empresas, "locura ", "Colombia");
        agregar(empresas, "Nokia ", "Finlandia");
        agregar(empresas, "Sony ", "Japón");

        if(contienekey(empresas, "google")){
            System.out.println("google si existe");
            System.out.println("Google es de "); 
            buscar(empresas,"google");
        } else {
            System.out.println("google no existe");
        }

        if(contienekey(empresas, "motorola")){
            System.out.println("motorola si existe");
            System.out.println("motorola es de "); 
            buscar(empresas,"motorola");
        } else {
            System.out.println("motorola no existe");
        }

        if(contienePais(empresas, "Estados Unidos")){
            System.out.println("Estados Unidos si tiene empresa(s)");
        } else {
            System.out.println("Estados Unidos no tiene empresas");
        }
        if(contienePais(empresas, "India")){
            System.out.println("India si tiene empresa(s)");
        } else {
            System.out.println("India no tiene empresas");
        }
    }
}
