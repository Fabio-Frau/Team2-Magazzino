package Login;
import DBManager.DataMapper;
import DBManager.FakeDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static DBManager.DbManager.createStatementForDbMagazzino;

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
        System.out.println("Indirizzo: ");
        String indirizzo = Utility.Input.readStr();
        System.out.println("Paese: ");
        String paese = Utility.Input.readStr();
        System.out.println("Numero di telefono: ");
        int numeroTelefono = Utility.Input.readInt();

        Cliente nuovoCliente= new Cliente(null, nome, cognome, email, password, indirizzo, paese, numeroTelefono);
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

    public static Utente pgAccediDb() {

        while (true) {
            System.out.println("Email:");
            String email = Utility.Input.readStr();
            System.out.println("Password:");
            String psw = Utility.Input.readStr();
            try  (Statement stmt = createStatementForDbMagazzino()) {

            } catch (SQLException e) {
                System.out.println(e);
            }
            Utente utente = loginCliente(email, psw);
            if (utente != null) {
                System.out.println("Autenticazione avvenuta con successo.");
                System.out.println("Benvenuto " + utente.getNome() + " " + utente.getCognome());
                return utente;
            } else {
                System.out.println("Autenticazione fallita");
            }
        }
    }

    public static Cliente loginCliente (String email, String password) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "SELECT id_cliente, nome, cognome, email, password, indirizzo, paese, telefono\n" +
                    "FROM cliente\n" +
                    "WHERE email ='" + email + "'" + "AND password = '" + password + "';";
            System.out.println(query);

            ResultSet rs = stmt.executeQuery(query);

            return DataMapper.getClientiFromDb(rs).get(0);


        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }


}

