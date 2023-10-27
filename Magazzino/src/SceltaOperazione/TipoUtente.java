package SceltaOperazione;
import Magazzino.*;
import Input.*;
import Prodotti.Prodotto;
import Prodotti.Tablet;
import Prodotti.TipoProdotto;

import java.util.ArrayList;
import java.util.Scanner;


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

