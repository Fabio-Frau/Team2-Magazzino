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

}
