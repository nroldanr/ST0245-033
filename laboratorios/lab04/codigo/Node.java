
/**
 * Write a description of class Node here.
 *
 * Esteban Quintero y Nicolas Roldan
 * Abril 2018
 */
public class Node
{
    public Node left;
    public Node right;
    public String nombre;
    public boolean hombre;
    public Node hijo;
    public Node(String n, boolean g, Node h){
        nombre = n;
        hombre = g;
        hijo = h;
    }
    public Node(String n, boolean g){
        nombre = n;
        hombre = g;
        hijo = null;
    }
}
