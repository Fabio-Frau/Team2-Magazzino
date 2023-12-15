package DBManager;

import Login.Cliente;
import Login.Utente;
import Prodotti.Prodotto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static DBManager.DbManager.createStatementForDbMagazzino;

public class DbRicercaCliente {
    public static ArrayList<Cliente> ricercaPerId(String id) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "SELECT id_cliente, nome, cognome, email, password, indirizzo, paese, telefono\n" +
                    "FROM cliente\n" +
                    "WHERE id_cliente =" + id + " ;";
            System.out.println(query);

            ResultSet rs = stmt.executeQuery(query);

            return DataMapper.getClientiFromDb(rs);


        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static ArrayList<Cliente> ricercaPerNome(String nome) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "SELECT id_cliente, nome, cognome, email, password, indirizzo, paese, telefono\n" +
                    "FROM cliente\n" +
                    "WHERE nome ='" + nome + "' ;";
            System.out.println(query);

            ResultSet rs = stmt.executeQuery(query);

            return DataMapper.getClientiFromDb(rs);


        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static ArrayList<Cliente> ricercaPerCognome(String cognome) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "SELECT id_cliente, nome, cognome, email, password, indirizzo, paese, telefono\n" +
                    "FROM cliente\n" +
                    "WHERE cognome ='" + cognome + "' ;";
            System.out.println(query);

            ResultSet rs = stmt.executeQuery(query);

            return DataMapper.getClientiFromDb(rs);


        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static ArrayList<Cliente> ricercaPerEmail(String email) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "SELECT id_cliente, nome, cognome, email, password, indirizzo, paese, telefono\n" +
                    "FROM cliente\n" +
                    "WHERE email ='" + email + "' ;";
            System.out.println(query);

            ResultSet rs = stmt.executeQuery(query);

            return DataMapper.getClientiFromDb(rs);


        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static ArrayList<Cliente> ricercaPerIndirizzo(String indirizzo) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "SELECT id_cliente, nome, cognome, email, password, indirizzo, paese, telefono\n" +
                    "FROM cliente\n" +
                    "WHERE indirizzo LIKE '%" + indirizzo + "%' ;";
            System.out.println(query);

            ResultSet rs = stmt.executeQuery(query);

            return DataMapper.getClientiFromDb(rs);


        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static ArrayList<Cliente> ricercaPerPaese(String paese) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "SELECT id_cliente, nome, cognome, email, password, indirizzo, paese, telefono\n" +
                    "FROM cliente\n" +
                    "WHERE paese ='" + paese + "' ;";
            System.out.println(query);

            ResultSet rs = stmt.executeQuery(query);

            return DataMapper.getClientiFromDb(rs);


        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static ArrayList<Cliente> ricercaPerTelefono(String telefono) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "SELECT id_cliente, nome, cognome, email, password, indirizzo, paese, telefono\n" +
                    "FROM cliente\n" +
                    "WHERE telefono ='" + telefono + "' ;";
            System.out.println(query);

            ResultSet rs = stmt.executeQuery(query);

            return DataMapper.getClientiFromDb(rs);


        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }


}
