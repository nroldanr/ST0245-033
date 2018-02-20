
/**
 * Write a description of class Taller5 here.
 *
 * @author Esteban Quintero y Nicolas Roldan
 * @version Febrero 2018
 */

import java.util.Random;

public class Taller5
{
   public static int[] GeneradorDeArreglos(int n) {
        int size = n;
        int max = 100000000;
        int[] Gen = new int[size];
        Random generator = new Random();
        for (int i =0; i<size; i++){
            Gen[i] = generator.nextInt(max);
        }
        return Gen;
   } 
   public static void ArraySum(int[] Gen, int n){
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum = sum + Gen[i];
        }
        System.out.println(sum);
   }
   public static void TablasDeMultiplicar(int n){
        for(int i = 0; i <= n; i++){
            for (int j = 0; j <= n; j++){
                System.out.println(i + " * " + j + " = " + i*j);
            }
        }
   }
   public static void Ordenar(int[] Gen, int n){
        for(int i = 0; i <= n-1; i++){
            int j = i;
            while (j > 0 && Gen[j-1] > Gen[j]){
                int temp = Gen[j];
                Gen[j] = Gen[j-1];
                Gen[j-1] = temp;
                j = j - 1;
            }
        }
   }
   public static void main(String[] args, int Tam){
        int[] array = GeneradorDeArreglos(Tam);
        int n = array.length - 1;
        
        long startTime = System.currentTimeMillis();
        ArraySum(array, n);
        long TimeSum = System.currentTimeMillis() - startTime;
        
        startTime = System.currentTimeMillis();
        TablasDeMultiplicar(n);
        long TimeMult = System.currentTimeMillis() - startTime;
        
        startTime = System.currentTimeMillis();
        Ordenar(array, n);
        long TimeOrd = System.currentTimeMillis() - startTime;
        
        System.out.println("Suma de arreglo con " + Tam + " elementos se demoró " + TimeSum + " milisegundos.");
        System.out.println("Tablas de multiplicar con " + Tam + " elementos se demoró " + TimeMult + " milisegundos.");
        System.out.println("Ordenar con " + Tam + " elementos se demoró " + TimeOrd + " milisegundos.");
   }
}
