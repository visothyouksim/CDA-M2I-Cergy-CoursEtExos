package menu;

import java.util.InputMismatchException;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

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
		case 3:// fillTheTank();
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
		// TODO chaque voiture doit être unique
			String nomModel = askNomModel();
			Voiture v = new Voiture(nomModel);
			//garage.getGarage()[emptySpace] = v;
			garage.getGarage().put(nomModel, v);
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

	/*private int returnEmptySpaceFromGarage() {
		for (int i = 0; i < garage.getGarage().length; i++) {
			if (garage.getGarage()[i] == null) {
				return i;
			}
		}
		return -1;
	}*/

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
		System.out.println("Bonjour!");
		System.out.println("Que voulez faire :");
		System.out.println("1 Créer une voiture");
		System.out.println("2 Allumer une voiture");
		System.out.println("3 Mettre de l'essence dans une voiture");
		System.out.println("4 Afficher le garage");
		System.out.println("5 Exit");

	}
}
