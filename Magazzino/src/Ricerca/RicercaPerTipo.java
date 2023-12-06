package Ricerca;
import Utility.Choose;
import Utility.Input;
import Prodotti.*;
import Utility.RangeUtils;


import java.util.ArrayList;

public class RicercaPerTipo {

    public static ArrayList<Prodotto> ricercaPerTipo (ArrayList<Prodotto> magazzino, TipoProdotto tipo) {
        ArrayList<Prodotto> listaProdottoCercato = new ArrayList<>();
        for (Prodotto prodotto : magazzino) {
            if(prodotto.getTipo().equals(tipo)){
                listaProdottoCercato.add(prodotto);
            }
        }
        return listaProdottoCercato;
    }




}
