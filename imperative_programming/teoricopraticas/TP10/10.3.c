#include <stdio.h>

struct ponto {
  int x, y;
} ;


int compara (struct ponto p, struct ponto q) {

  if (p.x < q.x)
    return -1;
  if (p.x == q.x) {
    if (p.y == q.y)
      return 0;
    if (p.y < q.y)
      return -1;
  }
  return 1;
}


int main () {

  int cmp;
  struct ponto a, b;

  char ops[] = "<=>" ;
  scanf("%d%d" ,&a.x , &a.y);
  scanf("%d%d" ,&b.x , &b.y);

  cmp= compara(a,b);

  printf("(%d,%d)" ,a.x,a.y);
  putchar(ops[cmp+1]);
  printf("(%d,%d)\n" ,b.x, b.y) ;
  
  
  return 0;
}
