package Ricerca;
import Prodotti.Prodotto;
import Utility.Input;
import java.util.ArrayList;

public class RicercaPerDimMemoria {
    public static ArrayList<Prodotto> ricercaDimMemoria(ArrayList<Prodotto> magazzino,int min, int max) {
        ArrayList<Prodotto> listaProdottiRangeMemoria = new ArrayList<>();
        for (Prodotto prodotto : magazzino) {
            if(prodotto.getDimMemoria() >= min && prodotto.getDimMemoria() <= max) {
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
