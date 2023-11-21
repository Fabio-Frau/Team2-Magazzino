package Carrello;

import Prodotti.Prodotto;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Carrello {

    private ArrayList<Prodotto> carrello = new ArrayList<>();
    public ArrayList<Prodotto> getCarrello(){return carrello;}
    public void setCarrello(ArrayList<Prodotto> carrello){this.carrello = carrello;}

    @Override
    public String toString() {
        return "Carrello{" +
                "carrello=" + carrello +
                '}';
    }

//private BigDecimal totaleSpesa;
}
