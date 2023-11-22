package Magazzino;

import Prodotti.*;
import java.util.ArrayList;

public class Magazzino {

    public static ArrayList<Prodotto> magazzino;
    private ArrayList<Prodotto> listaProdotti= new ArrayList<>();

    public Magazzino() {
        this.listaProdotti = listaProdotti;
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

    public ArrayList<Prodotto> getListaProdotti() {
        return listaProdotti;
    }

    public void setListaProdotti(ArrayList<Prodotto> listaProdotti) {this.listaProdotti = listaProdotti; }

    public static void setMagazzino(ArrayList<Prodotto> magazzino) {
        Magazzino.magazzino = magazzino;
    }

}
