import java.util.Scanner;

public class Main {

    /**
     * Demande à l'utilisateur quelle action il veut faire, et exécute l'action.
     * Méthode statique, donc n'appartient pas à une instance d'une classe (ie
     * n'est pas liée à un objet en particulier).
     * @param billboard panneau d'affichage sur lequel travailler
     * @param scanner scanner pour l'entrée utilisateur
     * @return true si l'utilisateur veut quitter, false sinon
     */
    public static boolean askAndDoAction(Billboard billboard, Scanner scanner) {
        System.out.println(billboard);
        System.out.println("\n");
        System.out.print(
            "Que voulez-vous faire ?\n" +
            "    1. Ajouter un mot\n" +
            "    2. Effacer l'affichage\n" +
            "    3. Quitter\n\n" +
            ">>> "
        );
        // On récupère le choix de l'utilisateur
        int choice = scanner.nextInt();
        // On vide le scanner
        scanner.nextLine();

        // Si le choix n'est pas parmi ceux proposés
        if (choice != 1 && choice != 2 && choice != 3) {
            System.out.println("Choix incorrect ! Recommencez !\n");
            return askAndDoAction(billboard, scanner);
        }
        boolean willQuit;
        // En fonction du choix, on effectue l'action correspondante
        switch (choice) {
            case 1:
                System.out.print("Entrez le mot à ajouter : ");
                String word = scanner.nextLine();
                billboard.addWord(word);
                willQuit = false;
                break;
            case 2:
                billboard.clear();
                willQuit = false;
                break;
            default: // case: 3
                willQuit = true;
                break;
        }
        return willQuit;
    }

    /**
     * Méthode statique exécutée au démarrage de l'application. C'est le point
     * d'entrée du programme.
     * @param args éventuels arguments passés en ligne de commande lors du
     * lancement du programme
     */
    public static void main(String[] args) {
        System.out.println(
            "Bienvenue dans ce système de gestion d'affichage !\n\n");
        // On créé une instance de panneau d'affichage
        Billboard billboard = new Billboard(32);
        // On créé un scanner pour lire les entrées clavier de l'utilisateur
        Scanner scanner = new Scanner(System.in);
        boolean willQuit = false;
        while (!willQuit) {
            // Tant que l'utilisateur n'a pas dit qu'il voulait quitter, on
            // continue à lui demander ce qu'il veut faire
            willQuit = askAndDoAction(billboard, scanner);
        }
    }
}
