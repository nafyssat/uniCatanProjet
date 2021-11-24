import java.util.*;

public class Plateau {
	private Tuile[][] cases; //par défaut, on choisira des cases de la forme 4x4 pour les tuiles
	String[][] tab_affichage;
	
	public Plateau() {	
		cases = new Tuile[4][4];
		tab_affichage = new String[9][9]; //l'astérisque désignera les sommets i.e. l'emplacement des colonies/villes

		String nbDesert = ""; //Ici on va limiter le plateau à 3 tuiles de Terrain Désert

		//----------------------REMPLISSAGE DU TABLEAU DE TUILES-----------------------------
		
		for(int i = 0; i < 4; i++) {
			
			LinkedList<Tuile> toRet = new LinkedList<Tuile>();

			while(toRet.size() < 4) {
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

		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				cases[i][j].estDesert(); //on vérifie si il y a des cases de terrain Désert
			}
		}

		//-----------------------REMPLISSAGE DU TABLEAU VISIBLE TEXTUELLEMENT-------------------

		String[][] tuile_aux = new String[9][9];
		
		/*tuile_aux[1][1] = cases[0][0].toString();
		tuile_aux[1][3] = cases[0][1].toString();
		tuile_aux[1][5] = cases[0][2].toString();
		tuile_aux[1][7] = cases[0][3].toString();

		tuile_aux[3][1] = cases[1][0].toString();
		tuile_aux[3][3] = cases[1][1].toString();
		tuile_aux[3][5] = cases[1][2].toString();
		tuile_aux[3][7] = cases[1][3].toString();

		[...]*/
		
		int incr = 1;

		for(int i = 1; i < 8; i+=2) {	
			for(int j = 1; j < 8; j+=2) {
				tuile_aux[i][j] = cases[i-incr][j/2].toString();
			}

			incr++;
		}

		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(i%2 == 0 && j%2 == 0) { //si on est sur une ligne et une colonne paire
					tab_affichage[i][j] = "*";
				} else if(i%2 == 1 && j%2 == 1) {
					tab_affichage[i][j] = tuile_aux[i][j];
				} else if(i%2 == 0 && j%2 == 1) {
					tab_affichage[i][j] = "---";
				} else {
					tab_affichage[i][j] = "|";
				}
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

		/*for(int i = 0; i < cases.length; i++) {
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

		System.out.println("\n" + "***************************************" + "\n");*/

		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.format("%-6s",tab_affichage[i][j]);
			}

			System.out.println("");
		}

	}

	public static void main(String[] args) {
		Plateau test = new Plateau();
		test.afficher();
	}
}	
