#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <string.h>


void login();
void main_menu();
void balance();
void add_balance();
void stats();
void logout();
void shopping();
int checklogin(char *line);
float getbalance(char *username);
void checkout();
void add_item();
void print_inventory();
void print_user_inventory();
void remove_balance();

char user[50];
float account_balance=-1;
char user_shop_list[250];
char user_stats[250];

void clear() {

	system("clear");
	printf("--SUPERMERCADO CLIENTE--\n");
	printf("--User:%s\n--Saldo:%.2f€\n\n" ,user,account_balance);
}

void login() {
	system("clear");
	printf("///////////////////\n");
	printf("//   MENU LOGIN  //\n");
	printf("///////////////////\n\n");
	printf("Enter username:");
	char username[50];
	scanf("%s", username);
	char password[50];
	char *ptr;
	ptr = getpass("Enter password:");
	strcpy(password,ptr);

	char user_pass[100];
	strcpy(user_pass, username);
	strcat(user_pass, ";");
	strcat(user_pass, password);
	if(checklogin(user_pass)==0) {
		printf("\n\nLOGIN INVÀLIDO");
		fflush(stdout);
		sleep(2);
		login();
	}
	else if(checklogin(user_pass)==1) {
		strcpy(user, username);
		strcpy(user_shop_list, user);
		strcat(user_shop_list, "_list.txt");
		strcpy(user_stats, user);
		strcat(user_stats, "_stats.txt");
		account_balance = getbalance(user);
		main_menu();
	}
}

int checklogin(char *line) {
	FILE *fp;
	char temp[512];

	if((fp = fopen("database_passwords.txt", "r")) == NULL) {
		return(-1);
	}
	while(fgets(temp, 512, fp) != NULL) {
		if((strstr(temp, line)) != NULL) {
			fclose(fp);
			return 1;
		}
	}
	if(fp) {
		fclose(fp);
	}
	return 0;
}

float getbalance(char *username) {
	FILE *fp;
	char temp[512];
	char *user;
	char *temp2;
	float ammount;

	if((fp = fopen("database_balance.txt", "r")) == NULL) {
		return -1;
	}
	while(fgets(temp, 512, fp) != NULL) {
		user = strtok(temp, ";");
		if( strcmp(user,username)==0) {
			temp2 = strtok(NULL, "/n");
			ammount = atoi (temp2);
			if(fp) {
				fclose(fp);
			}
			return ammount;
		}
	}
	if(fp) {
		fclose(fp);
	}
	return -1;
}

