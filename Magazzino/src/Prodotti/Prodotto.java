package Prodotti;

/*abstract si o no?*/
public class Prodotto {

    private TipoProdotto tipo;
    private String produttore;
    private String modello;
    private String descrizione;
    private double dimDisplay;
    private double dimMemoria;
    private double prezzoAcquisto;
    private double prezzoVendita;
    private String id;

    public Prodotto() {
        /*Id mi da problemi se lo metto alla fine, che sia perchè prima faccio
        scanner di double con try catch, non mi consuma bene il token*/


        setTipo();
        setProduttore();
        setModello();
        setId();
        setDescrizione();
        setDimDisplay();
        setDimMemoria();
        setPrezzoAcquisto();
        setPrezzoVendita();

    }

    public TipoProdotto getTipo() {
        return tipo;
    }

    public void setTipo() {
        this.tipo = InputProdotti.readTipo();
    }

    public String getProduttore() {
        return produttore;
    }

    public void setProduttore() {
        System.out.println("Produttore:");
        this.produttore = InputProdotti.readString();
    }

    public String getModello() {
        return modello;
    }

    public void setModello() {
        System.out.println("Modello:");
        this.modello = InputProdotti.readString();
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione() {
        System.out.println("Descrizione:");
        this.descrizione = InputProdotti.readString();
    }

    public double getDimDisplay() {
        return dimDisplay;
    }

    public void setDimDisplay() {
        System.out.println("Dimensione display:");
        this.dimDisplay = InputProdotti.readDouble();
    }

    public double getDimMemoria() {
        return dimMemoria;
    }

    public void setDimMemoria() {
        System.out.println("Dimensione memoria:");
        this.dimMemoria = InputProdotti.readDouble();
    }

    public double getPrezzoAcquisto() {
        return prezzoAcquisto;
    }

    public void setPrezzoAcquisto() {
        System.out.println("Prezzo di acquisto:");
        this.prezzoAcquisto = InputProdotti.readDouble();
    }

    public double getPrezzoVendita() {
        return prezzoVendita;
    }

    public void setPrezzoVendita() {
        System.out.println("Prezzo di vendita:");
        this.prezzoVendita = InputProdotti.readDouble();
    }

    public String getId() {
        return id;
    }

    public void setId() {
        System.out.println("ID:");
        this.id = InputProdotti.readString();
    }



    /*qualche campo deve essere final?
    * getter and setter, tutti i setter o alcune cose non modificabili?*/
}
