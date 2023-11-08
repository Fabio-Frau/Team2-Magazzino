package Login;

import java.util.ArrayList;

public class ListaUtenti {
    ArrayList<Utente> listaUtenti = new ArrayList<>();

    public ListaUtenti() {
        Utente utente1 = new Utente("Andrea", "Rossi", "andrearossi@gmail.com",
                "andrea10", 349567742);
        Utente utente2 = new Utente("Mario", "Bianchi", "mariobianchi@gmail.com",
                "bianchi91", 342478902);
        Utente utente3 = new Utente("Giulia", "Verdi", "giuliaverdi@gmail.com",
                "giulietta12", 349721134);
        Utente utente4 = new Utente("Sara", "Neri", "saraneri@gmail.com",
                "sarabella1", 348334566);
        listaUtenti.add(utente1);
        listaUtenti.add(utente2);
        listaUtenti.add(utente3);
        listaUtenti.add(utente4);
    }


}
