#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main () {
  int  i, x;
  srand((unsigned) time(NULL) );
  for (i=0; i<1000; i++) {
    x= 155 + rand( ) %56; 
      printf("%.2f\n",(float)x/100 ); 
    }
  
  return 0;
}
