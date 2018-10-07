/**
 * Classe représentant notre panneau d'affichage déroulant (comme dans les
 * anciens trams par exemple)
 */
public class Billboard {
    // Ici on définit les champs internes à notre objet Billboard

    /**
     * Tableau de caractère pour représenter en interne notre affichage
     */
    private final char[] chars;

    /**
     * Nombre total de caractères choisi pour cette instance du panneau
     */
    private int total_chars_nb;

    /**
     * Nombre de caractères actuellement affichés (en partant de la gauche)
     * dans le panneau
     */
    private int used_chars_nb;

    /**
     * Constructeur pour notre panneau. Initialise les champs internes
     * @param _total_chars_nb nombre de caractères voulus pour le panneau
     */
    public Billboard(int _total_chars_nb) {
        this.used_chars_nb = 0;
        this.total_chars_nb = _total_chars_nb;
        this.chars = new char[this.total_chars_nb];
        for (int i = 0; i < this.total_chars_nb; i++) {
            this.chars[i] = ' ';
        }
    }

    /**
     * Affiche le caractère voulu sur l'écran, en décalant tous les autres vers
     * la gauche si besoin.
     * @param c le caractère à afficher
     */
    public void addChar(char c) {
        if (this.used_chars_nb < this.total_chars_nb) {
            // Si l'affichage n'est pas encore plein
            this.chars[this.used_chars_nb] = c;
            this.used_chars_nb++;
        } else {
            // Si l'affichage est plein
            for (int i = 0; i < this.used_chars_nb - 1; i++) {
                // On commence par déplacer tout vers la gauche
                this.chars[i] = this.chars[i + 1];
            }
            this.chars[this.used_chars_nb - 1] = c;
        }
    }

    /**
     * Affiche le mot voulu sur l'écran, en ajoutant un espace avant si besoin.
     * @param str le mot à afficher
     */
    public void addWord(String str) {
        if (this.used_chars_nb > 0) {
            // Si l'affichage n'est pas vide, il est nécessaire d'ajouter un
            // espace avant d'ajouter notre nouveau mot
            this.addChar(' ');
        }
        // Ensuite, on ajoute notre mot (lettre par lettre) à l'affichage
        for (char c: str.toCharArray()) {
            this.addChar(c);
        }
    }

    /**
     * Vide l'affichage complétement.
     */
    public void clear() {
        this.used_chars_nb = 0;
        for (int i = 0; i < this.total_chars_nb; i++) {
            this.chars[i] = ' ';
        }
    }

    /**
     * Retourne une représentation textuelle de notre objet.
     * @return une représentation textuelle de notre objet
     */
    @Override
    public String toString() {
        // On utilise un StringBuilder pour optimiser les performances qui va
        // contenir la String en cours de construction (car les String sont
        // immuables en Java)
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("+");
        for (int i = 0; i < this.total_chars_nb; i++) {
            strBuilder.append("-");
        }
        strBuilder.append("+\n");

        strBuilder.append("|");

        for (int i = 0; i < this.total_chars_nb; i++) {
            strBuilder.append(this.chars[i]);
        }

        strBuilder.append("|\n");

        strBuilder.append("+");
        for (int i = 0; i < this.total_chars_nb; i++) {
            strBuilder.append("-");
        }
        strBuilder.append("+");

        return strBuilder.toString();
    }
}
