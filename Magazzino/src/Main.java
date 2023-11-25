import Carrello.Carrello;
import Login.*;
import Magazzino.*;
import Prodotti.*;
import SceltaOperazione.*;
import Utility.*;

import java.math.BigDecimal;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.ArrayList;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        // TEST PRODOTTI IN MAGAZZINO


        /*ArrayList<Prodotto> prodottiPresenti = new ArrayList<>();
        ProdottiTest.prodottiBase(prodottiPresenti);
        Magazzino magazzino = new Magazzino(prodottiPresenti);

        Cliente cliente1 = new Cliente(magazzino);
        cliente1.sceltaRicercheCliente();*/


        ListaUtenti listaUtenti = new ListaUtenti();
        UtentiTest.utentiBase();
        ArrayList<Prodotto> tmp = new ArrayList<>();
        Magazzino magazzino = new Magazzino();
        magazzino.setListaProdotti(ProdottiTest.prodottiBase(magazzino.getListaProdotti()));
        Carrello carrello = new Carrello();
        Login.accesso(listaUtenti, magazzino, carrello, tmp);


//        ArrayList<Prodotto> prodottiPresenti = new ArrayList<>();
//        ProdottiTest.prodottiBase(prodottiPresenti);
//        Magazzino magazzino = new Magazzino(prodottiPresenti);
//        Cliente cliente1 = new Cliente(magazzino);
//        cliente1.sceltaRicercheCliente();
//


       /* Stampa.perGestore(magazzino.getListaProdotti());
        Prodotto prodotto = new Prodotto();
        magazzino.aggiungiProdotto(prodotto);
        Stampa.perGestore(magazzino.getListaProdotti());*/




//         ArrayList<Prodotto> prodottiPresenti = new ArrayList<>();
//         ProdottiTest.prodottiBase(prodottiPresenti);
//         Magazzino magazzino = new Magazzino(prodottiPresenti);

//         Gestore gestore = new Gestore(magazzino);
//         gestore.operazioniGestore();

        //Stampa.perGestore(magazzino.getListaProdotti());
        //Stampa.perCliente(magazzino.getListaProdotti());




        //TipoUtente.sceltaUtente(prodottiPresenti);

//        ArrayList<Utente> prova = UtentiTest.utentiBase();
//
//        for (Utente user : prova) {
//            System.out.println(user.getNome() + " is " + user.getClass());
//        }




    }

    public static void sceltaOperazione() {

        System.out.println("Scegli l'operazione da eseguire:");
        System.out.println("1. Aggiunta a magazzino\n2. Scarico merce da magazzino\n3. Acquista");

        int numeroOperazione = Utility.Input.readInt();

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

        TipoProdotto tipologia = Utility.Input.readTipo();


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