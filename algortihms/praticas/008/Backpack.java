import java.io.*;
import java.util.*;

public class Backpack {

public static int n;


	public static boolean possible (int v[], int val, int part) {
		int  acum=0, check = 0;
		for (int i = 0 ; i < n ; i++ ){
			if ( part == 0 )
				return false;
			if ( val < v[i])
				return false;
			acum = acum + v[i];
			if ( acum > val ){
				acum = v[i];
				check++;
			}
			if ( check == part )
				return false;
		}
		return true;
	}

	public static int binarysearch (int low, int high,int distances[], int days) {

		while (low < high ){
			int middle = low + (high-low)/2;
			if ( possible(distances, middle, days) )
				high = middle;
			else
				low = middle + 1;
		}
		return low;
	}

	public static void main(String args[]) {

		Scanner stdin = new Scanner(System.in);
		int max=0, sum=0;
		n = stdin.nextInt();
		int[] distances = new int[n];
		for(int i=0; i<n; i++) {
			distances[i]= stdin.nextInt();
			sum+=distances[i];
			if(distances[i]>max)
				max=distances[i];
		}
		int p = stdin.nextInt();
		int days;
		for (int i=0; i<p; i++) {
			days = stdin.nextInt();
			if(days==n)
				System.out.println(max);
			else
				System.out.println(binarysearch(0,sum,distances,days));
		}

	}
}