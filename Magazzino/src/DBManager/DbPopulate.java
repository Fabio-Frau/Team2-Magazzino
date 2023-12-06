package DBManager;

import Prodotti.TipoProdotto;

import java.math.BigDecimal;

public class DbPopulate {
    public static void populateVenditore() {
        DbManager.insertVenditore("Pippo","Baudo","pippo@email.com","777","Sanremo","Italia","123");
        DbManager.insertVenditore("Mickey","Mouse","mickey@email.com","111","Parigi, Tour Eiffel 12","Francia","4343");
        DbManager.insertVenditore("Donald","Trump","trump@email.com","666","Trump tower St 21","USA","555");
    }

    public static void populateCliente() {
        DbManager.insertCliente("Antonio","Iovine","anto@email.com","abc","Develhope Tower 99","Italia","0101");
        DbManager.insertCliente("Matteo","Renzi","renzi@email.com","1af","Via Firenze 1, Firenze","Italia","3932");
        DbManager.insertCliente("Lionel","Messi","messi@email.com","qwerty","Miami Beach 22","USA","987");
    }

    public static void populateProdotto() {
        for (int i = 1; i <= 10; i++) {
            DbManager.insertProdotto(1, TipoProdotto.NOTEBOOK, "Alienware", "G6","NULL",1000,15.6, BigDecimal.valueOf(900),BigDecimal.valueOf(1300));
        }
        for (int i = 1; i <= 8; i ++) {
            DbManager.insertProdotto(2, TipoProdotto.NOTEBOOK, "Lenovo", "XZ","NULL",1000,15.6, BigDecimal.valueOf(550.59),BigDecimal.valueOf(899.99));
        }
        for (int i = 1; i <= 5; i++) {
            DbManager.insertProdotto(3, TipoProdotto.TABLET, "Samsung", "Galaxy Tab S6 Lite", "NULL", 128,
                    10.4, BigDecimal.valueOf(120.00), BigDecimal.valueOf(298.00));
        }
        for (int i = 1; i <= 9; i++) {
            DbManager.insertProdotto(3, TipoProdotto.TABLET, "Samsung", "Galaxy Tab A7 Lite", "NULL", 64,
                    8.7, BigDecimal.valueOf(60), BigDecimal.valueOf(119.00));
        }


    }
}
