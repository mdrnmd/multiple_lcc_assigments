import java.util.*;
import java.io.*;

public class p17 {
	static int n;
	static boolean adj[][];
	static boolean visited[];

	static void dfs(int v) {
		visited[v] = true;
		for(int i=1; i<=n; i++) {
			if(adj[v][i] && !visited[i]) 	
				dfs(i);
		}
	}

	public static void main(String args[]) {
		Scanner stdin = new Scanner(System.in);

		n = stdin.nextInt();

		adj		= new boolean[n+1][n+1];
		visited = new boolean[n+1];

		int l = stdin.nextInt();

		for(int i=0; i<l; i++) {
			int a = stdin.nextInt();
			int b = stdin.nextInt();
			adj[a][b] = adj[b][a] = true;
		}

		for(int i=1; i<=n; i++) 
			visited[i]= false;

		int count=0;
		for(int i=1; i<=n; i++) {
			if(!visited[i]) {
				count++;
				dfs(i);
			}
		}

		System.out.println(count);
	}
}