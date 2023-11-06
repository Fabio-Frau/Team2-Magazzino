package Ricerca;

import Prodotti.Prodotto;
import Prodotti.TipoProdotto;
import Utility.Choose;
import Utility.Input;
import Utility.Range;
import Utility.Stampa;

import java.util.*;

public class Ricerche {
    public static ArrayList<Prodotto> ricercaDimSchermo(ArrayList<Prodotto> magazzino ) {

        double[] rng = range();

        ArrayList<Prodotto> listaProdottoCercato = new ArrayList<Prodotto>();

        for (Prodotto prodotto : magazzino) {
            if (prodotto.getDimDisplay()>=rng[0] && prodotto.getDimDisplay()<= rng[1]) {
                listaProdottoCercato.add(prodotto);
            }
        }

        stampaPerCliente(listaProdottoCercato);

        return listaProdottoCercato;
    }
    public static double[] range(){
        System.out.println("Inserire la fascia di prezzo: ");
        double[] range = new double[2];
        for(int i = 0; i < range.length; i++){
            range[i] = Input.readInt();
        }
        Arrays.sort(range);
        return range;
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

    public static void ricercaPerMarca(ArrayList<Prodotto> magazzino) {
        ArrayList<Prodotto> listaProdottoMarca = new ArrayList<>();
        //input marca dell utente
        String marcaUtente = sceltaMarca();
        //aggiungo alla listaProdottoMarca tutti i dispositivi della marca inserita dall utente all interno del magazzino
        for (Prodotto prodotto : magazzino) {
            if (prodotto.getProduttore().toLowerCase().equals(marcaUtente)) {
                listaProdottoMarca.add(prodotto);
            }
        }
        //stampo i prodotti di quella marca
        for (Prodotto prodotto : listaProdottoMarca) {
            System.out.println(prodotto);
        }
        //se la marca non e presente
        if (listaProdottoMarca.isEmpty()) {
            System.out.println("Marca inserita non presente in magazzino");
        }
    }
    public static String sceltaMarca() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserire la marca: ");
        String marca = sc.nextLine().toLowerCase();
        return marca;
    }

    public static void ricercaRangePrezzo (ArrayList<Prodotto> magazzino) {
        System.out.println("Inserire la fascia di prezzo: ");
        double[] rng = Range.DoubleRange();
        RicercaPerPrezzo(magazzino,rng);

        Choose.ContinuaRicercaCliente(magazzino);
    }
    public static void RicercaPerPrezzo (ArrayList<Prodotto> magazzino, double[] rng) {
        ArrayList<Prodotto> listaProdottoCercato = new ArrayList<>();
        for (Prodotto prodotto : magazzino) {
            if (prodotto.getPrezzoVendita() >= rng[0] && prodotto.getPrezzoVendita() <= rng[1]) {
                listaProdottoCercato.add(prodotto);
            }
        }
        listaProdottoCercato.sort(Comparator.comparingDouble(Prodotto::getPrezzoVendita));
        Stampa.PerCliente(listaProdottoCercato);
    }

    public static void ricercaPerModello(ArrayList<Prodotto> magazzino) {
        ArrayList<Prodotto> listaProdottoModello = new ArrayList<>();
        //input modello dell utente
        String modelloUtente = sceltaModello();
        //aggiungo alla listaProdottoModello tutti i dispositivi del modello inserito dall utente all interno del magazzino
        for (Prodotto prodotto : magazzino) {
            //lista che contiene ogni stringa del modello
            List<String> modelloSplit = Arrays.asList(prodotto.getModello().toLowerCase().split(" "));
            if (modelloSplit.contains(modelloUtente)) {
                listaProdottoModello.add(prodotto);
            }
        }
        //stampo i prodotti di quella marca
        for (Prodotto prodotto : listaProdottoModello) {
            System.out.println(prodotto);
        }
        //se la marca non e presente
        if (listaProdottoModello.isEmpty()) {
            System.out.println("Modello inserito non presente in magazzino");
        }
    }
    public static String sceltaModello() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserire il modello: ");
        String modello = sc.nextLine().toLowerCase();
        return modello;
    }

    public static void sceltaTipo (ArrayList<Prodotto> magazzino) {

        System.out.println("Tipo di prodotto ricercato: \n 1. Smartphone \n 2. Tablet \n 3. Notebook");
        int choose = Input.readInt();

        switch (choose) {
            case 1: {
                Ricerche.RicercaSmartphone(magazzino);
                break;
            }
            case 2: {
                Ricerche.RicercaTablet(magazzino);
                break;
            }
            case 3: {
                Ricerche.RicercaNotebook(magazzino);
                break;
            }
            case 4: {
                Ricerche.RicercaSmartphone(magazzino);
                Ricerche.RicercaTablet(magazzino);
                Ricerche.RicercaNotebook(magazzino);
            }
        }

        Choose.ContinuaRicercaCliente(magazzino);
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

    public static ArrayList<Prodotto> ricercaDimMemoria(ArrayList<Prodotto> magazzino) {
        int memoriaMax = 0;
        int memoriaMin = 0;
        inserisciDimMemoriaMaxMin(memoriaMax, memoriaMin);
        ArrayList<Prodotto> listaProdottiRangeMemoria = new ArrayList<>();
        for (Prodotto prodotto : magazzino) {
            if(prodotto.getDimMemoria() > memoriaMin && prodotto.getDimMemoria() < memoriaMax) {
                listaProdottiRangeMemoria.add(prodotto);
            }
        }
        return listaProdottiRangeMemoria;
    }
    public static void inserisciDimMemoriaMaxMin(int max, int min) {
        System.out.println("Inserire dimensione massima: ");
        max = Input.readInt();
        System.out.println("Inserire dimensione minima: ");
        min = Input.readInt();
    }
}
