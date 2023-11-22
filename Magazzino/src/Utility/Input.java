package Utility;

import Prodotti.TipoProdotto;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    static Scanner in = new Scanner(System.in);

    public static TipoProdotto readTipo() {

        while (true) {
            try {
                System.out.println("Inserisci il tipo di prodotto: ");
                return TipoProdotto.valueOf(in.nextLine().toUpperCase());
            }
            catch (IllegalArgumentException e) {
                System.out.println("Devi inserire un tipo di prodotto presente in magazzino");
            }
        }
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
            }
        }
    }

    public static int readInt() {
        int num;
        while(true) {
            try {
                return in.nextInt();
            }
            catch (InputMismatchException e)
            {
                System.out.println("Inserire un numero intero");
                in.next();
            }
        }
    }
    public static String readStr() {
        while(true) {
            try {
                return in.next().toLowerCase();
            }
            catch (InputMismatchException e)
            {
                System.out.println("Inserire una stringa");
                in.next();
            }
        }
    }

    //aggiunto un readStr a parte senza il toLowerCase per leggere in particolare Marca Modello e ID per gestore
    public static String readStrNoLowerCase() {
        while(true) {
            try {
                return in.next();
            }
            catch (InputMismatchException e)
            {
                System.out.println("Inserire una stringa");
                in.next();
            }
        }
    }
    public static BigDecimal readBigD() {
        BigDecimal d;
        while(true) {
            try {
                return in.nextBigDecimal();
            }
            catch (InputMismatchException e)
            {
                System.out.println("Inserire un numero decimale");
                in.next();
            }
        }
    }

}
