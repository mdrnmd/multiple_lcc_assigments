#include <stdio.h>
#include <signal.h>
#include <unistd.h>
#include <sys/types.h>

void my_handler(int sig) {
  if (sig == SIGTSTP) {
    printf("Recebemos um sinal de CTRL-Z\n");
  }
  else if (sig == SIGINT) {
    printf("Recebemos um sinal de CTRL-C\n");
  }
  else if (sig == SIGTERM)  {
    printf("Voce tentou matar seu programa com o kill\n");
  }
}

int main() {
  printf("PID %d\n" ,getpid());
  signal(SIGTSTP, my_handler);
  signal(SIGINT, my_handler);
  signal(SIGTERM, my_handler);

  while(1)
    pause();

  return 0;
}
