package Login;

import java.util.ArrayList;

public class UtentiTest {

    public static ArrayList<Utente> utentiBase() {

        ArrayList<Utente> listaUtenti = new ArrayList<>();
//        Utente utente1 = new Utente("Andrea", "Rossi", "andrearossi@gmail.com",
//                "andrea10", 349567742);
//        Utente utente2 = new Utente("Mario", "Bianchi", "mariobianchi@gmail.com",
//                "bianchi91", 342478902);
//        Utente utente3 = new Utente("Giulia", "Verdi", "giuliaverdi@gmail.com",
//                "giulietta12", 349721134);
//        Utente utente4 = new Utente("Sara", "Neri", "saraneri@gmail.com",
//                "sarabella1", 348334566);

        Cliente cliente1 = new Cliente("Andrea", "Rossi", "andrearossi@gmail.com",
                "andrea10", 349567742);
        Cliente cliente2 = new Cliente("Mario", "Bianchi", "mariobianchi@gmail.com",
                "bianchi91", 342478902);
        Gestore gestore1 = new Gestore("Giulia", "Verdi", "giuliaverdi@gmail.com",
                "giulietta12", 349721134);
        Gestore gestore2 = new Gestore("Sara", "Neri", "saraneri@gmail.com",
                "sarabella1", 348334566);


        listaUtenti.add(cliente1);
        listaUtenti.add(cliente2);
        listaUtenti.add(gestore1);
        listaUtenti.add(gestore2);

        return listaUtenti;
    }
}
