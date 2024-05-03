package game;

import java.util.ArrayList;
import java.util.List;

import model.Enemy;
import model.Joueur;
import model.Personnage;
public class Game {

	String[][] carte = new String[10][10];
	Personnage link = new Joueur(5, 5, "L", 3);
	ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	//arrayList<> 
	//add 3 enemies à enemyList
	//afficher le contenu de l'ALE dans notre carte
	
	public void launch() {
		createEnemies();
		createTab();
		addEnemieOnMap();
		updateTabWithPerso(link);
		printTab();
	}
	
	private void addEnemieOnMap() {
		for (Enemy e : enemyList) {
			updateTabWithPerso(e);
		}
	}

	private void createEnemies() {
		enemyList.add(new Enemy(2, 2, "E"));
		enemyList.add(new Enemy(3, 3, "E"));
		enemyList.add(new Enemy(7, 7, "E"));
	}

	private void updateTabWithPerso(Personnage perso) {
		carte[perso.getX()][perso.getY()] = perso.getSprite();
	}

	private void createTab() {
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
	}

	//methode pour afficher la carte
	public void printTab() {
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