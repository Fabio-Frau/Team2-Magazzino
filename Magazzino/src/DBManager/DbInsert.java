package DBManager;
import Carrello.Carrello;
import Login.Cliente;
import Login.Gestore;
import Prodotti.Prodotto;
import Prodotti.TipoProdotto;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.OffsetDateTime;
import static DBManager.DbManager.*;

public class DbInsert {

    public static void insertProdottoIntoProdotto(Prodotto prodotto, Gestore gestore) {
        try (Statement stmt = createStatementForDbMagazzino()) {
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

    public static void insertProdottoQuantitaVolte(Prodotto prodotto, int quantita, Gestore gestore) {
        for (int i = 0; i < quantita; i++) {
            insertProdottoIntoProdotto(prodotto, gestore);
        }
    }

    public static void insertProdottoIntoProdottoCarrello(int id_prodotto, int id_carrello, Cliente cliente) {
        try (Statement stmt = createStatementForDbMagazzino()) {
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

    public static void insertVenditore(String nome, String cognome, String email, String password, String indirizzo, String paese, String num_telefono) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "INSERT INTO venditore (nome, cognome, email, password, indirizzo, paese, telefono) " +
                    "VALUES ( '" + nome + "', '" + cognome + "', '" + email + "', '" + password + "', '" + indirizzo +
                    "', '" + paese + "', '" + num_telefono + "' );";

            stmt.execute(query);

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void insertCliente(String nome, String cognome, String email, String password, String indirizzo, String paese, String num_telefono) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "INSERT INTO cliente (nome, cognome, email, password, indirizzo, paese, telefono) " +
                    "VALUES ( '" + nome + "', '" + cognome + "', '" + email + "', '" + password + "', '" + indirizzo +
                    "', '" + paese + "', '" + num_telefono + "' );";

            stmt.execute(query);

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void insertProdotto(int id_venditore, TipoProdotto categoria, String produttore, String modello,
                                      String descrizione, int dimesione_memoria, double dimensione_schermo,
                                      BigDecimal prezzoAcquisto, BigDecimal prezzoVendita) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "INSERT INTO prodotto (id_venditore, categoria, produttore, modello, descrizione, dimensione_memoria, " +
                    "dimensione_schermo, prezzo_acquisto, prezzo_vendita) " + "VALUES ( '" + id_venditore + "', '" + categoria +
                    "', '" + produttore + "', '" + modello + "', '" + descrizione + "', '" + dimesione_memoria + "', '" +
                    dimensione_schermo + "', '" + prezzoAcquisto.setScale(2) + "', '" + prezzoVendita.setScale(2) + "' );";

            stmt.execute(query);

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public static Integer insertOrdine(int id_cliente, OffsetDateTime data_esecuzione) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String data = data_esecuzione.toString();
            String query = "INSERT INTO ordine (id_cliente, data_esecuzione ) " + "VALUES ( '" + id_cliente + "', '" + data  + "' );";
            stmt.execute(query);

            query = "select last_insert_id(); ";
            ResultSet rs = stmt.executeQuery(query);

            rs.next();
            int lastIndex = rs.getInt(1);

            return lastIndex;

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static void insertFromCarrelloToDettaglioOrdine(Carrello carrello, int id_ordine) {
        for (Prodotto prodotto : carrello.getCarrello()) {
            try (Statement stmt = createStatementForDbMagazzino()) {
                String query = "INSERT INTO dettaglioOrdine (id_prodotto, id_ordine ) " + "VALUES ( '" + prodotto.getId() + "', '" + id_ordine  + "' );";
                stmt.execute(query);

            } catch (SQLException e) {
                System.out.println(e);
            }
        }

    }


    public static void insertDettaglioOrdine(int id_prodotto, int id_ordine) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "INSERT INTO dettaglioOrdine (id_prodotto, id_ordine ) " + "VALUES ( '" + id_prodotto + "', '" + id_ordine  + "' );";
            stmt.execute(query);

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void insertCarrelloCliente( int id_cliente) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "INSERT INTO carrellocliente ( id_cliente ) " + "VALUES ( '" + id_cliente  + "' );";
            stmt.execute(query);

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void insertProdottoCarrello(int id_prodotto, int id_carrello) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "INSERT INTO prodottocarrello ( id_prodotto, id_carrello ) " + "VALUES ( '" + id_prodotto  + "', '" + id_carrello +  "' );";
            stmt.execute(query);

        } catch (SQLException e) {
            System.out.println(e);
        }
    }





}
