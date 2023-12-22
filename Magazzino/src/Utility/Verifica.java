package Utility;

import Carrello.Carrello;
import DBManager.DbRicercaProdotto;
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

    public static Carrello getCarreloFromCarrelli(ArrayList<Carrello> carrelli, int idcarrelo) {
        for (Carrello carrelo : carrelli) {
            if (carrelo.getIdcarrello() == idcarrelo) {
                return carrelo;
            }
        }
        return null;
    }

    public static boolean checkPresenzaProdottoInCarrello(Carrello carrello, int idprodotto) {
        for(Prodotto prodotto : carrello.getCarrello()) {
            if (prodotto.getId() == idprodotto) {
                return true;
            }
        }
        return false;
    }

    public static Boolean disponibilitaProdottiCarrello(Carrello carrello) {
        for (Prodotto prodotto : carrello.getCarrello()) {
            if (!DbRicercaProdotto.checkDisponibilitaProdotto(prodotto.getId())) {
                return false;
            }
        }
        return true;
    }

}
