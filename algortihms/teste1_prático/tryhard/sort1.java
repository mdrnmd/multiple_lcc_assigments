import java.io.*;
import java.util.*;

// Classe para guardar um nome
class Team implements Comparable<Team> {
	public int points, goal_average;
	public String name;

	Team( String n, int a, int b) {
		points = a;
		name = n;
		goal_average = b;
	}

    // Definir como comparar dois elementos da classe Team
    // compareTo e uma funcao que compara objecto com outro objecto "p"
    // Esta funcao deve devolver:
    //  - numero < 0 se objecto for menor que objecto "p"
    //  - numero > 0 se objecto for maior que objecto "p"
    //  - zero, se objecto for igual ao objecto "p"
	@Override
	public int compareTo(Team p) {
		if (points < p.points) return 1;
		if (points > p.points) return -1;
		if(goal_average < p.goal_average) return 1;
		if(goal_average > p.goal_average) return -1;
		return name.compareTo(p.name);
	}
}

public class sort1 {
	public static void main(String args[]) {
		Scanner stdin = new Scanner(System.in);

		int n    = stdin.nextInt();	
		Team v[] = new Team[n]; 
		for (int i = 0; i<n; i++)
			v[i] = new Team(stdin.next(), 3 * stdin.nextInt() + stdin.nextInt() + 0*stdin.nextInt(),
				stdin.nextInt() - stdin.nextInt());

	// Chamada ao sort padrao da linguagem Java
	// Usa o comparador padrao do tipo do array
		Arrays.sort(v);

		for (int i = 0; i<n; i++)
			System.out.println(v[i].name + " " + v[i].points + " " + v[i].goal_average);
	}
}