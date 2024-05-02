package pasFait;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class SmallProject1 {

	public static void main(String[] args) {

		/*
		 * Creation d'un jeu guess the number
		 * Le joueur doit deviner un chiffre entre 1 et 100
		 * Le jeu lui donne des indications (plus haut, plus bas)
		 * Le jeu lui dit en combien d'essai il a trouvé
		 * 
		 * 1ere étape : Découper le besoin en section. 
		 * De quoi va t on avoir besoin?
		 * 
		 * 2eme étape : mettre en place le code
		 * 3eme étape : revue et amélioration
		 * 
		 * 
		 */
		
		//variables declaration
		int count = 0;
		int randomNumber = 0;
		int numberGivenByUser = 0;
		boolean gameOn = true;
		System.out.println("Guess the number !");
		System.out.println("From 1 to 100");
		//generate random number
		Random random = new Random();
	    randomNumber = random.nextInt(100)+1;
	   
	    while(gameOn) {
		    
		    System.out.println("Give a number : ");
			//user input
			Scanner sc = new Scanner(System.in);
		    try {
				numberGivenByUser = sc.nextInt();
				//check
				//increment count
			    count++;
			    if(numberGivenByUser<randomNumber) {
			    	System.out.println("Higher !");
			    }
			    else if(numberGivenByUser>randomNumber) {
			    	System.out.println("Lower");
			    }
			    else {
			    	System.out.println("Victory!");
			    	gameOn = false;
			    }
		    }
		    catch(InputMismatchException e) {
		    	System.err.println(e);
		    }	
	    }
	    //end
	    System.out.println("You found with " + count + " attempt");
		
		
		
		/*
		 * Besoins :
		 * Print instructions
		 * Génération aléatoire d'un chiffre entre 1 et 100
		 * Définition d'un compteur
		 * boucle
		 * Saisie utilisateur int
		 * Comparaison et resultat :
		 * 		plus haut, bas, victoire.
		 * 		Incrémentation compteur
		 * 
		 */
	}

}
