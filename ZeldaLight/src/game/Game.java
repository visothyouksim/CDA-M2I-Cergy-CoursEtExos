package game;

import java.util.ArrayList;
import java.util.Scanner;

import model.Element;
import model.Enemy;
import model.Item;
import model.Joueur;
import model.Personnage;
public class Game {

	String[][] carte = new String[15][15];
	Joueur link = new Joueur(5, 5, "L", 3, 0);
	ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	ArrayList<Item> itemList = new ArrayList<Item>();
	boolean gameOn = true;

	//class Element, personnage héritant de Element
	//class item héritant de Element
	//x, y et sprite dans Element
	public void launch() {
		createEnemies();
		createItems();
		createTab();
		addEnemieOnMap();
		addItemsOnMap();
		updateTabWithPerso(link);
		
		while(gameOn) {
			printTab();
			handleMouvement();
		}
	}
	
	private void handleMouvement() {
		System.out.println("Direction : z->up");
		Scanner sc = new Scanner(System.in);
		String direction = sc.nextLine();
		switch(direction) {
		case "z":
			if(moveAllowed(link.getX()-1, link.getY())) {
				carte[link.getX()][link.getY()] = " ";
				link.setX(link.getX()-1);
				updateTabWithPerso(link);
			}
			else {
				//cas particulier
				handleCollision(link.getX()-1, link.getY());
			}
			break;
		case "s":
			if(moveAllowed(link.getX()+1, link.getY())) {
				carte[link.getX()][link.getY()] = " ";
				link.setX(link.getX()+1);
				updateTabWithPerso(link);
			}
			else {
				//cas particulier
				handleCollision(link.getX()+1, link.getY());
			}
			break;
		case "q":
			if(moveAllowed(link.getX(), link.getY()-1)) {
				carte[link.getX()][link.getY()] = " ";
				link.setY(link.getY()-1);
				updateTabWithPerso(link);
			}
			else {
				//cas particulier
				handleCollision(link.getX(), link.getY()-1);
			}
			break;
		case "d":
			if(moveAllowed(link.getX(), link.getY()+1)) {
				carte[link.getX()][link.getY()] = " ";
				link.setY(link.getY()+1);
				updateTabWithPerso(link);
			}
			else {
				//cas particulier
				handleCollision(link.getX(), link.getY()+1);
			}
			break;
			
		default :
			System.out.println("Erreur de saisie");
		}
		
		
	}
	
	
	private void handleCollision(int x, int y) {
		if(carte[x][y] == "I") {
			link.setNbItem(link.getNbItem()+1);

			/*impossible car itemList est verrouilée
			 * for(Item i : itemList) {
				if(i.getX()==x && i.getY()==y) itemList.remove(i);
			}*/
			
			Item tempItemToRemove = null;
			for(Item i : itemList) {
				if(i.getX()==x && i.getY()==y) tempItemToRemove = i;
			}
			itemList.remove(tempItemToRemove);
			
			
			carte[link.getX()][link.getY()] = " ";
			link.setX(x);
			link.setY(y);
			updateTabWithPerso(link);
		}
		
		else if(carte[x][y]=="E") {
			if(link.getNbItem()==0) {
				gameOn = false;
				System.out.println("Game Over!");
			}
			else {
				link.setNbItem(link.getNbItem()-1);
				
				Enemy tempEnemyToRemove = null;
				for(Enemy e : enemyList) {
					if(e.getX()==x && e.getY()==y) tempEnemyToRemove = e;
				}
				enemyList.remove(tempEnemyToRemove);
				
				
				carte[link.getX()][link.getY()] = " ";
				link.setX(x);
				link.setY(y);
				updateTabWithPerso(link);
			}
		}
		
	}

	
	private boolean moveAllowed(int x, int y) {
		/*if(carte[x][y]!=" ") { 
			return true;
		}
		else {
			return false;
		}*/
		return carte[x][y]==" " ? true : false;
	}
	

	private void addItemsOnMap() {
		for (Item i : itemList) {
			updateTabWithPerso(i);
		}
	}

	private void createItems() {
		//itemList.add(new Item(4, 5, "I"));
		itemList.add(new Item(7, 3, "I"));
		itemList.add(new Item(10, 10, "I"));
		
	}

	private void addEnemieOnMap() {
		for (Enemy e : enemyList) {
			updateTabWithPerso(e);
		}
	}

	private void createEnemies() {
		enemyList.add(new Enemy(3, 5, "E"));
		enemyList.add(new Enemy(3, 3, "E"));
		enemyList.add(new Enemy(7, 7, "E"));
	}

	private void updateTabWithPerso(Element perso) {
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
M M M M M M M M M M M M M M M 
M                           M 
M   E                       M 
M     E                     M 
M                           M 
M         L                 M 
M                           M 
M     I       E             M 
M                           M 
M   I                       M 
M                   I       M 
M                           M 
M                           M 
M                           M 
M M M M M M M M M M M M M M M 
*/