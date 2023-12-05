package DBManager;

import java.sql.*;
import java.util.ArrayList;

public class DbManager {
    static final String DB_URL_ROOT = "jdbc:mysql://localhost:3306/mysql";
    static final String USER_ROOT = "root";
    static final String PASSWORD_ROOT = "123";

    static final String DB_URL_MAGAZZINO = "jdbc:mysql://localhost:3306/magazzino";
    static final String USER_MAGAZZINO = "developer";
    static final String PASSWORD_MAGAZZINO = "123";

    public static void grantPrivilegeToDeveloper() {
        try (Statement stmt = createStatementForDbRoot()){
            String query = "GRANT ALL PRIVILEGES ON magazzino.* TO 'developer'@'localhost'";
            stmt.execute(query);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    private static Statement createStatementForDbRoot () {
        try {
            Connection conn = DriverManager.getConnection(DB_URL_ROOT, USER_ROOT, PASSWORD_ROOT);
            return conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Statement createStatementForDbMagazzino () {
        try {
            Connection conn = DriverManager.getConnection(DB_URL_MAGAZZINO, USER_MAGAZZINO, PASSWORD_MAGAZZINO);
            return conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createDb () {
        try (Statement stmt = createStatementForDbRoot()) {
            String query = "CREATE DATABASE IF NOT EXISTS magazzino";
            stmt.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void createClienteTab () {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "CREATE TABLE IF NOT EXISTS cliente (" +
                    "id_cliente INT NOT NULL AUTO_INCREMENT," +
                    "nome VARCHAR(50) NOT NULL," +
                    "cognome VARCHAR(50) NOT NULL," +
                    "email VARCHAR(50) NOT NULL," +
                    "password VARCHAR(50) NOT NULL," +
                    "indirizzo VARCHAR(100) NOT NULL," +
                    "paese VARCHAR(50) NOT NULL," +
                    "telefono VARCHAR(15) NOT NULL," +
                    "PRIMARY KEY (id_cliente));";

            stmt.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void createVenditoreTab () {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "CREATE TABLE IF NOT EXISTS venditore (" +
                    "id_venditore INT NOT NULL AUTO_INCREMENT," +
                    "nome VARCHAR(50) NOT NULL," +
                    "cognome VARCHAR(50) NOT NULL," +
                    "email VARCHAR(50) NOT NULL," +
                    "password VARCHAR(50) NOT NULL," +
                    "indirizzo VARCHAR(100) NOT NULL," +
                    "paese VARCHAR(50) NOT NULL," +
                    "telefono VARCHAR(15) NOT NULL," +
                    "PRIMARY KEY (id_venditore));";

            stmt.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void createProdottoTab() {
        try (Statement stmt = createStatementForDbMagazzino()){
            String query = "CREATE TABLE IF NOT EXISTS prodotto (" +
                    "id_prodotto INT NOT NULL AUTO_INCREMENT," +
                    "id_venditore INT NOT NULL," +
                    "categoria ENUM('SMARTPHONE','NOTEBOOK','TABLET') NOT NULL," +
                    "produttore VARCHAR(50) NOT NULL," +
                    "modello VARCHAR(50) NOT NULL," +
                    "descrizione VARCHAR(255) NULL," +
                    "dimensione_memoria INT NOT NULL," +
                    "dimensione_schermo FLOAT NOT NULL," +
                    "prezzo_acquisto DECIMAL(7,2) NOT NULL," +
                    "prezzo_vendita DECIMAL(7,2) NOT NULL," +
                    "PRIMARY KEY (id_prodotto));";

            stmt.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void createDettaglioOrdineTab() {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "CREATE TABLE IF NOT EXISTS dettaglioOrdine (" +
                    "id_prodotto INT NOT NULL," +
                    "id_ordine INT NOT NULL," +
                    "PRIMARY KEY (id_prodotto, id_ordine));";
            stmt.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void createOrdineTab() {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "CREATE TABLE IF NOT EXISTS ordine (" +
                    "id_ordine INT NOT NULL AUTO_INCREMENT," +
                    "id_cliente INT NOT NULL," +
                    "data_esecuzione DATETIME," +
                    "PRIMARY KEY (id_ordine));";
            stmt.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void createProdottoCarelloTab() {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "CREATE TABLE IF NOT EXISTS prodottoCarrello (" +
                    "id_carrello INT NOT NULL," +
                    "id_prodotto INT NOT NULL," +
                    "PRIMARY KEY (id_carrello, id_prodotto));";
            stmt.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void createCarrelloClienteTab() {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "CREATE TABLE IF NOT EXISTS carrelloCliente (" +
                    "id_carrello INT NOT NULL AUTO_INCREMENT," +
                    "id_cliente INT NOT NULL," +
                    "PRIMARY KEY (id_carrello));";
            stmt.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void createFkProdottoVenditore() {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "ALTER TABLE prodotto " +
                    "ADD CONSTRAINT FK_prodotto_venditore " +
                    "FOREIGN KEY (id_venditore) " +
                    "REFERENCES venditore(id_venditore);";
            stmt.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e);
        }
    }



   /* private static ArrayList<City> dataMapper(ResultSet rs) throws SQLException {
        ArrayList<City> cities = new ArrayList<>();
        while (rs.next()) {
            City city = new City(
                    rs.getInt("ID"),
                    rs.getString("Name"),
                    rs.getString("CountryCode"),
                    rs.getString("District"),
                    rs.getInt("Population")
            );
            cities.add(city);
        }
        return cities;
    }*/

}
