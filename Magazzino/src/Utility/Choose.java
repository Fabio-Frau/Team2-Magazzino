package Utility;
import Prodotti.*;
import SceltaOperazione.Cliente;
import SceltaOperazione.Gestore;

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
    public static void continuaRicercaCliente(){
        System.out.println("Vuoi continuare la ricerca?");
        char c = Choose.yesORnot();
        switch (c){
            case 'y': {
                Cliente.sceltaRicercheCliente();
                break;
            }
            case 'n' : {
                break;
            }
        }
    }

    //Continua ricerca gestore
    public static void continuaRicercaGestore(){
        System.out.println("Vuoi continuare la ricerca?");
        char c = Choose.yesORnot();
        switch (c){
            case 'y': {
                Gestore.operazioniGestore();
                break;
            }
            case 'n' : {
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + c);
        }
    }
}
