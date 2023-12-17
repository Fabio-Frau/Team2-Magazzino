package DBManager;

import Login.Gestore;
import Prodotti.Prodotto;

import java.math.RoundingMode;
import java.sql.SQLException;
import java.sql.Statement;

public class DbDelete {

    public static void deleteProdottoVenditore(int id, Gestore gestore) {
        try (Statement stmt = DbManager.createStatementForDbMagazzino()) {
            String query = "DELETE FROM Prodotto WHERE id_prodotto = " + id + " AND id_venditore = " + gestore.getId() + " ;";
            int updatedRows = stmt.executeUpdate(query);

            if(updatedRows == 0) {
                System.out.println("Elemento non trovato");
            } else if (updatedRows == 1) {
                System.out.println("Prodotto eliminato");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

}
