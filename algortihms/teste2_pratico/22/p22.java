
import java.io.*;
import java.util.*;

// Classe que representa um no
class Node {
    public LinkedList<Integer> adj; // Lista de adjacencias
    public boolean visited;         // Valor booleano que indica se foi visitao numa pesquisa
    public int distance;            // Distancia do no origem da pesquisa

    Node() {
    	adj = new LinkedList<Integer>();
    	visited = false;
    	distance = -1;
    }
}

// Classe que representa um grafo
class Graph {
    int n;           // Numero de nos do grafo
    Node nodes[];    // Array para conter os nos
    int matrix[][];


    Graph(int n) {
    	this.n = n;
	nodes  = new Node[n+1]; 	 // +1 se os comecam em 1 ao inves de 0
	matrix = new int[n+1][n+1];

	for (int i=1; i<=n; i++)
		nodes[i] = new Node();
}

public void addLink(int a, int b) {
	nodes[a].adj.add(b);
	nodes[b].adj.add(a);
}

    // Algoritmo de pesquisa em largura
public void bfs(int v) {
	LinkedList<Integer> q = new LinkedList<Integer>();

	for (int i = 1 ; i <= n ; i++)
		nodes[i].visited = false;

	q.add(v);
	nodes[v].visited = true;
	nodes[v].distance = 0;

	while (q.size() > 0) {
		int u = q.removeFirst();
		matrix[v][u]= nodes[u].distance;
		for (int w : nodes[u].adj)
			if (!nodes[w].visited) {
				q.add(w);
				nodes[w].visited  = true;
				nodes[w].distance = nodes[u].distance + 1; 
			}	    
		}
	}
}

public class p22 {
	public static void main(String args[]) {
		Scanner stdin = new Scanner(System.in);

		int n = stdin.nextInt();
		Graph g = new Graph(n);
		int   e = stdin.nextInt();
		for (int i=0; i<e; i++) 
			g.addLink(stdin.nextInt(), stdin.nextInt());


	// Pesquisa em largura a partir do no 1
		for(int i=1; i<=n; i++)
			g.bfs(i);		


		//diametro
		int max=0;
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=n; j++)	{
				if(g.matrix[i][j]>max)
					max=g.matrix[i][j];
			}
		}
		System.out.println(max);


		//raio 
		int max2=0;
		int min=1000000;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++)	{
				if(g.matrix[i][j]>max2)
					max2=g.matrix[i][j];
			}
			if(max2<min)
				min=max2;
			max2=0;
		}
		System.out.println(min);

		//nós centrais
		boolean central[] = new boolean[n+1];
		int count=0;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++)	{
				if(g.matrix[i][j]>max2)
					max2=g.matrix[i][j];
			}
			if(max2==min) {
				central[i]=true;
			}
			max2=0;
		}
		for(int i=1; i<=n; i++) {
			if(central[i])
				count++;
		}

		for(int i=1; i<=n; i++) {
			if(central[i] && count==1)
				System.out.println(i);
			else if(central[i]){
				System.out.print(i + " ");
				count--;
			}
		}

		//nós periféricos

		boolean periferic[] = new boolean[n+1];
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=n; j++) {
				if(g.matrix[i][j]==max)
					periferic[i]=true;
			}
		}
		count=0;
		for(int i=1; i<=n; i++) {
			if(periferic[i])
				count++;
		}

		for(int i=1; i<=n; i++) {
			if(periferic[i] && count==1)
				System.out.println(i);
			else if(periferic[i]){
				System.out.print(i + " ");
				count--;
			}
		}

		 /*matrix printer
		for(int i=1; i<=n; i++){
			for(int j=1; j<=n; j++) {
				System.out.print(g.matrix[i][j]);	
			}
			System.out.println();
		}
*/
		
	}
}
