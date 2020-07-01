#include <stdio.h>
int main() {
  int num, soma=1, aux;
   scanf("%d" ,&num );
   aux= num;
  while (num > 0) {
    soma = num * soma;
    num--; }
  printf( "fatorial de %d e:%d\n" ,aux ,soma);
  return 0;
}
