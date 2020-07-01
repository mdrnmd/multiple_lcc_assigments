#include <stdio.h>
int main() {
  int n1, n2, n3, n4;
  scanf(" %d %d %d %d" ,&n1 ,&n2 ,&n3 ,&n4);
  n1 = n1 + n3;
  n2 = n2 + n4;
  if (n1 >10)
	   n1 = n1 -10;
  if (n2 >10) {
	   n2 = n2-10;
	   n1 = n1+1; }
  printf("%d%d\n" ,n1 ,n2);
  return 0;
}
