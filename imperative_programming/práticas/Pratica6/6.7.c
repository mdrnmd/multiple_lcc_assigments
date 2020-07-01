#include<stdio.h>

int main() {
  
  int vet[50] ;
  int conta =0, valor=0 , i, flag=0;


  //scanning
  scanf("%d" ,&valor);
  while ( valor!=-1) {

    for( i=0; i<50; i++) {

      if(valor == vet[i])
	flag=1;
    }
    if (flag !=1)
      vet[i] = valor;
    flag=0;
    scanf("%d" ,&valor);
  }
  // printing
  for (i=0; vet[i]!='\0'; i++)
    conta++;
  printf("%d" ,conta);
  return 0;
}
