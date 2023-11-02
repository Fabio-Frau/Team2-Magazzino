package Ricerca;

import SceltaOperazione.Cliente;
import Utility.Choose;
import Utility.Input;
import Prodotti.Prodotto;
import Utility.Range;
import Utility.Stampa;

import java.util.ArrayList;
import java.util.*;

public class RicercaPerPrezzo {

    public static void ricercaRangePrezzo (ArrayList<Prodotto> magazzino) {
        System.out.println("Inserire la fascia di prezzo: ");
        double[] rng = Range.DoubleRange();
        RicercaPerPrezzo(magazzino,rng);

        Choose.ContinuaRicercaCliente(magazzino);
    }


    public static void RicercaPerPrezzo (ArrayList<Prodotto> magazzino, double[] rng) {
        ArrayList<Prodotto> listaProdottoCercato = new ArrayList<>();
        for (Prodotto prodotto : magazzino) {
            if (prodotto.getPrezzoVendita() >= rng[0] && prodotto.getPrezzoVendita() <= rng[1]) {
                listaProdottoCercato.add(prodotto);
            }
        }
        listaProdottoCercato.sort(Comparator.comparingDouble(Prodotto::getPrezzoVendita));
        Stampa.PerCliente(listaProdottoCercato);
    }


}
