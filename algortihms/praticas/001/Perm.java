	// Gerar todas as permutacoes de 'n' numeros
	// Input: um unico numero indicando 'n'
	// ----------------------------------
	// Pedro Ribeiro (DCC/FCUP) - 21/09/2016
	// ----------------------------------

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
