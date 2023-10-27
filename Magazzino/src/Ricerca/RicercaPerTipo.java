package Ricerca;
import Prodotti.*;
import Magazzino.*;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class RicercaPerTipo {


    public static ArrayList<Prodotto> RicercaTablet (ArrayList<Prodotto> magazzino) {
        ArrayList<Prodotto> listaProdottoCercato = new ArrayList<>();
        for (Prodotto prodotto : magazzino) {
            if (prodotto.getTipo() == TipoProdotto.TABLET) {
                listaProdottoCercato.add(prodotto);
            }
        }
        return listaProdottoCercato;
    }

    public static void RicercaSmartohone (ArrayList<Prodotto> magazzino) {
        ArrayList<Prodotto> listaProdottoCercato = new ArrayList<>();
        for (Prodotto prodotto : magazzino) {
            if (prodotto.getTipo() == TipoProdotto.SMARTPHONE) {
                listaProdottoCercato.add(prodotto);
            }
        }
        stampaPerCliente(listaProdottoCercato);
        //return listaProdottoCercato;
    }

    public static ArrayList<Prodotto> RicercaNotebook (ArrayList<Prodotto> magazzino) {
        ArrayList<Prodotto> listaProdottoCercato = new ArrayList<>();
        for (Prodotto prodotto : magazzino) {
            if (prodotto.getTipo() == TipoProdotto.NOTEBOOK) {
                listaProdottoCercato.add(prodotto);
            }
        }
        return listaProdottoCercato;
    }

    public static void stampaPerCliente(ArrayList<Prodotto> prodottoCercato){
        StringBuilder stampaProdotto = new StringBuilder();
        for (Prodotto prodotto : prodottoCercato){
            System.out.println(stampaProdotto.append(prodotto.getProduttore()).append(prodotto.getModello()));

        }

    }
}
