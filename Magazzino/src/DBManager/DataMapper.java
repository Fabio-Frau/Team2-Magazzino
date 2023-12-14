package DBManager;

import Login.Cliente;
import Prodotti.Prodotto;
import Prodotti.TipoProdotto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataMapper {
    public static ArrayList<Prodotto> getProdottiFromDb(ResultSet rs) {
        ArrayList<Prodotto> prodotti = new ArrayList<>();
        try {
            while (rs.next()) {
                prodotti.add(new Prodotto(TipoProdotto.valueOf(rs.getString("categoria")), rs.getString("produttore"),
                        rs.getString("modello"), rs.getString("id_prodotto"), rs.getString("descrizione"),
                        rs.getDouble("dimensione_schermo"), rs.getInt("dimensione_memoria"),
                        rs.getBigDecimal("prezzo_acquisto"), rs.getBigDecimal("prezzo_vendita")
                        ));
            }
            return prodotti;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static ArrayList<Cliente> getClientiFromDb (ResultSet rs) {
        ArrayList<Cliente> clienti = new ArrayList<>();
        try {
            while (rs.next()) {
                clienti.add(new Cliente(rs.getString("id_cliente"), rs.getString("nome"), rs.getString("cognome"),
                        rs.getString("email"), rs.getString("password"), rs.getString("indirizzo"),
                        rs.getString("paese"), rs.getInt("telefono"))
                );
            }
            return clienti;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
