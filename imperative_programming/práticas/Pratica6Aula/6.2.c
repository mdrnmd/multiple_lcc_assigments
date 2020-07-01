#include <stdio.h>
#include <ctype.h>
int main () {
  char c;
  int letras=0, digits=0, total=0;
  while ((c=getchar())!='\n') {
    if (isdigit(c))
      digits++;
    else if (isalpha(c) )
      letras++ ;
    total ++; }
  if (total!=0)
    printf("Letras %.2f\nDigitos %.2f\n",(float)letras/total, (float)digits/total);

  return 0;
}
