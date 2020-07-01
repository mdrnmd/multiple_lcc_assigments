#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <signal.h>

int main(int argc, char *argv[]) {

  int n = atoi(argv[1]);
  printf("%d\n" ,n);
  
  if(n < 0) {
    printf("Number of processes negative\n");
    exit(0);
  }
  else {
    for(int i=0; i < n; i++) {
      pid_t pid = fork();
      if(pid == 0) {	
	printf("PID:%d PPID:%d\n" ,getpid(), getppid());
	exit(0);
      }
    }
  }
  exit(200);
}
