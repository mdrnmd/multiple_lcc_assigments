import java.io.*;
import java.util.*;

public class Exec003 {
	static int n, best1, best2, best3, mid;
	static int v[]; 

	static int sms(int v[], int a, int b) {
		if (a==b) 
			return v[a];
		mid= (a+b) / 2;
		best1 = sms(v, a, mid);
		best2 = sms(v, mid+1, b);
		best3 = sms(v, a, mid) + sms(v, mid+1, b);

         //pick best
		if (best1 > best2 && best1 > best3)
			return best1;
		else if (best2 > best3)
			return best2;
		else 
			return best3;
	}

	public static void main(String args[]) {

		Scanner stdin = new Scanner(System.in);
		
		int n = stdin.nextInt();
		int[] v= new int [n];
		
		for (int i=0; i<n; i++) {
			v[i]=stdin.nextInt();
		}
System.out.println(sms(v, 0, n));

}
}
