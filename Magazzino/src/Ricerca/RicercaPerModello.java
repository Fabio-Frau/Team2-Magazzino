package Ricerca;
import Prodotti.Prodotto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RicercaPerModello {
    public static ArrayList<Prodotto> ricercaPerModello(ArrayList<Prodotto> magazzino, String modello) {
        ArrayList<Prodotto> listaProdottoModello = new ArrayList<>();
        for (Prodotto prodotto : magazzino) {
            List<String> modelloSplit = Arrays.asList(prodotto.getModello().toLowerCase().split(" "));
            if (modelloSplit.contains(modello)) {
                listaProdottoModello.add(prodotto);
            }
        }
        return listaProdottoModello;
    }

    public static String sceltaModello() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserire il modello: ");
        String modello = sc.nextLine().toLowerCase();
        return modello;
    }
}
