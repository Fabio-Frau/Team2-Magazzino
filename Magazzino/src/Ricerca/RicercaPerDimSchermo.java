package Ricerca;

import Prodotti.InputProdotti;
import Prodotti.Prodotto;
import Utility.Input;

import java.util.ArrayList;
import java.util.Arrays;

public class RicercaPerDimSchermo {

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

}
