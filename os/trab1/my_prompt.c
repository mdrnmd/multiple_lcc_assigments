/////////////////////////////////////////////////////////
//                                                     //
//               Trabalho I: Mini-Shell                //
//                                                     //
// Compilação: gcc my_prompt.c -lreadline -o my_prompt //
// Utilização: ./my_prompt                             //
//                                                     //
/////////////////////////////////////////////////////////

#include <stdio.h>
#include <stdlib.h>
#include <readline/readline.h>
#include <readline/history.h>
#include <string.h>
#include <unistd.h>
#include <ctype.h>
#include <fcntl.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <assert.h>

#define MAXARGS 100
#define PIPE_READ 0
#define PIPE_WRITE 1

typedef struct command {
    char *cmd;              // string apenas com o comando
    int argc;               // número de argumentos
    char *argv[MAXARGS+1];  // vector de argumentos do comando
    struct command *next;   // apontador para o próximo comando
} COMMAND;

// variáveis globais
char* inputfile = NULL;	    // nome de ficheiro (em caso de redireccionamento da entrada padrão)
char* outputfile = NULL;    // nome de ficheiro (em caso de redireccionamento da saída padrão)
int background_exec = 0;    // indicação de execução concorrente com a mini-shell (0/1)

// declaração de funções
COMMAND* parse(char *);
void print_parse(COMMAND *);
void execute_commands(COMMAND *);
void free_commlist(COMMAND *);

// include do código do parser da linha de comandos
#include "parser.c"

int main(int argc, char* argv[]) {
  char *linha;
  COMMAND *com;
  pid_t pid;

  while (1) {
    if ((linha = readline("my_prompt$ ")) == NULL)
      exit(0);
    if (strlen(linha) != 0) {
      add_history(linha);
      com = parse(linha);
      if (com) {
	print_parse(com);
	execute_commands(com);
	free_commlist(com);
      }
    }
    free(linha);
  }
}


void print_parse(COMMAND* commlist) {
  int n, i;

  printf("---------------------------------------------------------\n");
  printf("BG: %d IN: %s OUT: %s\n", background_exec, inputfile, outputfile);
  n = 1;
  while (commlist != NULL) {
    printf("#%d: cmd '%s' argc '%d' argv[] '", n, commlist->cmd, commlist->argc);
    i = 0;
    while (commlist->argv[i] != NULL) {
      printf("%s,", commlist->argv[i]);
      i++;
    }
    printf("%s'\n", commlist->argv[i]);
    commlist = commlist->next;
    n++;
  }
  printf("---------------------------------------------------------\n");
}


void free_commlist(COMMAND *commlist){ //Libertar memória alocada
  COMMAND *temp = NULL;                //para a lista de comandos
  while(commlist){
    temp = commlist->next;
    free(commlist);
    commlist = temp;
  }  
}

void execute_commands(COMMAND *commlist) {
  COMMAND *current_comm = commlist;
  pid_t pid;
  int in,out,fd[2],fd_prev[2];
  while(current_comm != NULL){
    if(pipe(fd) < 0){
      printf("Error creating pipe\n");
    }
    if((pid = fork())<0)
      printf("error creating fork\n");
    else if(pid == 0){
      if(inputfile != NULL && (current_comm == commlist)){
	//printf("There is an input file\n");
	if((in = open(inputfile, O_RDONLY))<0){
	  printf("Error opening input file\n");
	  exit(1);
	}
	dup2(in,STDIN_FILENO);
      }
      if(outputfile != NULL && (current_comm->next == NULL)){
	//printf("There is an output file\n");
	if((out = open(outputfile, O_WRONLY | O_CREAT | O_TRUNC, S_IRWXU))<0){
	  printf("Error opening output file\n");
	  exit(1);
	}
	dup2(out,STDOUT_FILENO);
      }
      if(current_comm != commlist){
	//printf("%s read from prev\n",current_comm->cmd);
	dup2(fd_prev[PIPE_READ],STDIN_FILENO);
      }
      if(current_comm->next != NULL){
	//printf("%s writes to pipe\n",current_comm->cmd);
	dup2(fd[PIPE_WRITE],STDOUT_FILENO);
	close(fd[PIPE_WRITE]);
      }
      if(execvp(current_comm->cmd,current_comm->argv)<0){
	printf("command failed\n");
	exit(1);
      }
      close(in);
      exit(0);
    }
    else {
      wait(NULL);
      if(pipe(fd_prev) < 0)
	printf("Error creating previous pipe\n");
      else {
	fd_prev[PIPE_READ] = fd[PIPE_READ];
	fd_prev[PIPE_WRITE] = fd[PIPE_WRITE];
      }
      close(fd_prev[PIPE_WRITE]);
      current_comm=current_comm->next;
    }
  }
} 