void main_menu() {
	clear();
	printf("///////////////////\n");
	printf("//MENU  PRINCIPAL//\n");
	printf("///////////////////\n\n");
	printf("1) Lista de Compras\n");
	printf("2) Gerir Saldo\n");
	printf("3) Ver Estatísticas\n");
	printf("4) Logout\n");
	
	int opt=0;
	printf("\nAção:");
	scanf("%d" ,&opt);


	if(opt==1)
		shopping();
	else if(opt==2)
		balance();
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

void shopping() {

	clear();
	printf("///////////////////\n");
	printf("// MENU  COMPRAS //\n");
	printf("///////////////////\n\n");
	
	print_user_inventory();

	printf("\n1) Adicionar Item\n");
	printf("2) Checkout\n");
	printf("3) VOLTAR\n");
	
	int opt=0;
	printf("\nAção:");
	scanf("%d" ,&opt);
	
	if(opt==1) {
		add_item();
	}
	else if(opt==2) {
		checkout();
	}
	else if(opt==3) {
		main_menu();
	} 
	else {
		printf("\n\nOPÇÂO INVÀLIDA");
		fflush(stdout);
		sleep(2);
		shopping();
	}

}
void print_inventory() {

	FILE *fp;
	char temp[512];
	int id, qty;
	float price, retail_price;
	char name[25];


	fp = fopen("database_inventory.txt", "r");

	if(fp==NULL) {
		printf("\nInventário de Loja Vazio!\n");
		fflush(stdout);
		sleep(5);
		main_menu();
	}
	else if (NULL != fp) {
		fseek (fp, 0, SEEK_END);
		int size = ftell(fp);
		if (0 == size) {
			printf("\nInventário de Loja Vazio!\n");
			fflush(stdout);
			sleep(5);
			main_menu();
		}
	}
	rewind(fp);
	printf("   ID       NAME  PREÇO   QTD\n");
	while(fgets(temp, 512, fp) != NULL) {	
		id = atoi(strtok(temp, ";"));
		strcpy(name, strtok(NULL,";"));
		qty = atoi(strtok(NULL, ";"));
		price = atof(strtok(NULL, ";"));
		retail_price = atof(strtok(NULL, "\n"));
		printf("%5d %10s %5.2f %5d\n" ,id, name, retail_price, qty);
	}
	fclose(fp);
}

void print_user_inventory() {
	FILE *fp;
	char temp[512];
	int id, qty;
	float price, retail_price;
	char name[25];
	
	if( access(user_shop_list, F_OK ) != -1 ) {
		if(fopen(user_shop_list, "r")==NULL) {
			printf("Lista de Compras Vazia\n\n");
			fp = fopen(user_shop_list, "a");
			fclose(fp);
		}
		else {
			printf("Lista de Compras:\n");
			printf("   ID       NAME  PREÇO   QTD\n");;
			fp = fopen(user_shop_list, "r");
			while(fgets(temp, 512, fp) != NULL) {	
				id = atoi(strtok(temp, ";"));
				strcpy(name, strtok(NULL,";"));
				qty = atoi(strtok(NULL, ";"));
				price = atof(strtok(NULL, ";"));
				retail_price = atof(strtok(NULL, "\n"));
				printf("%5d %10s %5.2f %5d\n" ,id, name, retail_price, qty);
			}
			fclose(fp);
		}

	}
	else {
		printf("Lista de Compras Vazia\n\n");
		fp = fopen(user_shop_list ,"a");
		fclose(fp);
	}
}


void add_item() {
	clear();
	printf("///////////////////\n");
	printf("// MENU  COMPRAS //\n");
	printf("///////////////////\n\n");
	printf("Inventário:\n");

	print_inventory();

	int id=0, qty;
	printf("\nIndique o ID:");
	scanf("%d" ,&id);
	printf("Indique a quantidade:");
	scanf("%d" ,&qty);

	FILE *fp;
	FILE *fp2;
	char temp[512], temp_copy[512];
	char temp1[512];
	char item[512];

	fp = fopen("database_inventory.txt", "r");
	fp2 = fopen("database_invetory_copy.txt", "w");

	while(fgets(temp, 512, fp) != NULL) {
		strcpy(temp_copy,temp);
		strcpy(temp1,strtok(temp,";"));
		if(id == atoi(temp1))
			strcpy(item,temp_copy);
		else {
			fprintf(fp2, "%s", temp_copy);
		}
	}
	fclose(fp);
	fclose(fp2);

	remove("database_inventory.txt");
	rename( "database_invetory_copy.txt", "database_inventory.txt");


	int id2, qty2;
	float price, retail_price;
	char name[25];

	id2 = atoi(strtok(item, ";"));
	strcpy(name, strtok(NULL,";"));
	qty2 = atoi(strtok(NULL, ";"));
	price = atof(strtok(NULL, ";"));
	retail_price = atof(strtok(NULL, "\n"));

	if(qty > qty2) {
		system("clear");
		printf("QUANTIDADE EXCIDIDA!\n");
		fflush(stdout);
		sleep(2);

		fp = fopen("database_inventory.txt", "a");
		fprintf(fp,"%d;%s;%d;%.2f;%.2f;\n", id2, name, qty2, price, retail_price);
		fclose(fp);
		shopping();
	}
	else {
		int qty3;
		qty3 = qty2-qty;

		fp = fopen(user_shop_list, "a");
		fprintf(fp,"%d;%s;%d;%.2f;%.2f;\n", id2, name, qty, price, retail_price);
		fclose(fp);

		fp = fopen("database_inventory.txt", "a");
		fprintf(fp,"%d;%s;%d;%.2f;%.2f;\n", id2, name, qty3, price, retail_price);
		fclose(fp);

		shopping();
	}
}

void checkout() {
	float fullpaymment=0;

	int id, qty;
	float price, retail_price;
	char name[25];



	FILE *fp;
	FILE *fp2;
	FILE *fp3;
	char temp[512];

	fp = fopen(user_shop_list, "a+");

	if(fgets(temp, 512, fp) == NULL) {
		shopping();
	}
	else {
		id = atoi(strtok(temp, ";"));
		strcpy(name, strtok(NULL,";"));
		qty = atoi(strtok(NULL, ";"));
		price = atof(strtok(NULL, ";"));
		retail_price = atof(strtok(NULL, "\n"));
		fullpaymment = fullpaymment + (qty*retail_price);

		while(fgets(temp, 512, fp) != NULL) {
			id = atoi(strtok(temp, ";"));
			strcpy(name, strtok(NULL,";"));
			qty = atoi(strtok(NULL, ";"));
			price = atof(strtok(NULL, ";"));
			retail_price = atof(strtok(NULL, "\n"));
			fullpaymment = fullpaymment + (qty*retail_price);
		}
	}

	clear();
	fflush(stdout);
	printf("PREÇO TOTAL:%.2f€" ,fullpaymment);
	printf("\nDeseja Continuar?(s/n):");
	char c;
	scanf(" %c" ,&c);
	if(c == 's') {
		if(fullpaymment > account_balance) {

			printf("\nNÃO TEM DINHEIRO!\n");
			fflush(stdout);
			sleep(2);
			main_menu();
		}
		else  {
			fp = fopen(user_shop_list, "r");
			fp2 = fopen(user_stats, "a");
			fp3 = fopen("database_stats.txt" ,"a");

			while(fgets(temp, 512, fp) != NULL) {
				fprintf(fp2, "%s", temp);
				fprintf(fp3, "%s;%s",user,temp);
			}
			fclose(fp);
			fclose(fp2);
			fclose(fp3);
			remove(user_shop_list);
			account_balance = account_balance - fullpaymment;
			printf("COMPRA EFUTUADA COM SUCESSO!\n");
			fflush(stdout);
			sleep(2);
			main_menu();
		}
	}
	else shopping();
}

void balance() {
	if(account_balance == -1)  {
		printf("\n\nERRO NA CONTA");
		fflush(stdout);
		sleep(2);
		login();
	}
	clear();
	printf("///////////////////\n");
	printf("//  MENU  SALDO  //\n");
	printf("///////////////////\n\n");
	printf("Saldo Disponível: %.2f€\n\n" ,account_balance);
	printf("1) Adicionar Saldo\n");
	printf("2) Remover Saldo\n");
	printf("3) VOLTAR\n");

	int opt=0;
	printf("Ação:");
	scanf("%d" ,&opt);
	if(opt==1)
		add_balance();
	else if(opt==2) 
		remove_balance();
	else if(opt==3)
		main_menu();
	else {
		printf("\n\nOPÇÂO INVÀLIDA");
		fflush(stdout);
		sleep(2);
		balance();
	}
}

void add_balance() {
	clear();
	printf("///////////////////\n");
	printf("//  MENU  SALDO  //\n");
	printf("///////////////////\n\n");
	printf("Saldo Disponível: %.2f€\n\n" ,account_balance);
	printf("Quantia:");
	int amount;
	scanf("%d" ,&amount);
	account_balance = account_balance + amount;
	main_menu();
}

void remove_balance() {
	clear();
	printf("///////////////////\n");
	printf("//  MENU  SALDO  //\n");
	printf("///////////////////\n\n");
	printf("Saldo Disponível: %.2f€\n\n" ,account_balance);
	printf("Quantia:");
	int amount;
	scanf("%d" ,&amount);

	if (amount>account_balance) {
		account_balance=0;
		main_menu();
	}
	else {
		account_balance = account_balance - amount;
		main_menu();
	}
}

void logout() {
	FILE *fp;
	FILE *fp2;
	char temp[512], temp_copy[512],temp1[512];

	fp = fopen("database_balance.txt", "r");
	fp2 = fopen("database_balance_copy.txt", "w");

	while(fgets(temp, 512, fp) != NULL) {
		strcpy(temp_copy,temp);
		strcpy(temp1,strtok(temp,";"));
		if(strcmp(temp1,user)==0)
			fprintf(fp2, "%s;%.2f",user,account_balance);
		else {
			fprintf(fp2, "%s" ,temp_copy);
		}
	}
	fclose(fp);
	fclose(fp2);

	remove("database_balance.txt");
	rename( "database_balance_copy.txt", "database_balance.txt");
	system("clear");
	fflush(stdout);
	exit(0);
}	

void stats() {
	
	float totalmonney;
	int totalqty;
	float most_expensive=-1;
	float least_expensive=1000;

	int id, qty;
	float price, retail_price;
	char name[25];

	FILE *fp;
	char temp[512], temp_copy[512];

	fp = fopen(user_stats, "r");

	while(fgets(temp, 512, fp) != NULL) {
		id = atoi(strtok(temp, ";"));
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

	clear();
	printf("///////////////////\n");
	printf("/MENU ESTATÍSTICAS/\n");
	printf("///////////////////\n\n");

	printf("Total de dinheiro gasto:%.2f€\n" ,totalmonney);
	printf("Total de itens comprados:%d\n",totalqty);
	printf("Item mais caro:%.2f€\n" , most_expensive);
	printf("Item mais barato:%.2f€\n\n" , least_expensive);
	
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

int main() {
	login();
	return 0;
}
