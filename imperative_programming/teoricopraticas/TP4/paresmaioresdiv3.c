#include <stdio.h>
#define SEQ 7
int main() {
  int conta=0 , num, div3=0 , par=0;
  float result;
  while (conta < SEQ) {
    printf("Insira um numero inteiro:");
    scanf("%d" ,&num);
    conta++;
    if (num%2 == 0) {
      par++; }
    if (num%3 == 0) {
      div3++; }
  }
  result =( (float)par / (float)div3) ;
  printf("%.2f \n" ,result );
  return 0;
}
  
      
     
