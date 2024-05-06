package pasFait;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
public class Game {

	int victoire = 0, defaite = 0;
	boolean gameOn = true;
	String filepath = "./score.txt";

	public void launch() {

		readSave();

		System.out.println(Texte.BONJOUR);
		System.out.println(Texte.TITRE);

		while (gameOn) {
			System.out.println(Texte.MENU);

			int choix = saisieInt();
			
			switch (choix) {
			case 1:
				lancerJeu();
				break;
			case 2:
				afficherScore();
				break;
			case 3:
				gameOn = false;
				break;
			default:
				System.out.println(Texte.ERREUR);
			}

			save();

		}
		System.out.println(Texte.BYE);

	}

	private void readSave() {

		BufferedReader bf = null;
		try {
			bf = new BufferedReader(new FileReader(filepath));

			victoire = Integer.valueOf(bf.readLine());
			defaite = Integer.valueOf(bf.readLine());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			try {
				bf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	private void save() {
		try {
			BufferedWriter bf = new BufferedWriter(new FileWriter(filepath));
			bf.write(Integer.toString(victoire));
			bf.write("\n");
			bf.write(Integer.toString(defaite));
			bf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void lancerJeu() {
		System.out.println(Texte.CHOIX);
		String choixPartie = saisieString();
		String computerChoix = "";

		int randomComputerChoice = randomInt();
		switch (randomComputerChoice) {
		case 0:
			computerChoix = "pierre";
			break;
		case 1:
			computerChoix = "feuille";
			break;
		case 2:
			computerChoix = "ciseaux";
			break;
		}

		System.out.println("Joueur : " + choixPartie + ", ordi : " + computerChoix);
		
		
		//equalsIgnoreCase
		if ((choixPartie == "feuille" && computerChoix == "pierre")
				|| (choixPartie == "pierre" && computerChoix == "ciseaux")
				|| (choixPartie == "ciseaux" && computerChoix == "feuille")) {
			victoire++;
			System.out.println(Texte.VICTOIRE);
		} else {
			defaite++;
			System.out.println(Texte.DEFAITE);
		}

	}

	private void afficherScore() {
		System.out.println("Joueur : " + victoire + ", ordi : " + defaite);
	}

	public String saisieString() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}

	public int saisieInt() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

	public int randomInt() {
		Random r = new Random();
		return r.nextInt(3);
	}

}
