#include <stdio.h>
char maiuscula (char c);

int main () {
  char c, ola, toldo;
  while ( (c=getchar()) != '\n' )
    putchar(maiuscula (c)  ) ;
  return 0;
}

  
