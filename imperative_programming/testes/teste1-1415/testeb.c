#include <stdio.h>
int main() {
  float media;
  int conta, num, soma, aux;
  scanf("%d" ,&conta) ;
  aux = conta;
  while (conta > 0) {
    scanf("%d" ,&num);
    if (num > 5 )
      num = num - 5;
    else num = 0;
    conta = conta -1;
    soma = soma + num; }
  media = ((float)soma / (float)aux);
  printf("%.2f \n" ,media);
  return 0;
}
