package DBManager;
import Login.Gestore;
import Prodotti.Prodotto;
import Prodotti.TipoProdotto;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.sql.Statement;

public class DbInsert {

    public static void insertProdottoIntoProdotto(Prodotto prodotto, Gestore gestore) {
        try (Statement stmt = DbManager.createStatementForDbMagazzino()) {
            String query = "INSERT INTO prodotto (id_venditore, categoria, produttore, modello, descrizione," +
                    " dimensione_memoria, " + "dimensione_schermo, prezzo_acquisto, prezzo_vendita) " +
                    "VALUES ( '" + gestore.getId() + "', '" + prodotto.getTipo().toString() +
                    "', '" + prodotto.getProduttore() + "', '" + prodotto.getModello() + "', '"
                    + prodotto.getDescrizione() + "', '" + prodotto.getDimMemoria() + "', '" +
                    prodotto.getDimDisplay() + "', '" +
                    prodotto.getPrezzoAcquisto().setScale(2, RoundingMode.HALF_EVEN) + "', '" +
                    prodotto.getPrezzoVendita().setScale(2, RoundingMode.HALF_EVEN) + "' );";

            stmt.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println(e);
        }

    }


}
