import java.util.*;

public class Plateau {
	private Tuile[][] cases; //par défaut, on choisira des cases de la forme 4x4
	
	public Plateau(int n) {	
		cases = new Tuile[n][n];

		String nbDesert = ""; //Ici on va limiter le plateau à 3 tuiles de Terrain Désert

		for(int i = 0; i < n; i++) {
			
			LinkedList<Tuile> toRet = new LinkedList<Tuile>();

			while(toRet.size() < n) {
				Random r = new Random();
				int num = r.nextInt(11) + 2;

				if(!nbDesert.endsWith("DDD")) {
					int nat = r.nextInt(6);
					toRet.add(new Tuile(nat,num));
					nbDesert += "D";
				} else {
					int nat = r.nextInt(5) + 1;
					toRet.add(new Tuile(nat,num));
				}	
			}

			Tuile[] array = toRet.toArray(new Tuile[toRet.size()]);
			cases[i] = array;
		}

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				cases[i][j].estDesert(); //on vérifie si il y a des cases de terrain Désert
			}
		}
	}

	public void afficher() {
		System.out.format("|-----------------------TERRAINS---------------------|%n");
		System.out.format("+----------------------------------------------------+%n");
		System.out.format("|----------(D)ésert * (F)orêt * (C)ollines-----------|%n");
		System.out.format("|----------(P)rés * (Ch)amps * (M)ontagnes-----------|%n");
		System.out.format("+----------------------------------------------------+%n");
		System.out.println("");

		for(int i = 0; i < cases.length; i++) {
			for(int j = 0; j < cases.length; j++) {
				if(j == cases.length - 1) {
					String r = "| " + cases[i][j] + " |";
					System.out.format("%-10s",r);
				} else {
					String r = "| " + cases[i][j] + " ";
					System.out.format("%-9s",r);
				}		
			}

			System.out.println("");
		}
	}

	public static void main(String[] args) {
		Plateau test = new Plateau(5);
		test.afficher();
	}
}	
