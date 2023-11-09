package Prodotti;

import java.math.BigDecimal;

public class Tablet extends Prodotto {

    public Tablet(){
        super();
        this.tipo = TipoProdotto.TABLET;
    }

    public Tablet(TipoProdotto tipo, String produttore, String modello, String id, String descrizione,
                  double dimDisplay, int dimMemoria, BigDecimal prezzoAcquisto, BigDecimal prezzoVendita) {
        super(tipo, produttore, modello, id, descrizione, dimDisplay, dimMemoria, prezzoAcquisto, prezzoVendita);
        this.tipo = TipoProdotto.TABLET;
    }
}
