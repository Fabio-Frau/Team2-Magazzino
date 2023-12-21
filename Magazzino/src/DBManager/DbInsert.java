package DBManager;
import Login.Cliente;
import Login.Gestore;
import Prodotti.Prodotto;
import Prodotti.TipoProdotto;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.OffsetDateTime;

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

    public static void insertProdottoIntoProdottoCarrello(int id_prodotto, int id_carrello, Cliente cliente) {
        try (Statement stmt = DbManager.createStatementForDbMagazzino()) {
            String query = "INSERT INTO prodottoCarrello (id_carrello, id_prodotto) \n" +
                    "SELECT " + id_carrello + ", " + id_prodotto + " \n" +
                    "FROM carrelloCliente JOIN prodottoCarrello ON carrelloCliente.id_carrello = prodottoCarrello.id_carrello \n" +
                    "WHERE carrelloCliente.id_cliente = " + cliente.getId() + ";";
            System.out.println(query);

            stmt.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println(e);
        }

    }





}
