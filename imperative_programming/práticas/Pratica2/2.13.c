#include <stdio.h>
#define PROVAS 4
int main() {
  float soma=0, media, peso1, aux2;
  int num1, conta=0, aux1=0;
  while (conta < PROVAS) {
    scanf("%f %d" ,&peso1, &num1);
    aux2 = peso1/100;
    soma = soma + (num1*aux2);
    conta++;
    aux1 +=peso1;
      }
  if (aux1 != 100)
    printf("Erro: pesos nao somam 100! \n");
  else {
    media=(float)soma;
    printf("A media do aluno e:%.2f \n",media);
  }
  return 0;
}
