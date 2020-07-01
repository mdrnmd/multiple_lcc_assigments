import java.util.*;
import java.io.*;

public class labirinto {
	static final int CIMA = 1;
	static final int BAIXO = 0;
	static int l;
	static int c;
    static boolean visited[][][];  // Que nos ja foram visitados?
    static char matriz[][];  // para ter acesso à minha matriz nas diferentes funções do meu programa
    static int encontrado; // para contar as componentes ligadas (caminho) do meu grafo/matriz
    static int contador; //para contar o nº de nós
    static int maximo;

    static void dfs(int y, int x, int lado, int ipai, int jpai, int side) {

    	if(x<c && x>=0 && y<l && y>=0 && !visited[y][x][lado]){
    		contador++;
    		System.out.println(contador);
    		if (lado == BAIXO){
    			visited[y][x][BAIXO] = true;
    			System.out.println("estou em baixo");
    			dfs(y+1, x, CIMA, ipai, jpai, side);

    			if(matriz[y][x] == '/'){
    				if((x+1)<c && (x+1)>=0 && y<l && y>=0 && matriz[y][x+1] == '/')
            dfs(y, x+1, CIMA, ipai, jpai, side);  //dependendo da barra  seguinte vou parar em CIMA ou em BAIXO
        if((x+1)<c && (x+1)>=0 && y<l && y>=0 && matriz[y][x+1] == '\\')
        	dfs(y, x+1, BAIXO, ipai, jpai, side);
    }
    if(matriz[y][x] == '\\'){
    	if((x-1)<c && (x-1)>=0 && y<l && y>=0 && matriz[y][x-1] == '/')
            dfs(y, x-1, BAIXO, ipai, jpai, side);  //dependendo da barra  seguinte vou parar em CIMA ou em BAIXO
        if((x-1)<c && (x-1)>=0 && y<l && y>=0 && matriz[y][x-1] == '\\')
        	dfs(y, x-1, CIMA, ipai, jpai, side);
    }
}
if(lado == CIMA){
	visited[y][x][CIMA] = true;
	System.out.println("estou em cima");
	dfs(y-1, x, BAIXO, ipai, jpai, side);

	if(matriz[y][x] == '/'){
		if((x-1)<c && (x-1)>=0 && y<l && y>=0 && matriz[y][x-1] == '/')
            dfs(y, x-1, BAIXO, ipai, jpai, side);  //dependendo da barra  seguinte vou parar em CIMA ou em BAIXO, como vejo o seguinte???
        if( (x-1)<c && (x-1)>=0 && y<l && y>=0 && matriz[y][x-1] == '\\')
        	dfs(y, x-1, CIMA, ipai, jpai, side);
    }
    if(matriz[y][x] == '\\'){
    	if((x+1)<c && (x+1)>=0 && y<l && y>=0 && matriz[y][x+1] == '/')
            dfs(y, x+1, CIMA, ipai, jpai, side);  //dependendo da barra  seguinte vou parar em CIMA ou em BAIXO, como vejo o seguinte???
        if((x+1)<c && (x+1)>=0 && y<l && y>=0 && matriz[y][x+1] == '\\')
        	dfs(y, x+1, BAIXO, ipai, jpai, side);
    }
}
}
    if(x<c && x>=0 && y<l && y>=0 && visited[y][x][lado] && contador>2){ //cheguei a um que já foi visitado
    	System.out.println("Entrei");
        if(x==jpai && y==ipai && lado==side){ //vou vêr se é o que deu origem a dfs ("pai") // esta condição não é verificada, como posso verificar se o no onde me encontro é o no pai??
        encontrado++;
        System.out.println("papá!!!");
        if (contador > maximo){
            maximo = contador; //contei os nos do meu ciclo, comparo com o maximo e atualizo
        }
    }
}
}

public static void main(String args[]) {
	Scanner stdin = new Scanner(System.in);

	c = stdin.nextInt();
	l = stdin.nextInt();
	int lado = 2;
	matriz  = new char [l][c];
	visited = new boolean [l][c][lado];

	for(int k=0; k<l; k++){
		matriz[k] = stdin.next().toCharArray();
        //System.out.println(matriz[i]);
	}

	for(int k=0; k<l; k++){
		for(int m=0; m<c; m++){
			visited[k][m][CIMA] = false;
			visited[k][m][BAIXO] = false;
		}
	}

	encontrado = 0;

	for (int i=0; i<l; i++){
		for (int j=0; j<c; j++){
			if (!visited[i][j][BAIXO]) {
				contador = 0;
				dfs(i, j, BAIXO, i, j, BAIXO);
			}
			if(!visited[i][j][CIMA]){
				contador = 0;
				dfs(i, j, CIMA, i, j, CIMA);
			}
		}
	}

    if(encontrado==0) //não encontrou nenhum ciclo
    System.out.println("nao tem ciclos");
    else
        System.out.println(encontrado + " "+ maximo); // encontrou x ciclos, o ciclo maior tem y nos
}
}