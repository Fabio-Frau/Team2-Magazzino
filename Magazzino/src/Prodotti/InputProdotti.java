package Prodotti;

import java.util.EnumSet;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.IllegalArgumentException;

public class InputProdotti {

    static Scanner in = new Scanner(System.in);

    public static TipoProdotto readTipo() {

        while (true) {
            try {
                System.out.println("Inserisci il tipo di prodotto: ");
                return TipoProdotto.valueOf(in.nextLine().toLowerCase());
            }
            catch (IllegalArgumentException e) {
                System.out.println("Devi inserire un tipo di prodotto presente in magazzino");
                //in.next();
                continue;
            }
        }

    }

    public static String readString() {
        return in.nextLine().toLowerCase();
    }

    public static double readDouble() {

        double num;

        while(true) {
            try {
                return in.nextDouble();
            }
            catch (InputMismatchException e)
            {
                System.out.println("Inserire un double");
                in.next();
                continue;
            }
        }


    }


}
