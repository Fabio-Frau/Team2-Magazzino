package SceltaOperazione;
import Input.*;
import Magazzino.*;
import Prodotti.Prodotto;
import Prodotti.TipoProdotto;
import Ricerca.RicercaPerTipo;

import java.util.ArrayList;


public class Cliente{
    public static void operazioniCliente(ArrayList<Prodotto> magazzino) {

        System.out.println("Tipo di prodotto cercato: " +
                "\n 1. Smartphone" + "\n 2. Tablet" + "\n 3. NoteBook" + "\n 4. Qualsiasi");

        int sceltaUtente = Input.readInt();

        switch (sceltaUtente) {
            case 1: {
                RicercaPerTipo.RicercaSmartohone(magazzino);

                break;
            }
            case 2: {
                System.out.println("Tablet:\n"  );
                // break;
            }
            case 3: {
                System.out.println("NoteBook:\n" + TipoProdotto.NOTEBOOK);
                // break;
            }
            case 4: {
                //gestore();
                // break;
            }
        }
    }
}
