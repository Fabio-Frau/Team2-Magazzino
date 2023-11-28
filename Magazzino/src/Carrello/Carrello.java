package Carrello;
import Prodotti.Prodotto;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Carrello {

    private ArrayList<Prodotto> carrello;
    public ArrayList<Prodotto> getCarrello(){return carrello;}
    public void setCarrello(ArrayList<Prodotto> carrello){this.carrello = carrello;}

    public boolean aggiungiProdotto(Prodotto prodotto) {
        return this.carrello.add(prodotto);
    }

    public boolean aggiungiListaProdotti(ArrayList<Prodotto> prodotti) {
        return this.carrello.addAll(prodotti);
    }

    public Prodotto rimuoviProdottoPerID(String id) {
        for (Prodotto prodotto : this.carrello) {
            if(prodotto.getId().equals(id)) {
                carrello.remove(prodotto);
                return prodotto;
            }
        }
        return null;
    }

    public Prodotto rimuoviProdotto(Prodotto prodotto) {
        if(this.carrello.remove(prodotto)) {
            return prodotto;
        } else {
            return null;
        }
    }

    public ArrayList<Prodotto> rimuoviListaProdotti(ArrayList<Prodotto> prodotti) {
        if (this.carrello.removeAll(prodotti)) {
            return prodotti;
        } else {
            return null;
        }
    }

    public BigDecimal getPrezzoTotale() {
        BigDecimal prezzoTotale = BigDecimal.ZERO;
        if (this.carrello.isEmpty() || this.carrello == null) {
            return prezzoTotale;
        } else {
            for(Prodotto prodotto : this.carrello) {
                prezzoTotale = prezzoTotale.add(prodotto.getPrezzoVendita());
            }
            return prezzoTotale;
        }
    }



    public Carrello(ArrayList<Prodotto> carrello) {
        this.carrello = carrello;
    }

    @Override
    public String toString() {
        return "Carrello{" +
                "carrello=" + carrello +
                '}';
    }
}
