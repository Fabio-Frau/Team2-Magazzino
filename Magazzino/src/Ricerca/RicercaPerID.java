package Ricerca;
import Magazzino.Magazzino;
import Prodotti.Prodotto;
import java.util.ArrayList;

public class RicercaPerID {
    public static ArrayList<Prodotto> ricercaPerID(ArrayList<Prodotto> magazzino, String id) {
        ArrayList<Prodotto> listaProdottoCercato = new ArrayList<>();
        for (Prodotto prodotto : magazzino) {
            if (prodotto.getId().equals(id)) {
                listaProdottoCercato.add(prodotto);
            }
        }
        return listaProdottoCercato;
    }
}
