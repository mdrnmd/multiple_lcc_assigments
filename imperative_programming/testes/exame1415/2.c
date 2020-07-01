#include <stdio.h>

int main() {

  int i, n ,pessoas[50], soma=0, aux;
  
  scanf("%d" ,&n);
  for(i=0; i<n; i++) {
    scanf("%d" ,&pessoas[i]);
  } // ler a sequencia

  for (i=0; i<n ; i++)
    if (pessoas[i] >0 )
      aux++ ; // verifica as idades
  
  for (i=0; i<n ; i++)
    if ((pessoas[i] >= 60) && (pessoas[i] < 70) )
      soma++ ; // verifica as idades

  for (i=0; i<n ; i++)
    if ((pessoas[i] <= 0)  )
      n-- ; // verifica as idades
    


  if (aux==0 ) {
    printf("Sem amostra\n");
    return 0;}
  
  printf("%.3f\n" ,(float)soma / n);
  return 0;
  
  
}
