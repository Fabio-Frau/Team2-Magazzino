package Prodotti;

public class Notebook extends Prodotto {

    public Notebook(){
        super();
        this.tipo = TipoProdotto.NOTEBOOK;
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
