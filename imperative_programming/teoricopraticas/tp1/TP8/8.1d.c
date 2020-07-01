#include<stdio.h>

int main() {
  char palavra[50], letra1;
  int i,flag;
  scanf("%s\n%c" , palavra, &letra1);
  for(i=0;i<50 ; i++) {
    if ( palavra[i] == letra1) {
      palavra[i] = '\0';
      flag= 1; }
    if (flag == 1)
      palavra[i]= '\0';
	  
  }
  printf("%s\n", palavra);
  return 0;
}
