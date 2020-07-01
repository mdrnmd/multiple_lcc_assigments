#include<stdio.h>

int main() {
  int x[6], i, num1;
  for (i=0; i<6; i++) {
    scanf("%d" ,&x[i]);
   
  }
   putchar('\n');
  scanf("%d" , &num1);
  printf("%d " ,x[num1]);
  putchar('\n');
   return 0;
}
