package Ricerca;

import Prodotti.Prodotto;
import Utility.Input;

import java.util.ArrayList;
import java.util.Arrays;

public class RicercaPerDimSchermo {

    public static ArrayList<Prodotto> ricercaDimSchermo(ArrayList<Prodotto> magazzino ) {

        double[] rng = Utility.RangeUtils.DoubleRange();

        ArrayList<Prodotto> listaProdottoCercato = new ArrayList<Prodotto>();

        for (Prodotto prodotto : magazzino) {
            if (prodotto.getDimDisplay()>=rng[0] && prodotto.getDimDisplay()<= rng[1]) {
                listaProdottoCercato.add(prodotto);
            }
        }

        stampaPerCliente(listaProdottoCercato);

        return listaProdottoCercato;
    }

    public static void stampaPerCliente(ArrayList<Prodotto> prodottoCercato){
        StringBuilder stampaProdotto = new StringBuilder();
        for (Prodotto prodotto : prodottoCercato){
            stampaProdotto.append(prodotto.getProduttore()).append(' ').append(prodotto.getModello()).append("\t Dimensione Display(pollici): ")
                    .append(prodotto.getDimDisplay()).append("\t Dimensione Memoria(GB): ").append(prodotto.getDimMemoria()).
                    append("\t Prezzo: ").append(prodotto.getPrezzoVendita()).append(" € \n");
        }
        System.out.println(stampaProdotto);

    }

}
