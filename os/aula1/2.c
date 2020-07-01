#include <stdio.h>

int main() {

  char c, *cptr;
  c = 'a';
  cptr = &c;
  printf("tamanho de um char: %lu\n", sizeof(c));
  printf("tamanho do endereço de um char: %lu\n", sizeof(&c));
  printf("tamanho de um apontador para um char: %lu\n", sizeof(cptr));
  printf("tamanho do conteúdo apontado por um apontador para um char: %lu\n", sizeof(*cptr));
  printf("Os valores apontados pelos endereços '%p' e '%p' são '%c' e '%c'\n\n", &c, cptr, c, *cptr);


  short s, *sptr;
  s = 120;
  sptr = &s;
  printf("tamanho de um short: %lu\n", sizeof(s));
  printf("tamanho do endereço de um short: %lu\n", sizeof(&s));
  printf("tamanho de um apontador para um short: %lu\n", sizeof(sptr));
  printf("tamanho do conteúdo apontado por um apontador para um short: %lu\n", sizeof(*sptr));
  printf("Os valores apontados pelos endereços '%p' e '%p' são '%hu' e '%hu'\n\n", &s, sptr, s, *sptr);

  int i, *iptr;
  i = 3000;
  iptr = &i;
  printf("tamanho de um int: %lu\n", sizeof(i));
  printf("tamanho do endereço de um int: %lu\n", sizeof(&i));
  printf("tamanho de um apontador para um int: %lu\n", sizeof(iptr));
  printf("tamanho do conteúdo apontado por um apontador para um int: %lu\n", sizeof(*iptr));
  printf("Os valores apontados pelos endereços '%p' e '%p' são '%d' e '%d'\n\n", &i, iptr, i, *iptr);


  long l, *lptr;
  l = 40111123;
  lptr = &l;
  printf("tamanho de um long: %lu\n", sizeof(l));
  printf("tamanho do endereço de um long: %lu\n", sizeof(&l));
  printf("tamanho de um apontador para um long: %lu\n", sizeof(lptr));
  printf("tamanho do conteúdo apontado por um apontador para um long: %lu\n", sizeof(*lptr));
  printf("Os valores apontados pelos endereços '%p' e '%p' são '%ld' e '%ld'\n\n", &l, lptr, l, *lptr);

  float f, *fptr;
  f = 40.24112312415;
  fptr = &f;
  printf("tamanho de um float: %lu\n", sizeof(f));
  printf("tamanho do endereço de um float: %lu\n", sizeof(&f));
  printf("tamanho de um apontador para um float: %lu\n", sizeof(fptr));
  printf("tamanho do conteúdo apontado por um apontador para um float: %lu\n", sizeof(*fptr));
  printf("Os valores apontados pelos endereços '%p' e '%p' são '%f' e '%f'\n\n", &f, fptr, f, *fptr);


  double d, *dptr;
  d = 40.241;
  dptr = &d;
  printf("tamanho de um double: %lu\n", sizeof(d));
  printf("tamanho do endereço de um double: %lu\n", sizeof(&d));
  printf("tamanho de um apontador para um double: %lu\n", sizeof(dptr));
  printf("tamanho do conteúdo apontado por um apontador para um double: %lu\n", sizeof(*dptr));
  printf("Os valores apontados pelos endereços '%p' e '%p' são '%g' e '%g'\n\n", &d, dptr, d, *dptr);
  
  return 0;
}
