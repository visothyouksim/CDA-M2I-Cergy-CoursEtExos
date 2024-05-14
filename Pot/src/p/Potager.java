package p;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.List;

import UUU.Utilitaires;
import m.Aliment;
import m.Carotte;
import m.Pdt;
import m.Poireau;
import m.Pomme;

public class Potager {

	HashMap<Aliment, Integer> gardeManger = new HashMap<Aliment, Integer>();
	ArrayList<Aliment> potager = new ArrayList<Aliment>();
	float argentDisponible = 10;

	public void cestparti() {

		System.out.println("Bonjour");
		System.out.println("Bienvenue dans votre potager!");

		boolean appliOn = true;

		do {
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
					System.out.println("Que voulez-vous planter? 1 Pdt, 2 Carotte, 3 Poireau, 4 Pomme");
					int j = Utilitaires.readInt();
					if (j >= 1 && j <= 4) {
						Aliment plant = null;
						switch (j) {
							case 1:
								plant = new Pdt();
								break;
							case 2:
								plant = new Carotte();
								break;
							case 3:
								plant = new Poireau();
								break;
							case 4:
								plant = new Pomme();
								break;
						}
						if (plant != null) {
							potager.add(plant);
							System.out.println("Vous avez planté " + plant.toString());
						} else {
							System.out.println("Option invalide");
						}
					} else {
						System.out.println("Option invalide");
					}
					break;
				case 2:
					Utilitaires.printPotager(potager);
					break;
				case 3:
					System.out.print("Quel fruit ou legume voulez vous recolter?");
					int jj = Utilitaires.readInt();
					if (jj >= 1 && jj <= 4) {
						Aliment plant = null;
						switch (jj) {
							case 1:
								plant = new Pdt();
								break;
							case 2:
								plant = new Carotte();
								break;
							case 3:
								plant = new Poireau();
								break;
							case 4:
								plant = new Pomme();
								break;
						}
						if (plant != null && plant.isMature()) {
							potager.remove(plant);
							System.out.println("Vous avez recolte " + plant.toString());
						} else {
							System.out.println("Le " + plant.toString() + " n'est pas encore mature.");
						}
					} else {
						System.out.println("Option invalide");
					}
					break;
				case 4:
					System.out.println("Vente au marché");
					System.out.print("Quel fruit/legume vendre? ");
					int kk = Utilitaires.readInt();
					if (kk >= 1 && kk <= 4) {
						Aliment plant = null;
						switch (kk) {
							case 1:
								plant = new Pdt();
								break;
							case 2:
								plant = new Carotte();
								break;
							case 3:
								plant = new Poireau();
								break;
							case 4:
								plant = new Pomme();
								break;
						}
						if (plant != null && gardeManger.containsKey(plant)) {
							int quantity = gardeManger.get(plant);
							if (quantity > 0) {
								gardeManger.put(plant, quantity - 1);
								argentDisponible += plant.getValeur();
								System.out.println("Vous avez vendu " + plant.toString() + " pour " + plant.getValeur()
										+ " euros.");
							} else {
								System.out.println("Vous n'avez plus de " + plant.toString() + " à vendre.");
							}
						} else {
							System.out.println("Vous n'avez pas de " + plant.toString() + " à vendre.");
						}
					} else {
						System.out.println("Option invalide");
					}
					break;
				case 5:
					System.out.println("Sauvegarde dans un fichier");
					try {
						PrintWriter writer = new PrintWriter("potager.txt", "UTF-8");
						writer.println("Etat du potager :");
						for (Aliment plant : potager) {
							writer.println(plant.getNom() + " est en croissance.");
						}
						writer.println("Etat du garde-manger :");
						for (Map.Entry<Aliment, Integer> entry : gardeManger.entrySet()) {
							writer.println(entry.getKey().getNom() + " : " + entry.getValue() + " unités.");
						}
						writer.close();
						System.out.println("Sauvegarde réussie dans potager.txt!");
					} catch (IOException e) {
						e.printStackTrace();
						System.out.println("Erreur lors de la sauvegarde.");
					}
					break;
				case 6:
					appliOn = false;
					break;
				default:
					System.out.println("Option invalide");
			}

			// Faire pousser chaque fruit/legume du potager
			Iterator<Aliment> iterator = potager.iterator();
			while (iterator.hasNext()) {
				Aliment plant = iterator.next();
				plant.grow();
				if (plant.isMature()) {
					iterator.remove();
					System.out.println("Le " + plant.toString() + " est trop mûr et a été retiré du potager.");
				}
			}

		} while (appliOn);
	}
}