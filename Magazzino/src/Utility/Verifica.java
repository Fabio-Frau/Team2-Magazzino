package Utility;

import Carrello.Carrello;
import Prodotti.Prodotto;

import java.util.ArrayList;

public class Verifica {

    public static void checkResultsGestore(ArrayList<Prodotto> prodotto){
        if (prodotto.isEmpty()){
            System.out.println("La ricerca non ha prodotto alcun risultato.");
        }
        else{
            Stampa.perGestore(prodotto);
        }
    }

    public static void checkResultsCliente(ArrayList<Prodotto> prodotto){
        if (prodotto.isEmpty()){
            System.out.println("La ricerca non ha prodotto alcun risultato.");
        }
        else{
            Stampa.perCliente(prodotto);
        }
    }

    public static boolean checkAppartenenzaCarrelloCliente(ArrayList<Carrello> carrelli, int idcarrelo) {
        for (Carrello carrello : carrelli) {
            if (carrello.getIdcarrello() == idcarrelo) {
                return true;
            }
        }
        return false;
    }

}
