// Exemplo de ordenacao de 10 numeros inteiros
// ----------------------------------
// Pedro Ribeiro (DCC/FCUP) - 17/10/2015
// ----------------------------------

import java.io.*;
import java.util.*;

public class Sort {
	public static void main(String args[]) {


		Scanner stdin = new Scanner(System.in);
		
		int n = stdin.nextInt();
		String[] teams = new String[n];
		int[] points = new int[n];
		int[] goals = new int[n];

		for (int i=0; i<n; i++) {
			teams[i]=stdin.next();
			
			int x=0;
			x=stdin.nextInt();
			points[i] = 3*x;
			x=stdin.nextInt();
			points[i] += x;
			x=stdin.nextInt();
			
			goals[i]=stdin.nextInt();
			x=stdin.nextInt();
			goals[i]-=x;
		}
		


		for (int i=0; i<10; i++)
			System.out.print(v[i] + " ");
		System.out.println();

	}
}