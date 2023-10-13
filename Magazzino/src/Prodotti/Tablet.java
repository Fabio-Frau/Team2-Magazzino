package Prodotti;

public class Tablet extends Prodotto {

    public Tablet(){
        super();
        this.tipo = TipoProdotto.TABLET;
    }

    public Tablet(String produttore, String modello, String id, String descrizione, double dimDisplay, int dimMemoria, double prezzoAcquisto, double prezzoVendita) {
        super(produttore, modello, id, descrizione, dimDisplay, dimMemoria, prezzoAcquisto, prezzoVendita);
        this.tipo = TipoProdotto.TABLET;
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "tipo=" + getTipo() +
                ", produttore='" + getProduttore() + '\'' +
                ", modello='" + getModello() + '\'' +
                ", descrizione='" + getDescrizione() + '\'' +
                ", dimDisplay=" + getDimDisplay() +
                ", dimMemoria=" + getDimMemoria() +
                ", prezzoAcquisto=" + getPrezzoAcquisto() +
                ", prezzoVendita=" + getPrezzoVendita() +
                ", id='" + getId() + '\'' +
                '}';
    }

}
