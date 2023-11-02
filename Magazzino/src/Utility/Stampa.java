package Utility;

import Prodotti.Prodotto;

import java.util.ArrayList;

public class Stampa {

    public static void PerCliente(ArrayList<Prodotto> prodottoCercato){
        StringBuilder stampaProdotto = new StringBuilder();
        for (Prodotto prodotto : prodottoCercato){
            stampaProdotto.append(prodotto.getProduttore()).append(' ').append(prodotto.getModello()).append("\t Dimensione Display(pollici): ")
                    .append(prodotto.getDimDisplay()).append("\t Dimensione Memoria(GB): ").append(prodotto.getDimMemoria()).
                    append("\t Prezzo: ").append(prodotto.getPrezzoVendita()).append(" € \n");
        }
        System.out.println(stampaProdotto);

    }
}
