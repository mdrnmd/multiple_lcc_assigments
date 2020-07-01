#include <stdio.h>

int main()  {

  int x[3] = { 23, 41, 17};

  printf("1-%d\n" ,  x[0]   );
  printf("2-%d\n" ,  x[1]    );
  printf("3-%d\n" ,  x[2]    );
  printf("4-%p\n" ,  x    );
  printf("5-%d\n" ,  *x    );
  printf("6-%p\n" ,  x+1    );
  printf("7-%d\n" ,  *(x+1)    );
  printf("8-%p\n" ,  x+2    );
  printf("9-%d\n" ,  *(x+2)    );
  printf("10-%p\n" ,       &(x[0])   );
  printf("11-%d\n" ,    *&(x[0])  );
  //printf("%p\n" ,      &*(x[0])    );

  return 0;
}
