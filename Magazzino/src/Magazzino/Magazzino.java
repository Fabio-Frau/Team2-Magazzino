package Magazzino;

import Prodotti.*;
import java.util.ArrayList;

public class Magazzino {
    private ArrayList<Prodotto> listaProdotti = new ArrayList<>();

    public Magazzino(ArrayList<Prodotto> listaProdotti) {
        this.listaProdotti = listaProdotti;
    }

    public ArrayList<Prodotto> getListaProdotti() {
        return listaProdotti;
    }

    public Prodotto aggiungiProdotto(Prodotto prodotto) {
        this.listaProdotti.add(prodotto);
        return prodotto;
    }

    public ArrayList<Prodotto> aggiungiListaProdotti(ArrayList<Prodotto> prodotti) {
        this.listaProdotti.addAll(prodotti);
        return prodotti;
    }

    public Prodotto rimuoviProdotto(Prodotto prodotto) {
        this.listaProdotti.remove(prodotto);
        return prodotto;
    }

    public ArrayList<Prodotto> rimuoviListaProdotti(ArrayList<Prodotto> prodotti) {
        this.listaProdotti.removeAll(prodotti);
        return prodotti;
    }



    public void setListaProdotti(ArrayList<Prodotto> listaProdotti) {this.listaProdotti = listaProdotti; }

    public void setMagazzino(ArrayList<Prodotto> listaProdotti) {
        this.listaProdotti = listaProdotti;
    }

}
