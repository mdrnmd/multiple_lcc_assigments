#include<stdio.h>

int main() {
  int v[30], conta=-1, i, j, flag;

  scanf("%d" ,&v[0]);
  for (i=1; v[i-1] !=-999 ;i++ ) {
    scanf("%d" ,&v[i]); 
    if (v[i] ==-999)
      flag=i-1;
  }
  for (j=0 ; j<i ; j++) {
    if (v[j] == v[flag])
      conta++;
  }
  printf("%d\n" ,conta);
  return 0;
}
