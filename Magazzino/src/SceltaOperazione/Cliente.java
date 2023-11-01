package SceltaOperazione;
import Input.*;
import Magazzino.*;
import Prodotti.Prodotto;
import Prodotti.TipoProdotto;
import Ricerca.RicercaPerMarca;
import Ricerca.RicercaPerModello;
import Ricerca.RicercaPerTipo;

import java.util.ArrayList;


public class Cliente{
    public static void operazioniCliente(ArrayList<Prodotto> magazzino) {

        System.out.println("Quale azioni vuoi compiere?" +
                "\n 1. Ricerca per tipo di prodotto" + "\n 2. Ricerca per Marca" + "\n 3. Ricerca per dimensione schermo" +
                "\n 4. Ricerca per dimensione memoria" + "\n 5. Ricerca per modello");

        int sceltaUtente = Input.readInt();

        switch (sceltaUtente) {
            case 1: {
                RicercaPerTipo.sceltaTipo(magazzino);
                break;
            }
            case 2: {
                RicercaPerMarca.ricercaPerMarca(magazzino);
                break;
            }
            case 5: {
                RicercaPerModello.ricercaPerModello(magazzino);
                break;
            }

        }


    }
}
