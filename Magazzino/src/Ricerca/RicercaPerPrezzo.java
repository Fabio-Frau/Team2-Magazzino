package Ricerca;

import Input.Input;
import Prodotti.Prodotto;
import Prodotti.TipoProdotto;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.*;

public class RicercaPerPrezzo {

    public static void ricercaRangePrezzo (ArrayList<Prodotto> magazzino) {
        double[] rng = range();
        RicercaPerPrezzo(magazzino,rng);
    }

    public static void RicercaPerPrezzo (ArrayList<Prodotto> magazzino, double[] rng) {
        ArrayList<Prodotto> listaProdottoCercato = new ArrayList<>();
        for (Prodotto prodotto : magazzino) {
            if (prodotto.getPrezzoVendita() >= rng[0] && prodotto.getPrezzoVendita() <= rng[1]) {
                listaProdottoCercato.add(prodotto);
            }
        }
        listaProdottoCercato.sort(Comparator.comparingDouble(Prodotto::getPrezzoVendita));
        stampaPerCliente (listaProdottoCercato);
    }



    public static double[] range(){
        System.out.println("Inserire la fascia di prezzo: ");
        double[] range = new double[2];
        for(int i = 0; i < range.length; i++){
            range[i] = Input.readInt();
        }
        Arrays.sort(range);
        return range;
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
