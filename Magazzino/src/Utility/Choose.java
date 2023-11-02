package Utility;
import Prodotti.*;
import SceltaOperazione.Cliente;

import java.util.ArrayList;
import java.util.Scanner;

public class Choose {
    static Scanner in = new Scanner(System.in);
    public static char yesORnot() {
        System.out.println("Digita 'y' per continuare, 'n' per tornare indietro.");
        char YNinput = 0;
        do {
            YNinput = in.nextLine().trim().toLowerCase().charAt(0);
        } while (YNinput != 'y' && YNinput != 'n');
        return YNinput;
    }


    //Continua Ricerca Cliente
    public static void ContinuaRicercaCliente(ArrayList<Prodotto> magazzino){
        System.out.println("Vuoi continuare la ricerca?");
        char c = Choose.yesORnot();
        switch (c){
            case 'y': {
                Cliente.operazioniCliente(magazzino);
                break;
            }
            case 'n' : {
                break;
            }
        }
    }
}
