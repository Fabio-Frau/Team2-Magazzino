package Ricerca;
import Prodotti.Prodotto;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class RicercaPerMarca {
    public static ArrayList<Prodotto> ricercaPerMarca(ArrayList<Prodotto> magazzino, String marca) {
        ArrayList<Prodotto> listaProdottoMarca = new ArrayList<>();
        for (Prodotto prodotto : magazzino) {
            if (prodotto.getProduttore().equalsIgnoreCase(marca)) {
                listaProdottoMarca.add(prodotto);
            }
        }
        return listaProdottoMarca;
    }

    public static String sceltaMarca() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserire la marca: ");
        String marca = sc.nextLine().toLowerCase();
        return marca;
    }
}
