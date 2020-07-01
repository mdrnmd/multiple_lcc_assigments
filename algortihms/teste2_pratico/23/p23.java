
import java.io.*;
import java.util.*;

public class p23 {
	char matrix[][], copy;
	int l,c;

	public boolean check() {
		for(int i=0; i<l; i++) {
			for(int j=0; j<c; j++) {
				if(matrix[i][j]=='A') {
					if(i+1<l) {
						if(matrix[i+1][j]=='.')
							return true;
					}
					if(i-1>=0) {
						if(matrix[i-1][j]=='.')
							return true;
					}
					if(j-1>=0) {
						if(matrix[i][j-1]=='.')
							return true;
					}
					if(j+1<c) {
						if(matrix[i][j+1]=='.')
							return true;
					}
				}
			}
		}
		return false;
	}

	public boolean semicheck() {
		boolean x1,x2,x3,x4;
		for(int i=0; i<l; i++) {
			for(int j=0; j<c; j++) {
				if(matrix[i][j]=='A') {
					if(i+1<l) {
						if(matrix[i+1][j]!='#')
							x1 = false;
					}
					if(i-1>=0) {
						if(matrix[i-1][j]!='#')
							x2 = false;
					}
					if(j-1>=0) {
						if(matrix[i][j-1]!='#')
							x3 = false;
					}
					if(j+1<c) {
						if(matrix[i][j+1]!='#')
							x4 = false;
					}
				}
			}

		}
	}


	public void adj(int i, int j) {
		if(i+1<l) {
			if(matrix[i+1][j]=='.')
				old[i+1][j]='#';
		}
		if(i-1>=0) {
			if(matrix[i-1][j]=='.')
				old[i-1][j]='#';
		}
		if(j-1>=0) {
			if(matrix[i][j-1]=='.')
				old[i][j-1]='#';
		}
		if(j+1<c) {
			if(matrix[i][j+1]=='.')
				old[i][j+1]='#';
		}
	}

	public void time() {
		int full_count=0, semi_count=0;
		while(check) {
			if(semicheck())
				System.out.print("")
			for(int i=0; i<l; i++) {
				for(int j=0; j<c; j++) {
					if(matrix[i][j]=='A')
						old[i][j]='A';
					else if(matrix[i][j]=='#')
						adj(i,j);
				}
			}
			for(int i=0; i<l; i++) {
				for(int j=0; j<c; j++) {
					if(old[i][j]==0)
						old[i][j]='.';
				}
				for(int i=0; i<matrix.length; i++) {
					for(int j=0; j<matrix[i].length; j++)
						matrix[i][j]=old[i][j];
				}







				public static void main(String args[]) {
					Scanner stdin = new Scanner(System.in);

					l = stdin.nextInt();
					c = stdin.nextInt();
					stdin.nextLine();

					matrix[][]	= new char[l][c];
					copy[][]	= new char[l][c];


		//scan
					for(int i=0; i<l; i++) {
						char[] line = stdin.nextLine().toCharArray();
						for(int j=0;j<line.length;j++){
							matrix[i][j] = line[j];
						}
					}




		//printer
					for(int i=0; i<l; i++) {
						for(int j=0; j<c; j++) 
							System.out.print(matrix[i][j]);
						System.out.println();
					}


				}
			}
