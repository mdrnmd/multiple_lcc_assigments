#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int main() {

  pid_t pid;
  pid = fork();
  
  if(pid < 0) {
    /*fork failed */
  }
  else if (pid == 0) {
    printf("PID:%d PPID:%d UID:%d\n" ,getpid(), getppid(), getuid());
     exit(1);
  }
  else {
     printf("PID:%d PPID:%d UID:%d\n" ,getpid(), getppid(), getuid());
  }
  return 0;
}
