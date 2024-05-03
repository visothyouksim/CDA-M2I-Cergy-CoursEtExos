package smallProjet2TakeNote;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SmallProjet2TakeNote {
    private static List<String> listeNotes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;

        while (continueProgram) {
            System.out.println("Menu:");
            System.out.println("1. Prendre une note");
            System.out.println("2. Lire la liste des notes");
            System.out.println("3. Quitter");

            System.out.print("Votre choix: ");
            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    prendreUneNote(scanner);
                    break;
                case 2:
                    lireListeDesNotes();
                    break;
                case 3:
                    continueProgram = false;
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez choisir entre 1 et 3.");
            }
        }

        scanner.close();
    }

    private static void prendreUneNote(Scanner scanner) {
        String contenu = scanner.nextLine();

        // Générer le nom du fichier basé sur la date
        String nomFichier = "C:\\Users\\visot\\OneDrive\\Bureau\\JAVA\\exoSmallNote\\notes\\" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + ".txt";
        
        // Créer le répertoire "notes" si nécessaire
        File directory = new File("C:\\Users\\visot\\OneDrive\\Bureau\\JAVA\\exoSmallNote\\notes\\");
        if (!directory.exists()) {
            directory.mkdirs(); // Crée le répertoire si nécessaire
        }

        try {
            FileWriter writer = new FileWriter(nomFichier);
            
            // Écrit la chaîne de caractères dans le fichier
            writer.write("Java 03.05.2024");
            writer.close();
            System.out.println("Note enregistrée avec succès!");

            // Ajouter le nom du fichier à la liste des notes
            listeNotes.add(nomFichier);
        } catch (IOException e) {
            System.err.println("Erreur lors de l'enregistrement de la note: " + e.getMessage());
        }
    }

    private static void lireListeDesNotes() {
        if (!listeNotes.isEmpty()) {
            for (String note : listeNotes) {
                System.out.println(note);
            }
        } else {
            System.out.println("Aucune note enregistrée.");
        }
    }
}


