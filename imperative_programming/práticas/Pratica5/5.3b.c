#include<stdio.h>
#include<time.h>
#include<stdlib.h>

int main() {

  int vezes, i, result, conta1=0 , conta2=0;
  float prob;
  
  printf("Quantas vezes devo lançar a moeda?\n");
  scanf("%d" ,&vezes);
  printf("Qual é a probabilidade de sair ""cara""?\n");
  scanf("%f" ,&prob);

  srand(time(NULL)); // randomiza uma sequencia

  prob= prob*100; // transforma o decimal em percentagem

  for (i=0 ; i<vezes; i++) {
    
    result =rand() % 100 +1;

    if ( result > prob) { // apresenta resultados
      conta1++; }
    else {
      conta2++; }
  }
  printf("Coroa:%d\n" ,conta1);
  printf("Cara:%d\n" ,conta2);
  return 0;
}
