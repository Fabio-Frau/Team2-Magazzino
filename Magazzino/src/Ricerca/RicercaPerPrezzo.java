package Ricerca;

import SceltaOperazione.Cliente;
import Utility.Choose;
import Utility.Input;
import Prodotti.Prodotto;
import Utility.RangeUtils;
import Utility.Stampa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.*;

public class RicercaPerPrezzo {

    public static void ricercaRangePrezzoBD (ArrayList<Prodotto> magazzino) {
        System.out.println("Inserire la fascia di prezzo: ");
        BigDecimal[] rng = RangeUtils.DoubleRangeBD();

        RicercaPerPrezzo(magazzino,rng);
        Choose.ContinuaRicercaCliente(magazzino);
    }

    public static ArrayList<Prodotto> RicercaPerPrezzo (ArrayList<Prodotto> magazzino, BigDecimal[] rng) {
        ArrayList<Prodotto> listaProdottoCercato = new ArrayList<>();
        for (Prodotto prodotto : magazzino) {
            if(RangeUtils.isInRange(prodotto.getPrezzoVendita(),rng[0], rng[1])){
                listaProdottoCercato.add(prodotto);
            }
        }
       // listaProdottoCercato.sort(Comparator.comparingDouble(Prodotto::getPrezzoVendita));
        return (listaProdottoCercato);
    }
}
//INSERRIRE STAMPA LISTA PRODOTTO CERCATO




