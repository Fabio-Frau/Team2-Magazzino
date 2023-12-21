package DBManager;
import Prodotti.Prodotto;
import java.sql.SQLException;
import java.sql.Statement;

import static DBManager.DbManager.createStatementForDbMagazzino;

public class DbUpdate {

    public static void rimuoviDisponibilitaProdotto(Prodotto prodotto) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "UPDATE prodotto " +
                    " SET disponibile = 0" +
                    " WHERE id_prodotto = " + prodotto.getId() + ");";

            stmt.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
