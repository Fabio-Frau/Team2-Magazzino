package DBManager;

import Login.Cliente;
import Login.Gestore;
import Prodotti.Prodotto;

import java.math.RoundingMode;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Queue;

public class DbDelete {

    //trasformarlo in update disp = 0 non voglio eliminare il prodotto problemi con FK
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

    public static void deleteProdottoCarrello(int id_prodotto, int id_carrello, Cliente cliente) {
        try (Statement stmt = DbManager.createStatementForDbMagazzino()) {
            String query = "DELETE prodottocarrello FROM prodottocarrello \n" +
                    "WHERE id_prodotto = " + id_prodotto + "  AND prodottocarrello.id_carrello = " + id_carrello + " ;";
            stmt.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public static void svuotaCarrello(int id_carrello, Cliente cliente) {
        try (Statement stmt = DbManager.createStatementForDbMagazzino()) {
            String query = "DELETE FROM carrellocliente \n" +
                    "WHERE id_carrello = " + id_carrello + " ;";
            stmt.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println(e);
        }

    }



}
