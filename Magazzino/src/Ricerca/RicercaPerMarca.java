package Ricerca;

import Prodotti.Prodotto;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class RicercaPerMarca {
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
}
