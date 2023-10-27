package Magazzino;
import Prodotti.*;
import java.util.ArrayList;

public class ProdottiTest {

    public static ArrayList<Prodotto> prodottiBase(ArrayList<Prodotto> listaProdotti) {


        Tablet tablet1 = new Tablet(TipoProdotto.TABLET, "Samsung", "Galaxy Tab S6 Lite", "TabS6", "con pen in dotazione",
                10.4, 128, 120.00, 298.00);

        Tablet tablet2 = new Tablet(TipoProdotto.TABLET, "Samsung", "Galaxy Tab A7 Lite", "TabA7", "economico",
                8.7, 64, 60, 119.00);

        Tablet tablet3 = new Tablet(TipoProdotto.TABLET, "Lenovo", "Tab M10", "LM10", "miglior rapporto qualità prezzo",
                10.6, 128, 150, 229);
        ////////////////////////////////////////////////////////////////////////////////////////////////////
        Smartphone smartp1 = new Smartphone(TipoProdotto.SMARTPHONE, "Samsung", "Galaxy A54", "SMA54", "superofferta",
                6.4, 256, 250, 529.00);

        Smartphone smartp2 = new Smartphone(TipoProdotto.SMARTPHONE, "Samsung", "Galaxy S23 Ultra", "SS23", "top di gamma",
                6.8, 256, 450.00, 999.00);

        Smartphone smartp3 = new Smartphone(TipoProdotto.SMARTPHONE, "Xiaomi", "Redmi Note 12 Pro", "XRN12p", "best buy",
                6.67, 256, 200, 339.9);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Notebook note1 = new Notebook(TipoProdotto.NOTEBOOK, "MSI", "GF 63 A54", "MSIGF63", "Serie Gaming",
                15.6, 1000, 980, 1699.00);

        Notebook note2 = new Notebook(TipoProdotto.NOTEBOOK, "Lenovo", "Legion 5 Pro", "LenLegion5", "best buy",
                16, 512, 780.00, 1499.00);

        Notebook note3 = new Notebook(TipoProdotto.NOTEBOOK, "Asus", "TUf G F15", "AsusF15", " ",
                15.6, 512, 940.00, 1399.00);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////


        listaProdotti.add(tablet1);
        listaProdotti.add(tablet2);
        listaProdotti.add(tablet3);
        listaProdotti.add(smartp1);
        listaProdotti.add(smartp2);
        listaProdotti.add(smartp3);
        listaProdotti.add(note1);
        listaProdotti.add(note2);
        listaProdotti.add(note3);

        return listaProdotti;

    }
}
