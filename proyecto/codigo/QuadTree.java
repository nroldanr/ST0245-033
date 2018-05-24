package ProyectoDatos1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


class Node {

    double x, y;
    int NumBee;

    Node(double x, double y, int NumBee) {
        this.x = x;
        this.y = y;
        this.NumBee = NumBee;
        /* some data*/
    }

    public double getx() {
        return x;
    }

    public double gety() {
        return y;
    }

    public int getNumBee() {
        return NumBee;
    }
}

/* Using two points of Rectangular (Top,Left) & (Bottom , Right)*/
class Frontera {

    public double getxMin() {
        return xMin;
    }

    public double getyMin() {
        return yMin;
    }

    public double getxMax() {
        return xMax;
    }

    public double getyMax() {
        return yMax;
    }

    public Frontera(double xMin, double yMin, double xMax, double yMax) {
        super();
        /*
		 *  Storing two diagonal points 
         */
        this.xMin = xMin;
        this.yMin = yMin;
        this.xMax = xMax;
        this.yMax = yMax;
    }

    public boolean Rango(double x, double y) {
        return (x >= this.getxMin() && x <= this.getxMax()
          && y >= this.getyMin() && y <= this.getyMax());
    }

    double xMin, yMin, xMax, yMax;

}

public class QuadTree {

    final int MAX_CAPACITY = 10;
    int level = 0;
    List<Node> nodes;
    QuadTree Cuadrante1 = null;
    QuadTree Cuadrante2 = null;
    QuadTree Cuadrante3 = null;
    QuadTree Cuadrante4 = null;
    Frontera frontera;
    
    static ArrayList<Node[]> node = new ArrayList<>();
    /*Costructor del Quadtree*/
    public  QuadTree(int level, Frontera frontera) {
        this.level = level;
        nodes = new ArrayList<>();
        this.frontera = frontera;
    }
    /*Metodo para guardar los resultados*/
    public static void SaveFile(){
        FileWriter file = null;
        PrintWriter writer = null;
        
        try {
            file = new FileWriter("Salida.txt");
            writer = new PrintWriter(file);
            
            for (Node[] node1 : node) {
                writer.println("- colision entre: " + "abeja: (" + 
                      node1[0].getx() +","+node1[0].gety()+") y abeja: ("
                      + node1[1].getx()+","+node1[1].gety()+")");
            }
            
        } catch (IOException ex) {
            Logger.getLogger(QuadTree.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try{
                if(file != null){
                    file.close();
                }
            }catch(IOException e){
                throw new Error("No se guardo correctamente"+e);
            }
        }
    }
    
    /* Metodo que detecta las colisiones*/
    public static void colisiones(QuadTree tree) {
        if (tree == null) {
            return;
        }
        if (tree.nodes.isEmpty()) {
            //System.out.printf("No hay abejas ");
        }

        double i;
        double j;
        double x1, x2;
        double y1, y2;
        
        
        for (Node node : tree.nodes) {
            for (Node node1 : tree.nodes) {

                x1 = node.getx();
                y1 = node.gety();
                x2 = node1.getx();
                y2 = node1.gety();
                j = ((Math.pow((x1 + x2), 2)) + (Math.pow((y1 + y2), 2)));
                i = ((Math.sqrt(j)) / 111.1);
                //System.out.println("Distancia entre 2 puntos: " + i);
                if (i <= 151.643 && node != node1) {
                    //System.out.println("colision entre: " + "abeja: " + node.getNumBee() + " y abeja: " + node1.getNumBee());
                    
                    Node[] no = {node, node1};
                    
                    QuadTree.node.add(no);
                }
                j = 0;
                i = 0;
                x1 = 0;
                x2 = 0;
                y1 = 0;
                y2 = 0;

            }
        }
        colisiones(tree.Cuadrante1);
        colisiones(tree.Cuadrante2);
        colisiones(tree.Cuadrante3);
        colisiones(tree.Cuadrante4);

    }

    void split() {
        int xOffset = (int) (this.frontera.getxMin()
          + (this.frontera.getxMax() - this.frontera.getxMin()) / 2);
        int yOffset = (int) (this.frontera.getyMin()
          + (this.frontera.getyMax() - this.frontera.getyMin()) / 2);

        Cuadrante1 = new QuadTree(this.level + 1, new Frontera(
          this.frontera.getxMin(), this.frontera.getyMin(), xOffset,
          yOffset));
        Cuadrante2 = new QuadTree(this.level + 1, new Frontera(xOffset,
          this.frontera.getyMin(), xOffset, yOffset));
        Cuadrante3 = new QuadTree(this.level + 1, new Frontera(
          this.frontera.getxMin(), xOffset, xOffset,
          this.frontera.getyMax()));
        Cuadrante4 = new QuadTree(this.level + 1, new Frontera(xOffset, yOffset,
          this.frontera.getxMax(), this.frontera.getyMax()));

    }

    void insert(double x, double y, int NumBee) {
        if (!this.frontera.Rango(x, y)) {
            return;
        }

        Node node = new Node(x, y, NumBee);
        if (nodes.size() < MAX_CAPACITY) {
            nodes.add(node);
            return;
        }
        // Exceeded the capacity so split it in FOUR
        if (Cuadrante1 == null) {
            split();
        }

        // Check coordinates belongs to which partition 
        if (this.Cuadrante1.frontera.Rango(x, y)) {
            this.Cuadrante1.insert(x, y, NumBee);
        } else if (this.Cuadrante2.frontera.Rango(x, y)) {
            this.Cuadrante2.insert(x, y, NumBee);
        } else if (this.Cuadrante3.frontera.Rango(x, y)) {
            this.Cuadrante3.insert(x, y, NumBee);
        } else if (this.Cuadrante4.frontera.Rango(x, y)) {
            this.Cuadrante4.insert(x, y, NumBee);
        } else {
            //System.err.printf("ERROR");
        }
    }

    public static void main(String args[]) {
        
        String linea, cx, cy;
        double x, y;
        int i = 0;
        FileReader fr;
        BufferedReader br;
        Frontera frontera = new Frontera(8388.1, 699.9, 8399.2, 707.7);
        QuadTree Q = new QuadTree(0, frontera);
        try {
            fr = new FileReader("abejas.txt");
            br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                int n = linea.indexOf(',');
                cx = linea.substring(0, n);
                cy = linea.substring(n + 1);
                x = Float.parseFloat(cx);
                y = Float.parseFloat(cy);
                y = Math.abs(y *111.1);
                x = Math.abs(x * 111.1);
                //System.out.println(x + " " + y + " " + i);
                Q.insert(x, y, i);
                i++;
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Problema al procesar el archivo");

        }
        long startTime = System.currentTimeMillis();
        Q.colisiones(Q);
        
        SaveFile();
        long TimeSum = System.currentTimeMillis() - startTime;
        
        System.out.println("Colisiones con " + i + " elementos se demoró " + TimeSum + " milisegundos.");
    }
}
