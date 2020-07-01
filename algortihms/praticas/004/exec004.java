 import java.util.*;
import java.text.*;

public class exec004 {
	
	static double radius, width;

	public static double intersecao(double x1, double  x2, double  y1, double y2, double width) {

		//quadrado fora do circulo, 100%
		if(((y1 + radius < x1)||(y1 - radius > x1 + width)) && ((y2 + radius < x2)||(y2 - radius > x2 + width)))
			return 0;
		
		//quadrado dentro do circulo, 100%
		else if (dentro(x1, x2, y1, y2, radius) 
			&& dentro(x1 + width, x2, y1, y2, radius) 
			&& dentro(x1, x2 + width, y1, y2, radius) 
			&& dentro(x1+ width, x2+ width, y1, y2, radius))
			return (width * width); 

		//circulo dentro do quadrado, 100%
		else if((y1 + radius < x1 + width) && 
			(y1 - radius > x1) &&
			(y2 + radius < x2 + width) &&
			(y1 - radius > x2))
			return (Math.PI * (radius * radius));

		// caso final, dividir em 4 quadrados
		double area=0;	
		if (width>0.00036)  {
			width= width / 2;
			area = area + intersecao(x1, x2, y1, y2, width) 
			+ intersecao(x1 + width, x2 + width, y1, y2, width)
			+ intersecao(x1 + width, x2, y1, y2, width)
			+ intersecao(x1, x2 + width, y1, y2, width);
		}
		return area;
	}
	
	public static boolean dentro(double x1, double x2, double y1, double y2, double radius) {
		return(Math.sqrt(((x1-y1)*(x1-y1)) + ((x2-y2)*(x2-y2))) < radius);
	}

	public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in);


		int n = stdin.nextInt();
		for(int i=0; i<n; i++) {
			double x1 = stdin.nextDouble();
			double x2 = stdin.nextDouble();
			width = stdin.nextDouble();
			double c1 = stdin.nextDouble();
			double c2 = stdin.nextDouble();
			radius= stdin.nextDouble();
			System.out.printf("%.2f" ,(intersecao( x1, x2, c1, c2, width)));
			System.out.println();
		}

	}
}
