import java.io.*;
import java.util.*;



public class moeda {
	public static void coins(int[] v, int n, int k) {
		int[] used = new int[10001];
		int[] coins = new int[10001];

		Arrays.fill(used,0);
		coins[0]=0;

		for(int i=1; i<=k; i++) {
			coins[i]= 10001;
			for(int j=1; j<=n; j++) {
				if(v[j]<=i && 1 + coins[i-v[j]] <  coins[i]) {
					coins[i] = 1 + coins[i-v[j]];
					used[i] = v[j];
				}

			}
		}

		System.out.print(k + ": [" + coins[k] + "]");


		while (k>0) {
			System.out.print(" " + used[k]);
			k = k - used[k];
		}
		System.out.println();
	}



	public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in);

		int n = stdin.nextInt();
		int[] v = new int[n+1];

		for (int i=1; i<=n; i++) 
			v[i]= stdin.nextInt();

		int x = stdin.nextInt();

		for(int i=0; i<x; i++) {
			int k = stdin.nextInt();
			coins(v,n,k);

		}

	}
}