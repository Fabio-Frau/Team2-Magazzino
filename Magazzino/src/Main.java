import Magazzino.*;
import Prodotti.InputProdotti;
import Prodotti.Prodotto;
import Prodotti.Tablet;
import Prodotti.TipoProdotto;

import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        //System.out.println(InputProdotti.readTipo());

        //System.out.println(InputProdotti.readString());

        //System.out.println(InputProdotti.readDouble());


        //Prodotto prodotto = new Prodotto();

//        Tablet tablet = new Tablet();
//
//        System.out.println(tablet.toString());

        //sceltaTipo();
//
//


        //sceltaOperazione();


        // TEST PRODOTTI IN MAGAZZINO


        prodottiTest ptest= new prodottiTest();
        Magazzino magazzino = new Magazzino();

        magazzino.setListaTablet(ptest.listaTablet);
        magazzino.setListaNotebook(ptest.listaNotebook);
        magazzino.setListaSmartphone(ptest.listaSmartphone);

        magazzino.stampaMagazzino();













    }

    public static void sceltaOperazione() {

        System.out.println("Scegli l'operazione da eseguire:");
        System.out.println("1. Aggiunta a magazzino\n2. Scarico merce da magazzino\n3. Acquista");

        int numeroOperazione = Prodotti.InputProdotti.readInt();

        switch (numeroOperazione) {
            case 1: {
                System.out.println("Aggiunta a magazzino");
                break;
            }
            case 2: {
                System.out.println("Scarico merce da magazzino");
                break;
            }
            case 3: {
                System.out.println("Acquista");
                break;
            }
            default: {
                System.out.println("Operazione non trovata");
            }
        }
    }

    public static void sceltaTipo () {

        ArrayList<Tablet> arrayTablet = new ArrayList<Tablet>();

        TipoProdotto tipologia = Prodotti.InputProdotti.readTipo();


        switch (tipologia) {
            case TABLET: {
                arrayTablet.add(new Tablet());
                System.out.println(arrayTablet.toString());
                break;
            }
            case NOTEBOOK:  {

                break;
            }
            case SMARTPHONE: {

                break;
            }


        }
    }
}