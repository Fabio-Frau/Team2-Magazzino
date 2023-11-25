package SceltaOperazione;
import Magazzino.Magazzino;
import Ricerca.*;
import Utility.*;

import java.math.BigDecimal;


public class InterfacciaCliente {
    private static Magazzino magazzino;

    public InterfacciaCliente(Magazzino magazzino) {
        this.magazzino = magazzino;
    }
    public static void sceltaRicercheCliente() {

        System.out.println("Opzioni disponibili" +
                "\n 1. Ricerca per produttore" + "\n 2. Ricerca per modello" + "\n 3. Ricerca per ID" +
                "\n 4. Ricerca per dimensione display" + "\n 5. Ricerca per dimensione memoria" +
                "\n 6. Ricerca per prezzo di vendita");

        int sceltaUtente = Input.readInt();

        switch (sceltaUtente) {
            case 1: {
                System.out.println("Inserisci la marca del prodotto cercato:");
                String marca = Input.readStr();
                Verifica.checkResultsCliente(RicercaPerMarca.ricercaPerMarca(magazzino.getListaProdotti(), marca));
                break;
            }
            case 2: {
                System.out.println("Inserisci il modello del prodotto cercato:");
                String modello = Input.readStr();
                Verifica.checkResultsCliente(RicercaPerModello.ricercaPerModello(magazzino.getListaProdotti(), modello));
                break;
            }
            case 3: {
                System.out.println("Inserisci l'id del prodotto: ");
                String id = Input.readStr();
                Verifica.checkResultsCliente(RicercaPerID.ricercaPerID(magazzino.getListaProdotti(), id));
                break;
            }
            case 4: {
                System.out.println("Inserisci la dimensioni dello schermo: (pollici) ");
                double min = Input.readDouble();
                double max = Input.readDouble();
                Verifica.checkResultsCliente(RicercaPerDimSchermo.ricercaDimSchermo(magazzino.getListaProdotti(), min, max));
                break;
            }
            case 5: {
                System.out.println("Inserisci la dimensione della memoria del dispositivo: (GB) ");
                int min = Input.readInt();
                int max = Input.readInt();
                Verifica.checkResultsCliente(RicercaPerDimMemoria.ricercaDimMemoria(magazzino.getListaProdotti(), min, max));
                break;
            }
            case 6: {
                System.out.println("Inserisci la fascia di prezzo: (€)");
                BigDecimal[] range = RangeUtils.DoubleRangeBD();
                Verifica.checkResultsCliente((RicercaPerPrezzo.RicercaPerPrezzoVendita(magazzino.getListaProdotti(), range)));
                break;
            }
            default: {
                System.out.println("Scelta non valida.");
                break;
            }
        }
    }
}
