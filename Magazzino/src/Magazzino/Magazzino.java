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

    public boolean aggiungiProdotto(Prodotto prodotto) {
         return this.listaProdotti.add(prodotto);
    }

    public boolean aggiungiListaProdotti(ArrayList<Prodotto> prodotti) {
        return this.listaProdotti.addAll(prodotti);
    }

    public Prodotto rimuoviProdottoPerID(String id) {
        for (Prodotto prodotto : this.listaProdotti) {
            if(prodotto.getId().equals(id)) {
                listaProdotti.remove(prodotto);
                return prodotto;
            }
        }
        return null;
    }

    public Prodotto rimuoviProdotto(Prodotto prodotto) {
        if(this.listaProdotti.remove(prodotto)) {
            return prodotto;
        } else {
            return null;
        }
    }

    public ArrayList<Prodotto> rimuoviListaProdotti(ArrayList<Prodotto> prodotti) {
        if (this.listaProdotti.removeAll(prodotti)) {
            return prodotti;
        } else {
            return null;
        }
    }

    public void setListaProdotti(ArrayList<Prodotto> listaProdotti) {this.listaProdotti = listaProdotti; }

    public void setMagazzino(ArrayList<Prodotto> listaProdotti) {
        this.listaProdotti = listaProdotti;
    }

}
