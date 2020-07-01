import java.util.*;
import java.io.*;

public class p20 {
	static int n;
	static int adj[][];
	static boolean visited[];
	static Stack<Integer> st = new Stack<>();

	static void dfs(int v) {
		visited[v] = true;
		for(int i=0; i<26; i++) {
			if(adj[v][i]==1 && !visited[i])
				dfs(i);
		}
		if(adj[v][v]==1)
			st.push(new Integer(v));
	}

	public static void main(String args[]) {
		Scanner stdin = new Scanner(System.in);

		String index[] = new String[100]; 
		adj = new int[26][26];
		visited = new boolean[26];

		n = stdin.nextInt();
    	stdin.nextLine(); //reseting

    	for(int i=0; i<n; i++) {
    		index[i]= stdin.nextLine();
    	}

    	//stupid comparator
    	boolean equal=true;
    	int x=0;
    	int count=0;
    	for(int i=0; i<n-1; i++) {
    		while(equal && index[i].length()>x && index[i+1].length()>x) {
    			int c1 = index[i].charAt(x) - 'A';
    			int c2 = index[i+1].charAt(x) - 'A';

    			adj[c1][c1]=1;
    			adj[c2][c2]=1;
    			if(c1!=c2) {
    				adj[c1][c2] = 1;
    				equal=false;
    			}
    			x++;
    		}
    		equal=true;
    		x=0;
    	}

    	//calL dfs
    	Arrays.fill(visited, false);

    	for(int i=0; i<26; i++) {
    		if(!visited[i]) {
    			dfs(i);
    		}
    	}

    	//trafulhices das stacks
    	while(!st.empty()){
    		int xw=(int)st.pop();
    		xw= xw + 'A';
    		char a=(char)xw;
    		System.out.print(a);
    	}
    	System.out.println();

    }
} 