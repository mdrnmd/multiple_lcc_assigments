#include<stdio.h>

int main() {
  int v[20], max, i;

  scanf("%d" ,&max);
  for (i=0; i<max; i++) {
    scanf("%d" ,&v[i]);
  }
  printf("%d" ,v[0]*2);
  for( i=1; i<max; i++) {
    printf(" %d" ,v[i]*2);
  }
  printf("\n");
  return 0;
}
