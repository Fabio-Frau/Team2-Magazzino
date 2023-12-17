package SceltaOperazione;

import Carrello.Carrello;
import DBManager.DbRicercaProdotto;
import Login.Cliente;
import Login.Utente;
import Magazzino.Magazzino;
import Prodotti.Prodotto;
import Prodotti.TipoProdotto;
import Ricerca.*;
import Utility.Input;
import Utility.RangeUtils;
import Utility.Stampa;
import Utility.Verifica;

import java.math.BigDecimal;
import java.util.ArrayList;

public class InterfacciaClienteDB {
    public static void operazioniCliente(Cliente cliente) {

        Carrello carrello = new Carrello(new ArrayList<Prodotto>());
        //Magazzino magTemp = magazzino.clone();

        opCliente : while (true) {
            System.out.println("Seleziona l'operazione da eseguire:\n" +
                    "1. Lettura prodotti in magazzino\n" +
                    "2. Ricerca Prodotto\n" +
                    "3. Visualizzare il carrello \n" +
                    "4. Aggiungere un prodotto al carrello\n" +
                    "5. Rimuovere un prodotto dal carrello\n" +
                    "6. Svuotare il carrello\n" +
                    "7. Calcolare la spesa totale\n" +
                    "8. Concludere l'ordine\n" +
                    "0. Ritorna al menu di Login"
            );

            int sceltaUtente = Input.readInt();
            switch (sceltaUtente) {
                case 1: {
                    Verifica.checkResultsCliente(DbRicercaProdotto.ricercaTuttiProdotti());
                    break;
                }
                case 2: {
                    sceltaRicercheCliente();
                    break;
                }
                case 3: {
                    Stampa.perCliente(carrello.getCarrello());
                    break;
                }
                case 4: {
                    System.out.println("Inserisci l'ID del prodotto da aggiungere al carrello");
                    /*String id = Input.readStr();
                    Prodotto aggiunta = magTemp.rimuoviProdottoPerID(id);
                    if( aggiunta != null) {
                        carrello.aggiungiProdotto(aggiunta);
                        Stampa.perCliente(carrello.getCarrello());
                    } else {
                        System.out.println("Il prodotto selezionato non è presente in magazzino.");
                    }*/
                    break;
                }
                case 5: {
                    System.out.println("Inserisci l'ID del prodotto da rimuovere dal carrello");
                    /*String id =Input.readStr();
                    Prodotto rimozione = carrello.rimuoviProdottoPerID(id);
                    if (rimozione != null) {
                        magTemp.aggiungiProdotto(rimozione);
                        Stampa.perCliente(carrello.getCarrello());
                    } else {
                        System.out.println("Il prodotto selezionato non è presente nel carrello");
                    }*/
                    break;
                }
                case 6: {
                    carrello.getCarrello().clear();
                    System.out.println("Carrello svuotato");
                    break;
                }
                case 7: {
                    System.out.println("Il prezzo totale del carrello é di ");
                    System.out.println(carrello.getPrezzoTotale());
                    break;
                }
                case 8: {
                    /*if (magazzino.checkAvailability(carrello.getCarrello())) {
                        magazzino.rimuoviListaProdotti(carrello.getCarrello());
                        magTemp.getListaProdotti().clear();
                        carrello.getCarrello().clear(); //salvare la transazione da qualche parte
                    }*/

                }
                case 0: {
                    break opCliente;
                }
            }
        }
    }


    public static void sceltaRicercheCliente() {

        ricCliente : while (true) {
            System.out.println("Opzioni disponibili" +
                    "\n 1. Ricerca per produttore" + "\n 2. Ricerca per modello" + "\n 3. Ricerca per ID" +
                    "\n 4. Ricerca per dimensione display" + "\n 5. Ricerca per dimensione memoria" +
                    "\n 6. Ricerca per prezzo di vendita" + "\n 7. Ricerca per tipo di prodotto" +
                    "\n 0. Ritorna al menu scelta operazioni cliente.");

            int sceltaUtente = Input.readInt();
            switch (sceltaUtente) {
                case 1: {
                    System.out.println("Inserisci la marca del prodotto cercato:");
                    String marca = Input.readStr();
                    Verifica.checkResultsCliente(DbRicercaProdotto.ricercaPerProduttore(marca));
                    break;
                }
                case 2: {
                    System.out.println("Inserisci il modello del prodotto cercato:");
                    String modello = Input.readStr();
                    Verifica.checkResultsCliente(DbRicercaProdotto.ricercaPerModello(modello));
                    break;
                }
                case 3: {
                    System.out.println("Inserisci l'id del prodotto: ");
                    int id = Input.readInt();
                    Verifica.checkResultsCliente(DbRicercaProdotto.ricercaPerID(id));
                    break;
                }
                case 4: {
                    System.out.println("Inserisci la fascia di dimensioni dello schermo: (pollici) ");
                    double[] minAndMax = RangeUtils.DoubleRange();
                    double min = minAndMax[0];
                    double max = minAndMax[1];
                    Verifica.checkResultsCliente(DbRicercaProdotto.ricercaPerDimensioneSchermo(min, max));
                    break;
                }
                case 5: {
                    System.out.println("Inserisci la fascia di dimensione della memoria del dispositivo: (GB) ");
                    int[] minAndMax = Input.readIntSort();
                    int min = minAndMax[0];
                    int max = minAndMax[1];
                    Verifica.checkResultsCliente(DbRicercaProdotto.ricercaPerMemoria(min, max));
                    break;
                }
                case 6: {
                    System.out.println("Inserisci la fascia di prezzo: (€)");
                    BigDecimal[] range = RangeUtils.DoubleRangeBD();
                    Verifica.checkResultsCliente(DbRicercaProdotto.ricercaPerPrezzoVendita(range[0], range[1]));
                    break;
                }
                case 7: {
                    System.out.println("Inserisci il tipo di prodotto: ");
                    TipoProdotto tipo = Input.readTipo();
                    Verifica.checkResultsCliente(DbRicercaProdotto.ricercaPerCategoria(tipo));
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
