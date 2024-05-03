package menu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import content.TextContent;
import model.Garage;
import model.Voiture;

public class Menu {

	boolean isOn = true;
	Garage garage = new Garage();

	public void launch() {
		do {
			printMenuInitial();
			int choixUtil = saisieInt();
			handleUtilisateurChoix(choixUtil);
			tempsQuiPasse();
		} while (isOn);
	}

	private void tempsQuiPasse() {
		// décrémenter les reservoirs d'essence de chaque voiture en marche
		// eteindre les voitures qui n'ont plus d'essence
		for (Entry<String, Voiture> vv : garage.getGarage().entrySet()) {
			Voiture v = vv.getValue();
			if (v.isMarche()) {
				v.setEssence(v.getEssence() - 1);
				if (v.getEssence() <= 0) {
					v.setMarche(false);
				}
			}
		}
	}

	private void handleUtilisateurChoix(int choixUtil) {

		switch (choixUtil) {
			case 1:
				creationVoiture();
				break;
			case 2:
				startACar();
				break;
			case 3:
				fillTheTank();
				break;
			case 4:
				System.out.println(garage);
				break;
			case 5:
				bye();
				// System.exit(0);
				break;
			default:
				;
		}
	}

	private void fillTheTank() {
		for (Entry<String, Voiture> vv : garage.getGarage().entrySet()) {
			Voiture v = vv.getValue();
			int qtAjoutee = 50 - v.getEssence();
			System.out.println("Vous avez mis : " + qtAjoutee + "l d'essence");
			v.setEssence(50);
		}
	}

	private void startACar() {

		// TODO demarer si essence
		System.out.println(garage);
		System.out.println("Saisir le nom du modèle");
		// TODO selection par nom du model unique
		String keyVoitureSelectionne = saisieString();
		if (garage.getGarage().containsKey(keyVoitureSelectionne) &&
				garage.getGarage().get(keyVoitureSelectionne).getEssence() >= 0) {
			garage.getGarage().get(keyVoitureSelectionne).setMarche(true);
		} else {
			System.out.println("Pas assez d'essence pour démarrer");
		}
	}

	private void creationVoiture() {
		String nomModel = askNomModel();
		// Check if a car with the same model already exists
		if (garage.getGarage().containsKey(nomModel)) {
			System.out.println("Cette voiture existe déjà. Merci d'entrer un nom de modèle different.");
			// Optionally, you can call this method again to allow the user to try again
			// creationVoiture();
		} else {
			Voiture v = new Voiture(nomModel);
			garage.getGarage().put(nomModel, v);
			System.out.println("Voiture crée avec succès");
		}
	}

	private String askNomModel() {
		System.out.print("Quel est le model de ta voiture : ");
		String nomModel = saisieString();
		return nomModel;
	}

	private String saisieString() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}

	/*
	 * private int returnEmptySpaceFromGarage() {
	 * for (int i = 0; i < garage.getGarage().length; i++) {
	 * if (garage.getGarage()[i] == null) {
	 * return i;
	 * }
	 * }
	 * return -1;
	 * }
	 */

	private void bye() {
		System.out.println("Au revoir!");
		isOn = false;
	}

	private int saisieInt() {
		Scanner sc = new Scanner(System.in);
		try {
			return sc.nextInt();
		} catch (InputMismatchException e) {
			return 0;
		}
	}

	private void printMenuInitial() {
		System.out.println(TextContent.TEXTBONJOUR);

	}

	{

		try {
			BufferedWriter bf = new BufferedWriter(new FileWriter("text.txt"));
			bf.write("test1\n");
			bf.write("test2\n");
			bf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
