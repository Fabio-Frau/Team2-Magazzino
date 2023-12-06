package Ricerca;
import Prodotti.Prodotto;
import Utility.Input;
import java.util.ArrayList;

public class RicercaPerDimMemoria {
    public static ArrayList<Prodotto> ricercaDimMemoria(ArrayList<Prodotto> magazzino,int min, int max) {
        ArrayList<Prodotto> listaProdottoCercato = new ArrayList<>();
        for (Prodotto prodotto : magazzino) {
            if(prodotto.getDimMemoria() >= min && prodotto.getDimMemoria() <= max) {
                listaProdottoCercato.add(prodotto);
            }
        }
        return listaProdottoCercato;
    }


}
