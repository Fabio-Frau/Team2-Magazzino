package DBManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static DBManager.DbManager.createStatementForDbMagazzino;

public class DbRicerche {

    public static ResultSet ricercaPerModelloCliente(String modello) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "SELECT id_prodotto, categoria, produttore, modello, dimensione_memoria, dimensione_schermo, prezzo_vendita\n" +
                    "FROM prodotto\n" +
                    "WHERE modello LIKE '%" + modello + "%' ;";
            System.out.println(query);

            ResultSet rs = stmt.executeQuery(query);

            /*SCRIVERE FUNZIONE DI STAMPA DA RIUSARE PER LE VARIE QUERY => DATA MAPPER*/
            while(rs.next()) {
                System.out.println(rs.getString("id_prodotto"));
            }


        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

}

/*"id_prodotto INT NOT NULL AUTO_INCREMENT," +
                    "id_venditore INT NOT NULL," +
                    "categoria ENUM('SMARTPHONE','NOTEBOOK','TABLET') NOT NULL," +
                    "produttore VARCHAR(50) NOT NULL," +
                    "modello VARCHAR(50) NOT NULL," +
                    "descrizione VARCHAR(255) NULL," +
                    "dimensione_memoria INT NOT NULL," +
                    "dimensione_schermo FLOAT NOT NULL," +
                    "prezzo_acquisto DECIMAL(7,2) NOT NULL," +
                    "prezzo_vendita DECIMAL(7,2) NOT NULL," +*/