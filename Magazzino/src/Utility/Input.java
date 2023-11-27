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
                return TipoProdotto.valueOf(in.next().toUpperCase());
            }
            catch (IllegalArgumentException e) {
                System.out.println("Devi inserire un tipo di prodotto presente in magazzino");
            }
        }
    }

    public static double readDouble() {
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

    public static double[] readDoubleSort() {

        double num1 = readDouble();
        double num2 = readDouble();

        if (num1 >= num2) {
            return new double[] {num2, num1};
        } else {
            return new double[] {num1, num2};
        }
    }

    public static int readInt() {
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

    public static int[] readIntSort() {

        int num1 = readInt();
        int num2 = readInt();

        if (num1 >= num2) {
            return new int[] {num2, num1};
        } else {
            return new int[] {num1, num2};
        }
    }


    public static String readStr() {
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
