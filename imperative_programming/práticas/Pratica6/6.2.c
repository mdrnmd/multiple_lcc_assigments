#include<stdio.h>
#include<ctype.h>

int main ()  {
  int alga=0, mais=0, minus=0;
  char let;
  
  
  scanf("%c" ,&let); 

  while (let!= '\n') {
    if ( isdigit(let))
      alga++;
    if(islower(let))
      minus++;
    if(isupper(let))
      mais++;
    scanf("%c" ,&let);
  }
  
  printf("%d números\n%d maiúsculas\n%d minúsculas\n" ,alga, mais, minus);
  return 0;
}
