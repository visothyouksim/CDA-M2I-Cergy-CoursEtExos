package main;

import java.util.Map.Entry;

import data.Data;
import data.TxtConst;
import model.Groupe;
import model.Scene;
import utilitaires.Utilitaires;

public class Launch {

	Data data;

	public Launch() {
		data = new Data();
	}

	public void lancement() {
		do {
			int choiceMainMenu = mainMenu();
			level2Menu(choiceMainMenu);
		} while (Data.isMenuOn());
	}

	private int mainMenu() {
		System.out.println(TxtConst.BONJOUR);
		System.out.println(TxtConst.MENUQUESTION);
		return Utilitaires.saisieInt();
	}

	private void level2Menu(int i) {
		Data.setSubPartOn(true);
		switch (i) {
		case 1:
			menuGroupe();
			break;
		case 2:
			menuScene();
			break;
		case 3:
			menuFestival();
			break;
		case 4:
			menuSave();
			break;
		case 5:
			System.out.println(TxtConst.AUREVOIR);
			Data.setMenuOn(false);
			break;
		default:
			System.out.println(TxtConst.ERREUR);
			break;
		}

	}

	// Le code de la fonction menuGroupe semble fonctionnel, même s'il ne respecte
	// pas assez les normes.
	private void menuGroupe() {
		do {
			System.out.println(TxtConst.MENUGROUPE);
			System.out.println(TxtConst.MENUGROUPECHOICE);
			System.out.println("1. Voulez vous lister les groupes existants?");
			System.out.println("2. Voulez vous enregistrer un groupe?");
			System.out.println("3. Voulez vous supprimer un groupe?");
			System.out.println("4. Revenir au menu principal?");

			switch (Utilitaires.saisieInt()) {
			case 1:
				Utilitaires.printGroupes(Data.getGroupes());
				break;
			case 2:
				System.out.println("Quel groupe voulez vous créer");
				System.out.println("Nom :");
				String nomToAdd = Utilitaires.getStringFromUser();
				System.out.print("Style :");
				String styleToAdd = Utilitaires.getStringFromUser();
				Data.getGroupes().put(nomToAdd, new Groupe(nomToAdd, styleToAdd));
				break;
			case 3:
				System.out.println("Quel groupe voulez vous suprimer ?");
				Utilitaires.printGroupes(Data.getGroupes());
				System.out.println("Nom :");
				String nomToRemove = Utilitaires.getStringFromUser();
				if (Data.getGroupes().containsKey(nomToRemove)) {
					Data.getGroupes().remove(nomToRemove);
				} else {
					System.out.println("Erreur saisie");
				}
				break;
			case 4:
				Data.setSubPartOn(false);
				break;
			default:
				System.out.println(TxtConst.ERREUR);
				break;
			}

		} while (Data.isSubPartOn());

	}

