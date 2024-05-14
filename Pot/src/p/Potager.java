package p;

import java.util.ArrayList;
import java.util.HashMap;

import UUU.Utilitaires;
import m.Aliment;
import m.Pdt;

public class Potager {

	//A la bonne place?
	HashMap<Aliment, Integer> gardeManger = new HashMap<Aliment, Integer>();
	ArrayList<Aliment> potager = new ArrayList<Aliment>();
	float argentDisponible = 10;
	
	
	
	
	public void cestparti() {
		
		System.out.println("Bonjour");
		System.out.println("Bienvenue dans votre potager!");
		
		/*System.out.println("Souhaitez vous restaurer une sauvegarde?");
		
		if(Utilitaires.readString().equals("oui")) {
			//TODO
			//Lecture d'un fichier txt contenant les informations normalisés du potager
			Utilitaires.restaurationData();
		}*/
		
		boolean appliOn = false;
		
		do {
			//a la bonne place???
			System.out.println("Choix :");
			System.out.println("1 Planter");
			System.out.println("2 Etat du potager");
			System.out.println("3 Recolter");
			System.out.println("4 Vendre au marché");
			System.out.println("5 Sauvegarder");
			System.out.println("6 Exit");

			int i = Utilitaires.readInt();
			
			switch (i) {
			case 1:
				System.out.println("Que voulez-vous planter?"
						+ " 1 Pdt, 2 Carotte, 3 Poireau, 4 Pomme");
				int j = Utilitaires.readInt();

				//TO DO
				//Gestion saisie utilisateur : ajout d'un des fruits/legumes saisie dans le potager
				//On plante une unité.
				break;
			case 2:
				Utilitaires.printPotager(potager);
				break;
			case 3:
				System.out.print("Quel fruit ou legume voulez vous recolter?");
				int jj = Utilitaires.readInt();

				//TO DO
				//On peut recolter l'un des fruits/legumes à maturité (ni trop tôt, ni trop tard)
				break;
			case 4 : 
				System.out.println("Vente au marché");
				//TO DO
				//Quel fruit/legume vendre ?
				break;
			
			case 5:
				System.out.println("Sauvegarde dans un fichier");
				//TO DO
				//On sauvegarde ce qui est dans le potager, ainsi que l'argent courant
				break;
			case 6:
				appliOn = false;
				break;
			default:
				;
			}
		}
		
		//TO DO
		//ajout : la pousse de chaque fruit/legume du potager 
		//(il faut qu'à chaque action, tous les fruits et légumes poussent)
		//les fruits et légumes trop mûr sont perdus et retirés du potager
		
		
		while(appliOn);
	}
	

}
