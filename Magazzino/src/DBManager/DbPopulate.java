package DBManager;
import Prodotti.Prodotto;
import Prodotti.TipoProdotto;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class DbPopulate {
    public static void populateVenditore() {
        DbInsert.insertVenditore("Pippo","Baudo","pippo@email.com","777","Sanremo","Italia","123");
        DbInsert.insertVenditore("Mickey","Mouse","mickey@email.com","111","Parigi, Tour Eiffel 12","Francia","4343");
        DbInsert.insertVenditore("Donald","Trump","trump@email.com","666","Trump tower St 21","USA","555");
    }

    public static void populateCliente() {
        DbInsert.insertCliente("Antonio","Iovine","anto@email.com","abc","Develhope Tower 99","Italia","0101");
        DbInsert.insertCliente("Matteo","Renzi","renzi@email.com","1af","Via Firenze 1, Firenze","Italia","3932");
        DbInsert.insertCliente("Lionel","Messi","messi@email.com","qwerty","Miami Beach 22","USA","987");
    }

    public static void populateProdotto() {
        for (int i = 1; i <= 10; i++) {
            DbInsert.insertProdotto(1, TipoProdotto.NOTEBOOK, "Alienware", "G6","NULL",1000,15.6, BigDecimal.valueOf(900),BigDecimal.valueOf(1300));
        }
        for (int i = 1; i <= 8; i ++) {
            DbInsert.insertProdotto(2, TipoProdotto.NOTEBOOK, "Lenovo", "XZ","NULL",1000,15.6, BigDecimal.valueOf(550.59),BigDecimal.valueOf(899.99));
        }
        for (int i = 1; i <= 5; i++) {
            DbInsert.insertProdotto(3, TipoProdotto.TABLET, "Samsung", "Galaxy Tab S6 Lite", "NULL", 128,
                    10.4, BigDecimal.valueOf(120.00), BigDecimal.valueOf(298.00));
        }
        for (int i = 1; i <= 9; i++) {
            DbInsert.insertProdotto(3, TipoProdotto.TABLET, "Samsung", "Galaxy Tab A7 Lite", "NULL", 64,
                    8.7, BigDecimal.valueOf(60), BigDecimal.valueOf(119.00));
        }
        for (int i = 1; i <= 2; i++) {
            DbInsert.insertProdotto(3, TipoProdotto.SMARTPHONE, "Samsung", "Galaxy A54", "NULL", 256,
                    6.4, BigDecimal.valueOf(250), BigDecimal.valueOf(529.00));
        }
        for (int i = 1; i <= 4; i++) {
            DbInsert.insertProdotto(3, TipoProdotto.SMARTPHONE, "Samsung", "Galaxy S23 Ultra", "NULL", 256,
                    6.8, BigDecimal.valueOf(450), BigDecimal.valueOf(999.00));
        }
        for (int i = 1; i <= 5; i++) {
            DbInsert.insertProdotto(2, TipoProdotto.SMARTPHONE, "Xiaomi",  "Redmi Note 12 Pro", "NULL", 256,
                    6.67, BigDecimal.valueOf(200), BigDecimal.valueOf(339.00));
        }
    }

//    public static void populateOrdineFinalizzato() {
//        DbOrdineFinalizzato.ordineFinalizzato("1", "1",  "20", OffsetDateTime.now());
//        DbOrdineFinalizzato.ordineFinalizzato("1", "1", "31", OffsetDateTime.now());
//    }

    public static void populateOrdine() {
        DbInsert.insertOrdine(1, OffsetDateTime.now().minusMonths(3));
        DbInsert.insertOrdine(1, OffsetDateTime.now().minusMonths(4));


        DbInsert.insertOrdine(2, OffsetDateTime.now().minusMonths(13));
        DbInsert.insertOrdine(2, OffsetDateTime.now().minusMonths(7));


        DbInsert.insertOrdine(3, OffsetDateTime.now().minusMonths(2));
        DbInsert.insertOrdine(3, OffsetDateTime.now().minusMonths(1));
    }

    public static void populateDettaglioOrdine() {
        DbInsert.insertDettaglioOrdine(1,1);
        DbInsert.insertDettaglioOrdine(19,1);

        DbInsert.insertDettaglioOrdine(2,2);

        DbInsert.insertDettaglioOrdine(3,3);

        DbInsert.insertDettaglioOrdine(4,4);
        DbInsert.insertDettaglioOrdine(11,4);
        DbInsert.insertDettaglioOrdine(20,4);
        DbInsert.insertDettaglioOrdine(24,4);

        DbInsert.insertDettaglioOrdine(5,5);
        DbInsert.insertDettaglioOrdine(6,5);
        DbInsert.insertDettaglioOrdine(7,5);

        DbInsert.insertDettaglioOrdine(21,6);
        DbInsert.insertDettaglioOrdine(25,6);


    }

    public static void populateCarrelloCliente() {
        DbInsert.insertCarrelloCliente(1);
        DbInsert.insertCarrelloCliente(1);

        DbInsert.insertCarrelloCliente(2);
        DbInsert.insertCarrelloCliente(2);
        DbInsert.insertCarrelloCliente(2);

        DbInsert.insertCarrelloCliente(3);
    }

    public static void populateProdottoCarrello() {
        DbInsert.insertProdottoCarrello(1,1);
        DbInsert.insertProdottoCarrello(1,2);
        DbInsert.insertProdottoCarrello(30,3);
        DbInsert.insertProdottoCarrello(29,4);
    }
}
