package Login;
import Magazzino.Magazzino;
import Prodotti.Prodotto;
import javax.swing.text.Utilities;
import java.util.ArrayList;

public class Login {

    public static void accesso (ListaUtenti lista, Magazzino magazzino){
        System.out.println("Seleziona l'operazione di accesso:\s 1. Log in\s 2.Registrati");
        int in = Utility.Input.readInt();
        switch (in){
            case 1:
                pgAccedi(lista, magazzino);
                break;
            case 2:
                pgRegistrati(lista);
                break;
            default:
                break;
        }
    }
    //Accesso
    public static void pgAccedi(ListaUtenti lista, Magazzino magazzino){
        boolean isTrue = false;
        while (!isTrue){
            boolean f = false;
            System.out.println("Email:");
            String mail = Utility.Input.readStr();
            System.out.println("Password:");
            String psw = Utility.Input.readStr();

                for (Utenti u : lista.getLista()){
                    if (u.getEmail().equals(email) && u.getPassword().equals(psw)) {
                    f = true;
                    Utente user = u;}
                    }
                     if (!f){
                         System.out.println("Username o Password errati.");
                     }
                }
        }
    public static ListaUtenit pgRegistrati(ListaUtenti lista){
        System.out.println("Nome Utente: ");
        String name = Utility.Input.readStr();
        System.out.println("Cognome Utente: ");
        String cognome = Utility.Input.readStr();
        System.out.println("Email: ");
        String email = Utility.Input.readStr();
        System.out.println("Username: ");
        String username = Utility.Input.readStr();
        System.out.println("Password: ");
        String password = Utility.Input.readStr();
        System.out.println("Numero di telefono: ");
        int telefono = Utility.Input.readInt();

        //Utente u1 = new Utente(****);
        return u1;
    }

    public static ListaUtenti verificaPsw(ListaUtenti lista){
        System.out.println("Email: ");
        String email = Utility.Input.readStr();
        if (verificaMail(list, mail)){
            resetPsw(list,mail);
        } else {
            System.out.println("Email  non valida.");
        }
        return lista;
    }

    public static boolean verificaMail(ListaUtenti lista, String mail){
        for (Utenti u : lista.getLista()){
            if(u.getEmail().equals(mail)){
                System.out.println("Email corretta");
                return true;
            }
        }
        return false;
    }

    public static ListaUtenti resetPsw (ListaUtenti lista, String main){
        for (Utenti u : lista.getLista()){
            if (u.getEmail().equals(mail)){
                System.out.println("Inserisci password: ");
                String psw = Utility.Input.readStr();
                u.setPassword(psw);
            }
        }
        return lista;
    }
}

