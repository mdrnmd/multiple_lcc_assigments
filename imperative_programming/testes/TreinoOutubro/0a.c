#include <stdio.h>
int main() {
  int num1, num2, num3, seq, conta;
  scanf("%d" ,&seq);

  for (conta=0; conta<seq; conta++) {
    scanf("%d %d %d" ,&num1 ,&num2 ,&num3);
    if ( (num1<=0 ) || (num2<=0) || (num3<=0) )
      printf("claro que nao!\n");
    else {
      if ( (num1==num2) && (num1==num3) && (num2==num3) )
	printf("Sim, equilatero.\n");
      else if ( (num1+num2>= num3) &&  (num3+num2 >= num1) &&  (num1+num3>=num2) )
	printf("Sim.\n");
    }
  }
  return 0;
}
	  
	 
