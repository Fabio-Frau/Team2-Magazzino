import Login.Utente;
import Magazzino.*;
import Prodotti.Prodotto;
import Prodotti.Tablet;
import Prodotti.TipoProdotto;
import SceltaOperazione.TipoUtente;
import java.util.ArrayList;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // TEST PRODOTTI IN MAGAZZINO


        ArrayList<Prodotto> prodottiPresenti = new ArrayList<>();
        ProdottiTest.prodottiBase(prodottiPresenti);
        Magazzino magazzino = new Magazzino(prodottiPresenti);


        TipoUtente.sceltaUtente(prodottiPresenti);


        ArrayList<Utente> listaUtenti = new ArrayList<>();
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





//
//
//


    }

    public static void sceltaOperazione() {

        System.out.println("Scegli l'operazione da eseguire:");
        System.out.println("1. Aggiunta a magazzino\n2. Scarico merce da magazzino\n3. Acquista");

        int numeroOperazione = Prodotti.InputProdotti.readInt();

        switch (numeroOperazione) {
            case 1: {
                System.out.println("Aggiunta a magazzino");
                break;
            }
            case 2: {
                System.out.println("Scarico merce da magazzino");
                break;
            }
            case 3: {
                System.out.println("Acquista");
                break;
            }
            default: {
                System.out.println("Operazione non trovata");
            }
        }
    }

    public static void sceltaTipo () {

        ArrayList<Tablet> arrayTablet = new ArrayList<Tablet>();

        TipoProdotto tipologia = Prodotti.InputProdotti.readTipo();


        switch (tipologia) {
            case TABLET: {
                arrayTablet.add(new Tablet());
                System.out.println(arrayTablet.toString());
                break;
            }
            case NOTEBOOK:  {

                break;
            }
            case SMARTPHONE: {

                break;
            }


        }
    }
}