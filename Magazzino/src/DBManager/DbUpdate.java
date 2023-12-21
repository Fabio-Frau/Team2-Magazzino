package DBManager;
import Prodotti.Prodotto;
import java.sql.SQLException;
import java.sql.Statement;

import static DBManager.DbManager.createStatementForDbMagazzino;

public class DbUpdate {

    public static void rimuoviDisponibilitaProdotto(int idprodotto) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "UPDATE prodotto " +
                    " SET disponibile = 0 " +
                    " WHERE id_prodotto = " + idprodotto + ";";
            System.out.println(query);

            stmt.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
