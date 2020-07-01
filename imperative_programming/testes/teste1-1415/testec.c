#include <stdio.h>
int main () {
  float num=0 , max=0;
  int record=0;
  scanf("%f" ,&num);
  max=num;
  
  while (num != -1 ) {

    if (num > max) {
      max=num;
      record=record+1;
    }
        scanf("%f" ,&num); 
  }
  if ( record ==1 )
    printf ("%d vez\n" ,record);
  else
    printf ("%d vezes\n" ,record);
  return 0;
}

    
