package SceltaOperazione;
import Ricerca.Ricerche;
import Utility.*;
import Prodotti.Prodotto;

import java.util.ArrayList;


public class Cliente{
    public static void operazioniCliente(ArrayList<Prodotto> magazzino) {

        System.out.println("Quale azioni vuoi compiere?" +

                "\n 1. Ricerca per tipo di prodotto" + "\n 2. Ricerca per Marca" + "\n 3. Ricerca per dimensione schermo" +
                "\n 4. Ricerca per dimensione memoria" + "\n 5. Ricerca per modello");


        int sceltaUtente = Input.readInt();

        switch (sceltaUtente) {
            case 1: {
                Ricerche.sceltaTipo(magazzino);
                break;
            }
            case 2: {
                Ricerche.ricercaPerMarca(magazzino);
                break;
            }
            case 5: {
                Ricerche.ricercaPerModello(magazzino);
                break;
            }
        }
    }
}
