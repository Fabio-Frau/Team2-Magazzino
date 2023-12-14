package Utility;

import Login.Cliente;
import Login.Utente;
import Prodotti.Prodotto;

import java.util.ArrayList;

public class Stampa {

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

    public static void utenti (ArrayList<Cliente> listaUtenti) {
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
}
