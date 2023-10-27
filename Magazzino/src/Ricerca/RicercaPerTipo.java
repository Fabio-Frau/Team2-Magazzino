package Ricerca;
import Input.Input;
import Prodotti.*;
import Magazzino.*;


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
        stampaPerCliente(listaProdottoCercato);
    }

    public static void RicercaSmartphone (ArrayList<Prodotto> magazzino) {
        ArrayList<Prodotto> listaProdottoCercato = new ArrayList<>();
        for (Prodotto prodotto : magazzino) {
            if (prodotto.getTipo() == TipoProdotto.SMARTPHONE) {
                listaProdottoCercato.add(prodotto);
            }
        }
        System.out.println(TipoProdotto.SMARTPHONE);
        stampaPerCliente(listaProdottoCercato);
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
        stampaPerCliente(listaProdottoCercato);
    }

    public static void stampaPerCliente(ArrayList<Prodotto> prodottoCercato){
        StringBuilder stampaProdotto = new StringBuilder();
        for (Prodotto prodotto : prodottoCercato){
            stampaProdotto.append(prodotto.getProduttore()).append(' ').append(prodotto.getModello()).append("\t Dimensione Display(pollici): ")
                    .append(prodotto.getDimDisplay()).append("\t Dimensione Memoria(GB): ").append(prodotto.getDimMemoria()).
                    append("\t Prezzo: ").append(prodotto.getPrezzoVendita()).append(" € \n");
        }
        System.out.println(stampaProdotto);

    }
}
