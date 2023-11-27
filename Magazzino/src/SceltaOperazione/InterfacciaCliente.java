package SceltaOperazione;
import Magazzino.Magazzino;
import Ricerca.*;
import Utility.*;

import java.math.BigDecimal;


public class InterfacciaCliente {


    public static void sceltaRicercheCliente(Magazzino magazzino) {

        ricCliente : while (true) {
            System.out.println("Opzioni disponibili" +
                    "\n 1. Ricerca per produttore" + "\n 2. Ricerca per modello" + "\n 3. Ricerca per ID" +
                    "\n 4. Ricerca per dimensione display" + "\n 5. Ricerca per dimensione memoria" +
                    "\n 6. Ricerca per prezzo di vendita" + "\n 0. Ritorna al menu scelta operazioni cliente.");

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
                    System.out.println("Inserisci la fascia di dimensioni dello schermo: (pollici) ");
                    double[] minAndMax = RangeUtils.DoubleRange();
                    double min = minAndMax[0];
                    double max = minAndMax[1];
                    Verifica.checkResultsCliente(RicercaPerDimSchermo.ricercaDimSchermo(magazzino.getListaProdotti(), min, max));
                    break;
                }
                case 5: {
                    System.out.println("Inserisci la fascia di dimensione della memoria del dispositivo: (GB) ");
                    int[] minAndMax = Input.readIntSort();
                    int min = minAndMax[0];
                    int max = minAndMax[1];
                    Verifica.checkResultsCliente(RicercaPerDimMemoria.ricercaDimMemoria(magazzino.getListaProdotti(), min, max));
                    break;
                }
                case 6: {
                    System.out.println("Inserisci la fascia di prezzo: (€)");
                    BigDecimal[] range = RangeUtils.DoubleRangeBD();
                    Verifica.checkResultsCliente((RicercaPerPrezzo.ricercaPerPrezzoVendita(magazzino.getListaProdotti(), range)));
                    break;
                }
                case 0:
                    break ricCliente;
                default: {
                    System.out.println("Scelta non valida.");
                    break;
                }
            }
        }


    }
}
