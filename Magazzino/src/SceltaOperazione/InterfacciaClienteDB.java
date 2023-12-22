package SceltaOperazione;
import Carrello.Carrello;
import DBManager.*;
import Login.Cliente;
import Prodotti.TipoProdotto;
import Utility.Input;
import Utility.RangeUtils;
import Utility.Stampa;
import Utility.Verifica;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;

public class InterfacciaClienteDB {



    public static void operazioniCliente(Cliente cliente) {

        ArrayList<Carrello> carrelliCliente = DbRicercaCarrelloCliente.getProdottiCarrelliCliente(cliente);

        opCliente : while (true) {
            System.out.println("Seleziona l'operazione da eseguire:\n" +
                    "1. Lettura prodotti in magazzino\n" +
                    "2. Ricerca Prodotto\n" +
                    "3. Visualizzare i carrelli \n" +
                    "4. Aggiungere un prodotto al carrello\n" +
                    "5. Rimuovere un prodotto dal carrello\n" +
                    "6. Svuotare il carrello\n" +
                    "7. Calcolare la spesa totale\n" +
                    "8. Concludere l'ordine\n" +
                    "9. Crea nuovo carrello\n" +
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
                    Stampa.carrelliPerCliente(carrelliCliente);
                    break;
                }
                case 4: {
                    System.out.println("Inserisci l'ID del prodotto da aggiungere al carrello");
                    int id_prodotto = Input.readInt();

                    if (DbRicercaProdotto.checkDisponibilitaProdotto(id_prodotto)) {
                        System.out.println("Inserisci l'ID del carrello");
                        int id_carrello = Input.readInt();
                        if (Verifica.checkAppartenenzaCarrelloCliente(carrelliCliente, id_carrello)) {
                            DbInsert.insertProdottoCarrello(id_prodotto, id_carrello);
                            carrelliCliente = DbRicercaCarrelloCliente.getProdottiCarrelliCliente(cliente);
                        } else {
                            System.out.println("Carrello non appartenente al cliente");
                        }
                    } else {
                        System.out.println("Prodotto non disponibile");
                    }

                    break;
                }
                case 5: {
                    System.out.println("Inserisci l'ID del carrello");
                    int id_carrello =Input.readInt();
                    if (Verifica.checkAppartenenzaCarrelloCliente(carrelliCliente, id_carrello)) {
                        Carrello carrello = Verifica.getCarreloFromCarrelli(carrelliCliente, id_carrello);
                        System.out.println("Inserisci l'ID del prodotto da rimuovere dal carrello");
                        int id_prodotto =Input.readInt();
                        if (Verifica.checkPresenzaProdottoInCarrello(carrello, id_prodotto)) {
                            DbDelete.deleteProdottoCarrello(id_prodotto, id_carrello, cliente);
                            carrelliCliente = DbRicercaCarrelloCliente.getProdottiCarrelliCliente(cliente);
                        } else {
                            System.out.println("Prodotto non presente nel carrello");
                        }
                    } else {
                        System.out.println("Carrello non appartenente al cliente");
                    }

                    break;
                }
                case 6: {
                    System.out.println("Inserisci l'ID del carrello");
                    int id_carrello =Input.readInt();
                    if (Verifica.checkAppartenenzaCarrelloCliente(carrelliCliente, id_carrello)) {
                        DbDelete.svuotaCarrello(id_carrello, cliente);
                        carrelliCliente = DbRicercaCarrelloCliente.getProdottiCarrelliCliente(cliente);
                    } else {
                        System.out.println("Carrello non appartenente al cliente");
                    }

                    break;
                }
                case 7: {
                    System.out.println("Seleziona carrello di cui calcolare il totale");
                    int id_carrello =Input.readInt();
                    if (Verifica.checkAppartenenzaCarrelloCliente(carrelliCliente, id_carrello)){
                        Carrello carrello = Verifica.getCarreloFromCarrelli(carrelliCliente, id_carrello);
                        carrello.getPrezzoTotale();
                        System.out.println("Il costo totale del carrelo " + carrello.getIdcarrello() + " è di " + carrello.getPrezzoTotale());
                    } else {
                        System.out.println("Carrello non appartentente al cliente");
                    }
                                        ;
                    break;
                }
                case 8: {
                    System.out.println("Seleziona carrello che vuoi acquistare: ");
                    int id_carrello =Input.readInt();
                    if (Verifica.checkAppartenenzaCarrelloCliente(carrelliCliente, id_carrello)) {
                        Carrello carrello = Verifica.getCarreloFromCarrelli(carrelliCliente, id_carrello);
                        if (Verifica.disponibilitaProdottiCarrello(carrello)) {
                            Integer id_ordine = DbInsert.insertOrdine(cliente.getId(), OffsetDateTime.now());
                            DbInsert.insertFromCarrelloToDettaglioOrdine(carrello, id_ordine);
                            DbDelete.svuotaCarrello(id_carrello, cliente);
                            carrelliCliente = DbRicercaCarrelloCliente.getProdottiCarrelliCliente(cliente);
                        } else {
                            System.out.println("Alcuni prodotti presenti nel carrello non sono più disponibili");
                        }
                    } else {
                        System.out.println("Carrello non appartenente al cliente");
                    }
                    break ;
                }
                case 9: {
                    DbInsert.insertCarrelloCliente(cliente.getId());
                    carrelliCliente = DbRicercaCarrelloCliente.getProdottiCarrelliCliente(cliente);
                    break;
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
