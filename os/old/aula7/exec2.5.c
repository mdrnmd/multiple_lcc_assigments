#include <stdio.h>
#include <signal.h>
#include <unistd.h>
#include <sys/types.h>

int ok=0;

void my_handler(int sig) {
  ok = 1;
}


int main() {
  signal(SIGUSR1, my_handler);
  
  pid_t p = fork();
  if (p == 0) { 
    printf("FILHO\n");
    kill(SIGUSR1, getppid());
  
  } else {
    while(ok==1);
    printf("PAI\n");
  }

}

