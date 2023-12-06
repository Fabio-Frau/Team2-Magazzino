package DBManager;

import Prodotti.TipoProdotto;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public class DbManager {
    private static final String DB_URL_ROOT = "jdbc:mysql://localhost:3306/mysql";
    private static final String USER_ROOT = "root";
    private static final String PASSWORD_ROOT = "123";

    private static final String DB_URL_MAGAZZINO = "jdbc:mysql://localhost:3306/magazzino";
    private static final String USER_MAGAZZINO = "developer";
    private static final String PASSWORD_MAGAZZINO = "123";

    public static void grantPrivilegeToDeveloper() {
        try (Statement stmt = createStatementForDbRoot()){
            String query = "GRANT ALL PRIVILEGES ON magazzino.* TO 'developer'@'localhost'";
            stmt.execute(query);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static Statement createStatementForDbRoot () {
        try {
            Connection conn = DriverManager.getConnection(DB_URL_ROOT, USER_ROOT, PASSWORD_ROOT);
            return conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Statement createStatementForDbMagazzino () {
        try {
            Connection conn = DriverManager.getConnection(DB_URL_MAGAZZINO, USER_MAGAZZINO, PASSWORD_MAGAZZINO);
            return conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insertVenditore(String nome, String cognome, String email, String password, String indirizzo, String paese, String num_telefono) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "INSERT INTO venditore (nome, cognome, email, password, indirizzo, paese, telefono) " +
                    "VALUES ( '" + nome + "', '" + cognome + "', '" + email + "', '" + password + "', '" + indirizzo +
                    "', '" + paese + "', '" + num_telefono + "' );";

                stmt.execute(query);

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void insertCliente(String nome, String cognome, String email, String password, String indirizzo, String paese, String num_telefono) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "INSERT INTO cliente (nome, cognome, email, password, indirizzo, paese, telefono) " +
                    "VALUES ( '" + nome + "', '" + cognome + "', '" + email + "', '" + password + "', '" + indirizzo +
                    "', '" + paese + "', '" + num_telefono + "' );";

            stmt.execute(query);

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void insertProdotto(int id_venditore, TipoProdotto categoria, String produttore, String modello,
                                      String descrizione, int dimesione_memoria, double dimensione_schermo,
                                      BigDecimal prezzoAcquisto, BigDecimal prezzoVendita) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "INSERT INTO prodotto (id_venditore, categoria, produttore, modello, descrizione, dimensione_memoria, " +
                    "dimensione_schermo, prezzo_acquisto, prezzo_vendita) " + "VALUES ( '" + id_venditore + "', '" + categoria +
                    "', '" + produttore + "', '" + modello + "', '" + descrizione + "', '" + dimesione_memoria + "', '" +
                    dimensione_schermo + "', '" + prezzoAcquisto.setScale(2) + "', '" + prezzoVendita.setScale(2) + "' );";

            stmt.execute(query);

        } catch (SQLException e) {
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
