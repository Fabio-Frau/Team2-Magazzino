import DBManager.FakeDB;
import DataSample.ProdottiSample;
import DataSample.UtentiSample;
import Login.*;
import Magazzino.*;
import SceltaOperazione.InterfacciaCliente;
import SceltaOperazione.InterfacciaGestore;

import java.sql.SQLOutput;
import java.util.ArrayList;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {

        FakeDB db = initData();

//        Utente utenteCorrente = null;
//        utenteCorrente = Login.accesso(db);




        Utente utenteCorrente = new Gestore(
                "Sara", "Neri", "saraneri@gmail.com",
                "sarabella1", 348334566);

        if (utenteCorrente instanceof Cliente) {
            InterfacciaCliente.sceltaRicercheCliente(db.getMagazzino());
        } else if(utenteCorrente instanceof Gestore) {
            InterfacciaGestore.operazioniGestore(db.getMagazzino());

        }





        //Login.accesso(listaUtenti, magazzino, carrello, tmp);

        // TEST PRODOTTI IN MAGAZZINO


        /*ArrayList<Prodotto> prodottiPresenti = new ArrayList<>();
        ProdottiTest.prodottiBase(prodottiPresenti);
        Magazzino magazzino = new Magazzino(prodottiPresenti);

        Cliente cliente1 = new Cliente(magazzino);
        cliente1.sceltaRicercheCliente();*/


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

    /**Carica dei dati di prova sul magazzino e sulla lista degli utenti*/
    public static FakeDB initData() {

        ArchivioUtenti archivioUtenti = new ArchivioUtenti(UtentiSample.utentiBase());
        Magazzino magazzino = new Magazzino(ProdottiSample.prodottiBase());

        return new FakeDB(magazzino, archivioUtenti);

    }




}