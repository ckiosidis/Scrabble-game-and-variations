package scrabble;

import java.util.ListResourceBundle;

public class Localization_el extends ListResourceBundle {

    private Object[][] contents = {
        {"charset","Cp1253"},
        {"players", "Πόσοι παίκτες θα λάβουν μέρος (2 ως 4);"},
        {"name", "Ονομα παικτη "},
        {"nextPlayer","Παιζει ο παικτης: "},
        {"choice", "Δώσε επιλογή:(1)πάσο,(2)αλλαγή γραμμάτων,(3)σχηματισμός λέξης: "},
        {"choice", "Δώσε επιλογή:(1)πάσο,(3)σχηματισμός λέξης: "},
        {"lettersToChange","Ποσα γραμματα θελεις να αλλαξεις "},
        {"unexpected","Μη αποδεκτος αριθμος γραμματων"},
        {"letter","Διαλεξε γραμμα(νουμερο): "},
        {"validation","Εισαι σιγουρος πως θελεις να αλλαξεις το γραμμα  "},
        {"validation2"," ? y/n :"},
        {"word","Δώσε τη λέξη που σχηματίζεις: "},
        {"position","Δώσε (1) για οριζόντια τοποθέτηση και (2) για κάθετη τοποθέτηση της λέξης: "},
        {"coord","Δώσε συντεταγμένες κελιού εκκίνησης της λέξης, ξεχωριστα: "},
        {"show","Ο παικτης: "},
        {"has"," εχει "},
        {"points", " ποντοι: "},
        {"winner"," είναι ο νικητης."},
        {"end","Συγχαρητιρια τελειωσατε το παιχνιδι."},
        
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }

}
