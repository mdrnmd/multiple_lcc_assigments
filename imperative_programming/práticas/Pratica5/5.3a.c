#include<stdio.h>
#include<time.h>
#include<stdlib.h>

int main() {

  int vezes, i, result;
  float prob;
  
  printf("Quantas vezes devo lançar a moeda?\n");
  scanf("%d" ,&vezes);
  printf("Qual é a probabilidade de sair ""cara""?\n");
  scanf("%f" ,&prob);

  srand(time(NULL)); // randomiza uma sequencia

  prob= prob*100; // transforma o decimal em percentagem

  for (i=0 ; i<vezes; i++) {
    
    result =rand() % 100 +1;

    if ( result > prob) // apresenta resultados
      printf("Coroa\n");
    else printf("Cara\n");

  }
  return 0;
}
