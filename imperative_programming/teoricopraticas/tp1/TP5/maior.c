#include <stdio.h>
int main(void) {
  int seq, num, maior, conta=2 ;
  printf("Insira o valor da sequencia de inteiros:");
  scanf("%d" ,&seq);
  scanf(" %d " ,&num);
  maior = num;
  while (conta < seq) {
    scanf(" %d " ,&num);
    if (num > maior)
      maior = num;
    conta++;
  }
  printf("%d\n" ,maior);
  return 0;
}
