#include<stdio.h>

int main() {
  
  int v[20], max, i;
  scanf("%d" ,&max);

  for (i=0; i<max; i++)
    scanf("%d" ,&v[i]);

  printf("%d" ,v[ max-1]*2);
  for (i=max-2; i>=0; i--)
    printf(" %d" ,v[i]*2);
  printf("\n" );
  return 0;
}
