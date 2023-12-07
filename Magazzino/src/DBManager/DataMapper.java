package DBManager;

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
}
