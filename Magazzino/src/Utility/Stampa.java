package Utility;

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
}
