package Login;

import DBManager.DataMapper;
import DBManager.FakeDB;
import SceltaOperazione.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static DBManager.DbManager.createStatementForDbMagazzino;

public class Login {

    /**Questo è il punto di ingresso al programma. Si chiede se loggarsi come cliente o venditore oppure creare un nuovo profilo cliente.*/
    public static Utente accesso() {

        Utente utente = null;
        boolean quit = false;

        while (!quit) {
            utente = null;
            System.out.println("Seleziona l'operazione di accesso:\n 0. Chiudi programma\n 1. Login Cliente\n 2. Login Gestore\n 3. Registrati");
            int in = Utility.Input.readInt();
            switch (in) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    utente = pgAccediClienteDb();
                    break;
                case 2:
                    utente = pgAccediVenditoreDb();
                    break;
                case 3:
                    pgRegistrati();
                    break;
                default:
                    break;
            }
            if (utente instanceof Cliente) {
                InterfacciaClienteDB.operazioniCliente((Cliente)utente);
            } else if (utente instanceof Gestore) {
                InterfacciaGestoreDB.operazioniGestore((Gestore)utente);
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


    public static void pgRegistrati() {

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

        Cliente nuovoCliente = new Cliente(null, nome, cognome, email, password, indirizzo, paese, numeroTelefono);

        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "INSERT INTO cliente (nome, cognome, email, password, indirizzo, paese, telefono)\n" +
                    "SELECT '" + nome + "', '" + cognome + "', '" + email + "', '" + password + "', '" + indirizzo + "', '" + paese + "', '" + numeroTelefono + "'\n" +
                    "WHERE NOT EXISTS ( SELECT * FROM cliente\n" +
                    "WHERE email = '" + email + "');";

            stmt.execute(query);

        } catch (SQLException e) {
            System.out.println(e);
        }
    }


    public static ArchivioUtenti resetPsw(ArchivioUtenti lista, String mail) {
        for (Utente u : lista.getArchivioUtenti()) {
            if (u.getEmail().equals(mail)) {
                System.out.println("Inserisci la nuova password: ");
                String psw = Utility.Input.readStr();
                u.setPassword(psw);
            }
        }
        return lista;
    }

    public static Utente pgAccediClienteDb() {

        System.out.println("Email:");
        String email = Utility.Input.readStr();
        System.out.println("Password:");
        String psw = Utility.Input.readStr();
        try (Statement stmt = createStatementForDbMagazzino()) {
            Utente utente = loginCliente(email, psw);
            if (utente != null) {
                System.out.println("Autenticazione avvenuta con successo.");
                System.out.println("Benvenuto " + utente.getNome() + " " + utente.getCognome());
                return utente;
            } else {
                throw new SQLException("Autenticazione fallita");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static Cliente loginCliente(String email, String password) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "SELECT id_cliente, nome, cognome, email, password, indirizzo, paese, telefono\n" +
                    "FROM cliente\n" +
                    "WHERE email ='" + email + "'" + "AND password = '" + password + "';";

            ResultSet rs = stmt.executeQuery(query);
            ArrayList<Cliente> cliente = DataMapper.getClientiFromDb(rs);

            if (cliente.isEmpty() || cliente == null) {
                throw new SQLException("Utente non trovato. Riprova.");
            } else {
                return cliente.get(0);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static Utente pgAccediVenditoreDb() {

        System.out.println("Email:");
        String email = Utility.Input.readStr();
        System.out.println("Password:");
        String psw = Utility.Input.readStr();
        try (Statement stmt = createStatementForDbMagazzino()) {
            Utente utente = loginVenditore(email, psw);
            if (utente != null) {
                System.out.println("Autenticazione avvenuta con successo.");
                System.out.println("Benvenuto " + utente.getNome() + " " + utente.getCognome());
                return utente;
            } else {
                throw new SQLException("Autenticazione fallita");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static Gestore loginVenditore(String email, String password) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "SELECT id_venditore, nome, cognome, email, password, indirizzo, paese, telefono\n" +
                    "FROM venditore\n" +
                    "WHERE email ='" + email + "'" + "AND password = '" + password + "';";

            ResultSet rs = stmt.executeQuery(query);
            ArrayList<Gestore> gestore = DataMapper.getVenditoriFromDb(rs);

            if (gestore.isEmpty() || gestore == null) {
                throw new SQLException("Utente non trovato. Riprova.");
            } else {
                return gestore.get(0);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

}

