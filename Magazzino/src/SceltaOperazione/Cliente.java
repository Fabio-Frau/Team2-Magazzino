package SceltaOperazione;
import Magazzino.Magazzino;
import Ricerca.*;
import Utility.*;
import Prodotti.Prodotto;
import Prodotti.TipoProdotto;
import java.math.BigDecimal;
import java.util.ArrayList;


public class Cliente{

    private static Magazzino magazzino;

    public Cliente(Magazzino magazzino) {
        this.magazzino = magazzino;
    }

//    public static void operazioniCliente() {
//
//        System.out.println("Quale azioni vuoi compiere?" +
//
//                "\n 1. Ricerca per tipo di prodotto" + "\n 2. Ricerca per Prezzo di Vendita" +
//                "\n 3. Ricerca per Marca" + "\n 4. Ricerca per modello"
//                +"\n 5. Ricerca per dimensione schermo" +
//                "\n 6. Ricerca per dimensione memoria" );
//
//
//        int sceltaUtente = Input.readInt();
//
//        switch (sceltaUtente) {
//            case 1: {
//                RicercaPerTipo.sceltaTipo(magazzino);
//                break;
//            }
//            case 2: {
//                RicercaPerPrezzo.ricercaRangePrezzoVendita(magazzino);
//                break;
//            }
//            case 3: {
//                RicercaPerMarca.ricercaPerMarca(magazzino, "marca");
//                break;
//            }
//            case 4: {
//                RicercaPerModello.ricercaPerModello(magazzino,"modello");
//                break;
//            }
//            case 5: {
//
//                RicercaPerDimSchermo.ricercaDimSchermo(magazzino,13.5,14.5);
//                break;
//            }
//            case 6: {
//                RicercaPerDimMemoria.ricercaDimMemoria(magazzino,1,2);
//                break;
//            }
//        }
//    }

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
                Stampa.perCliente(RicercaPerMarca.ricercaPerMarca(magazzino.getListaProdotti(), marca));
                break;
            }
            case 2: {
                System.out.println("Inserisci il modello del prodotto cercato:");
                String modello = Input.readStr();
                Stampa.perCliente(RicercaPerModello.ricercaPerModello(magazzino.getListaProdotti(), modello));
                break;
            }
            case 3: {
                System.out.println("Inserisci l'id del prodotto: ");
                String id = Input.readStr();
                Stampa.perCliente(RicercaPerID.ricercaPerID(magazzino.getListaProdotti(), id));
                break;
            }
            case 4: {
                System.out.println("Inserisci la dimensioni dello schermo: (pollici) ");
                double min = Input.readDouble();
                double max = Input.readDouble();
                Stampa.perCliente(RicercaPerDimSchermo.ricercaDimSchermo(magazzino.getListaProdotti(), min, max));
                break;
            }
            case 5: {
                System.out.println("Inserisci la dimensione della memoria del dispositivo: (GB) ");
                int min = Input.readInt();
                int max = Input.readInt();
                Stampa.perCliente(RicercaPerDimMemoria.ricercaDimMemoria(magazzino.getListaProdotti(),min,max));
                break;
            }
            case 6: {
                System.out.println("Inserisci la fascia di prezzo: (€)");
                BigDecimal[] range = RangeUtils.DoubleRangeBD();
                Stampa.perCliente((RicercaPerPrezzo.RicercaPerPrezzoAcquisto(magazzino.getListaProdotti(), range)));
                break;
            }
            case 7: {
                System.out.println("Inserisci la fascia di prezzo: (€)");
                BigDecimal[] range = RangeUtils.DoubleRangeBD();
                Stampa.perCliente((RicercaPerPrezzo.RicercaPerPrezzoVendita(magazzino.getListaProdotti(), range)));
                break;
            }
            default: {
                System.out.println("Scelta non valida.");
                break;
            }
        }
        Choose.continuaRicercaCliente();
    }
}
