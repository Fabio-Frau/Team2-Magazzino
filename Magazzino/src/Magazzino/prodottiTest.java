package Magazzino;
import Prodotti.*;
import java.util.ArrayList;



public class prodottiTest {
    public ArrayList<Tablet> listaTablet = new ArrayList<Tablet>();
    public ArrayList<Smartphone> listaSmartphone = new ArrayList<Smartphone>();

    public ArrayList<Notebook> listaNotebook = new ArrayList<Notebook>();

    public ArrayList<Prodotto> listaProdotti = new ArrayList<>();



    public prodottiTest() {

        listaTablet.add(tablet1);
        listaTablet.add(tablet2);
        listaTablet.add(tablet3);


        listaSmartphone.add(smartp1);
        listaSmartphone.add(smartp2);
        listaSmartphone.add(smartp3);


        listaNotebook.add(note1);
        listaNotebook.add(note2);
        listaNotebook.add(note3);

        listaProdotti.addAll(listaNotebook);
        listaProdotti.addAll(listaSmartphone);
        listaProdotti.addAll(listaTablet);

    }

    Tablet tablet1 = new Tablet("Samsung", "Galaxy Tab S6 Lite", "TabS6", "con pen in dotazione",
            10.4, 128, 120.00, 298.00);

    Tablet tablet2 = new Tablet("Samsung", "Galaxy Tab A7 Lite", "TabA7", "economico",
            8.7, 64, 60, 119.00);

    Tablet tablet3 = new Tablet("Lenovo", "Tab M10", "LM10", "miglior rapporto qualità prezzo",
            10.6, 128, 150, 229);



    ////////////////////////////////////////////////////////////////////////////////////////////////////
    Smartphone smartp1 = new Smartphone("Samsung", "Galaxy A54", "SMA54", "superofferta",
            6.4, 256, 250, 529.00);

    Smartphone smartp2 = new Smartphone("Samsung", "Galaxy S23 Ultra", "SS23", "top di gamma",
            6.8, 256, 450.00, 999.00);

    Smartphone smartp3 = new Smartphone("Xiaomi", "Redmi Note 12 Pro", "XRN12p", "best buy",
            6.67, 256, 200, 339.9);

/////////////////////////////////////////////////////////////////////////////////////////////////////////////
    Notebook note1 = new Notebook("MSI", "GF 63 A54", "MSIGF63", "Serie Gaming",
            15.6, 1000, 980, 1699.00);

    Notebook note2 = new Notebook("Lenovo", "Legion 5 Pro", "LenLegion5", "best buy",
            16, 512, 780.00, 1499.00);

    Notebook note3 = new Notebook("Asus", "TUf G F15", "AsusF15", " ",
            15.6, 512, 940.00, 1399.00);


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
