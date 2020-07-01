#include <stdio.h>
int main() {
  int ndias=0 , nmaus=0, dia;
  while (ndias < 7) {
    scanf("%d" ,&dia);
    ndias++;
    if ((dia>35) && (dia<=60)) {
      nmaus++;
    }
  }
  printf ("%d\n" ,nmaus);
  return 0;
}

    
    
