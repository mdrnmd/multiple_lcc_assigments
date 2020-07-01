import java.io.*;
import java.util.*;

public class bsearch {
	static int bsearch1(int[] array,int low,int high,int key){
		while (low <= high) {
			int middle = low + (high-low)/2;
			if( key ==array[middle]) 
				return middle;
			else if(key<array[middle])
				high = middle-1;
			else
				low=middle+1;
		}
		return -1;
	}
	public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in);

		int n = stdin.nextInt();
		int v[] = new int[n];
		for (int i=0; i<n; i++) 
			v[i]= stdin.nextInt();
		int x = stdin.nextInt();
		System.out.println(bsearch1(v,0,n,x));

	}
}	