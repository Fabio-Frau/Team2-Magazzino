package DBManager;

import java.sql.*;
import java.util.ArrayList;

public class DbManager {
    static final String DB_URL_ROOT = "jdbc:mysql://localhost:3306/magazzino";
    static final String USER_ROOT = "root";
    static final String PASSWORD_ROOT = "passwordhere";

    private static Statement createStatementForDb () {
        try {
            Connection conn = DriverManager.getConnection(DB_URL_ROOT, USER_ROOT, PASSWORD_ROOT);
            return conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createDb () {
        try (Statement stmt = createStatementForDb()) {
            String query = "CREATE DATABASE IF NOT EXISTS magazzino";
            stmt.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void createClienteTab () {
        try (Statement stmt = createStatementForDb()) {
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
