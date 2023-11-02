package Prodotti;

import java.util.ArrayList;

/*abstract si o no?*/
public class Prodotto {

    protected TipoProdotto tipo;

    private String produttore;
    private String modello;
    private String descrizione;
    private double dimDisplay;
    private int dimMemoria;
    private double prezzoAcquisto;
    private double prezzoVendita;
    private String id;

    public Prodotto() {
        /*Id mi da problemi se lo metto alla fine, che sia perchè prima faccio
        scanner di double con try catch, non mi consuma bene il token*/
        //setTipo();
        setProduttore();
        setModello();
        setId();
        setDescrizione();
        setDimDisplay();
        setDimMemoria();
        setPrezzoAcquisto();
        setPrezzoVendita();

    }

    public Prodotto(TipoProdotto tipo, String produttore, String modello, String id, String descrizione,
                    double dimDisplay, int dimMemoria, double prezzoAcquisto, double prezzoVendita) {
        setProduttore(produttore);
        setModello(modello);
        setId(id);
        setDescrizione(descrizione);
        setDimDisplay(dimDisplay);
        setDimMemoria(dimMemoria);
        setPrezzoAcquisto(prezzoAcquisto);
        setPrezzoVendita(prezzoVendita);
    }

    public TipoProdotto getTipo() {
        return tipo;
    }


    public String getProduttore() {
        return produttore;
    }

    public void setProduttore() {
        System.out.println("Produttore:");
        this.produttore = InputProdotti.readString();
    }

    public void setProduttore(String produttore) {
        this.produttore = produttore;
    }

    public String getModello() {
        return modello;
    }

    public void setModello() {
        System.out.println("Modello:");
        this.modello = InputProdotti.readString();
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione() {
        System.out.println("Descrizione:");
        this.descrizione = InputProdotti.readString();
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public double getDimDisplay() {
        return dimDisplay;
    }

    public void setDimDisplay() {
        System.out.println("Dimensione display:");
        this.dimDisplay = InputProdotti.readDouble();
    }

    public void setDimDisplay(double dimDisplay) {
        this.dimDisplay = dimDisplay;
    }

    public int getDimMemoria() {
        return dimMemoria;
    }

    public void setDimMemoria() {
        System.out.println("Dimensione memoria:");
        this.dimMemoria = InputProdotti.readInt();
    }

    public void setDimMemoria(int dimMemoria) {
        this.dimMemoria = dimMemoria;
    }

    public double getPrezzoAcquisto() {
        return prezzoAcquisto;
    }

    public void setPrezzoAcquisto() {
        System.out.println("Prezzo di acquisto:");
        this.prezzoAcquisto = InputProdotti.readDouble();
    }

    public void setPrezzoAcquisto(double prezzoAcquisto) {
        this.prezzoAcquisto = prezzoAcquisto;
    }

    public double getPrezzoVendita() {
        return prezzoVendita;
    }

    public void setPrezzoVendita() {
        System.out.println("Prezzo di vendita:");
        this.prezzoVendita = InputProdotti.readDouble();
    }

    public void setPrezzoVendita(double prezzoVendita) {
        this.prezzoVendita = prezzoVendita;
    }

    public String getId() {
        return id;
    }

    public void setId() {
        System.out.println("ID:");
        this.id = InputProdotti.readString();
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                //"tipo=" + tipo +
                "  produttore='" + produttore + '\'' +
                ", modello='" + modello + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", dimDisplay=" + dimDisplay +
                ", dimMemoria=" + dimMemoria +
                ", prezzoAcquisto=" + prezzoAcquisto +
                ", prezzoVendita=" + prezzoVendita +
                ", id='" + id + '\'' +
                '}';
    }

//    public String stampaPerCliente(){
//        return produttore + ", " + modello + "\n Caratteristiche: display " + dimDisplay + ", memoria " +
//                dimMemoria + ", prezzo " + prezzoVendita;
//    }

    /*qualche campo deve essere final?
    * getter and setter, tutti i setter o alcune cose non modificabili?*/
}
