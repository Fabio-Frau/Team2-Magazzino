package SceltaOperazione;
import Ricerca.*;
import Utility.*;
import Prodotti.Prodotto;
import Prodotti.TipoProdotto;

import java.util.ArrayList;


public class Cliente{
    public static void operazioniCliente(ArrayList<Prodotto> magazzino) {

        System.out.println("Quale azioni vuoi compiere?" +

                "\n 1. Ricerca per tipo di prodotto" + "\n 2. Ricerca per Prezzo di Vendita" +
                "\n 3. Ricerca per Marca" + "\n 4. Ricerca per modello"
                +"\n 5. Ricerca per dimensione schermo" +
                "\n 6. Ricerca per dimensione memoria" );


        int sceltaUtente = Input.readInt();

        switch (sceltaUtente) {
            case 1: {
                RicercaPerTipo.sceltaTipo(magazzino);
                break;
            }
            case 2: {
                RicercaPerPrezzo.ricercaRangePrezzoVendita(magazzino);
                break;
            }
            case 3: {
                RicercaPerMarca.ricercaPerMarca(magazzino, "marca");
                break;
            }
            case 4: {
                RicercaPerModello.ricercaPerModello(magazzino,"modello");
                break;
            }
            case 5: {

                RicercaPerDimSchermo.ricercaDimSchermo(magazzino,13.5,14.5);
                break;
            }
            case 6: {
                RicercaPerDimMemoria.ricercaDimMemoria(magazzino,1,2);
                break;
            }
        }
    }
}
