//Welcome to caralho
//Nice code
//Real Simple


// 1º Hello World
// 2º Problemas Práticos
// 3º Source code dos problemas das práticas
// 4º Ordenação (ordemnacasa) 006 010
// 5º Binary Search (procurarnacasa) 007
// 6º Dynamic Programming (casadinamica) 012 013



public class HelloWorld {

	public static void main(String[] args) {
        // Prints "Hello, World" to the terminal window.
		System.out.println("Hello, World");
	}

}


// Problemas Práticos
// 001



import java.util.*;

public class Perm {
	 static int n;          // Quantidade de numeros
	 static int perm[];     // Guardar a permutacao em si    
	 static boolean used[]; // Indica se um numero ja foi usado
	 public static String[] name;
	 static double[][] dist = new double[n][n];
	 public static double out = 200000;
	 
	 

	// Funcao recursiva para colocar numero na posicao 'pos'
	 static void goPerm(int pos ) {

	// Chegamos ao fim da permutacao, vamos imprimi-la
	 	if (pos == n) {
	 		double soma = 0;
	 		for (int i=0; i<n-1; i++) {
	 			soma = soma + dist[perm[i]][perm[i+1]];
	 		}
	 		soma = soma + dist[perm[n-1]][0];

	 		if (out > soma) 		
	 			out= soma;

	 		//System.out.print(Math.round(soma * 100.00) / 100.00 + " "); // stackoverflow 
	 		soma = 0;

		/*
	 		for (int i=0; i<n; i++) {
	 			System.out.print(name[perm[i]] + " ");
	 		}
	 		System.out.print(name[perm[0]]);
	 		System.out.println();
	 		*/
	 		
	 		
	 	}


	// Vamos a meio da permutacao
	// Gerar numero nao usado para colocar nesta posicao
	 	else {
	 		used[0] = true;
	 		for (int i=1; i<n; i++)
	 			if (!used[i]) {
	 				perm[pos] = i;
	 				used[i] = true;
	 				goPerm(pos+1);
	 				used[i] = false;
	 			}
	 		}

	 	}   
	 	public static void main(String args[]) {


	 		Scanner stdin = new Scanner(System.in);

	// Ler a quantidade de numeros

	 		n = stdin.nextInt();	
	 		double[][] distancia = new double[n][n];


	 		String[] nome = new String[n];
	// Ler a String de estações

	 		for (int j = 0; j < n; j++) {
	 			nome[j] = stdin.next();
	 		}

	// Ler a matriz de distancias
			stdin.useLocale(Locale.US); // thanks google.
			for(int i=0; i<n; i++){
				for (int j=0; j<n; j++) {
					distancia[i][j]= stdin.nextDouble();
				}
			}

	// Alocar memoria para criar permutacoes
			perm = new int[n];
			used = new boolean[n];
			name = nome;
			dist = distancia;
			

	// Iniciar a permutacao na posicao 2
			goPerm(1);  
			System.out.println(Math.round(out * 100.00) / 100.00);  
		}
	}



// 002



	import java.util.Scanner;

	public class Comb {
    static int n, k, segundostotal, soma, out; // Combinacoes de 'n', 'k' a 'k'
    static int comb[],musica[] ;

      // Guardar a combinacao em si

    // Funcao recursiva para colocar numero na posicao 'pos',
    // sabendo que nesta posicao podem vir numeros a partir de 'first'
    static void goComb(int pos, int first) {
    	
	// Chegamos ao fim da combinacao, vamos imprimi-la
    	if (pos == k) { 
    		soma=0;
    		for (int i=0; i<k; i++) {
    			soma = soma + musica[comb[i]];
    		}
    		if (soma <= segundostotal && soma > out)
    			out = soma;
    		//System.out.print(soma + " ");
    		//	System.out.print(musica[comb[i]] + " ");
    		//System.out.println();
    	}
    	
	// Vamos a meio da combinacao
	// Gerar numero nao usado para colocar nesta posicao
    	else {
    		for (int i=first; i<n; i++) {
    			comb[pos] = i;
    			goComb(pos+1, i+1);
    		}
    	}
    }
    
    public static void main(String args[]) {
    	
    	Scanner stdin = new Scanner(System.in);
    	
	// Ler Input   
    	
    	segundostotal = stdin.nextInt();
    	
    	n = stdin.nextInt();

    		// Alocar memoria para criar combinacoes
    	comb = new int[n];
    	musica = new int[n];
    	
    	for (int i=0; i<n; i++) {
    		musica[i]= stdin.nextInt();
    	}

    	
	// Iniciar a combinacao na posicao 0 e fazer todas as combinações possíveis
    	k=0;
    	for (int i=0; i<= n; i++) {
    		k++;
    		goComb(0, 0);  
    	}
    	System.out.println(out);
    }

}


