#include<stdio.h>
#include<time.h>
#include<stdlib.h>

int main() {
  int random, guess, repeat=1, stat1=0, min=100, max=0 , med=0, conta=1;
  
  while ( repeat != 0) { // ínicio da função base do jogo
    printf("*********************************************\n");
    stat1++;
    scanf("%d" ,&guess);
    srand(time(NULL)); 
    random= rand()%100 +1;
    while (guess != random) { // verifica a resposta
      conta++;
      if (guess > random)
	printf("O número em que pensei é menor que esse.\n");
      else 
	printf("O número que pensei é maior que esse.\n");
      scanf("%d" ,&guess);
      
    }
    if (conta < min)
      min = conta;
    if (conta > max)
      max = conta;
    med += conta;
    conta = 1;
    
    printf("Acertou!\n");
    
    printf("*********************************************\n");
    printf("Quer jogar outra vez?(1/0)\n"); // função repeat
    scanf("%d" ,&repeat); // fim da função base do jogo
  }
  // estatística
  
  printf("O jogador jogou %d vezes.\n" ,stat1);
  printf("O jogo com menos tentativas teve %d.\n" ,min);
  printf("O jogo com mais tentativas teve %d.\n", max);
  printf("A média de tentativas foi %.2f\n", (float)med/stat1);
  
  return 0; 
}

