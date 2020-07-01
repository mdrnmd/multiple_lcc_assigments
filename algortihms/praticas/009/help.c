#include <stdio.h>
#include <stdlib.h>
#define MAX 1000

int c=0;

int compare_int(const void *pa, const void *pb) {x
  int a = *(const int *)pa;
  int b = *(const int *)pb;
  if (a < b) return -1;
  if (a > b) return +1;
  return 0;
}

void check(int m, int lastNum, int startIndex, int v[][2], int n){
  if (lastNum >= m) printf("%d\n", c);
  else{
    int i,max=0;
    for (i=startIndex;v[i][0]<=lastNum;i++){
      if (v[i][0] <= lastNum)
        if (v[i][1] > max) max = v[i][1];
    }
    c++;
    check(m, max, i,v, n);
  }
}

int main(){
  int m,n,i;
  int line[MAX][2];
  scanf("%d", &m);
  scanf("%d", &n);
  for (i=0;i<n;i++){
    scanf("%d %d", &line[i][0], &line [i][1]);
  }
  qsort(line, n, sizeof line[0], compare_int);
  check(m, 0, 0, line, n);
  return 0;
}