package Login;
import Magazzino.Magazzino;

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
            String email = Utility.Input.readStr();
            System.out.println("Password:");
            String psw = Utility.Input.readStr();

                for (Utente u : lista.getListaUtenti()){
                    if (u.getEmail().equals(email) && u.getPassword().equals(psw)) {
                    f = true;
                    Utente user = u;}
                    }
                     if (!f){
                         System.out.println("Username o Password errati.");
                     }
                }
        }
    public static Utente pgRegistrati(ListaUtenti lista){
        System.out.println("Nome Utente: ");
        String nome = Utility.Input.readStr();
        System.out.println("Cognome Utente: ");
        String cognome = Utility.Input.readStr();
        System.out.println("Email: ");
        String email = Utility.Input.readStr();
        System.out.println("Password: ");
        String password = Utility.Input.readStr();
        System.out.println("Numero di telefono: ");
        int telefono = Utility.Input.readInt();

        Utente u1 = new Utente(nome, cognome, email, password, telefono);
        return u1;
    }


    public static boolean verificaMail(ListaUtenti lista, String mail){
        for (Utente u : lista.getListaUtenti()){
            if(u.getEmail().equals(mail)){
                System.out.println("Email corretta");
                return true;
            }
        }
        return false;
    }

    public static ListaUtenti resetPsw (ListaUtenti lista, String mail){
        for (Utente u : lista.getListaUtenti()){
            if (u.getEmail().equals(mail)){
                System.out.println("Inserisci la nuova password: ");
                String psw = Utility.Input.readStr();
                u.setPassword(psw);
            }
        }
        return lista;
    }

    public static ListaUtenti verificaPsw(ListaUtenti lista){
        System.out.println("Email: ");
        String email = Utility.Input.readStr();
        if (verificaMail(lista, email)){
            resetPsw(lista,email);
        } else {
            System.out.println("Email non valida.");
        }
        return lista;
    }
}

