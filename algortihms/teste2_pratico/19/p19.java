import java.util.*;
import java.io.*;

public class p19 {
	static int n;
	static boolean adj[][];
	static int visited[];
	static boolean check;

	static void dfs(int v, int color) {
		visited[v]=color;

		for(int i=1; i<=n; i++) {
			if(adj[v][i]) {
				if(visited[i]!=0 && visited[v]==visited[i]) {
					check=false;
					return;
				}
				if(visited[i]==0) {
					if(color == 1) 
						dfs(i,2);
					else dfs(i,1);
				}
			}
		}
	}

	public static void main(String args[]) {
		Scanner stdin = new Scanner(System.in);


		int w = stdin.nextInt();

		for(int z=0; z<w; z++) {
			n = stdin.nextInt();

			adj	= new boolean[n+1][n+1];
			visited = new int[n+1];
			Arrays.fill(visited, 0);

			int l = stdin.nextInt();

			for(int i=0; i<l; i++) {
				int a = stdin.nextInt();
				int b = stdin.nextInt();
				adj[a][b] = adj[b][a] = true;
			}

			check=true;
			dfs(1,1);
			if(check)
				System.out.println("sim");
			else System.out.println("nao");

		}
	}
}	
