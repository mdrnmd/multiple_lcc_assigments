// Gerar todas as permutacoes de 'n' numeros
// Input: um unico numero indicando 'n'
// ----------------------------------
// Pedro Ribeiro (DCC/FCUP) - 21/09/2016
// ----------------------------------

#include <stdio.h>

#define MAX 20

int n;          // Quantidade de numeros
int perm[MAX];  // Guardar a permutacao em si
char used[MAX]; // Indica se um numero ja foi usado

// Funcao recursiva para colocar numero na posicao 'pos'
void goPerm(int pos) {
	int i;

  // Chegamos ao fim da permutacao, vamos imprimi-la
	if (pos == n) {
		for (i=0; i<n; i++)
			printf("%d ", perm[i]);
		putchar('\n');
	}

  // Vamos a meio da permutacao
  // Gerar numero nao usado para colocar nesta posicao
	else {
		for (i=0; i<n; i++)
			if (!used[i]) {
				perm[pos] = i;
				used[i] = 1;
				goPerm(pos+1);
				used[i] = 0;
			}
		}
	}

	int main() {

		int j;



  // Ler a quantidade de numeros
		scanf("%d",&n);
		char *nome[n];
		for(j=0; j<n; j++) 
			scanf("%s" ,&nome[j]); 
		

  // Iniciar a permutacao na posicao 0  
		goPerm(0);  

		return 0;
	}
