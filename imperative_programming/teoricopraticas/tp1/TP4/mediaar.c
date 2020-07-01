#include <stdio.h>
#define MAXDIAS 7

int main() {
  int dia, ndias=0, soma=0;
  float media;
  while (ndias < MAXDIAS) {
      printf("Insira o Indice: ");
      scanf("%d" ,&dia );
      ndias++;
      soma = soma + dia; }
  media =(float)soma/MAXDIAS ;
  printf("A media e:%f\n" ,media);
  return 0;
}
