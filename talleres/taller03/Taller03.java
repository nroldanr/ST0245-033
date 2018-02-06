
/**
 * Write a description of class Taller03 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Taller03
{
    public static void torresHanoi(int num, String a, String b, String c){
        if(num == 0){
            System.out.println("mueva la " + a + " para la " + c);
        }
        else{
            torresHanoi(num -1, a, c, b);
            System.out.println("mueva la " + a + " para la " + c);
            torresHanoi(num -1, b, a, c);
        }
    }
    public static void combinations(String base, String s, int j){
        if (j == 0){
            for(int i = 0; i < s.length(); i++){
                combinations("", s.substring(i), 1);
            }
        } else if (s.length() == 0){
            System.out.println(base);
        }
        else
        {
            for (int i = 1; i <= s.length(); i++){
                combinations(base + s.charAt(0), s.substring(i), i);
            }
        }
    }
    public static void permutaciones(String aux, String s){
        if(s.length() == 0){
            System.out.println(aux);
        }
        else{
            for(int i = 0; i<s.length(); i++){
              permutaciones(aux + s.charAt(i), s.substring(0,i) + s.substring(i+1));  
            }
        }
    }
    public static void permutacionesRep(String aux, String s){
        if(aux.length() == s.length()){
            System.out.println(aux);
        }
        else{
            for(int i = 0; i<s.length(); i++){
                permutacionesRep(aux + s.charAt(i), s);
            }
        }
    }
    public static void main(String[] args){
      System.out.println("Ejercicio 1");
      System.out.println("");
      torresHanoi(3, "PRIMERA", "SEGUNDA", "TERCERA");
      System.out.println("");
      System.out.println("Ejercicio 2");
      System.out.println("");
      combinations("", "abc", 0);
      System.out.println("");
      System.out.println("Ejercicio 3");
      System.out.println("");
      permutaciones("", "abc");
      System.out.println("");
      System.out.println("Ejercicio 4");
      System.out.println("");
      permutacionesRep("", "abc");
    }
}
