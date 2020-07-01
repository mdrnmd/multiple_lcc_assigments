#include <stdio.h>
#include <ctype.h>

int main()  {
  int n, v[30] , v2[30]={0}, i, aux, raluno=0, cont=0;

  scanf("%d" ,&n); // ler valores


  for(i=0 ; i<n; i++) {
    scanf("%d",& v[i]);
  }
  
  scanf("%d" ,&aux); // conta as respostas certas do aluno




  for (i=0 ; i<n; i++) {
    if (v[i] == aux )
      raluno++;
  }



  
  // verifica os outros alunos
  for (i=0 ; i<n ; i++)
    v2[v[i]-1]++;

  for (i=0; i<30; i++)
    if (v2[i] > raluno)
	   cont++;

  
  printf("%d %d\n" ,raluno ,cont);
  
  return 0;
}
