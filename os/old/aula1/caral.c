#include <stdio.h>

int main() {

  int i=5;
  int *p=&i;

   p++;

  printf(" i=%d\n p=%p\n *p=%d\n" ,i ,p, *p);

  return 0;
}
  
