package Ricerca;
import Prodotti.Prodotto;
import Utility.Input;
import java.util.ArrayList;
import java.util.Arrays;

public class RicercaPerDimSchermo {

    public static ArrayList<Prodotto> ricercaDimSchermo(ArrayList<Prodotto> magazzino, double min, double max ) {
        ArrayList<Prodotto> listaProdottoCercato = new ArrayList<Prodotto>();
        for (Prodotto prodotto : magazzino) {
            if (prodotto.getDimDisplay() >= min && prodotto.getDimDisplay() <= max) {
                listaProdottoCercato.add(prodotto);
            }
        }
        return listaProdottoCercato;
    }

}
