package game;

import model.Joueur;
import model.Personnage;
import java.util.ArrayList; // Import ArrayList
import java.util.Random;


public class Game {

    String[][] carte = new String[10][10];
    Personnage link = new Joueur(5, 5, "L", 3);
    //créer une arrayList pour les ennemi
    //ajouter 3 ennemi à l'arrayList
    //afficher le contenu de l'arrayList dans notre carte
    ArrayList<Personnage> enemies = new ArrayList<>(); // Create an ArrayList for enemies


    public void launch() {
        carte = createTab(carte);
        carte = updateTabWithPerso(carte, link);
        addEnemies(); // Add enemies to the ArrayList
        displayEnemiesOnCarte(); // Display enemies on the carte
        printTab(carte);
    }

    private void addEnemies() {
        // Add 3 enemies to the ArrayList
        enemies.add(new Personnage(1, 1, "E1", 1));
        enemies.add(new Personnage(2, 2, "E2", 1));
        enemies.add(new Personnage(3, 3, "E3", 1));

        // Random random = new Random();
        // // Define the enemies with their unique identifiers
        // String[] enemyIds = {"E1", "E2", "E3"};
        // // Define the enemies' initial positions
        // int[][] initialPositions = {{1, 1}, {2, 2}, {3, 3}};

        // for (int i = 0; i < enemyIds.length; i++) {
        //     int x = initialPositions[i][0]; // Use the initial x position
        //     int y = initialPositions[i][1]; // Use the initial y position
        //     // Ensure the position is not already occupied by another character
        //     while (carte[x][y] != null && !carte[x][y].equals(" ")) {
        //         x = random.nextInt(10); // Generate a new random x coordinate (0 to 9)
        //         y = random.nextInt(10); // Generate a new random y coordinate (0 to 9)
        //     }
        //     // Add the enemy to the ArrayList with the unique identifier and the new random position
        //     enemies.add(new Personnage(x, y, enemyIds[i], 1)); // Example enemy with unique identifier and random position
        // }

        // Random random = new Random();
        // // Assuming you want to add 3 enemies
        // for (int i = 0; i < 3; i++) {
        //     int x = random.nextInt(10); // Generate a random x coordinate (0 to 9)
        //     int y = random.nextInt(10); // Generate a random y coordinate (0 to 9)
        //     // Ensure the position is not already occupied by another character
        //     while (carte[x][y] != null && !carte[x][y].equals(" ")) {
        //         x = random.nextInt(10);
        //         y = random.nextInt(10);
        //     }
        //     // Add the enemy to the ArrayList
        //     enemies.add(new Personnage(x, y, "E", 1)); // Example enemy
        // }
    }

    private void displayEnemiesOnCarte() {
        // Iterate through the ArrayList and update the carte
        for (Personnage enemy : enemies) {
            carte[enemy.getX()][enemy.getY()] = enemy.getSprite();
        }
    }

    private String[][] updateTabWithPerso(String[][] carte, Personnage link) {
    	carte[link.getX()][link.getY()] = link.getSprite();
		return carte;
	}

	private String[][] createTab(String[][] carte) {
        for (int i = 0; i < carte.length; i++) {
            for (int j = 0; j < carte[i].length; j++) {
                if (i == 0 || i == carte.length - 1 || j == 0 || j == carte[i].length - 1) {
                    carte[i][j] = "M";
                } else {
                    carte[i][j] = " ";
                }
            }
        }
        return carte;
    }

    // methode pour afficher la carte
    public void printTab(String[][] carte) {
        for (int i = 0; i < carte.length; i++) {
            for (int j = 0; j < carte[i].length; j++) {
                System.out.print(carte[i][j] + " ");
            }
            System.out.println();
        }
    }
}
