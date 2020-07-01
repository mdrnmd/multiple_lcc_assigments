import java.util.*;
import java.io.*;

public class p18 {
	static int n, l, c, fillnumber;
	static char adj[][];
	static boolean visited[][];

	static void dfs(int x, int y) {

		visited[x][y]=true;

		if(!(adj[x][y] =='#'))
			return;
		else {
			adj[x][y]= (char)fillnumber;

			if(x+1<=l) 
				dfs(x+1,y);
			if(x-1>0)
				dfs(x-1,y);
			if(y+1<=c) 
				dfs(x,y+1);
			if(y-1>0) 
				dfs(x,y-1); 
			if(x+1<=l && y+1<=c) 
				dfs(x+1,y+1);
			if(x+1<=l && y-1<=c) 
				dfs(x+1,y-1);
			if(x-1>0 && y+1<=c) 
				dfs(x-1,y+1);
			if(x-1>0 && y-1<=c) 
				dfs(x-1,y-1);

		}
	}

	public static void main(String args[]) {
		Scanner stdin = new Scanner(System.in);

		n = stdin.nextInt();

		for(int w=0; w<n; w++){

			fillnumber='0';

			l = stdin.nextInt();
			c = stdin.nextInt();

			adj		= new char[l+1][c+1];
			visited = new boolean[l+1][c+1];

			//scan
			for(int i=0; i<=l; i++) {
				char[] line = stdin.nextLine().toCharArray();
				for(int j=1;j<=line.length;j++){
					adj[i][j] = line[j-1];
				}

			}


			//put visited false;
			for(int i=1; i<=l; i++) {
				for(int j=1; j<=c; j++) { 
					visited[i][j] = false;
				}
			}


			for(int i=1; i<=l; i++) {
				for(int j=1; j<=c; j++) {
					if(!visited[i][j] && adj[i][j]=='#') {
						fillnumber++;
						dfs(i,j);
					}	
				}
			}
			
			
			//counter 

			int count[] = new int[2000];
			Arrays.fill(count, 0);

			for(int i=1; i<=l; i++) {
				for(int j=1; j<=c; j++)
					if(adj[i][j]!='.')
						count[adj[i][j]]++;	
				}
				int max=0;
				for(int i=1;i<2000; i++)
					if(count[i]>max)
						max= count[i];

					System.out.println(max);
				}
			}	
		} 