// 003


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


//004

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
		if (width>0.0001)  {
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


// 005

import java.util.*;

public class exec005_v1 {
	public static void main(String[] args) {
		
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();
		int[] v = new int[n];
		for (int i=0; i<n; i++) {
			v[i] = stdin.nextInt();
		}

		int contador=0; 
		for(int i=0; i<n-1; i++) 
			for(int j=i+1; j<n; j++)
				if (v[i] > v[j])
					contador+=1;
				System.out.println(contador);
			}
		}




// 006

// Exemplo de ordenacao customizada de pessoas
// Primeiro por ordem crescente da idade, e em caso de empate por
// ordem crescente alfabetica do nome
// ----------------------------------
// Pedro Ribeiro (DCC/FCUP) - 09/10/2016
// ----------------------------------

		import java.io.*;
		import java.util.*;
		import java.lang.*;

// Classe para guardar um nome
		class Team implements Comparable<Team> {
			public int points, goals;
			public String name;

			Team(String n, int a, int b) {
				name = n;
				points = a;
				goals = b;
			}

    // Definir como comparar dois elementos da classe Team
    // compareTo e uma funcao que compara objecto com outro objecto "p"
    // Esta funcao deve devolver:
    //  - numero < 0 se objecto for menor que objecto "p"
    //  - numero > 0 se objecto for maior que objecto "p"
    //  - zero, se objecto for igual ao objecto "p"
			@Override
			public int compareTo(Team p) {
				if (points < p.points) return -1;
				if (points > p.points) return +1;
				if (goals < p.goals) return -1;
				if (goals > p.goals) return 1;
				return -(name.compareToIgnoreCase(p.name));
			}

		}

		public class CustomSort {
			public static void main(String args[]) {
				Scanner stdin = new Scanner(System.in);

				int n = stdin.nextInt();	
				Team v[] = new Team[n]; 

				for (int i = 0; i<n; i++) {

					v[i] = new Team(stdin.next(),(3 * stdin.nextInt()) + stdin.nextInt() + (0*stdin.nextInt()),(stdin.nextInt() - stdin.nextInt()));
				}

	// Chamada ao sort padrao da linguagem Java
	// Usa o comparador padrao do tipo do array
				Arrays.sort(v);

				for (int i=n-1; i>-1; i--)
					System.out.println(v[i].name + " " + v[i].points + " " + v[i].goals);
			}
		}



// 007


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
						else if(somas[x+1]-p == p-somas[x] & somas[x+1] != somas[x])
							System.out.println(somas[x] + " " + somas[x+1]);
						else {
							System.out.println(compare(somas,x,p));
						}
					}





				}
			}
		}





// 008



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

/// 010



		import java.io.*;
		import java.util.*;

		public class sapatos {
			public static void main(String[] args) {

				Scanner stdin = new Scanner(System.in);
				int n = stdin.nextInt();
				double x, y;
				double[] array= new double[1000];

				for(int i=1; i<=n; i++) {
					x = stdin.nextDouble();
					y = stdin.nextDouble();
					array[i]=y/x;
				}
				for(int i=1; i<=n; i++) {
					int max=0;
					for(int j=1; j<=n; j++) 
						if(array[max] < array[j])
							max=j;
						array[max]=0;

						if(i<n) 
							System.out.print(max + " ");
						else 
							System.out.println(max);
					}
				}
			}import java.io.*;
			import java.util.*;

			public class sapatos {
				public static void main(String[] args) {

					Scanner stdin = new Scanner(System.in);
					int n = stdin.nextInt();
					double x, y;
					double[] array= new double[1000];

					for(int i=1; i<=n; i++) {
						x = stdin.nextDouble();
						y = stdin.nextDouble();
						array[i]=y/x;
					}
					for(int i=1; i<=n; i++) {
						int max=0;
						for(int j=1; j<=n; j++) 
							if(array[max] < array[j])
								max=j;
							array[max]=0;

							if(i<n) 
								System.out.print(max + " ");
							else 
								System.out.println(max);
						}
					}
				}




