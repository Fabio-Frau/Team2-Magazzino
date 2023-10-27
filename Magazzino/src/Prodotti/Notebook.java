package Prodotti;

public class Notebook extends Prodotto {

    public Notebook(){
        super();
        this.tipo = TipoProdotto.NOTEBOOK;
    }
    public Notebook(TipoProdotto tipo, String produttore, String modello, String id, String descrizione,
                    double dimDisplay, int dimMemoria, double prezzoAcquisto, double prezzoVendita) {
        super(tipo ,produttore, modello, id, descrizione, dimDisplay, dimMemoria, prezzoAcquisto, prezzoVendita);
        this.tipo = TipoProdotto.NOTEBOOK;
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
