import java.io.*;
import java.util.*;

public class Exec003_v2 {
	static int n;
	static int v[]; 

	public static int max( int[] v)
	{
		int soma = 0;
		int max= -20000;

		for (int j=0; j < v.length; j++) {
			soma += v[j];
			if (max < soma) 
				max = soma;
			else if (soma<0)
				soma=0;
		}
		return max;

	}
	
	public static void main(String args[]) {

		Scanner stdin = new Scanner(System.in);
		
		int n = stdin.nextInt();
		int[] v= new int [n];
		
		for (int i=0; i<n; i++) {
			v[i]=stdin.nextInt();
		}

		System.out.println(max(v));

	}
}
