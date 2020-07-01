-----------------------------------------------------------
	Autores:

- Helder Bessa		up201503035@fc.up.pt	201503035
- Rafael Novais		up201508010@fc.up.pt	201508010

-----------------------------------------------------------
	Ficheiros:
-SUPClient.c		
-SUPServer.c
-README.txt
-Client
-Server	
	
-----------------------------------------------------------
	Requisitos do sistema:
-Compilador C
-Terminal

	Testado em:
OS: Ubuntu 17.04 zesty
Kernel: x86_64 Linux 4.10.0-20-generic
Shell: bash 4.4.5

-----------------------------------------------------------
	Instruções de uso:

0) Como abrir programas


0.1) Compilar o servidor utilizando o comando:
	gcc SUPServer.c -W -o Server
0.2) Compilar o cliente utilizando o comando:
	gcc SUPClient.c -W -o Client
0.3) Executar o servidor utilizando o comando:
	./Server
0.4) Executar o cliente noutro terminal utilizando o comando:
	./Client


1) Adicionando utilizadores


1.1) Adicione utilizadores ao servidor no menu "Gerir Utilizadores".
1.2) Seguir menu "Adicionar Novo Utilizador".
1.3) Será pedido Nome, Contacto, username e password.
1.4) Para apagar um utilizador, selecione "Apagar Utilziador"
e insira o id a ser apagado.

BUGS: Whitespace no nome.


2) Adicionando items ao inventário

2.1) Seguir menu "Gerir Stocks" para gerir o stock de itens
2.2) Adicione alguns itens no menu "Adicionar Novo Produto"
2.3) Será pedido ID, Descrição, Quantidade, Custo e Preço
	Custo e Preço são float na forma 5.20(5 euros e 20 centimos).
2.4) Para apagar ou modificiar algum item do invetário deve conhecer o seu id.


3) Fazendo compras

Depois de já ter uma conta e produtos na base de dados, vamos agora
proceder a utilização do cliente.

3.1) Fazer login com utilizador e password criadas
3.2) Começar por adicionar algum saldo à sua conta no "Gerir Saldo"
3.3) No menu principal, seguir Lista de Compras
3.4) Selecionar menu "Adicionar Item"
3.5) Quanto já tiver todos os itens, seguir checkout e confirmar
3.6) Todos os produtos comprados ficam numa base de dados texto com o nome do user
 

-----------------------------------------------------------
	Dicas(opcional)

- Deverá usar o logout para que o saldo atualize na base de dados do supermercado.
- Poderá sair do menu de compras e voltar a qualquer momento, o seu carrinho será guardado.
- No menu Estatísticas tanto no Cliente como no Servidor poderá as estatitísticas.
- Adicionalmente o programa Servidor cria 4 ficheiros:
	database_passwords.txt 	Lista de passwords e users.
	database_balance.txt	Lista de users e saldos.
	database_inventory.txt	Lista de itens no supermercado.
	database_stats.txt
-Por cada utilizador é ainda criado 2 ficheiros:
	[user]_list.txt 	Lista de compras.
	[user]_stats.txt 	Lista de compras já feitas.









