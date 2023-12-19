package DBManager;

import Login.Cliente;
import Prodotti.Prodotto;

import java.math.BigDecimal;
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

    public static BigDecimal getCostoTotaleCarrello(Cliente cliente, int id_carrello) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "select SUM(prezzo_vendita) AS `totale` from prodotto \n" +
                    "join prodottocarrello on prodotto.id_prodotto = prodottocarrello.id_prodotto\n" +
                    "join carrellocliente on prodottocarrello.id_carrello = carrellocliente.id_carrello\n" +
                    "where id_cliente = " + cliente.getId() + " AND carrellocliente.id_carrello = " + id_carrello + ";";

            System.out.println(query);

            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            return rs.getBigDecimal(1);

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }




}
