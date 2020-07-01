#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

int main() {
  char x , y, op;
  int result;
  

  
  op= getchar();
  x= getchar();
  y= getchar();
  
  if ( (op!='+' && op!='*') || !islower(x) || !islower(y) ) {
    
    printf("%c%c%c=erro\n",op,x,y);

    return 0;
  }

  x= x - 'a';
  y= y - 'a';
  
  if (op == '+')
    result = x+y;
  else result =x*y;
  
  
  printf("%c%d%d=%d\n",op ,x ,y, result);
  return 0 ;
}
