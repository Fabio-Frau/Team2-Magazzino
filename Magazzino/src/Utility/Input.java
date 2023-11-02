package Utility;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    static Scanner in = new Scanner(System.in);

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
                continue;
            }
        }

    }

}
