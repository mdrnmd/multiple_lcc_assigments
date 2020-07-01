#include <stdio.h>
#define MAX 100

int main() {
  int  num, divisor=0, aux;
  scanf("%d" ,&num);
  while (divisor < MAX) {
    divisor++;
    aux = num / divisor;
    if (aux == divisor) {
      printf("E quadrado de %d.\n" ,divisor);
      return 0;
    }
  }
  printf("Nao e quadrado perfeito!\n");
  return 0;
}
  
