package Ricerca;

import Prodotti.Prodotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RicercaPerModello {
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
}
