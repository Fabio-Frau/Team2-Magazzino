package DBManager;

import Login.Gestore;
import Prodotti.Prodotto;
import Prodotti.TipoProdotto;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static DBManager.DbManager.createStatementForDbMagazzino;

public class DbRicercaProdotto {

    public static ArrayList<Prodotto> ricercaTuttiProdotti() {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "SELECT *\n" +
                    "FROM prodotto;";

            ResultSet rs = stmt.executeQuery(query);
            return DataMapper.getProdottiFromDb(rs);

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static ArrayList<Prodotto> ricercaPerVenditore(Gestore gestore) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "SELECT id_prodotto, categoria, produttore, modello, descrizione, dimensione_memoria, dimensione_schermo, prezzo_acquisto, prezzo_vendita\n" +
                    "FROM prodotto\n" +
                    "WHERE id_venditore = " + gestore.getId() + " ;";

            ResultSet rs = stmt.executeQuery(query);
            return DataMapper.getProdottiFromDb(rs);

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static ArrayList<Prodotto> ricercaPerModello(String modello) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "SELECT id_prodotto, categoria, produttore, modello, descrizione, dimensione_memoria, dimensione_schermo, prezzo_acquisto, prezzo_vendita\n" +
                    "FROM prodotto\n" +
                    "WHERE modello LIKE '%" + modello + "%' ;";

            ResultSet rs = stmt.executeQuery(query);
            return DataMapper.getProdottiFromDb(rs);

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static ArrayList<Prodotto> ricercaPerProduttore(String produttore) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "SELECT id_prodotto, categoria, produttore, modello, descrizione, dimensione_memoria, dimensione_schermo, prezzo_acquisto, prezzo_vendita\n" +
                    "FROM prodotto\n" +
                    "WHERE produttore LIKE '%" + produttore + "%' ;";

            ResultSet rs = stmt.executeQuery(query);
            return DataMapper.getProdottiFromDb(rs);

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static ArrayList<Prodotto> ricercaPerID(int id) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "SELECT id_prodotto, categoria, produttore, modello, descrizione, dimensione_memoria, dimensione_schermo, prezzo_acquisto, prezzo_vendita\n" +
                    "FROM prodotto\n" +
                    "WHERE id_prodotto LIKE '%" + id + "%' ;";

            ResultSet rs = stmt.executeQuery(query);
            return DataMapper.getProdottiFromDb(rs);

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static ArrayList<Prodotto> ricercaPerCategoria(TipoProdotto categoria) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "SELECT id_prodotto, categoria, produttore, modello, descrizione, dimensione_memoria, dimensione_schermo, prezzo_acquisto, prezzo_vendita\n" +
                    "FROM prodotto\n" +
                    "WHERE categoria LIKE '%" + categoria + "%' ;";

            ResultSet rs = stmt.executeQuery(query);
            return DataMapper.getProdottiFromDb(rs);

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static ArrayList<Prodotto> ricercaPerDescrizione(String descrizione) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "SELECT id_prodotto, categoria, produttore, modello, descrizione, dimensione_memoria, dimensione_schermo, prezzo_acquisto, prezzo_vendita\n" +
                    "FROM prodotto\n" +
                    "WHERE descrizione LIKE '%" + descrizione + "%' ;";

            ResultSet rs = stmt.executeQuery(query);
            return DataMapper.getProdottiFromDb(rs);

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static ArrayList<Prodotto> ricercaPerDimensioneSchermo(double dimensioneMin, double dimensioneMax) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "SELECT id_prodotto, categoria, produttore, modello, descrizione, dimensione_memoria, dimensione_schermo, prezzo_acquisto, prezzo_vendita\n" +
                    "FROM prodotto\n" +
                    "WHERE dimensione_schermo BETWEEN " + dimensioneMin + " AND " + dimensioneMax + ";";

            ResultSet rs = stmt.executeQuery(query);
            return DataMapper.getProdottiFromDb(rs);

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static ArrayList<Prodotto> ricercaPerPrezzoVendita(BigDecimal prezzoMinimo, BigDecimal prezzoMassimo) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "SELECT id_prodotto, categoria, produttore, modello, descrizione, dimensione_memoria, dimensione_schermo, prezzo_acquisto, prezzo_vendita\n" +
                    "FROM prodotto\n" +
                    "WHERE prezzo_vendita BETWEEN " + prezzoMinimo + " AND " + prezzoMassimo + ";";

            ResultSet rs = stmt.executeQuery(query);
            return DataMapper.getProdottiFromDb(rs);

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static ArrayList<Prodotto> ricercaPerPrezzoAcquisto(BigDecimal prezzoMinimo, BigDecimal prezzoMassimo) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "SELECT id_prodotto, categoria, produttore, modello, descrizione, dimensione_memoria, dimensione_schermo, prezzo_acquisto, prezzo_vendita\n" +
                    "FROM prodotto\n" +
                    "WHERE prezzo_acquisto BETWEEN " + prezzoMinimo + " AND " + prezzoMassimo + ";";

            ResultSet rs = stmt.executeQuery(query);
            return DataMapper.getProdottiFromDb(rs);

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static ArrayList<Prodotto> ricercaPerMemoria(int memoriaMinima, int memoriaMassima) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "SELECT id_prodotto, categoria, produttore, modello, descrizione, dimensione_memoria, dimensione_schermo, prezzo_acquisto, prezzo_vendita\n" +
                    "FROM prodotto\n" +
                    "WHERE dimensione_memoria BETWEEN " + memoriaMinima + " AND " + memoriaMassima + ";";

            ResultSet rs = stmt.executeQuery(query);
            return DataMapper.getProdottiFromDb(rs);

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

}

