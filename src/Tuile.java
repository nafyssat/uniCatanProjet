import java.util.*;

public class Tuile {
	private int nature; //entier qui va représenter la nature du terrain
						//0 = désert, 1 = forêt, 2 = collines, 3 = prés , 4 = champs et 5 = montagnes
	
	private int numero; //numero attribué afin de les associer au lancer de dés [2;12]

	public Tuile(int n, int num) {
		nature = n;
		numero = num;
	}

	public String getNature() {
		switch(this.nature) {
			case 0:
				return "Désert";
			case 1: 
				return "Forêt";
			case 2:
				return "Collines";
			case 3:
				return "Prés";
			case 4:
				return "Champs";
			case 5: 
				return "Montagnes";
			default:
				return "";
		}
	}

	public void estDesert() { //le désert ne produit rien donc il n'a pas de numéro associé
		if(this.nature == 0) this.numero = 0;
	}

	public int getNumero() {
		return this.numero;
	}

	public String toString() {
		String cap = (this.nature == 4 ? getNature().substring(0,2) : String.valueOf(this.getNature().charAt(0)));	
		return(cap + "(" + numero + ")");
	}
}