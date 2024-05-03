package game;

import java.util.ArrayList;
import java.util.Scanner;

import model.Item;
import model.Element;
import model.Enemy;
import model.Joueur;
import model.Personnage;

public class Game {

    String[][] carte = new String[15][15];
    Personnage link = new Joueur(5, 5, "L");
    ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
    ArrayList<Item> itemList = new ArrayList<Item>();

    boolean gameOn = true;

    // class Element, personnage héritant de Element
    // class item héritant de Element
    // x, y et sprite dans Element
    public void launch() {
        createEnemies();
        createItems();
        createTab();
        addEnemieOnMap();
        addItemOnMap();
        updateTabWithPerso(link);
        while (gameOn) {
            printTab();
            handleMouvement();
        }
    }

    private void handleMouvement() {
        System.out.println("Quel direction ? : z -> up");
        Scanner sc = new Scanner(System.in);
        String direction = sc.nextLine();
        switch (direction) {
            case "z":
                carte[link.getY()][link.getY()] = " ";
                link.setY(link.getY() - 1);
                updateTabWithPerso(link);
                break;
        }
    }

    // ----------------------------------------------------

    private void createEnemies() {
        enemyList.add(new Enemy(2, 8, "E"));
        enemyList.add(new Enemy(8, 5, "E"));
        enemyList.add(new Enemy(12, 7, "E"));
    }

    private void addEnemieOnMap() {
        for (Enemy e : enemyList) {
            updateTabWithPerso(e);
        }
    }

    // ----------------------------------------------------

    private void createItems() {
        itemList.add(new Item(11, 2, "I"));
        itemList.add(new Item(8, 12, "I"));
        itemList.add(new Item(4, 10, "I"));
    }

    private void addItemOnMap() {
        for (Item i : itemList) {
            updateTabWithPerso(i);
        }
    }

    // ----------------------------------------------------

    private void updateTabWithPerso(Element perso) {
        carte[perso.getX()][perso.getY()] = perso.getSprite();
    }

    private void createTab() {
        for (int i = 0; i < carte.length; i++) {
            for (int j = 0; j < carte[i].length; j++) {
                if (i == 0 || i == carte.length - 1 || j == 0 || j == carte[i].length - 1) {
                    carte[i][j] = "M";
                } else {
                    carte[i][j] = " ";
                }
            }
        }
    }

    // methode pour afficher la carte
    public void printTab() {
        for (int i = 0; i < carte.length; i++) {
            for (int j = 0; j < carte[i].length; j++) {
                System.out.print(carte[i][j] + " ");
            }
            System.out.println();
        }
    }
}
/*
 * MMMMMMMMMM
 * M M
 * M M
 * M M
 * M M
 * M M
 * M M
 * M M
 * M M
 * MMMMMMMMMM
 */