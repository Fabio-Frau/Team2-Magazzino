package Utility;

import Carrello.Carrello;
import Login.Cliente;
import Login.Gestore;
import Login.Utente;
import Prodotti.Prodotto;

import java.util.ArrayList;

public class Stampa {

    public static void carrelliPerCliente(ArrayList<Carrello> carrelli) {
        for(Carrello carrello : carrelli) {
            System.out.println("Cliente: " + carrello.getIdcliente() + " ID Carrello: " + carrello.getIdcarrello());
            perCliente(carrello.getCarrello());
        }
    }

    public static void perCliente(ArrayList<Prodotto> prodottoCercato) {
        System.out.printf("%-15s %-15s %-15s %-25s %-20s %-20s %-20s", "Tipo", "ID", "Produttore", "Modello", "Dim. Display",
                "Dim. Memoria", "Prezzo Vendita");
        System.out.println();
        for (Prodotto prodotto : prodottoCercato) {
            System.out.printf("%-15s %-15s %-15s %-25s %-20.1f %-20d %-20.2f", prodotto.getTipo(), prodotto.getId(), prodotto.getProduttore(),
                    prodotto.getModello(), prodotto.getDimDisplay(), prodotto.getDimMemoria(),
                    prodotto.getPrezzoVendita());
            System.out.println();
        }
        System.out.println();
    }

    public static void perGestore(ArrayList<Prodotto> prodottoCercato) {
        System.out.printf("%-15s %-15s %-15s %-25s %-20s %-20s %-20s %-20s","Tipo", "ID", "Produttore", "Modello", "Dim. Display",
                "Dim. Memoria", "Prezzo Acquisto", "Prezzo Vendita");
        System.out.println();
        for (Prodotto prodotto : prodottoCercato){
            System.out.printf("%-15s %-15s %-15s %-25s %-20.1f %-20d %-20.2f %-20.2f", prodotto.getTipo(), prodotto.getId(), prodotto.getProduttore(),
                    prodotto.getModello(), prodotto.getDimDisplay(), prodotto.getDimMemoria(),
                    prodotto.getPrezzoAcquisto(), prodotto.getPrezzoVendita());
            System.out.println();
        }
        System.out.println();
    }

    public static void clienti (ArrayList<Cliente> listaUtenti) {
        System.out.printf("%-15s %-15s %-15s %-25s %-20s %-20s %-20s %-10s", "id", "nome", "cognome", "email", "password",
                "indirizzo", "paese", "numeroTelefono");
        System.out.println();
        for (Utente utente : listaUtenti) {
            System.out.printf("%-15s %-15s %-15s %-25s %-20s %-20s %-20s %-10d", utente.getId(), utente.getNome(), utente.getCognome(),
                    utente.getEmail(), utente.getPassword(), utente.getIndirizzo(),
                    utente.getPaese(), utente.getNumeroTelefono());
            System.out.println();
        }
        System.out.println();
    }

    public static void venditori (ArrayList<Gestore> listaVenditori) {
        System.out.printf("%-15s %-15s %-15s %-25s %-20s %-20s %-20s %-10s", "id", "nome", "cognome", "email", "password",
                "indirizzo", "paese", "numeroTelefono");
        System.out.println();
        for (Utente utente : listaVenditori) {
            System.out.printf("%-15s %-15s %-15s %-25s %-20s %-20s %-20s %-10d", utente.getId(), utente.getNome(), utente.getCognome(),
                    utente.getEmail(), utente.getPassword(), utente.getIndirizzo(),
                    utente.getPaese(), utente.getNumeroTelefono());
            System.out.println();
        }
        System.out.println();
    }
}
