package Prodotti;

import Utility.Input;

import java.math.BigDecimal;
import java.util.ArrayList;

/*abstract si o no?*/
public class Prodotto {

    protected TipoProdotto tipo;

    private String produttore;
    private String modello;
    private String descrizione;
    private double dimDisplay;
    private int dimMemoria;
    private BigDecimal prezzoAcquisto;
    private BigDecimal prezzoVendita;
    private int id;

    public Prodotto() {
        setTipo();
        setProduttore();
        setModello();
        setDescrizione();
        setDimDisplay();
        setDimMemoria();
        setPrezzoAcquisto();
        setPrezzoVendita();

    }

    public Prodotto(TipoProdotto tipo, String produttore, String modello, int id, String descrizione,
                    double dimDisplay, int dimMemoria, BigDecimal prezzoAcquisto, BigDecimal prezzoVendita) {
        this.tipo = tipo;
        this.produttore = produttore;
        this.modello = modello;
        this.id = id;
        this.descrizione = descrizione;
        this.dimDisplay = dimDisplay;
        this.dimMemoria = dimMemoria;
        this.prezzoAcquisto = prezzoAcquisto;
        this.prezzoVendita = prezzoVendita;
    }

    public void setTipo(TipoProdotto tipo) {
        this.tipo = tipo;
    }

    public void setTipo() {
        System.out.println("Categoria: ");
        this.tipo = Input.readTipo();
    }

    public TipoProdotto getTipo() {
        return tipo;
    }


    public String getProduttore() {
        return produttore;
    }

    public void setProduttore() {
        System.out.println("Produttore:");
        this.produttore = Utility.Input.readStr();
    }

    public void setProduttore(String produttore) {
        this.produttore = produttore;
    }

    public String getModello() {
        return modello;
    }

    public void setModello() {
        System.out.println("Modello:");
        this.modello = Utility.Input.readStr();
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione() {
        System.out.println("Descrizione:");
        this.descrizione = Utility.Input.readStr();
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public double getDimDisplay() {
        return dimDisplay;
    }

    public void setDimDisplay() {
        System.out.println("Dimensione display:");
        this.dimDisplay = Utility.Input.readDouble();
    }

    public void setDimDisplay(double dimDisplay) {
        this.dimDisplay = dimDisplay;
    }

    public int getDimMemoria() {
        return dimMemoria;
    }

    public void setDimMemoria() {
        System.out.println("Dimensione memoria:");
        this.dimMemoria = Utility.Input.readInt();
    }

    public void setDimMemoria(int dimMemoria) {
        this.dimMemoria = dimMemoria;
    }

    public BigDecimal getPrezzoAcquisto() {
        return prezzoAcquisto;
    }

    public void setPrezzoAcquisto() {
        System.out.println("Prezzo di acquisto:");
        this.prezzoAcquisto = Utility.Input.readBigD();
    }

    public void setPrezzoAcquisto(BigDecimal prezzoAcquisto) {
        this.prezzoAcquisto = prezzoAcquisto;
    }

    public BigDecimal getPrezzoVendita() {
        return prezzoVendita;
    }

    public void setPrezzoVendita() {
        System.out.println("Prezzo di vendita:");
        this.prezzoVendita = Utility.Input.readBigD();
    }

    public void setPrezzoVendita(BigDecimal prezzoVendita) {
        this.prezzoVendita = prezzoVendita;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        System.out.println("ID:");
        this.id = Utility.Input.readInt();
    }

    public void setId(int id) {
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
}
