#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <string.h>


void main_menu();
void stock();
void user();
void stats();
void clear();
void logout();

void add_item();
void modify_item();
void delete_item();

void delete_user();
void add_user();

void main_menu() {
	clear();
	printf("///////////////////\n");
	printf("//MENU  PRINCIPAL//\n");
	printf("///////////////////\n\n");
	printf("1) Gerir Stocks\n");
	printf("2) Gerir Utilizadores\n");
	printf("3) Ver Estatísticas\n");
	printf("4) Logout\n");
	int opt;
	printf("\nAção:");
	scanf("%d" ,&opt);

	if(opt==1)
		stock();
	else if(opt==2)
		user();
	else if(opt==3)
		stats();
	else if(opt==4)
		logout();
	else {
		printf("\n\nOPÇÂO INVÀLIDA");
		fflush(stdout);
		sleep(2);
		main_menu();
	}
}

void stock() {
	clear();
	printf("///////////////////\n");
	printf("//MENU  INVETÀRIO//\n");
	printf("///////////////////\n\n");
	printf("1) Adicionar Novo Produto\n");
	printf("2) Apagar Produto Existente\n");
	printf("3) Modificar Produto Existente\n");
	printf("4) VOLTAR\n");

	int opt;
	printf("\nAção:");
	scanf("%d" ,&opt);

	if(opt==1)
		add_item();
	else if(opt==2)
		delete_item();
	else if(opt==3)
		modify_item();
	else if(opt==4)
		main_menu();
	else {
		printf("\n\nOPÇÂO INVÀLIDA");
		fflush(stdout);
		sleep(2);
		stock();
	}
}

void user() {
	clear();
	printf("///////////////////\n");
	printf("//MENU UTILIZADOR//\n");
	printf("///////////////////\n\n");
	printf("1) Adicionar Novo Utilizador\n");
	printf("2) Apagar Utilizador Existente\n");
	printf("3) VOLTAR\n");


	int opt;
	printf("\nAção:");
	scanf("%d" ,&opt);

	if(opt==1)
		add_user();
	else if(opt==2)
		delete_user();
	else if(opt==3)
		main_menu();
	else {
		printf("\n\nOPÇÂO INVÀLIDA");
		fflush(stdout);
		sleep(2);
		user();
	}

}

void stats() {
	clear();	

	float totalmonney;
	int totalqty;
	float most_expensive=-1;
	float least_expensive=1000;

	int id, qty;
	float price, retail_price;
	char name[25], user[50];

	FILE *fp;
	char temp[512], temp_copy[512];

	fp = fopen("database_stats.txt", "r");

	while(fgets(temp, 512, fp) != NULL) {
		strcpy(user, strtok(temp,";"));
		id = atoi(strtok(NULL, ";"));
		strcpy(name, strtok(NULL,";"));
		qty = atoi(strtok(NULL, ";"));
		price = atof(strtok(NULL, ";"));
		retail_price = atof(strtok(NULL, "\n"));
		totalmonney = totalmonney + (qty * retail_price);
		totalqty = totalqty + qty;
		if(retail_price > most_expensive) {
			most_expensive = retail_price;
		}
		if ( retail_price < least_expensive) {
			least_expensive = retail_price;
		}
	}
	fclose(fp);

	printf("///////////////////\n");
	printf("/MENU ESTATÍSTICAS/\n");
	printf("///////////////////\n\n");

	printf("Total de dinheiro gasto:%.2f€\n" ,totalmonney);
	printf("Total de itens comprados:%d\n\n",totalqty);
	printf("1) VOLTAR\n");
	int opt=0;
	printf("Ação:");
	scanf("%d" ,&opt);
	if(opt==1)
		main_menu();
	else {
		stats();
	}

}

void logout() {
	system("clear");
	exit(0);
}

void add_item() {
	int id, qty;
	float price, retail_price;
	char name[25];
	clear();
	printf("///////////////////\n");
	printf("//MENU INVENTÀRIO//\n");
	printf("///////////////////\n\n");

	printf("ID:");
	scanf("%d" ,&id);
	printf("Descrição:");
	scanf("%s" ,name);
	printf("Quantidade:");
	scanf("%d" ,&qty);
	printf("Custo:");
	scanf("%f" , &price);
	printf("Preço:");
	scanf("%f" ,&retail_price);

	FILE *fp;

	fp = fopen("database_inventory.txt", "a");
	fprintf(fp,"%d;%s;%d;%.2f;%.2f;\n", id, name, qty, price, retail_price);
	fclose(fp);

	printf("\n\nPRODUTO ADICIONADO COM SUCESSO!\n");
	fflush(stdout);
	sleep(2);
	main_menu();

}

