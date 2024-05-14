package potager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import model.Aliment;
import model.Carotte;
import model.Pdt;
import model.Poireau;
import model.Pomme;
import utilitaires.Utilitaires;

public class Potager {

	//A la bonne place?
	HashMap<Aliment, Integer> gardeManger = new HashMap<Aliment, Integer>();
	ArrayList<Aliment> potager = new ArrayList<Aliment>();
	float argentDisponible = 10;
	
	public void launch() {
		
		potager.add(new Pdt());
		potager.add(new Carotte());
		potager.add(new Poireau());
		
		potager.get(0).setMomentPousse(3);
		
		System.out.println("Bonjour");
		System.out.println("Bienvenue dans votre potager!");
		
		/*System.out.println("Souhaitez vous restaurer une sauvegarde?");
		
		if(Utilitaires.readString().equals("oui")) {
			//TODO
			//Lecture d'un fichier txt contenant les informations normalisés du potager
			Utilitaires.restaurationData();
		}*/
		
		boolean appliOn = true;
		
		do {
			//a la bonne place???
			System.out.println("Choix :");
			System.out.println("1 Planter");
			System.out.println("2 Etat du potager");
			System.out.println("3 Recolter");
			System.out.println("4 Vendre au marché");
			System.out.println("5 Sauvegarder");
			System.out.println("6 Exit");

			System.out.println("Argent dispo : " + argentDisponible);
			int i = Utilitaires.readInt();
			
			switch (i) {
			case 1:
				System.out.println("Que voulez-vous planter?"
						+ " 1 Pdt, 2 Carotte, 3 Poireau, 4 Pomme");
				int j = Utilitaires.readInt();
				switch (j) {
					case 1:
						if(new Pdt().getPrixpourplanter()<=argentDisponible) {
							potager.add(new Pdt()); 
							argentDisponible -= new Pdt().getPrixpourplanter();
						}
						else {
							System.out.println("Pas assez de sous");
						}
						break;
					case 2:
						potager.add(new Carotte()); 
					break;
					case 3:
						potager.add(new Poireau()); 
					break;
					case 4:
						potager.add(new Pomme()); 
					break;
					default:
						System.out.println("N IMPORTE QUOI!!!!!");
					break;
				}
				
				//TO DO
				//Gestion saisie utilisateur : ajout d'un des fruits/legumes saisie dans le potager
				//On plante une unité.
				break;
			case 2:
				Utilitaires.printPotager(potager);
				break;
			case 3:
				System.out.println("Quel fruit ou legume voulez vous recolter?");
				ArrayList<Aliment> alimentMurs = new ArrayList<Aliment>();
				for(Aliment aliment : potager) {
					if(aliment.getDureePousse()==aliment.getMomentPousse()) {
						alimentMurs.add(aliment);
					}
				}
				for(Aliment aliment: alimentMurs) {
					System.out.println(alimentMurs.indexOf(aliment) + " : " + aliment.toString());
				}
				
				int jj = Utilitaires.readInt();
				Aliment alimentToRemove = alimentMurs.get(jj);
				potager.remove(alimentToRemove);
				if(gardeManger.containsKey(alimentToRemove)) {
					gardeManger.put(alimentToRemove,
							gardeManger.get(alimentToRemove)
							+ alimentToRemove.getRecoltePousse());
				}
				else {
					gardeManger.put(alimentToRemove, alimentToRemove.getRecoltePousse());
				}
				//TO DO
				//On peut recolter l'un des fruits/legumes à maturité (ni trop tôt, ni trop tard)
				break;
			case 4 : 
				System.out.println("Vente au marché");
				for(Entry<Aliment, Integer> a : gardeManger.entrySet()) {
					System.out.println(a.getKey().getNom() + " " + a.getValue());
				}
				System.out.println("Que vendre?");
				String nomAlimentAVendre = Utilitaires.saisieString();
				
				for(Aliment a : gardeManger.keySet()) {
					if(a.getNom().equals(nomAlimentAVendre)) {
						argentDisponible += a.getPrixdevente()*gardeManger.get(a);
						gardeManger.remove(a);
	
					}
					
				}
				
				
				
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
			
			ArrayList<Aliment> alimentToRemove = new ArrayList<Aliment>();
			for(Aliment aliment : potager) {
				aliment.setMomentPousse(aliment.getMomentPousse()+1);
				if(aliment.getMomentPousse()>aliment.getDureePousse()) {
					alimentToRemove.add(aliment);
				}
			}
			potager.removeAll(alimentToRemove);
		}
		
		//TO DO
		//ajout : la pousse de chaque fruit/legume du potager 
		//(il faut qu'à chaque action, tous les fruits et légumes poussent)
		//les fruits et légumes trop mûr sont perdus et retirés du potager
		
		
		while(appliOn);
	}
	

}
