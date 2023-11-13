package tp05_1;

import java.io.File;
import java.util.Scanner;

public class LsCmd {
    // Méthode pour implémenter la commande ls
    public static void ls_commande(String prefix, String cheminDuDossier) {
        // Créer un objet File pour le répertoire spécifié
        File dossier = new File(cheminDuDossier);

        // Obtenir la liste des fichiers et des répertoires dans le répertoire spécifié
        File[] fichiers = dossier.listFiles();

        // Vérifier si le répertoire n'est pas vide
        if (fichiers != null) {
            // Parcourir les fichiers et les répertoires
            for (File fichier : fichiers) {
                if (fichier.isDirectory()) {
                    // Afficher les informations sur le répertoire avec les autorisations
                    System.out.println(prefix + cheminDuDossier + "\\" + fichier.getName()
                            + " <DIR> " + (fichier.canRead() ? "r" : "")
                            + (fichier.canWrite() ? "w" : "")
                            + (fichier.isHidden() ? "h" : "-"));

                    // Appel récursif à ls_commande pour le sous-répertoire
                    ls_commande(prefix += "\t", cheminDuDossier + "\\" + fichier.getName());

                    // Supprimer le dernier caractère du préfixe pour maintenir la bonne indentation
                    prefix = prefix.substring(0, prefix.length() - 1);
                } else {
                    // Afficher les informations sur le fichier avec les autorisations
                    System.out.println(prefix + cheminDuDossier + "\\" + fichier.getName()
                            + " <FICH> " + (fichier.canRead() ? "r" : "")
                            + (fichier.canWrite() ? "w" : "")
                            + (fichier.isHidden() ? "h" : "-"));
                }
            }
        } else {
            // Afficher un message si le répertoire est vide
            System.out.println("Directory does not exist.");
        }
    }

    public static void main(String[] args) {
        // Lire le chemin du répertoire depuis l'utilisateur
        // String test_path = "C:\Users\pc\Documents\jee_pages_project";
        Scanner input = new Scanner(System.in);
        System.out.println("Chemin : ");
        String test_path = input.nextLine();

        // Appeler ls_commande pour lister les fichiers et répertoires
        ls_commande("", test_path);
    }
}
