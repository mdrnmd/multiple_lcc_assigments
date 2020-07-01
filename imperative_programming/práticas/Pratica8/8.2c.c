#include<stdio.h>
#include<string.h>
#include<ctype.h>
#define MAX 20

int quebra( char s[], char c, char esq[], char dir[]) {
  int i, j;
  for(i=0; s[i]!=c && s[i]!='\0'; i++); {
    if (s[i]=='\0')
      return -1; }
  for(j=0; j<i; j++)
    esq[j]=s[j];
  esq[j]='\0';
  for(j=0, i++; s[i]!='\0' ; j++, i++)
    dir[j] = s[i];
  dir[j] = '\0';
  return 0;
}

int main() {
  char seq[]= "esta frase!";
  char c=' ';
  char esq[MAX], dir[MAX] ;

  if(quebra(seq, c, esq, dir) !=-1)
    return 0;
}
