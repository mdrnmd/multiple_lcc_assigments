#include <stdio.h>
#include <stdlib.h>
#include <readline/readline.h>
#include <readline/history.h>
#include <string.h>



#define MAXARGS 100
typedef struct command {
  char *cmd;              // string apenas com o comando
  int argc;               // número de argumentos
  char *argv[MAXARGS+1];  // vector de argumentos do comando
} COMMAND;

COMMAND parse(char *linha);
void print_parse(COMMAND com);

int main() {
  char *linha;
  COMMAND com;

  while (1) {
    if ((linha = readline("my_prompt$ ")) == NULL)
      exit(0);
    if (strlen(linha) != 0) {
      add_history(linha);
      com = parse(linha);
      print_parse(com);
    }
    free(linha);
  }
}

COMMAND parse(char *linha) {
  COMMAND command;

  int i=0;
  
  command.argv[i] = strtok(linha, " ");
  command.cmd = command.argv[i];
  while( command.argv[i] != NULL ) {
    i++;
    command.argv[i] = strtok(NULL, " ");  
  }
  command.argc = i;
  return command;
}

void print_parse(COMMAND com) {
  int i=0;
  printf("-----------------------------------------------------\n");
  printf("Number of Arguments: %d\n" ,com.argc);
  printf("Arguments: ");
  
  while (i < com.argc) {
    printf("%s,", com.argv[i]);
    i++;
  }
  printf("\n-----------------------------------------------------\n");
  if(strcmp(com.argv[0], "exit") == 0)
    exit(0);
  
}
