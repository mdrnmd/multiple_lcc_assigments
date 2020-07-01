#include <stdio.h>
#define MAX 20
int main() {
  int div[MAX], contador[MAX]={0};
  int i,n, num;
  scanf("%d", &n);
  for (i=0; i<n; i++) {
    scanf("%d", &div[i]);
  }
  scanf("%d" ,&num);
  while (num != -1) {
    for(i=0; i<n; i++) {
      if (div[i] ) {
	if( num%div[i]==0)
	  contador[i]++;
	else if (num == 0) contador[i] ++;
      }
    }
    scanf("%d", &num);
    
  }
  for (i=0; i<n; i++) {
    printf("multiplos de %d: %d\n" ,div[i] ,contador[i]) ;
  }
  return 0;
}
