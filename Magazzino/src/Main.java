import Magazzino.Magazzino;
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

        Tablet tablet1 = new Tablet("Samsung", "S87", "IDPROVA", "beello",
                14.5, 16, 5000, 6000);

        Tablet tablet2 = new Tablet("FIAT", "S87", "IDPROVA", "beello",
                14.5, 16, 5000, 6000);

        Tablet tablet3 = new Tablet("FERRATI", "S87", "IDPROVA", "beello",
                14.5, 16, 5000, 6000);

        ArrayList<Tablet> listaTablet = new ArrayList<Tablet>();
        listaTablet.add(tablet1);
        listaTablet.add(tablet2);
        listaTablet.add(tablet3);


        Magazzino magazzino = new Magazzino();
        magazzino.setListaTablet(listaTablet);
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