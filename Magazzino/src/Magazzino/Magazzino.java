package Magazzino;

import Prodotti.*;
import java.util.ArrayList;

public class Magazzino {

    private ArrayList<Prodotto> listaProdotti;

    public Magazzino(ArrayList<Prodotto> listaProdotti) {
        this.listaProdotti = listaProdotti;
    }

    public ArrayList<Prodotto> getListaProdotti() {
        return listaProdotti;
    }


    //metodo di ricerca prodotto per tipo
//    public static ArrayList<Prodotto> ricercaProdotto(ArrayList<Prodotto> listaProdotti, TipoProdotto tipoProdotto) {
//        //array che conterra il prodotto cercato (TABLET o SMARTHPHONE o NOTEBOOK)
//
//        ArrayList<Prodotto> listaProdottoCercato = new ArrayList<>();
//        for (Prodotto prodotto : listaProdotti) {
//            if (prodotto.getTipo() == tipoProdotto) {
//                listaProdottoCercato.add(prodotto);
//            }
//        }
//        return listaProdottoCercato;
//    }
}
