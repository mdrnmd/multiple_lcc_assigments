import java.util.*;
import java.io.*;

// 0 - não visitado
// 1 - a visitar
// 2 - já visitado
// 8 - parede
public class p21 {
	static int n, count, max, cycle, c, l;
	static int matrix[][], scaled[][];

	static void dfs(int v, int w) {
		count++;
		if(scaled[v][w]==0)
		scaled[v][w]=1;
		else if(scaled[v][w]==1){
			cycle++;
			if(max<count) {
				max=count;
				count=1;
			}
			
			return;
		}

		if(v+1<l) {
			if(scaled[v+1][w]==0 || scaled[v+1][w]==1)
				dfs(v+1,w);
		}
		if(v-1>0) {
			if(scaled[v-1][w]==0 || scaled[v-1][w]==1)
				dfs(v-1,w);
		}
		if(w-1>0) {
			if(scaled[v][w-1]==0 || scaled[v][w-1]==1)
				dfs(v,w-1);
		}
		if(w+1<c) { 
			if(scaled[v][w+1]==0 || scaled[v][w+1]==1)
				dfs(v,w+1);
		}
		scaled[v][w]=2;
	}


	public static void main(String args[]) {
		Scanner stdin = new Scanner(System.in);


		l = stdin.nextInt();
		c = stdin.nextInt();

		matrix	= new int[c][l];
		scaled = new int[3*c][3*l];

		//line reseter after reading integer
		stdin.nextLine();

		//scan
		for(int i=0; i<c; i++) {
			char[] in = stdin.nextLine().toCharArray();
			for(int j=0; j<l; j++) {
				if(in[j]=='/') {
					matrix[i][j]=1;
				}
				else matrix[i][j]=0;
			}
		}

		//escalator
		for(int i =0; i<c; i++) {
			for(int j=0; j<l; j++) {
				if(matrix[i][j]==1) {
					scaled[(3*i)][(3*j)+2]=8;
					scaled[(3*i)+1][(3*j)+1]=8;
					scaled[(3*i)+2][(3*j)]=8;
				}
				else {
					scaled[3*i][3*j]=8;
					scaled[3*i+1][3*j+1]=8;
					scaled[3*i+2][3*j+2]=8;
				}
			}
		}



		cycle=0;
		max=0;
		for(int i=0; i<c*3; i++)
			for(int j=0; j<l*3; j++) {
				if(scaled[i][j]==0 && scaled[i][j]!=8) {
					count=1;
					dfs(i,j);
				}
			}


			if(cycle==0)
				System.out.println("nao tem ciclos");
			else System.out.println(cycle + " " + max);





			System.out.println();

			for(int i=0; i<3*c; i++) {
				for(int j=0; j<3*l; j++) {
					if(scaled[i][j]==2)
						System.out.print(" ");	
					else
						System.out.print(scaled[i][j]);
				}
				System.out.println();
			}


		}
	} 

