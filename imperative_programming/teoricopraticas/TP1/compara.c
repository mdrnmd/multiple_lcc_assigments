#include <stdio.h>
int main () {
  int n1, n2;
  printf(" Introduz dois numeros inteiros: \n" );
  scanf(" %d %d" ,&n1 ,&n2);
  if (n1 > n2 )
    printf ("O numero maior e: %d \n" ,n1);
  else if (n2 > n1)
    printf ("O numero maior e: %d \n" ,n2);
  else
    printf ("O numero %d e igual ao numero %d \n" ,n1 ,n2);
  return 0;
}
  
