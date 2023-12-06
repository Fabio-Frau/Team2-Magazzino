package Ricerca;
import Prodotti.Prodotto;
import Utility.RangeUtils;

import java.math.BigDecimal;
import java.util.ArrayList;

public class RicercaPerPrezzo {


    public static ArrayList<Prodotto> ricercaPerPrezzoVendita(ArrayList<Prodotto> magazzino, BigDecimal[] rng) {
        ArrayList<Prodotto> listaProdottoCercato = new ArrayList<>();
        for (Prodotto prodotto : magazzino) {
            if(RangeUtils.isInRange(prodotto.getPrezzoVendita(),rng[0], rng[1])){
                listaProdottoCercato.add(prodotto);
            }
        }

        return (listaProdottoCercato);
    }


    public static ArrayList<Prodotto> ricercaPerPrezzoAcquisto(ArrayList<Prodotto> magazzino, BigDecimal[] rng) {
        ArrayList<Prodotto> listaProdottoCercato = new ArrayList<>();
        for (Prodotto prodotto : magazzino) {
            if(RangeUtils.isInRange(prodotto.getPrezzoAcquisto(),rng[0], rng[1])){
                listaProdottoCercato.add(prodotto);
            }
        }

        return (listaProdottoCercato);
    }

}





