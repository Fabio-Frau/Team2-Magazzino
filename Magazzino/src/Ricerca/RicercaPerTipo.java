package Ricerca;
import SceltaOperazione.Cliente;
import Utility.Choose;
import Utility.Input;
import Prodotti.*;
import Utility.Stampa;


import java.util.ArrayList;

public class RicercaPerTipo {

    public static void sceltaTipo (ArrayList<Prodotto> magazzino) {

        System.out.println("Tipo di prodotto ricercato: \n 1. Smartphone \n 2. Tablet \n 3. Notebook \n 4. Lista prodotti:");
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

        Choose.ContinuaRicercaCliente(magazzino);
    }
    public static ArrayList<Prodotto> RicercaTablet (ArrayList<Prodotto> magazzino) {
        ArrayList<Prodotto> listaProdottoCercato = new ArrayList<>();
        for (Prodotto prodotto : magazzino) {
            if (prodotto.getTipo() == TipoProdotto.TABLET) {
                listaProdottoCercato.add(prodotto);
            }
        }
        return listaProdottoCercato;
    }

    public static ArrayList<Prodotto> RicercaSmartphone (ArrayList<Prodotto> magazzino) {
        ArrayList<Prodotto> listaProdottoCercato = new ArrayList<>();
        for (Prodotto prodotto : magazzino) {
            if (prodotto.getTipo() == TipoProdotto.SMARTPHONE) {
                listaProdottoCercato.add(prodotto);
            }
        }
        return listaProdottoCercato;
    }

    public static ArrayList<Prodotto> RicercaNotebook (ArrayList<Prodotto> magazzino) {
        ArrayList<Prodotto> listaProdottoCercato = new ArrayList<>();
        for (Prodotto prodotto : magazzino) {
            if (prodotto.getTipo() == TipoProdotto.NOTEBOOK) {
                listaProdottoCercato.add(prodotto);
            }
        }
        return listaProdottoCercato;
    }



}
