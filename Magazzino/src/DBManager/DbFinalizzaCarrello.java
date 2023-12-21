package DBManager;

import Prodotti.Prodotto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static DBManager.DbManager.createStatementForDbMagazzino;

public class DbFinalizzaCarrello {

    public static void ordineFinalizzato (String id_cliente){
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "INSERT INTO oridni_finalizzati (id_cliente, id_prodotto, data)"
                    + "VALUES (id_cliente ,  )";
            stmt.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}


/*public static ArrayList<Prodotto> getProdottiCarrelliCliente(String id_cliente) {
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
}*/