package DBManager;

import Prodotti.Prodotto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static DBManager.DbManager.createStatementForDbMagazzino;

public class DbRicercaCarrelloCliente {

    public static ArrayList<Prodotto> getProdottiCarrelliCliente(String id_cliente) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "SELECT prodotto.id_prodotto, categoria, produttore, modello, descrizione, dimensione_memoria, dimensione_schermo, prezzo_acquisto, prezzo_vendita\n" +
                    "FROM prodotto JOIN prodottocarrello ON prodotto.id_prodotto = prodottocarrello.id_prodotto\n" +
                    "JOIN carrellocliente ON prodottocarrello.id_carrello = carrellocliente.id_carrello\n" +
                    "WHERE id_cliente =" + id_cliente + " ;";

            ResultSet rs = stmt.executeQuery(query);
            return DataMapper.getProdottiFromDb(rs);

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static ArrayList<Integer> getCarrelliCliente(String id_cliente) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "SELECT id_carrello\n" +
                    "FROM carrellocliente\n" +
                    "WHERE id_cliente =" + id_cliente + " ;";

            ResultSet rs = stmt.executeQuery(query);
            return DataMapper.getIDCarrelliClienteDb(rs);

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }



}
