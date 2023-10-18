package Magazzino;


import Prodotti.*;
import java.util.ArrayList;

public class Magazzino {

    private ArrayList<Tablet> listaTablet = new ArrayList<Tablet>();
    private ArrayList<Notebook> listaNotebook = new ArrayList<Notebook>();
    private ArrayList<Smartphone> listaSmartphone = new ArrayList<Smartphone>();

    public void stampaMagazzino() {
        for (Tablet tablet : listaTablet)
        {
            System.out.println(tablet.toString());
        }
        for (Notebook notebook : listaNotebook)
        {
            System.out.println(notebook.toString());;
        }
        for (Smartphone smartphone : listaSmartphone)
        {
            System.out.println(smartphone.toString());
        }
    }

    public ArrayList<Tablet> getListaTablet() {
        return listaTablet;
    }

    public void setListaTablet(ArrayList<Tablet> listaTablet) {
        this.listaTablet = listaTablet;
    }

    public ArrayList<Notebook> getListaNotebook() {
        return listaNotebook;
    }

    public void setListaNotebook(ArrayList<Notebook> listaNotebook) {
        this.listaNotebook = listaNotebook;
    }

    public ArrayList<Smartphone> getListaSmartphone() {
        return listaSmartphone;
    }

    public void setListaSmartphone(ArrayList<Smartphone> listaSmartphone) {
        this.listaSmartphone = listaSmartphone;
    }

    //metodo di ricerca prodotto per tipo
    public static ArrayList<Prodotto> ricercaProdotto(ArrayList<Prodotto> listaProdotti, TipoProdotto tipoProdotto) {
        //array che conterra il prodotto cercato (TABLET o SMARTHPHONE o NOTEBOOK)
        ArrayList<Prodotto> listaProdottoCercato = new ArrayList<>();
        for (Prodotto prodotto : listaProdotti) {
            if (prodotto.getTipo() == tipoProdotto) {
                listaProdottoCercato.add(prodotto);
            }
        }
        return listaProdottoCercato;
    }

}
