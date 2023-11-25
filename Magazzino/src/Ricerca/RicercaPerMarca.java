package Ricerca;
import Prodotti.Prodotto;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class RicercaPerMarca {
    public static ArrayList<Prodotto> ricercaPerMarca(ArrayList<Prodotto> magazzino, String marca) {
        ArrayList<Prodotto> listaProdottoCercato = new ArrayList<>();
        for (Prodotto prodotto : magazzino) {
            if (prodotto.getProduttore().equalsIgnoreCase(marca)) {
                listaProdottoCercato.add(prodotto);
            }
        }
        return listaProdottoCercato;
    }


}
