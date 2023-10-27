package Ricerca;

import Prodotti.Prodotto;

import java.util.ArrayList;

public class RicercaPerDimSchermo {

    public static ArrayList<Prodotto> ricercaDimSchermo(ArrayList<Prodotto> magazzino, double dimensione) {

        ArrayList<Prodotto> listaProdottoCercato = new ArrayList<Prodotto>();

        for (Prodotto prodotto : magazzino) {
            if (prodotto.getDimDisplay() == dimensione) {
                listaProdottoCercato.add(prodotto);
            }
        }

        return listaProdottoCercato;
    }

}
