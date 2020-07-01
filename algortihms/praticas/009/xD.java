import java.io.*;
import java.util.*;

public class xD {
	public static void main(String args[]) {

		Scanner stdin = new Scanner(System.in);
		double x,y;
		int j;




		int n = stdin.nextInt();
		double[] array = new double[n];
		for(int i=0;i<n;i++)
		{
			x= stdin.nextDouble();
			y=stdin.nextDouble();
			array[i]=y/x;


		}
		for(j=1;j<=n;j++)
		{
			int max=0;
			for(i=1;i<=n;i++)
				if(array[max]<array[i])
					max=i;
				array[max]=0;
				if(j<n)
					System.out.print(max + " ");
				else
					System.out.println(max);
			}
		}
	}