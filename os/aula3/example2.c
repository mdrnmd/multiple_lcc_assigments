#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
q#include <sys/types.h>
#include <signal.h>

int main(int argc, char *argv[]) {

  int n = atoi(argv[1]);
  printf("Number of processes:%d\n" ,n);
  
  if(n < 0) {
    printf("Number of processes negative\n");
    exit(0);
  }
  else {
    pid_t pid = fork();

    if(pid == 0) {
      for(int i=0; i < n; i++) {
	printf("PID:%d PPID:%d\n" ,getpid(), getppid());
	exit(0);
	pid = fork();
      }
    }
    else (exit(50));
  }
  
  return 0;
}
