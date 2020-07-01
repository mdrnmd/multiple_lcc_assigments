#include <stdio.h>
int main () {
  int n1, n2, result, soma;
  printf( "Introduz dois numeros inteiros:" );
  scanf( "%d %d",&n1 ,&n2 );
  printf( "Introduz o resultado: \n");
  scanf( "%d" ,&result );
  soma = n1 + n2;
  if ( soma != result ) 
    printf("Erraste! Tenta outra vez! \n");
    else
      printf("Acertaste Cona!\n " ) ;
  return 0;
}

	     
