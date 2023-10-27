package Ricerca;

import Input.Input;
import Prodotti.Prodotto;

import java.util.ArrayList;

public class RicercaPerPrezzo {

    public static void ricercaRangePrezzo (ArrayList<Prodotto> magazzino) {
        range();

    }

    public static double[] range(){
        System.out.println("Inserire la fascia di prezzo: ");
        double[] range = new double[2];
        for(int i = 0; i < range.length; i++){
            range[i] = Input.readInt();
        }
        return range;
    }
}
