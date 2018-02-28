import java.util.Arrays;
/**
 * @author Esteban Quintero y Nicolas Roldan
 * @version Febrero 2018
 */
public class MiArrayList
{
  private int size;
  private static final int CAPACIDAD = 3;
  private int elementos[]; 

  // Inicializa los atributos size en cero y elements como un arreglo de tamaño  DEFAULT_CAPACITY. No, no recibe parámetros. public MiArrayList() {}          // Retorna el tamaño de la lista public int size() {}          // Agrega un elemento e a la última posición de la lista public void add(int e) {}          // Retorna el elemento que se encuentra en la posición i de la lista public int get(int i) {}          // Agrega un elemento e en la posición index de la lista
  public MiArrayList() {
      elementos = new int[CAPACIDAD];
      size = 0;
  }     

  // Retorna el tamaño de la lista 
  public int size() {
      return size;
  }   

  // Agrega un elemento e a la última posición de la lista
  public void add(int e) {
      if(elementos.length == size){
          int doble = elementos.length * 2;
          elementos = Arrays.copyOf(elementos, doble);
      }
      elementos[size] = e;
      size++;
  }    

  // Retorna el elemento que se encuentra en la posición i de la lista 
  public int get(int i) {
      if (i <0 || i>= size) {
            System.out.println("Error, no existe");
      }
      return  elementos[i];
  }

  // Agrega un elemento e en la posición index de la lista
  public void add(int index, int e) {
      index = index - 1;
      if(index > size){
          System.out.println("Error, No Existe");
      } else {
          if(elementos.length == size){
              int doble = elementos.length * 2;
              elementos = Arrays.copyOf(elementos, doble);
          }
          for (int i = size; i >= index; i--){
                elementos[i+1] = elementos[i];
          }
          elementos[index] = e;
          size++;
      }
  } 
}