void modify_item() {
	FILE *fp;
	FILE *fp2;
	int delete_id;
	char temp[512], temp_copy[512];
	int id, qty;
	float price, retail_price;
	char name[25];

	clear();
	printf("///////////////////\n");
	printf("//MENU INVENTÀRIO//\n");
	printf("///////////////////\n\n");
	printf("ID a ser modificado:");
	scanf("%d" ,&id);

	fp = fopen("database_inventory.txt", "r");
	fp2 = fopen("database_inventory_copy.txt", "w");

	while(fgets(temp, 512, fp) != NULL) {
		strcpy(temp_copy,temp);
		delete_id = atoi(strtok(temp, ";"));
		if (delete_id != id) 	
			fprintf(fp2, "%s", temp_copy);
	}
	fclose(fp);
	fclose(fp2);
	remove("database_inventory.txt");
	rename("database_inventory_copy.txt", "database_inventory.txt");

	printf("Descrição:");
	scanf("%s" ,name);
	printf("Quantidade:");
	scanf("%d" ,&qty);
	printf("Custo:");
	scanf("%f" , &price);
	printf("Preço:");
	scanf("%f" ,&retail_price);

	fp = fopen("database_inventory.txt", "a");
	fprintf(fp,"%d;%s;%d;%.2f;%.2f;\n", id, name, qty, price, retail_price);
	fclose(fp);
	printf("\n\nPRODUTO MODIFICADO COM SUCESSO\n");
	fflush(stdout);
	sleep(2);
	main_menu();

}

void delete_item() {
	FILE *fp;
	FILE *fp2;
	int delete_id=0;
	char temp[512], temp_copy[512];
	int id=0;

	clear();
	printf("///////////////////\n");
	printf("//MENU INVENTÁRIO//\n");
	printf("///////////////////\n\n");
	printf("ID a ser apagado:");
	scanf("%d" ,&id);



	fp = fopen("database_inventory.txt", "r");
	fp2 = fopen("database_inventory_copy.txt", "w");

	while(fgets(temp, 512, fp) != NULL) {
		strcpy(temp_copy,temp);
		delete_id = atoi(strtok(temp, ";"));
		if (delete_id != id) 	
			fprintf(fp2, "%s", temp_copy);

	}
	fclose(fp);
	fclose(fp2);

	remove("database_inventory.txt");
	rename( "database_inventory_copy.txt", "database_inventory.txt" );

	printf("\n\nPRODUTO APAGADO COM SUCESSO!\n");
	fflush(stdout);
	sleep(2);
	main_menu();

}

void delete_user() {
	FILE *fp;
	FILE *fp2;
	char name[50];
	char temp[512], temp_copy[512];
	char temp1[50];

	clear();
	printf("///////////////////\n");
	printf("//MENU UTILIZADOR//\n");
	printf("///////////////////\n\n");
	printf("Utilizador a ser apagado:");
	scanf("%s" ,name);

	fp = fopen("database_passwords.txt", "r");
	fp2 = fopen("database_passwords_copy.txt", "w");

	while(fgets(temp, 512, fp) != NULL) {
		strcpy(temp_copy,temp);
		strcpy(temp1,strtok(temp,";"));
		if(strcmp(name,temp1)!=0)
			fprintf(fp2, "%s", temp_copy);
	}
	fclose(fp);
	fclose(fp2);
	
	remove("database_passwords.txt");
	rename( "database_passwords_copy.txt", "database_passwords.txt");

	fp = fopen("database_balance.txt", "r");
	fp2 = fopen("database_balance_copy.txt", "w");

	while(fgets(temp, 512, fp) != NULL) {
		strcpy(temp_copy,temp);
		strcpy(temp1,strtok(temp,";"));
		if(strcmp(name,temp1)!=0)
			fprintf(fp2, "%s", temp_copy);
	}
	fclose(fp);
	fclose(fp2);
	
	remove("database_balance.txt");
	rename( "database_balance_copy.txt", "database_balance.txt");

	printf("\n\nUTILIZADOR APAGADO COM SUCESSO!\n");
	fflush(stdout);
	sleep(2);
	main_menu();

}
void add_user() {
	clear();
	printf("///////////////////\n");
	printf("//MENU UTILIZADOR//\n");
	printf("///////////////////\n\n");

	char name[200];
	int num;
	char username[50];
	char password[50];

	printf("Nome:");
	scanf(" %s" ,name);
	printf("Contato:");
	scanf("%d" ,&num);
	printf("Username:");
	scanf("%s" ,username);
	printf("password:");
	scanf("%s" ,password);

	FILE *fp;

	fp = fopen("database_passwords.txt", "a");
	fprintf(fp,"%s;%s\n", username, password);
	fclose(fp);

	fp = fopen("database_balance.txt", "a");
	fprintf(fp,"%s;0\n", username);
	fclose(fp);

	printf("\n\nUTILIZADOR ADICIONADO COM SUCESSO!\n");
	fflush(stdout);
	sleep(2);
	main_menu();
}

void clear() {
	system("clear");
	printf("--SUPERMERCADO SERVIDOR--\n\n");
}


int main() {
	main_menu();
}
