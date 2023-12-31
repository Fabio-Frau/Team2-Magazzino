package DBManager;

import Login.Cliente;
import Login.Gestore;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static DBManager.DbManager.createStatementForDbMagazzino;

public class DbRicercaVenditore {
    public static ArrayList<Gestore> ricercaPerId(String id) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "SELECT id_venditore, nome, cognome, email, password, indirizzo, paese, telefono\n" +
                    "FROM venditore\n" +
                    "WHERE id_venditore =" + id + " ;";

            ResultSet rs = stmt.executeQuery(query);
            return DataMapper.getVenditoriFromDb(rs);

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static ArrayList<Gestore> ricercaPerNome(String nome) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "SELECT id_venditore, nome, cognome, email, password, indirizzo, paese, telefono\n" +
                    "FROM venditore\n" +
                    "WHERE nome ='" + nome + "' ;";

            ResultSet rs = stmt.executeQuery(query);
            return DataMapper.getVenditoriFromDb(rs);

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static ArrayList<Gestore> ricercaPerCognome(String cognome) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "SELECT id_venditore, nome, cognome, email, password, indirizzo, paese, telefono\n" +
                    "FROM venditore\n" +
                    "WHERE cognome ='" + cognome + "' ;";

            ResultSet rs = stmt.executeQuery(query);
            return DataMapper.getVenditoriFromDb(rs);

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static ArrayList<Gestore> ricercaPerEmail(String email) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "SELECT id_venditore, nome, cognome, email, password, indirizzo, paese, telefono\n" +
                    "FROM venditore\n" +
                    "WHERE email ='" + email + "' ;";

            ResultSet rs = stmt.executeQuery(query);
            return DataMapper.getVenditoriFromDb(rs);

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static ArrayList<Gestore> ricercaPerIndirizzo(String indirizzo) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "SELECT id_venditore, nome, cognome, email, password, indirizzo, paese, telefono\n" +
                    "FROM venditore\n" +
                    "WHERE indirizzo LIKE '%" + indirizzo + "%' ;";

            ResultSet rs = stmt.executeQuery(query);
            return DataMapper.getVenditoriFromDb(rs);

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static ArrayList<Gestore> ricercaPerPaese(String paese) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "SELECT id_venditore, nome, cognome, email, password, indirizzo, paese, telefono\n" +
                    "FROM venditore\n" +
                    "WHERE paese ='" + paese + "' ;";

            ResultSet rs = stmt.executeQuery(query);
            return DataMapper.getVenditoriFromDb(rs);

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static ArrayList<Gestore> ricercaPerTelefono(String telefono) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "SELECT id_venditore, nome, cognome, email, password, indirizzo, paese, telefono\n" +
                    "FROM venditore\n" +
                    "WHERE telefono ='" + telefono + "' ;";

            ResultSet rs = stmt.executeQuery(query);
            return DataMapper.getVenditoriFromDb(rs);

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
