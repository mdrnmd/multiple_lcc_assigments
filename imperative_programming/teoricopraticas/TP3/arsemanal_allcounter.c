#include <stdio.h>
int main() {
  int ndias=0 , nmaus=0, dia, npessimos=0, nbons=0;
  while (ndias < 7) {
    scanf("%d" ,&dia);
    ndias++;
    if ((dia>35) && (dia<=60)) {
      nmaus++;
    }
    else if (dia<=35){
      nbons++;
    }
    else npessimos++;
    
  }
  printf ("Dias Maus %d\n" ,nmaus);
  printf ("Dias Pessimos %d\n" ,npessimos);
  printf ("Dias Bons %d\n" ,nbons);
  return 0;
}

    
