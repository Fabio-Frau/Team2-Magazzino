package SceltaOperazione;
import Ricerca.*;
import Utility.*;
import Magazzino.*;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Gestore {
    private Magazzino magazzino;

    public Gestore(Magazzino magazzino) {
        this.magazzino = magazzino;
    }

    public void operazioniGestore() {

        // AGGIUNGERE GESTIONE ECCEZIONI


        System.out.println("Operazione da eseguire" +
                "\n 1. Lettura prodotti in magazzino" + "\n 2. Ricerca Prodotto" + "\n 3. Aggiunta Prodotti");

        int sceltaUtente = Input.readInt();

        switch (sceltaUtente) {
            case 1: {
                Stampa.perGestore(magazzino.getListaProdotti());
                break;
            }
            case 2: {
                sceltaRicercheGestore();
                break;
            }
            case 3: {

                // break;
            }

        }
    }

    public void sceltaRicercheGestore () {
        System.out.println("Opzioni disponibili" +
                "\n 1. Ricerca per produttore" + "\n 2. Ricerca per modello" + "\n 3. Ricerca per ID" +
                "\n 4. Ricerca per dimensione display" + "\n 5. Ricerca per dimensione memoria" +
                "6. Ricerca per prezzo d'acquisto" +
                "\n 7. Ricerca per prezzo di vendita");

        int sceltaUtente = Input.readInt();
        switch (sceltaUtente) {
            case 1: {
                String marca = Input.readStr();
                Stampa.perGestore(RicercaPerMarca.ricercaPerMarca(magazzino.getListaProdotti(), marca));
                break;
            }
            case 2: {
                String modello = Input.readStr();
                Stampa.perGestore(RicercaPerModello.ricercaPerModello(magazzino.getListaProdotti(), modello));
                break;
            }
            case 3: {
                String id = Input.readStr();
                Stampa.perGestore(RicercaPerID.ricercaPerID(magazzino.getListaProdotti(), id));
                break;
            }
            case 4: {
                double min = Input.readDouble();
                double max = Input.readDouble();
                Stampa.perGestore(RicercaPerDimSchermo.ricercaDimSchermo(magazzino.getListaProdotti(), min, max));
                break;
            }
            case 5: {
                int min = Input.readInt();
                int max = Input.readInt();
                Stampa.perGestore(RicercaPerDimMemoria.ricercaDimMemoria(magazzino.getListaProdotti(), min, max));
                break;
            }
            case 6: {
                BigDecimal [] range = RangeUtils.DoubleRangeBD();
                Stampa.perGestore(RicercaPerPrezzo.RicercaPerPrezzoAcquisto(magazzino.getListaProdotti(), range));
                break;
            }
            case 7: {
                BigDecimal [] range = RangeUtils.DoubleRangeBD();
                Stampa.perGestore(RicercaPerPrezzo.RicercaPerPrezzoVendita(magazzino.getListaProdotti(), range));
                break;
            }
            default: {
                System.out.println("Scelta non valida.");
                break;
            }
        }
    }
}
