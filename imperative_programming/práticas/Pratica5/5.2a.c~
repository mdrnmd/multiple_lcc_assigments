#include<stdio.h>
#include<time.h>
#include<stdlib.h>

int main() {
  int random, guess;

  srand(time(NULL));
  random= rand()%100 +1;
  scanf("%d" ,&guess);
  while (guess != random) {
    if (guess > random)
      printf("O número em que pensei é menor que esse.\n");
    else 
      printf("O número que pensei é maior que esse.\n");
    scanf("%d" ,&guess);
  }
  printf("Acertou!\n");
  return 0;
}
