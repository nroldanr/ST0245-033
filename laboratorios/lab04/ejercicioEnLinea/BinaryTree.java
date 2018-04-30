
/**
 * Write a description of class BinaryTree here.
 *
 * Esteban Quintero y Nicolas Roldan
 * Abril 2018
 */
public class BinaryTree
{
 public Node root;

    public BinaryTree(){
        root = null;
    }

    private int max2(int i, int j)
    {
        if (i > j)
            return i;
        return j;
    }

    private int maxheightAUX(Node node)
    {
        if (node == null)
            return 0;
        else 
            return max2(maxheightAUX(node.left), maxheightAUX(node.right))+1;
    }

    public int maxheight()
    {
        return maxheightAUX(root);
    }

    private void recursivePrintAUX(Node node)
    {
        if (node != null)
        {
            recursivePrintAUX(node.left);
            recursivePrintAUX(node.right);
            System.out.println(node.data);
        }

    }

    public void recursivePrint()
    {
        recursivePrintAUX(root);
    }

    public void insertar(int n){
        if(root == null){
            root = new Node(n);;
        } else {
            insertarAux(n, root);
        }
    }

    private void insertarAux(int n, Node nodo){
        if(n > nodo.data){
            if(nodo.right == null){
                nodo.right = new Node(n);
            } else {
                insertarAux(n, nodo.right);
            }
        } else {
            if(nodo.left == null){
                nodo.left = new Node(n);
            } else {
                insertarAux(n, nodo.left);
            }
        }
    }

    public boolean buscar(int n){
        return buscarAux(n, root);
    }

    private boolean buscarAux(int n, Node nodo){
        if(nodo == null){
            return false;
        }
        if(nodo.data == n){
            return true;
        } else {
            return buscarAux(n, nodo.right) || buscarAux(n, nodo.left);
        }
    }
}
