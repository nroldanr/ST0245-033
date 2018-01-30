
public class Taller02
{
    public static int gdc(int x, int y){
        if (y == 0){
            return x;
        }
        else {
            return gdc(y, x % y);
        }
    }

    public static boolean sumaGrupo(int start,  int[] nums, int target) {
        if (start >= nums.length){
            return target == 0;
        }
        else {
            return sumaGrupo(start+1, nums, target) || sumaGrupo(start+1, nums, target - nums[start]);
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
    
    public static boolean ejercicio1(){
		int a, b, c, d;
		a = gdc(12,36);
		b = gdc(8,12);
		c = gdc(72,108);
		d = gdc(162, 270);
		if(a==12 && b==4 && c==36 && d==54)
			return true;
		return false;
    }
    
    public static boolean ejercicio2(){
		boolean a, b, c, d;
		a = sumaGrupo(0, new int[] {2, 4, 8}, 9);
		b = sumaGrupo(0, new int[] {2, 4, 8}, 8);
	        c = sumaGrupo(0, new int[] {10, 2, 2, 5}, 9);
		d = sumaGrupo(0, new int[] {10, 2, 2, 5}, 17);
		if(!a && b && c && d)
			return true;
		return false;
    }
    public static void ejercicio3(){
		System.out.println("Para la cadena 'abc' el resultado debe ser similar a:");
		System.out.println("a, ab, abc, ac, b, bc, c");
		combinations("", "abc", 0);

		System.out.println("Para la cadena 'Eafit' el resultado debe ser similar a:");
		System.out.println("E, Ea, Eaf, Eafi, Eafit, Eaft, Eai, Eait, Eat, Ef, Efi, Efit, Eft, Ei, Eit, Et, a, af, afi, afit, aft, ai, ait, at, f, fi, fit, ft, i, it, t");
		combinations("", "Eafit", 0);
		
		System.out.println("Para la cadena 'Hola' el resultado debe ser similar a:");
		System.out.println("H, Ho, Hol, Hola, Hoa, Hl, Hla, Ha, o, ol, ola, oa, l, la, a");
		combinations("", "Hola", 0);

		System.out.println("Para la cadena 'Hi' el resultado debe ser similar a:");
		System.out.println("H, Hi, i");
		combinations("", "Hi", 0);
	}
     
    public static void main(String[] args){
        if(ejercicio1())
            System.out.println("Ejercicio 1 Correcto");
        else
        System.out.println("Ejercicio 1 Incorrecto");
        
        if(ejercicio2())
            System.out.println("Ejercicio 2 Correcto");
        else
        System.out.println("Ejercicio 2 Incorrecto");
        
        System.out.println("");
        System.out.println("Ejercicio 3");
        ejercicio3();
    }
}