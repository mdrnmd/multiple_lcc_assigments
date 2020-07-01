#include <stdio.h>
#define NR 4
int main() {
  int num1 , result=0, conta=0 ;
  while (conta < NR){
    scanf("%d" ,&num1);
    result = result * 10;
    result = result + num1;
    conta++;
  }
  printf("%d\n" ,result);
  return 0;
}
    
