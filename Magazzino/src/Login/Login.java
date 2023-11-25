package Login;
import DBManager.FakeDB;

public class Login {

    public static Utente accesso (FakeDB db){

        Utente utente = null;
        while(utente == null) {
            System.out.println("Seleziona l'operazione di accesso:\n 1. Log in\n 2. Registrati");
            int in = Utility.Input.readInt();
            switch (in){
                case 1:
                    utente = pgAccedi(db.getArchivioUtenti());
                    break;
                case 2:
                    pgRegistrati(db.getArchivioUtenti());
                    break;
                default:
                    break;
            }
        }

        return utente;
    }

    //Accesso
    public static Utente pgAccedi(ArchivioUtenti archivioUtenti) {

        while (true) {
            System.out.println("Email:");
            String email = Utility.Input.readStr();
            System.out.println("Password:");
            String psw = Utility.Input.readStr();
            Utente utente = archivioUtenti.checkCredentials(email, psw);

            if (utente != null) {
                System.out.println("Autenticazione avvenuta con successo.");
                System.out.println("Benvenuto " + utente.getNome() + " " + utente.getCognome());
                return utente;
            } else {
                System.out.println("Autenticazione fallita");
            }
        }
    }


    public static Cliente pgRegistrati(ArchivioUtenti archivioUtenti){

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

        Cliente nuovoCliente= new Cliente(nome, cognome, email, password, telefono);
        if (archivioUtenti.addUtente(nuovoCliente)) {
            System.out.println("Utente inserito correttamente");
        } else {
            System.out.println("Impossibile registrare il nuovo utente:" +
                    "\nLa mail con cui ti stai registrando è già presente nell'archivio");
        }

        return nuovoCliente;

    }



    public static ArchivioUtenti resetPsw (ArchivioUtenti lista, String mail){
        for (Utente u : lista.getArchivioUtenti()){
            if (u.getEmail().equals(mail)){
                System.out.println("Inserisci la nuova password: ");
                String psw = Utility.Input.readStr();
                u.setPassword(psw);
            }
        }
        return lista;
    }


}