///012


				import java.util.Scanner;



				public class piramid {
					public static void main(String[] args) {

						int[][] pyramid = new int[1000][1000];	

						Scanner stdin = new Scanner(System.in);
						int n = stdin.nextInt();	

						int t=1;
						for(int i=0; i<n; i++) {
							for(int j=0; j<=n-t; j++)
								pyramid[i][j]=1;
							t++;
						}


						int d = stdin.nextInt();

						for(int i=0; i<d; i++) {
							int x = stdin.nextInt();
							int y = stdin.nextInt();
							pyramid[x-1][y-1]= 0;
						}

						for(int i=0; i<n; i++) {
							if(pyramid[1][i]==0)
								pyramid[1][i]=0;
						}

						t=1;
						if(n>=2)
							for(int i=1; i<n; i++) {
								for(int j=0; j<n-t; j++) {
									if(pyramid[i][j]==0)
										pyramid[i][j]=0;
									else 
										pyramid[i][j]=pyramid[i-1][j] + pyramid[i-1][j+1];
								}
								t++;
							}

							System.out.println(pyramid[n-1][0]);


						}
					}

// 013


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

/////
/////
/////
/////


//Permutações Source Code


// Gerar todas as permutacoes de 'n' numeros
// Input: um unico numero indicando 'n'
// ----------------------------------
// Pedro Ribeiro (DCC/FCUP) - 21/09/2016
// ----------------------------------

					import java.util.Scanner;

					public class Perm {
    static int n;          // Quantidade de numeros
    static int perm[];     // Guardar a permutacao em si    
    static boolean used[]; // Indica se um numero ja foi usado

    // Funcao recursiva para colocar numero na posicao 'pos'
    static void goPerm(int pos) {

	// Chegamos ao fim da permutacao, vamos imprimi-la
    	if (pos == n) {
    		for (int i=0; i<n; i++)
    			System.out.print(perm[i] + " ");
    		System.out.println();
    	}

	// Vamos a meio da permutacao
	// Gerar numero nao usado para colocar nesta posicao
    	else {
    		for (int i=0; i<n; i++)
    			if (!used[i]) {
    				perm[pos] = i;
    				used[i] = true;
    				goPerm(pos+1);
    				used[i] = false;
    			}
    		}
    	}    

    	public static void main(String args[]) {

    		Scanner stdin = new Scanner(System.in);

	// Ler a quantidade de numeros
    		n = stdin.nextInt();	

	// Alocar memoria para criar permutacoes
    		perm = new int[n];
    		used = new boolean[n];

	// Iniciar a permutacao na posicao 1
    		goPerm(0);    

    	}
    }




/// Combinações Source Code

// Gerar combinacaoes 'n' numeros, 'k' a 'k'
// Input: dois nÃºmeros: 'n' e 'k'
// ----------------------------------
// Pedro Ribeiro (DCC/FCUP) - 21/09/2016
// ----------------------------------

    import java.util.Scanner;

    public class Comb {
    static int n, k; // Combinacoes de 'n', 'k' a 'k'
    static int comb[];   // Guardar a combinacao em si

    // Funcao recursiva para colocar numero na posicao 'pos',
    // sabendo que nesta posicao podem vir numeros a partir de 'first'
    static void goComb(int pos, int first) {

	// Chegamos ao fim da combinacao, vamos imprimi-la
    	if (pos == k) {
    		for (int i=0; i<k; i++)
    			System.out.print(comb[i] + " ");
    		System.out.println();
    	}

	// Vamos a meio da combinacao
	// Gerar numero nao usado para colocar nesta posicao
    	else {
    		for (int i=first; i<n; i++) {
    			comb[pos] = i;
    			goComb(pos+1, i+1);
    		}
    	}
    }
    
    public static void main(String args[]) {

    	Scanner stdin = new Scanner(System.in);

	// Ler n e k    
    	n = stdin.nextInt();
    	k = stdin.nextInt();

	// Alocar memoria para criar combinacoes
    	comb = new int[n];

	// Iniciar a combinacao na posicao 0
    	goComb(0, 0);  

    }
}




