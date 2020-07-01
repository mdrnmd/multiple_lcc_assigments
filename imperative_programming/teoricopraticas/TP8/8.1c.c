#include<stdio.h>

int main() {
  char palavra[50], letra1, letra2;
  int i;
  scanf("%s\n%c\n%c" , palavra, &letra1 ,&letra2);
  for(i=0;i<50 ; i++) {
    if ( palavra[i] == letra1)
      palavra[i]= letra2;
  }
  printf("%s\n", palavra);
  return 0;
}
