package Carrello;

import Magazzino.Magazzino;
import Prodotti.Prodotto;
import Utility.Input;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class gestioneCarrello {
    public static Map<OffsetDateTime, ArrayList<Prodotto>> recVendita = new LinkedHashMap<>();


    public static void operazioniCarrello( Magazzino magazzino, Carrello carrello, ArrayList<Prodotto> tmp){
        // tmp è l'arraylist temporaneo con cui gestisco gli ordini del carrello
        boolean b = true;
        while (b){
            System.out.println("Seleziona l'operazione da eseguire:\n " +
                    "1. Visualizzare il carrello \n" +
                    "2. Aggiungere un prodotto al carrello\n"+
                    "3. Rimuovere un prodotto dal carrello\n" +
                    "4. Svuotare il carrello\n" +
                    "5. Calcolare la spesa totale\n" +
                    "6. Concludere l'ordine\n"
            );
            int opCar = Input.readInt();
            switch (opCar){
                case 1:
                    System.out.println(carrello);
                    break;
                case 2: // aggiungere prodottto
                    break;
                case 3 :
                    //Rimuovere prodotto
                    break;
                case 4 :
                    // Svuotare il carrello
                    carrello.getCarrello().clear();
                    break;
                case 5 :
                    // calcola tot
                    break;
                case 6:
                    // concludere ordine
                    break;
            }

            // proseguire le operazioni o tornare al menu
            boolean s = true;
            while (s){
                System.out.println("Scegli l'operazione da eseguire:\n" +
                        "1. Per continuare\n " + "2. Per tornare al menù precedente");
                int i = Input.readInt();
                switch (i){
                case 1 :
                    b = true;
                    s = false;
                    break;
                case 2:
                    b = false;
                    s = false;
                    break;
                    default: {
                        System.out.println("Scelta non valida, riprovare");
                        break;
                    }
                }
            }
        }
    }


}


