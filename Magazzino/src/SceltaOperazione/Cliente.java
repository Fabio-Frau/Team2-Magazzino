package SceltaOperazione;
import Utility.*;
import Prodotti.Prodotto;
import Ricerca.RicercaPerPrezzo;
import Ricerca.RicercaPerTipo;

import java.util.ArrayList;


public class Cliente{
    public static void operazioniCliente(ArrayList<Prodotto> magazzino) {

        System.out.println("Quale azioni vuoi compiere?" +
                "\n 1. Ricerca per tipo di prodotto" + "\n 2. Ricerca per fascia di prezzo" + "\n 3. Ricerca per Marca" +
                "\n 4. Ricerca per dimensione schermo" +
                "\n 5. Ricerca per dimensione memoria");

        int sceltaUtente = Input.readInt();

        switch (sceltaUtente) {
            case 1: {
                RicercaPerTipo.sceltaTipo(magazzino);
                break;
            }
            case 2: {
                RicercaPerPrezzo.ricercaRangePrezzo(magazzino);
                break;
            }

        }


    }
}
