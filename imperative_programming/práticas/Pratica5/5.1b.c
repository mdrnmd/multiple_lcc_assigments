#include<stdio.h>
#include<stdlib.h> 
#include<time.h>

int main() {
  int ans=0, result, n1, n2, opera;
  
  while (ans!= -1) {
    
    srand(time(NULL)); // Função que randomiza os números entre 1 e 9
    n1= rand()%9 +1;
    n2= rand()%9 +1;
    opera= rand()%4 +1;
    
    switch(opera) {
    case 1 : 
      result = n1 + n2;
      printf("Quanto é %d + %d?\n" ,n1 ,n2); // Pergunta e le a resposta 
      scanf("%d" ,&ans);
      break;
    case 2 :
      result = n1 - n2;
      if (result >= 0) {
	printf("Quanto é %d - %d?\n" ,n1 ,n2); // Pergunta e le a resposta 
	scanf("%d" ,&ans); }
      break;
      
    case 3 :
      result = n1 * n2;
      printf("Quanto é %d x %d?\n" ,n1 ,n2); // Pergunta e le a resposta 
      scanf("%d" ,&ans);
      
    case 4 :
      result = n1 / n2;
      printf("Quanto é %d / %d?\n" ,n1 ,n2); // Pergunta e le a resposta 
      scanf("%d" ,&ans);
      
    }
    
    if (ans == result) //verifica o resultado
      printf("Certo!\n");
    else if (ans == -1) // Termina o programa
      return 0;
    else 
      printf("Errado. O resultado é %d\n" ,result); // Resposta errada e mostra o resultado
    
  }
  
  return 0;
}

  
 
