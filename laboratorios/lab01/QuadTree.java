/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebadatos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 *  			N
 *  		W		E
 *  			S
 */

class Node {
	double x, y, value;

	Node(double x, double y, double value) {
		this.x = x;
		this.y = y;
		this.value = value; /* some data*/ 
	}
        public double getx(){
            return x;
        }
        public double gety(){
            return y;
        }
        public double getvalue(){
            return value;
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

	public boolean inRange(double x, double y) {
		return (x >= this.getxMin() && x <= this.getxMax()
				&& y >= this.getyMin() && y <= this.getyMax());
	}

	double xMin, yMin, xMax, yMax;

}

public class QuadTree {
	final int MAX_CAPACITY = 10;
	int level = 0;
	List<Node> nodes;
	QuadTree northWest = null;
	QuadTree northEast = null;
	QuadTree southWest = null;
	QuadTree southEast = null;
	Frontera frontera;

	QuadTree(int level, Frontera frontera) {
		this.level = level;
		nodes = new ArrayList<>();
		this.frontera = frontera;
	}

	/* Traveling the Graph using Depth First Search*/
	static void dfs(QuadTree tree) {
	System.out.println("si entra inicio quad");	
            if (tree == null){
			return;
            }
            if (tree.nodes.isEmpty()) {
			System.out.printf(" \n\t  Leaf Node.");
            }

                System.out.println("si entra mitad quad");
                double i;
                double j;
                double x1, x2;
                double y1, y2;
                       
		for (Node node : tree.nodes) {
                    for(Node node1 : tree.nodes){
                        x1 = node.getx();
                        y1 = node.gety();
                        x2 = node1.getx();
                        y2 = node1.gety();
                        j = (((x1 + x2)*(x1 + x2)) + ((y1 + y2)*(y1 + y2)));
                        i = ((Math.sqrt(j))/111.1);
                        System.out.println("Distancia entre 2 puntos: " + i);
                        if(i <= 200){
                            System.out.println("colision entre: " + "abeja: " + node.getvalue() + " y abeja: " + node1.getvalue());
                        }
                        j = 0;
                        i = 0;
                        x1 = 0;
                        x2 = 0;
                        y1 = 0;
                        y2 = 0;
                       
                    }
                    tree.nodes.remove(node);
                }
		dfs(tree.northWest);
		dfs(tree.northEast);
		dfs(tree.southWest);
		dfs(tree.southEast);
                System.out.println("si entra fin quad");
                

	    
        }

	void split() {
		int xOffset = (int) (this.frontera.getxMin()
                        + (this.frontera.getxMax() - this.frontera.getxMin()) / 2);
		int yOffset = (int) (this.frontera.getyMin()
                        + (this.frontera.getyMax() - this.frontera.getyMin()) / 2);

		northWest = new QuadTree(this.level + 1, new Frontera(
				this.frontera.getxMin(), this.frontera.getyMin(), xOffset,
				yOffset));
		northEast = new QuadTree(this.level + 1, new Frontera(xOffset,
				this.frontera.getyMin(), xOffset, yOffset));
		southWest = new QuadTree(this.level + 1, new Frontera(
				this.frontera.getxMin(), xOffset, xOffset,
				this.frontera.getyMax()));
		southEast = new QuadTree(this.level + 1, new Frontera(xOffset, yOffset,
				this.frontera.getxMax(), this.frontera.getyMax()));

	}

	void insert(double x, double y, double value) {
		if (!this.frontera.inRange(x, y)) {
			return;
		}

		Node node = new Node(x, y, value);
		if (nodes.size() < MAX_CAPACITY) {
			nodes.add(node);
			return;
		}
		// Exceeded the capacity so split it in FOUR
		if (northWest == null) {
			split();
		}

		// Check coordinates belongs to which partition 
		if (this.northWest.frontera.inRange(x, y))
			this.northWest.insert(x, y, value);
		else if (this.northEast.frontera.inRange(x, y))
			this.northEast.insert(x, y, value);
		else if (this.southWest.frontera.inRange(x, y))
			this.southWest.insert(x, y, value);
		else if (this.southEast.frontera.inRange(x, y))
			this.southEast.insert(x, y, value);
		else
			System.out.printf("ERROR");
	}

	public static void main(String args[]) {
            String linea, cx, cy;
        double x, y;
        int i = 0;
        FileReader fr;
        BufferedReader br; 
        Frontera frontera = new Frontera(8388.1, 699.9, 8399.2, 707.7);
        QuadTree Q = new QuadTree(0, frontera);
        System.out.println("si entra antes try");
        try {
            fr = new FileReader("C:\\Users\\Esteban\\Desktop\\DatosFinal.txt");
            br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                int n = linea.indexOf(',');
                cx = linea.substring(0, n);
                cy = linea.substring(n + 1);
                x = Float.parseFloat(cx);
                y = Float.parseFloat(cy);
                y = Math.abs(y * 111.1);
                x = Math.abs(x * 111.1);
                System.out.println(x + " " + y + " " + i);
                Q.insert(x, y, i);
                i++;
                System.out.println("si entra dentro del try");
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Problema al procesar el archivo");
		
	}
        System.out.println("si entra despues del try");
        Q.dfs(Q);
 }
}
