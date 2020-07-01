#include<stdio.h>
#include<stdlib.h> 
#include<time.h>

int main() {
  int ans=0, result, n1, n2;
  
  while (ans!= -1) {
    
    srand(time(NULL)); // Função que randomiza os números entre 1 e 9
    n1= rand()%9 +1;
    n2= rand()%9 +1;
    result = n1*n2;
    
    printf("Quanto é %d *% d?\n" ,n1 ,n2); // Pergunta e le a resposta 
    scanf("%d" ,&ans);
    
    if (ans == result) // Verifica o resultado
      printf("Certo!\n");
    else if (ans == -1) // Termina o programa
      return 0;
    else
      printf("Errado. O resultado é %d\n" ,result); // Resposta errada e mostra o resultado
    
  }
  
  return 0;
}

  
 
