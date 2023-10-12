package Prodotti;

public class Smartphone extends Prodotto{

    public Smartphone(){
        super();
        this.tipo = TipoProdotto.SMARTPHONE;
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
