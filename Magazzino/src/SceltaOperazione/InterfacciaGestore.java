package SceltaOperazione;
import Ricerca.*;
import Utility.*;
import Magazzino.*;
import Prodotti.*;

import java.math.BigDecimal;
import java.util.ArrayList;

public class InterfacciaGestore {

    public static void operazioniGestore(Magazzino magazzino) {

        opGestore : while(true) {
            System.out.println("Benvenuto GESTORE. Scegli l'operazione da eseguire:" +
                    "\n 1. Lettura prodotti in magazzino" +
                    "\n 2. Ricerca Prodotto" +
                    "\n 3. Aggiunta Prodotto" +
                    "\n 4. Eliminazione Prodotto" +
                    "\n 0. Torna al menu di Login");

            int sceltaUtente = Input.readInt();

            switch (sceltaUtente) {
                case 1: {
                    Stampa.perGestore(magazzino.getListaProdotti());
                    break;
                }
                case 2: {
                    sceltaRicercheGestore(magazzino);
                    break;
                }
                case 3: {
                    Prodotto prodotto = new Prodotto();
                    magazzino.aggiungiProdotto(prodotto);
                    Stampa.perGestore(magazzino.getListaProdotti());
                    break;
                }
                case 4: {
                    Stampa.perGestore(magazzino.getListaProdotti());
                    System.out.println("Digita l'ID del prodotto che vuoi eliminare dal magazzino:");
                    String id = Input.readStr();
                    magazzino.rimuoviProdottoPerID(id);
                    Stampa.perGestore(magazzino.getListaProdotti());
                    break;
                }
                case 0: {
                    break opGestore;
                }
                default:
                    System.out.println("Scelta non valida.");
                    break;
            }
        }



    }

    public static void sceltaRicercheGestore(Magazzino magazzino) {

        ricGestore : while(true) {
            System.out.println("Opzioni disponibili" +
                    "\n 1. Ricerca per produttore" + "\n 2. Ricerca per modello" + "\n 3. Ricerca per ID" +
                    "\n 4. Ricerca per dimensione display" + "\n 5. Ricerca per dimensione memoria" +
                    "\n 6. Ricerca per prezzo d'acquisto" + "\n 7. Ricerca per prezzo di vendita" +
                    "\n0. Ritorna al menu scelta operazioni gestore.");

            int sceltaUtente = Input.readInt();
            switch (sceltaUtente) {
                case 1: {
                    System.out.println("Inserisci la marca del prodotto cercato:");
                    String marca = Input.readStr();
                    Verifica.checkResultsGestore(RicercaPerMarca.ricercaPerMarca(magazzino.getListaProdotti(), marca));
                    break;
                }
                case 2: {
                    System.out.println("Inserisci il modello del prodotto cercato:");
                    String modello = Input.readStr();
                    Verifica.checkResultsGestore(RicercaPerModello.ricercaPerModello(magazzino.getListaProdotti(), modello));
                    break;
                }
                case 3: {
                    System.out.println("Inserisci l'id del prodotto: ");
                    String id = Input.readStr();
                    Verifica.checkResultsGestore(RicercaPerID.ricercaPerID(magazzino.getListaProdotti(), id));
                    break;
                }
                case 4: {
                    System.out.println("Inserisci la dimensioni dello schermo: (pollici) ");
                    double[] minAndMax = RangeUtils.DoubleRange();
                    double min = minAndMax[0];
                    double max = minAndMax[1];
                    Verifica.checkResultsGestore(RicercaPerDimSchermo.ricercaDimSchermo(magazzino.getListaProdotti(), min, max));
                    break;
                }
                case 5: {
                    System.out.println("Inserisci la fascia di dimensione della memoria del dispositivo: (GB) ");
                    int[] minAndMax = Input.readIntSort();
                    int min = minAndMax[0];
                    int max = minAndMax[1];
                    Verifica.checkResultsGestore(RicercaPerDimMemoria.ricercaDimMemoria(magazzino.getListaProdotti(),min,max));
                    break;
                }
                case 6: {
                    System.out.println("Inserisci la fascia di prezzo: (€)");
                    BigDecimal[] range = RangeUtils.DoubleRangeBD();
                    Verifica.checkResultsGestore((RicercaPerPrezzo.RicercaPerPrezzoAcquisto(magazzino.getListaProdotti(), range)));
                    break;
                }
                case 7: {
                    System.out.println("Inserisci la fascia di prezzo: (€)");
                    BigDecimal[] range = RangeUtils.DoubleRangeBD();
                    Verifica.checkResultsGestore((RicercaPerPrezzo.RicercaPerPrezzoVendita(magazzino.getListaProdotti(), range)));
                    break;
                }
                case 0: {
                    break ricGestore;
                }
                default: {
                    System.out.println("Scelta non valida.");
                    break;
                }
            }
        }

    }



}
