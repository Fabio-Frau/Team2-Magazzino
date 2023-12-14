package DBManager;

import Login.Cliente;
import Login.Utente;
import Prodotti.Prodotto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static DBManager.DbManager.createStatementForDbMagazzino;

public class DbRicercaCliente {
    public static ArrayList<Cliente> ricercaPerId(String id) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "SELECT id_cliente, nome, cognome, email, password, indirizzo, paese, telefono\n" +
                    "FROM cliente\n" +
                    "WHERE id_cliente =" + id + " ;";
            System.out.println(query);

            ResultSet rs = stmt.executeQuery(query);

            return DataMapper.getClientiFromDb(rs);


        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
