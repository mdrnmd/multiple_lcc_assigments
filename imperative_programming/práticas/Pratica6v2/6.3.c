#include <stdio.h>
int main() {
  int n, v[20], i, aux=0;
  scanf("%d" ,&n);
  for( i=0; i<n; i++) {
    scanf("%d",&v[i]);
  }
  for (i=0; i<n; i++) {
    aux= 2*v[i];
    printf("%d ",aux);
  }
  printf("\n");
  return 0;
}
