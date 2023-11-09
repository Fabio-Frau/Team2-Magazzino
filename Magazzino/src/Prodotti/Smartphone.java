package Prodotti;

import java.math.BigDecimal;

public class Smartphone extends Prodotto{

    public Smartphone(){
       super();
        this.tipo = TipoProdotto.SMARTPHONE;
   }

    public Smartphone(TipoProdotto tipo, String produttore, String modello, String id, String descrizione,
                      double dimDisplay, int dimMemoria, BigDecimal prezzoAcquisto, BigDecimal prezzoVendita) {
        super(tipo, produttore, modello, id, descrizione, dimDisplay, dimMemoria, prezzoAcquisto, prezzoVendita);
        this.tipo = TipoProdotto.SMARTPHONE;
    }

//    @Override
//    public String toString() {
//        return "Prodotto{" +
//                "tipo=" + getTipo() +
//                ", produttore='" + getProduttore() + '\'' +
//                ", modello='" + getModello() + '\'' +
//                ", descrizione='" + getDescrizione() + '\'' +
//                ", dimDisplay=" + getDimDisplay() +
//                ", dimMemoria=" + getDimMemoria() +
//                ", prezzoAcquisto=" + getPrezzoAcquisto() +
//                ", prezzoVendita=" + getPrezzoVendita() +
//                ", id='" + getId() + '\'' +
//                '}' + "\n " ;
//    }
}
