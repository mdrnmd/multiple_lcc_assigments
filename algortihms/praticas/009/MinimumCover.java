import java.io.*;
import java.util.*;

public class MinimumCover {

	public static int[] array,array2;

	public static void cocktailsort( int[] array, int[] array2){
		int temp;
		while(checksort(array)== false) {

			for (int i =0; i<=  array.length  - 2;i++) {
				if (array[ i ] > array[ i + 1 ]) {

					temp = array[i];
					array[i] = array[i+1];
					array[i+1]=temp;
					temp = array2[i];
					array2[i] = array2[i+1];
					array2[i+1]=temp;

				}
			}
			for (int i= array.length - 2;i>=0;i--) {
				if (array[ i ] > array[ i + 1 ]) {
					temp = array[i];
					array[i] = array[i+1];
					array[i+1]=temp;
					temp = array2[i];
					array2[i] = array2[i+1];
					array2[i+1]=temp;

				}
			}

		}
	}

	public static boolean checksort(int[] data) {
		for(int i = 1; i < data.length; i++){
			if(data[i-1] > data[i]){
				return false;
			}
		}
		return true;
	}
	public static void count(int[] array, int[]array2,int start,int index,int end, int count) {
		int max=0;
		if(start >= end) 
			System.out.println(count);
		else {
			for(int i=0; array2[i]<=end; i++) {
				if(array[i]<= start)
					if(array2[i]>max) 
						max= array2[i];
				}
				count++;
				count(array, array2, max, index, end, count);
			}
		}



		public static void main(String args[]) {

			Scanner stdin = new Scanner(System.in);

			int m = stdin.nextInt();
			int n = stdin.nextInt();
			int[] array = new int[n];
			int[] array2 = new int[n];

			for (int i=0; i<n; i++) {
				array[i]= stdin.nextInt();
				array2[i]= stdin.nextInt();
			}
			cocktailsort(array,array2);
			count(array, array2,0,0,m,0);

} 
}