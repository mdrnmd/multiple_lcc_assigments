#include <stdio.h>
int main() {
  int num=0 , max=0  , ant=0 , consec=0 ;
  scanf("%d" ,&num );
  ant= num;
  while (num!= -1 ) {
    scanf("%d" ,&num);
    if ( (num == 3) && ( ant == 3) )
      consec++; 
    if ( (consec > 1) && (consec > max) )
      max = consec;
    if ( (ant ==  3) && (num!=3) && (consec!=0) ) {
      printf("%d " ,consec );
      consec=1; }
    ant = num;
  }
  
  printf("(max %d)\n" ,max) ;
  return 0;
}

