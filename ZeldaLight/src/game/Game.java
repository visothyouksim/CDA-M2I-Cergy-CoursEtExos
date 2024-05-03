package game;

import model.Joueur;
import model.Personnage;
public class Game {

	String[][] carte = new String[10][10];
	Personnage link = new Joueur(5, 5, "L", 3);
	//arrayList<> 
	//add 3 enemies à l'ALE
	//afficher le contenu de l'ALE dans notre carte
	
	public void launch() {
		carte = createTab(carte);
		carte = updateTabWithPerso(carte, link);
		printTab(carte);
	}
	
	private String[][] updateTabWithPerso(String[][] carte, Personnage perso) {
		carte[perso.getX()][perso.getY()] = perso.getSprite();
		return carte;
	}

	private String[][] createTab(String[][] carte) {
		for(int i = 0; i<carte.length; i++) {
			for(int j = 0; j<carte[i].length; j++) {
				if(i==0||i==carte.length-1|| j==0|| j==carte[i].length-1) {
					carte[i][j]= "M";
				}
				else {
					carte[i][j]= " ";
				}
			}
		}
		return carte;
	}

	//methode pour afficher la carte
	public void printTab(String[][] carte) {
		for(int i = 0; i<carte.length; i++) {
			for(int j = 0; j<carte[i].length; j++) {
				System.out.print(carte[i][j] + " ");
			}
			System.out.println();
		}
	}
}
/*
MMMMMMMMMM
M        M
M        M
M        M
M        M
M        M
M        M
M        M
M        M
MMMMMMMMMM
*/