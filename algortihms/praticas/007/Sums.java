import java.io.*;
import java.util.*;
import java.lang.Math.*;

public class Sums {
	public static int[] somas;
	
	public static int custombinarySearch(int start, int end, int[] v, int key) {

		while (start < end) {
			int mid = start + (end - start)/2;
			if (key == v[mid]) {
				return mid;
			}
			if (key <= v[mid]) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		if(v[start] < key) return -1;
		return(end);
	}
	public static int compare(int[] somas,int x,int p) {
		if (somas[x] == p)
			return p;
		else if (x==0)
			return somas[0];
		else {
			if (somas[x] - p > p - somas[x-1])
				return somas[x-1];
			else if (somas[x] - p < p - somas[x-1])
				return somas[x];
		}
		return 0;
	}

	public static void main(String args[]) {

		Scanner stdin = new Scanner(System.in);

		int n = stdin.nextInt();
		int siz = (n*(n-1)/2);
		int[] s = new int[n];
		for (int i=0; i<n; i++) 
			s[i] = stdin.nextInt();
		int p1 = stdin.nextInt();

		somas = new int[(n*(n-1))/2];	
		int xd=0;
		for(int i=0; i<s.length-1; i++) {
			for(int j=i+1; j<s.length; j++) {
				somas[xd]= s[i] + s[j];
				xd++;
			}
		}
		Arrays.sort(somas);
		int x;
		for(int i=0; i<p1; i++) {
			int p = stdin.nextInt();
			if ( p >= somas[siz-1]) {
				x = somas[siz-1];
				System.out.println(x);
			}
			else if(p<= somas[0])
				System.out.println(somas[0]);
			else {
				x=custombinarySearch(0,siz-1, somas, p);
				if(somas[x]-p == p-somas[x-1] && somas[x-1] != somas[x])
					System.out.println(somas[x-1] + " " +  somas[x]);
				else if(somas[x+1]-p == p-somas[x] && somas[x+1] != somas[x])
					System.out.println(somas[x] + " " + somas[x+1]);
				else {
					System.out.println(compare(somas,x,p));
				}
			}

			



		}
	}
}
