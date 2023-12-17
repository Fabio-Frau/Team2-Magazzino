package SceltaOperazione;

import DBManager.DbDelete;
import DBManager.DbInsert;
import DBManager.DbRicercaProdotto;
import Login.Gestore;
import Magazzino.Magazzino;
import Prodotti.Prodotto;
import Prodotti.TipoProdotto;
import Ricerca.*;
import Utility.Input;
import Utility.RangeUtils;
import Utility.Stampa;
import Utility.Verifica;

import java.math.BigDecimal;

public class InterfacciaGestoreDB {
    public static void operazioniGestore(Gestore gestore) {

        opGestore : while(true) {
            System.out.println("Benvenuto GESTORE. Scegli l'operazione da eseguire:" +
                    "\n 1. Visualizza prodotti in magazzino" +
                    "\n 2. Ricerca Prodotto" +
                    "\n 3. Aggiunta Prodotto" +
                    "\n 4. Eliminazione Prodotto" +
                    "\n 5. Visualizza Prodotti Venditore" +
                    "\n 0. Torna al menu di Login");

            int sceltaUtente = Input.readInt();

            switch (sceltaUtente) {
                case 1: {
                    Verifica.checkResultsGestore(DbRicercaProdotto.ricercaTuttiProdotti());
                    break;
                }
                case 2: {
                    sceltaRicercheGestore();
                    break;
                }
                case 3: {
                    //aggiungere parametro per inserire prodotti multipli
                    Prodotto prodotto = new Prodotto();
                    DbInsert.insertProdottoIntoProdotto(prodotto, gestore);
                    break;
                }
                case 4: {
                    System.out.println("Digita l'ID del prodotto che vuoi eliminare dal magazzino:");
                    int id = Input.readInt();
                    DbDelete.deleteProdottoVenditore(id, gestore);
                    break;
                }
                case 5: {
                    Verifica.checkResultsGestore(DbRicercaProdotto.ricercaPerVenditore(gestore));
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

    public static void sceltaRicercheGestore() {

        ricGestore : while(true) {
            System.out.println("Opzioni disponibili" +
                    "\n 1. Ricerca per produttore" + "\n 2. Ricerca per modello" + "\n 3. Ricerca per ID" +
                    "\n 4. Ricerca per dimensione display" + "\n 5. Ricerca per dimensione memoria" +
                    "\n 6. Ricerca per prezzo d'acquisto" + "\n 7. Ricerca per prezzo di vendita" +
                    "\n 8. Ricerca per tipo di prodotto" + "\n 0. Ritorna al menu scelta operazioni gestore.");

            int sceltaUtente = Input.readInt();
            switch (sceltaUtente) {
                case 1: {
                    System.out.println("Inserisci la marca del prodotto cercato:");
                    String marca = Input.readStr();
                    Verifica.checkResultsGestore(DbRicercaProdotto.ricercaPerProduttore(marca));
                    break;
                }
                case 2: {
                    System.out.println("Inserisci il modello del prodotto cercato:");
                    String modello = Input.readStr();
                    Verifica.checkResultsGestore(DbRicercaProdotto.ricercaPerModello(modello));
                    break;
                }
                case 3: {
                    System.out.println("Inserisci l'id del prodotto: ");
                    int id = Input.readInt();
                    Verifica.checkResultsGestore(DbRicercaProdotto.ricercaPerID(id));
                    break;
                }
                case 4: {
                    System.out.println("Inserisci la fascia di dimensioni dello schermo: (pollici) ");
                    double[] minAndMax = RangeUtils.DoubleRange();
                    double min = minAndMax[0];
                    double max = minAndMax[1];
                    Verifica.checkResultsGestore(DbRicercaProdotto.ricercaPerDimensioneSchermo(min, max));
                    break;
                }
                case 5: {
                    System.out.println("Inserisci la fascia di dimensione della memoria del dispositivo: (GB) ");
                    int[] minAndMax = Input.readIntSort();
                    int min = minAndMax[0];
                    int max = minAndMax[1];
                    Verifica.checkResultsGestore(DbRicercaProdotto.ricercaPerMemoria(min, max));
                    break;
                }
                case 6: {
                    System.out.println("Inserisci la fascia di prezzo: (€)");
                    BigDecimal[] range = RangeUtils.DoubleRangeBD();
                    Verifica.checkResultsGestore(DbRicercaProdotto.ricercaPerPrezzoAcquisto(range[0], range[1]));
                    break;
                }
                case 7: {
                    System.out.println("Inserisci la fascia di prezzo: (€)");
                    BigDecimal[] range = RangeUtils.DoubleRangeBD();
                    Verifica.checkResultsGestore(DbRicercaProdotto.ricercaPerPrezzoVendita(range[0], range[1]));
                    break;
                }
                case 8: {
                    System.out.println("Inserisci il tipo di prodotto: ");
                    TipoProdotto tipo = Input.readTipo();
                    Verifica.checkResultsGestore(DbRicercaProdotto.ricercaPerCategoria(tipo));
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
