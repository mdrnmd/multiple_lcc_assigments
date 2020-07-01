#include<stdio.h>
#include<ctype.h>


char maiuscula(char c) {
  if (c>='A' && c<= 'Z')
    putchar(c);
  else putchar(c - ('a' - 'A'));
  return 0;
}

int main() {
  char letra;
  scanf("%c" ,&letra);
  maiuscula(letra);
  putchar('\n');
  
  return 0;
}
  
