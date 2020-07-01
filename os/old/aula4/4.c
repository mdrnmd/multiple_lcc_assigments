#include <stdio.h>
#include <unistd.h>

#define MAXLINE 200
int main () {

  int n, fd[2]; pid_t pid;
  char buf[MAXLINE];
  
  if (pipe(fd) < 0) {
    /* pipe pipe error */
  }

  if ((pid = fork()) < 0) {
    /* fork error */
  }

  else if (pid > 0) {
    // parent writes to the pipe
    close(fd[0]);
    write(fd[1],"hello world\n", 12);
  }
  else { // child reads from the pipe
    close(fd[1]);
    n = read(fd[0], buf, MAXLINE);
    write(STDOUT_FILENO, buf, n);
  }
}
