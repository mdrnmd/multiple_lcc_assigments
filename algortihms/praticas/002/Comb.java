// Gerar combinacaoes 'n' numeros, 'k' a 'k'
// Input: dois nÃºmeros: 'n' e 'k'
// ----------------------------------
// Pedro Ribeiro (DCC/FCUP) - 21/09/2016
// ----------------------------------

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