	private void menuScene() {
		do {
			System.out.println(TxtConst.MENUSCENE);
			System.out.println(TxtConst.MENUSCENECHOICE);
			System.out.println("1. Voulez vous lister les scènes existants?");
			System.out.println("2. Voulez vous enregistrer une scène?");
			System.out.println("3. Voulez vous supprimer une scène?");
			System.out.println("4. Voulez vous ajouter un groupe existant à une scène?");
			System.out.println("5. Voulez vous enlever un groupe à une scène?");
			
			System.out.println("6. Revenir au menu principal?" + "/n");

			// TODO
			// CRUD - s'inspirer de menuGroupe

			switch (Utilitaires.saisieInt()) {
				case 1:
					Utilitaires.printScenes(Data.getScenes());
					break;
				case 2:
					System.out.println("Quel scene voulez vous créer");
					System.out.println("Nom :");
					String nomToAdd = Utilitaires.getStringFromUser();
					Data.getScenes().put(nomToAdd, new Scene(nomToAdd));
					break;
				case 3:
					System.out.println("Quel scene voulez vous suprimer ?");
					Utilitaires.printScenes(Data.getScenes());
					System.out.println("Nom :");
					String nomToRemove = Utilitaires.getStringFromUser();
					if (Data.getScenes().containsKey(nomToRemove)) {
						Data.getScenes().remove(nomToRemove);
					} else {
						System.out.println("Erreur saisie");
					}
					break;
				case 4:
					System.out.println("Quel groupe voulez vous ajouter?");
					Utilitaires.printGroupes(Data.getGroupes());
					String nomGroupeToAdd = Utilitaires.getStringFromUser();
					System.out.println("A quelle scene l'ajouter?");
					Utilitaires.printScenes(Data.getScenes());
					String nomScene = Utilitaires.getStringFromUser();
					Scene s = Data.getScenes().get(nomScene);
					Groupe g = Data.getGroupes().get(nomGroupeToAdd);
					if(Data.getScenes().containsKey(nomScene) &&
							Data.getGroupes().containsKey(nomGroupeToAdd)) {
						s.getGroupes().add(g);
							
					}
					break;
				case 5:
					System.out.println("De quelle scene enlever un groupe?");
					Utilitaires.printScenes(Data.getScenes());
					System.out.println("Quel groupe voulez vous enlever?");
					Utilitaires.printGroupes(Data.getGroupes());
					String nomGroupeToRemove = Utilitaires.getStringFromUser();
					nomScene = Utilitaires.getStringFromUser();
					if(Data.getScenes().containsKey(nomScene) &&
							Data.getGroupes().containsKey(nomGroupeToRemove)) {
						Data.getScenes().get(nomScene).getGroupes()
							.remove(Data.getGroupes().get(nomGroupeToRemove));
					}
					break;
				
				case 6:
					Data.setSubPartOn(false);
					break;
				default:
					System.out.println(TxtConst.ERREUR);
					break;
			}
			
		} while (Data.isSubPartOn());

	}

	private void menuFestival() {
		do {
			System.out.println(TxtConst.MENUFESTIVAL);
			System.out.println("1. Voulez vous lister les scenes liées au festival?");
			System.out.println("2. Voulez vous ajouter une scene au festival?");
			System.out.println("3. Voulez vous supprimer une scene d'un festival?");
			
			System.out.println("4. Voulez vous supprimer un groupe?");

			System.out.println("5. Revenir au menu principal?");

			switch (Utilitaires.saisieInt()) {
			case 1:
				System.out.println(Data.getFestival().getScenes());
			break;
			case 2:
				System.out.println("Quel scene voulez vous ajouter?");
				Utilitaires.printScenes(Data.getScenes());
				String nomSceneToAdd = Utilitaires.getStringFromUser();
				if(Data.getScenes().containsKey(nomSceneToAdd)) {
					Data.getFestival().getScenes()
					.add(Data.getScenes().get(nomSceneToAdd));
				};
			break;
			case 3:
				System.out.println("Quel scene voulez vous supprimer?");
				System.out.println(Data.getFestival().getScenes());
				String nomSceneToRemove = Utilitaires.getStringFromUser();
				Scene sceneToRemove = Data.getScenes().get(nomSceneToRemove);
				if(Data.getFestival().getScenes().contains(sceneToRemove)) {
					Data.getFestival().getScenes()
					.remove(Data.getScenes().get(sceneToRemove));
				};
			break;
			case 4:
				System.out.println("Quel groupe voulez vous supprimer?");
				Utilitaires.printGroupes(Data.getGroupes());
				String nomGroupeToRemove = Utilitaires.getStringFromUser();
				Groupe groupeToRemove = Data.getGroupes().get(nomGroupeToRemove);
				
				for(Entry<String, Scene> scene : Data.getScenes().entrySet()) {
					if(scene.getValue().getGroupes().contains(groupeToRemove)) {
						scene.getValue().getGroupes().remove(groupeToRemove);
					}
					Data.getGroupes().remove(nomGroupeToRemove, groupeToRemove);
				};
			break;
			case 5:
				Data.setSubPartOn(false);
			break;
			
			} 
		} while (Data.isSubPartOn());

	}

	private void menuSave() {
		System.out.println(TxtConst.MENUSAVE);

		// TODO
		// Enregistrer les données du festival dans un fichier, quel qu'il soit
		// pas de mise en forme particulière, on veut juste que toutes les données y
		// soit :
		// les scènes en place dans le festival, et les groupes jouant sur les scènes.
		// pas besoin d'enregistrer les groupes qui ne sont pas liés à des scènes et les
		// scènes qui ne sont pas liées au festival

	}
}
