#include <stdio.h>
#define JOGOS 3

int main() {
  int n1, n2, pontos, conta=0, aux;
  while (conta < JOGOS ) {
    scanf("%d %d" ,&n1 ,&n2);
    conta++;
    aux= n1-n2;
    if (aux == 0)
      pontos= pontos +1;
    else if (aux > 0)
      pontos = pontos +3;
  }
  printf(" O clube fez %d pontos\n" ,pontos);
  return 0;
}
