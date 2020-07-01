#include <stdio.h>
int main() {
  int air ;
  scanf("%d" ,&air);
  if (air < 35)
    printf("Boa\n");
  else if (air <=60)
    printf("Ma\n");
  else printf ("Pessima\n");
  return 0;
}
