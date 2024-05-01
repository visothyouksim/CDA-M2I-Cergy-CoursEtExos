package menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.Garage;
import model.Voiture;

public class Menu {

	boolean isOn = true;
	Garage garage = new Garage(10);
	
	public void launch() {
		do {
			printMenuInitial();
			int choixUtil = saisieInt();
			handleUtilisateurChoix(choixUtil);
			tempsQuiPasse();
		}
		while(isOn);
	}

	
	private void tempsQuiPasse() {
		//décrémenter les reservoirs d'essence de chaque voiture en marche
		//eteindre les voitures qui n'ont plus d'essence
	}


	private void handleUtilisateurChoix(int choixUtil) {

		switch(choixUtil) {
			case 1: creationVoiture();
				break;
			case 2: startACar();
				break;
			case 3:// fillTheTank();
				break;
			case 4: System.out.println(garage);
				break;
			case 5: bye();
				//System.exit(0);
				break;
			default:;
		}
	}


	private void startACar() {

		//TODO demarer si essence
		System.out.println(garage);
		System.out.println("Saisir le numéro de l'emplacement");
		//TODO selection par nom du model unique
		int indexVoitureSelectionne = saisieInt();
		garage.getGarage()[indexVoitureSelectionne].setMarche(true);
	}


	private void creationVoiture() {
		//TODO chaque voiture doit être unique
		int emptySpace = returnEmptySpaceFromGarage();
		if(emptySpace != -1) {
			String nomModel = askNomModel();
			Voiture v = new Voiture(nomModel);
			garage.getGarage()[emptySpace] = v;
		}
		else {
			System.out.print("Impossible, plus de place");
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


	private int returnEmptySpaceFromGarage() {
		for(int i = 0; i<garage.getGarage().length; i++) {
			if(garage.getGarage()[i]==null) {
				return i;
			}
		}
		return -1;
	}


	private void bye() {
		System.out.println("Au revoir!");
		isOn = false;
	}


	private int saisieInt() {
		Scanner sc = new Scanner(System.in);
		try {
			return sc.nextInt();
		}
		catch(InputMismatchException e) {
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
