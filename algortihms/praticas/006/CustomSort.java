// Exemplo de ordenacao customizada de pessoas
// Primeiro por ordem crescente da idade, e em caso de empate por
// ordem crescente alfabetica do nome
// ----------------------------------
// Pedro Ribeiro (DCC/FCUP) - 09/10/2016
// ----------------------------------

import java.io.*;
import java.util.*;
import java.lang.*;

// Classe para guardar um nome
class Team implements Comparable<Team> {
	public int points, goals;
	public String name;

	Team(String n, int a, int b) {
		name = n;
		points = a;
		goals = b;
	}
	@Override
	public int compareTo(Team p) {
		if (points < p.points) return -1;
		if (points > p.points) return +1;
		if (goals < p.goals) return -1;
		if (goals > p.goals) return 1;
		return -(name.compareToIgnoreCase(p.name));
	}

}

public class CustomSort {
	public static void main(String args[]) {
		Scanner stdin = new Scanner(System.in);

		int n = stdin.nextInt();	
		Team v[] = new Team[n]; 
		
		for (int i = 0; i<n; i++) {
			
			v[i] = new Team(stdin.next(),(3 * stdin.nextInt()) + stdin.nextInt() + (0*stdin.nextInt()),(stdin.nextInt() - stdin.nextInt()));
		}

	// Chamada ao sort padrao da linguagem Java
	// Usa o comparador padrao do tipo do array
		Arrays.sort(v);

		for (int i=n-1; i>-1; i--)
			System.out.println(v[i].name + " " + v[i].points + " " + v[i].goals);
	}
}

