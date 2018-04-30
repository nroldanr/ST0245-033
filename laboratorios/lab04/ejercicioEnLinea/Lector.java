import java.util.Scanner;
/**
 * Write a description of class Lector here.
 *
 * Esteban Quintero y Nicolas Roldan
 * Abril 2018
 */
public class Lector
{
 public static void main(String[] args){
        BinaryTree arb = new BinaryTree();
        System.out.println("Ingresar datos en preorden");
        Scanner in = new Scanner(System.in);
        int n;
        while(in.hasNextLine()){
            String s = in.nextLine();
            try{
                n = Integer.parseInt(s);
                arb.insertar(n);
            } catch(Exception e){
                break;
            }
        }
        imprimirPostorden(arb.root);
    }
    
 public static void imprimirPostorden(Node node){
        if (node != null)
        {
            imprimirPostorden(node.left);
            imprimirPostorden(node.right);
            System.out.println(node.data);
        }
    }
}
