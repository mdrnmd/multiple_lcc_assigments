#include <stdio.h>

int main() {

  int i , falso[4], aux=1, soma;

  for (i=0; i<4; i++)
    scanf("%d" ,&falso[i] );

  while (aux!=0 ) {
    scanf("%d" ,&aux );
    for (i=0; i<4; i++) {
      if (aux == falso[i])
	falso[i] = 0; }
  }

  for (i=0; i<4; i++)
    if (falso[i]== 0)
      soma ++;

  printf("Utilizados:%d\n" ,soma);
  return 0;
}
  
