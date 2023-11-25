package DataSample;
import Prodotti.*;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ProdottiSample {

    public static ArrayList<Prodotto> prodottiBase () {

        ArrayList<Prodotto> listaProdotti = new ArrayList<>();

        Tablet tablet1 = new Tablet(TipoProdotto.TABLET, "Samsung", "Galaxy Tab S6 Lite", "TabS6", "con pen in dotazione",
                10.4, 128, BigDecimal.valueOf(120.00), BigDecimal.valueOf(298.00));

        Tablet tablet2 = new Tablet(TipoProdotto.TABLET, "Samsung", "Galaxy Tab A7 Lite", "TabA7", "economico",
                8.7, 64, BigDecimal.valueOf(60), BigDecimal.valueOf(119.00));

        Tablet tablet3 = new Tablet(TipoProdotto.TABLET, "Lenovo", "Tab M10", "LM10", "miglior rapporto qualità prezzo",
                10.6, 128, BigDecimal.valueOf(150), BigDecimal.valueOf(229));
        ////////////////////////////////////////////////////////////////////////////////////////////////////
        Smartphone smartp1 = new Smartphone(TipoProdotto.SMARTPHONE, "Samsung", "Galaxy A54", "SMA54", "superofferta",
                6.4, 256, BigDecimal.valueOf(250), BigDecimal.valueOf(529.00));

        Smartphone smartp2 = new Smartphone(TipoProdotto.SMARTPHONE, "Samsung", "Galaxy S23 Ultra", "SS23", "top di gamma",
                6.8, 256, BigDecimal.valueOf(450.00), BigDecimal.valueOf(999.00));

        Smartphone smartp3 = new Smartphone(TipoProdotto.SMARTPHONE, "Xiaomi", "Redmi Note 12 Pro", "XRN12p", "best buy",
                6.67, 256, BigDecimal.valueOf(200), BigDecimal.valueOf(339.9));
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Notebook note1 = new Notebook(TipoProdotto.NOTEBOOK, "MSI", "GF 63 A54", "MSIGF63", "Serie Gaming",
                15.6, 1000, BigDecimal.valueOf(980), BigDecimal.valueOf(1699.00));

        Notebook note2 = new Notebook(TipoProdotto.NOTEBOOK, "Lenovo", "Legion 5 Pro", "LenLegion5", "best buy",
                16, 512, BigDecimal.valueOf(780.00), BigDecimal.valueOf(1499.00));

        Notebook note3 = new Notebook(TipoProdotto.NOTEBOOK, "Asus", "TUf G F15", "AsusF15", " ",
                15.6, 512, BigDecimal.valueOf(940.00), BigDecimal.valueOf(1399.00));
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
