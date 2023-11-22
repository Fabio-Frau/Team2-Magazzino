package Carrello;
import Magazzino.*;
import Prodotti.*;
import Utility.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.*;



public class gestioneCarrello {
    public static Map<OffsetDateTime, ArrayList<Prodotto>> vendita = new LinkedHashMap<>();

    public static void operazioniCarrello(Magazzino magazzino, Carrello carrello, ArrayList<Prodotto> tmp) {

        System.out.println("Seleziona l'operazione da eseguire:\n " +
                "1. Visualizzare il carrello \n" +
                "2. Aggiungere un prodotto al carrello\n" +
                "3. Rimuovere un prodotto dal carrello\n" +
                "4. Svuotare il carrello\n" +
                "5. Calcolare la spesa totale\n" +
                "6. Concludere l'ordine\n"
        );

        int opCar = Input.readInt();
        switch (opCar) {
            case 1:
                Stampa.perCliente(carrello.getCarrello());
                //System.out.println(carrello);
                break;
            case 2: // aggiungere prodotto (per ID)
                String idProd = idProd();
                aggIDCarrello(tmp, carrello, idProd);
                break;
            case 3:
                //Rimuovere prodotto
                String idProd2 = idProd();
                rimuovi(carrello, tmp, idProd2);
                break;
            case 4:
                // Svuotare il carrello
                carrello.getCarrello().clear();
                break;
            case 5:
                // calcola tot
                totCarrello(carrello);
                break;
            case 6:
                // concludere ordine
                acquista(carrello, magazzino, tmp);
                break;
        }
    }

    public static String idProd(){
        System.out.println("Inserisci l'ID del prodotto che vuoi aggiungere al carrello:");
        return Input.readStr();
    }

    // Aggiunta prodotto al carrello
    public static ArrayList<Prodotto> aggIDCarrello (ArrayList<Prodotto> tmp, Carrello carrello, String idProd){
        ArrayList<Prodotto> carrelloTMP = new ArrayList<>();
        for ( int i = 0; i < tmp.size(); i++){
            if (tmp.get(i).getId().equals(idProd)){
                carrelloTMP.add(tmp.get(i));
                carrello.getCarrello().add(tmp.get(i));
                tmp.remove(tmp.get(i)); // Elimino il prodotto dal magazzino fittizio
            }
        }
        return carrelloTMP;
    }

    // Rimuovere prodotto tramite ID
    public static Carrello rimuovi (Carrello carrello, ArrayList<Prodotto> tmp, String idProd){
        // Aggiungere metodo di stampa del carrello
        for (int i = 0; i < carrello.getCarrello().size(); i++){
            if (carrello.getCarrello().get(i).getId().equals(idProd)){
                Prodotto prodTMP = carrello.getCarrello().get(i);
                carrello.getCarrello().remove(i);
                tmp.add(prodTMP); // riaggiungo il prodotto al magazzino fittizio
            }
        }
        return carrello;
    }

    //Calcoalre il tot
    public static BigDecimal totCarrello (Carrello carrello){
     BigDecimal tot = BigDecimal.ZERO;
     for (int i = 0; i < carrello.getCarrello().size(); i++) {
         tot = tot.add(carrello.getCarrello().get(i).getPrezzoVendita());
     }
        System.out.println("Totale del carrello:");
     return tot;
    }

    //Concludi ordine -> ACQUISTA
    public static ArrayList<Prodotto> acquista(Carrello carrello,Magazzino magazzino, ArrayList<Prodotto> tmp){
        ArrayList<Prodotto> ricevutaAcquisto = new ArrayList<>();
        for (int i = 0 ; i < carrello.getCarrello().size(); i++) {
            ricevutaAcquisto.add(carrello.getCarrello().get(i));
        }
        vendita.put(OffsetDateTime.now(), ricevutaAcquisto);

        for (Map.Entry<OffsetDateTime, ArrayList<Prodotto>> a : vendita.entrySet()){
            System.out.println(a);
            //Stampa.perCliente(new ArrayList<>(vendita.values().toArray()));

        }
        carrello.getCarrello().clear();
        magazzino.getListaProdotti().clear();
        magazzino.getListaProdotti().addAll(tmp);
        return ricevutaAcquisto;
    }
}