/// Sort int numbers



// Exemplo de ordenacao de 10 numeros inteiros
// ----------------------------------
// Pedro Ribeiro (DCC/FCUP) - 17/10/2015
// ----------------------------------

import java.io.*;
import java.util.*;

public class Sort {
	public static void main(String args[]) {

	// Um array exemplo 
		int v[] = {33, 4, 28, 18, 15, 2, 8, 17, 42, 39};

		System.out.print(" Antes de ordenar: "); 
		for (int i=0; i<10; i++)
			System.out.print(v[i] + " ");
		System.out.println();

	// Chamada ao sort padrao da linguagem Java
		Arrays.sort(v);

		System.out.print("Depois de ordenar: ");
		for (int i=0; i<10; i++)
			System.out.print(v[i] + " ");
		System.out.println();

	}
}



/// Sort strings simple

String[] strings = { " Hello ", " This ", "Is ", "Sorting ", "Example" };
Arrays.sort(strings);


// sort chars shit

import java.util.Arrays;

public class Test
{
	public static void main(String[] args)
	{
		String original = "edcba";
		char[] chars = original.toCharArray();
		Arrays.sort(chars);
		String sorted = new String(chars);
		System.out.println(sorted);
	}
}



// method fatorial java

int fact(int n)
{
	int result;

	if(n==1)
		return 1;

	result = fact(n-1) * n;
	return result;
}



// Check if sorted array 

boolean is_array_sorted(int arr[]) {
	for(int i=0; i < arr.len-1; i++) {
		if(arr[i] > arr[i+1]) {
			return false;
		}
	}
	return true;
}



////////////////////////////////////////////////////////////////////////////////////////////////7
///////////////////////////ordemnacasa//////////////////////////////////////////////////////////7
////////////////////////////////////////////////////////////////////////////////////////////////7


//custom sort 

// Exemplo de ordenacao customizada de pessoas
// Primeiro por ordem crescente da idade, e em caso de empate por
// ordem crescente alfabetica do nome
// ----------------------------------
// Pedro Ribeiro (DCC/FCUP) - 09/10/2016
// ----------------------------------

import java.io.*;
import java.util.*;

// Classe para guardar um nome
class Person implements Comparable<Person> {
	public int age;
	public String name;

	Person(int a, String n) {
		age = a;
		name = n;
	}

    // Definir como comparar dois elementos da classe Person
    // compareTo e uma funcao que compara objecto com outro objecto "p"
    // Esta funcao deve devolver:
    //  - numero < 0 se objecto for menor que objecto "p"
    //  - numero > 0 se objecto for maior que objecto "p"
    //  - zero, se objecto for igual ao objecto "p"
	@Override
	public int compareTo(Person p) {
		if (age < p.age) return -1;
		if (age > p.age) return +1;
		return name.compareTo(p.name);
	}
}

public class CustomSort {
	public static void main(String args[]) {
		Scanner stdin = new Scanner(System.in);

		int n    = stdin.nextInt();	
		Person v[] = new Person[n]; 
		for (int i = 0; i<n; i++)
			v[i] = new Person(stdin.nextInt(), stdin.next());

	// Chamada ao sort padrao da linguagem Java
	// Usa o comparador padrao do tipo do array
		Arrays.sort(v);

		for (int i = 0; i<n; i++)
			System.out.println(v[i].age + " " + v[i].name);
	}
}






////////////////////////////////////////////////////////////////////////////////////////////////7
///////////////////////////procurarnacasa///////////////////////////////////////////////////////7
////////////////////////////////////////////////////////////////////////////////////////////////7

 //// Simple binary search program

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






////////////////////////////////////////////////////////////////////////////////////////////////7
///////////////////////////casadinamica/////////////////////////////////////////////////////////7
////////////////////////////////////////////////////////////////////////////////////////////////7

