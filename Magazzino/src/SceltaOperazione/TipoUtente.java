package SceltaOperazione;
import Utility.*;
import Prodotti.Prodotto;

import java.util.ArrayList;


public class TipoUtente {

    public static void sceltaUtente(ArrayList<Prodotto>magazzino) {


        // aggiunta exception

        System.out.println("Tipo di utente:\n 1. Cliente \n 2. Gestore");

        int tipoUtente = Input.readInt();

        switch (tipoUtente) {
            case 1: {
                Cliente.operazioniCliente(magazzino);
                break;
            }
            case 2: {
               Gestore.operazioniGestore();
               break;
            }

        }
    }
}

