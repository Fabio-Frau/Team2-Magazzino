package Ricerca;
import Utility.Input;
import Prodotti.*;
import Utility.Stampa;


import java.util.ArrayList;

public class RicercaPerTipo {

    public static void sceltaTipo (ArrayList<Prodotto> magazzino) {

        System.out.println("Tipo di prodotto ricercato: \n 1. Smartphone \n 2. Tablet \n 3. Notebook");
        int choose = Input.readInt();

        switch (choose) {
            case 1: {
                RicercaPerTipo.RicercaSmartphone(magazzino);
                break;
            }
            case 2: {
                RicercaPerTipo.RicercaTablet(magazzino);
                break;
            }
            case 3: {
                RicercaPerTipo.RicercaNotebook(magazzino);
                break;
            }
            case 4: {
                RicercaPerTipo.RicercaSmartphone(magazzino);
                RicercaPerTipo.RicercaTablet(magazzino);
                RicercaPerTipo.RicercaNotebook(magazzino);
            }
        }
    }
    public static void RicercaTablet (ArrayList<Prodotto> magazzino) {
        ArrayList<Prodotto> listaProdottoCercato = new ArrayList<>();
        for (Prodotto prodotto : magazzino) {
            if (prodotto.getTipo() == TipoProdotto.TABLET) {
                listaProdottoCercato.add(prodotto);
            }
        }
        System.out.println(TipoProdotto.TABLET);
        Stampa.PerCliente(listaProdottoCercato);
    }

    public static void RicercaSmartphone (ArrayList<Prodotto> magazzino) {
        ArrayList<Prodotto> listaProdottoCercato = new ArrayList<>();
        for (Prodotto prodotto : magazzino) {
            if (prodotto.getTipo() == TipoProdotto.SMARTPHONE) {
                listaProdottoCercato.add(prodotto);
            }
        }
        System.out.println(TipoProdotto.SMARTPHONE);
        Stampa.PerCliente(listaProdottoCercato);
        //return listaProdottoCercato;
    }

    public static void RicercaNotebook (ArrayList<Prodotto> magazzino) {
        ArrayList<Prodotto> listaProdottoCercato = new ArrayList<>();
        for (Prodotto prodotto : magazzino) {
            if (prodotto.getTipo() == TipoProdotto.NOTEBOOK) {
                listaProdottoCercato.add(prodotto);
            }
        }
        System.out.println(TipoProdotto.NOTEBOOK);
        Stampa.PerCliente(listaProdottoCercato);
    }

}
