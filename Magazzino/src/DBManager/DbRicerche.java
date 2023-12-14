package DBManager;

import Prodotti.Prodotto;
import Prodotti.TipoProdotto;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static DBManager.DbManager.createStatementForDbMagazzino;

public class DbRicerche {

    public static ArrayList<Prodotto> ricercaPerModello(String modello) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "SELECT id_prodotto, categoria, produttore, modello, descrizione, dimensione_memoria, dimensione_schermo, prezzo_acquisto, prezzo_vendita\n" +
                    "FROM prodotto\n" +
                    "WHERE modello LIKE '%" + modello + "%' ;";
            System.out.println(query);

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
            System.out.println(query);

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
            System.out.println(query);

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
            System.out.println(query);

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
            System.out.println(query);

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
            System.out.println(query);

            ResultSet rs = stmt.executeQuery(query);

            return DataMapper.getProdottiFromDb(rs);


        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static ArrayList<Prodotto> ricercaPerPrezzo(BigDecimal prezzoMinimo, BigDecimal prezzoMassimo) {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "SELECT id_prodotto, categoria, produttore, modello, descrizione, dimensione_memoria, dimensione_schermo, prezzo_acquisto, prezzo_vendita\n" +
                    "FROM prodotto\n" +
                    "WHERE prezzo_vendita BETWEEN " + prezzoMinimo + " AND " + prezzoMassimo + ";";
            System.out.println(query);

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
            System.out.println(query);

            ResultSet rs = stmt.executeQuery(query);

            return DataMapper.getProdottiFromDb(rs);


        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

}

/*"id_prodotto INT NOT NULL AUTO_INCREMENT," +
                    "id_venditore INT NOT NULL," +
                    "categoria ENUM('SMARTPHONE','NOTEBOOK','TABLET') NOT NULL," +
                    "produttore VARCHAR(50) NOT NULL," +
                    "modello VARCHAR(50) NOT NULL," +
                    "descrizione VARCHAR(255) NULL," +
                    "dimensione_memoria INT NOT NULL," +
                    "dimensione_schermo FLOAT NOT NULL," +
                    "prezzo_acquisto DECIMAL(7,2) NOT NULL," +
                    "prezzo_vendita DECIMAL(7,2) NOT NULL," +*/