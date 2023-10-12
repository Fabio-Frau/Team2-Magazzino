package Magazzino;

import Prodotti.Notebook;
import Prodotti.Smartphone;
import Prodotti.Tablet;
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


}
