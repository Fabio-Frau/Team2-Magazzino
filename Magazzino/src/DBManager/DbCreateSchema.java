package DBManager;

import java.sql.Statement;

import static DBManager.DbManager.createStatementForDbMagazzino;
import static DBManager.DbManager.createStatementForDbRoot;

public class DbCreateSchema {
    public static void createDb () {
        try (Statement stmt = createStatementForDbRoot()) {
            String query = "CREATE DATABASE IF NOT EXISTS magazzino";
            stmt.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void addDisponibilita() {
        try (Statement stmt = createStatementForDbRoot()) {
            String query = "ALTER TABLE prodotto ADD COLUMN disponibilita TINYINT(1) NOT NULL DEFAULT 1";
            stmt.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void createClienteTab () {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "CREATE TABLE IF NOT EXISTS cliente (" +
                    "id_cliente INT NOT NULL AUTO_INCREMENT," +
                    "nome VARCHAR(50) NOT NULL," +
                    "cognome VARCHAR(50) NOT NULL," +
                    "email VARCHAR(50) NOT NULL," +
                    "password VARCHAR(50) NOT NULL," +
                    "indirizzo VARCHAR(100) NOT NULL," +
                    "paese VARCHAR(50) NOT NULL," +
                    "telefono VARCHAR(15) NOT NULL," +
                    "PRIMARY KEY (id_cliente));";

            stmt.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void createVenditoreTab () {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "CREATE TABLE IF NOT EXISTS venditore (" +
                    "id_venditore INT NOT NULL AUTO_INCREMENT," +
                    "nome VARCHAR(50) NOT NULL," +
                    "cognome VARCHAR(50) NOT NULL," +
                    "email VARCHAR(50) NOT NULL," +
                    "password VARCHAR(50) NOT NULL," +
                    "indirizzo VARCHAR(100) NOT NULL," +
                    "paese VARCHAR(50) NOT NULL," +
                    "telefono VARCHAR(15) NOT NULL," +
                    "PRIMARY KEY (id_venditore));";

            stmt.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void createProdottoTab() {
        try (Statement stmt = createStatementForDbMagazzino()){
            String query = "CREATE TABLE IF NOT EXISTS prodotto (" +
                    "id_prodotto INT NOT NULL AUTO_INCREMENT," +
                    "id_venditore INT NOT NULL," +
                    "categoria ENUM('SMARTPHONE','NOTEBOOK','TABLET') NOT NULL," +
                    "produttore VARCHAR(50) NOT NULL," +
                    "modello VARCHAR(50) NOT NULL," +
                    "descrizione VARCHAR(255) NULL," +
                    "dimensione_memoria INT NOT NULL," +
                    "dimensione_schermo FLOAT NOT NULL," +
                    "prezzo_acquisto DECIMAL(7,2) NOT NULL," +
                    "prezzo_vendita DECIMAL(7,2) NOT NULL," +
                    "PRIMARY KEY (id_prodotto));";

            stmt.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void addColumnDisp() {
        try (Statement stmt = createStatementForDbMagazzino()){
            String query = "ALTER TABLE prodotto " +
                    "ADD COLUMN disponibile TINYINT(1) NOT NULL DEFAULT 1";

            stmt.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void createDettaglioOrdineTab() {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "CREATE TABLE IF NOT EXISTS dettaglioOrdine (" +
                    "id_prodotto INT NOT NULL," +
                    "id_ordine INT NOT NULL," +
                    "PRIMARY KEY (id_prodotto, id_ordine));";
            stmt.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void createOrdineTab() {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "CREATE TABLE IF NOT EXISTS ordine (" +
                    "id_ordine INT NOT NULL AUTO_INCREMENT," +
                    "id_cliente INT NOT NULL," +
                    "data_esecuzione DATETIME," +
                    "PRIMARY KEY (id_ordine));";
            stmt.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void createProdottoCarelloTab() {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "CREATE TABLE IF NOT EXISTS prodottoCarrello (" +
                    "id_carrello INT NOT NULL," +
                    "id_prodotto INT NOT NULL," +
                    "PRIMARY KEY (id_carrello, id_prodotto));";
            stmt.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void createCarrelloClienteTab() {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "CREATE TABLE IF NOT EXISTS carrelloCliente (" +
                    "id_carrello INT NOT NULL AUTO_INCREMENT," +
                    "id_cliente INT NOT NULL," +
                    "PRIMARY KEY (id_carrello));";
            stmt.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void createFkProdottoVenditore() {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "ALTER TABLE prodotto " +
                    "ADD CONSTRAINT FK_prodotto_venditore " +
                    "FOREIGN KEY (id_venditore) " +
                    "REFERENCES venditore(id_venditore);";
            stmt.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void createFkDettaglioOrdineProdotto() {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "ALTER TABLE dettaglioOrdine " +
                    "ADD CONSTRAINT FK_dettaglioOrdine_prodotto " +
                    "FOREIGN KEY (id_prodotto) " +
                    "REFERENCES prodotto(id_prodotto);";
            stmt.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void createFkDettaglioOrdineOrdine() {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "ALTER TABLE dettaglioOrdine " +
                    "ADD CONSTRAINT FK_dettaglioOrdine_ordine " +
                    "FOREIGN KEY (id_ordine) " +
                    "REFERENCES ordine(id_ordine);";
            stmt.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void createFkOrdineCliente() {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "ALTER TABLE ordine " +
                    "ADD CONSTRAINT FK_ordine_cliente " +
                    "FOREIGN KEY (id_cliente) " +
                    "REFERENCES cliente(id_cliente);";
            stmt.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void createFkCarrelloClienteCliente() {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "ALTER TABLE carrelloCliente " +
                    "ADD CONSTRAINT FK_carrelloCliente_cliente " +
                    "FOREIGN KEY (id_cliente) " +
                    "REFERENCES cliente(id_cliente);";
            stmt.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void createFkProdottoCarrello_CarrelloCliente() {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "ALTER TABLE prodottoCarrello " +
                    "ADD CONSTRAINT FK_prodottoCarrello_carrelloCliente " +
                    "FOREIGN KEY (id_carrello) " +
                    "REFERENCES carrelloCliente(id_carrello) ON DELETE CASCADE;";
            stmt.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void createFkProdottoCarrelloProdotto() {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "ALTER TABLE prodottoCarrello " +
                    "ADD CONSTRAINT FK_prodottoCarrello_prodotto " +
                    "FOREIGN KEY (id_prodotto) " +
                    "REFERENCES prodotto(id_prodotto);";
            stmt.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void createUKDettaglioProdotto() {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "ALTER TABLE magazzino.dettaglioordine " +
                    "ADD CONSTRAINT dettaglioordine_un UNIQUE KEY (id_prodotto);";
            stmt.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public static void createUKEmailCliente() {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "ALTER TABLE magazzino.cliente " +
                    "ADD CONSTRAINT cliente_un_email UNIQUE KEY (email);";
            stmt.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void createUKEmailVenditore() {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "ALTER TABLE magazzino.venditore " +
                    "ADD CONSTRAINT venditore_un_email UNIQUE KEY (email);";
            stmt.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void createUKTelefonoVenditore() {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "ALTER TABLE magazzino.venditore " +
                    "ADD CONSTRAINT venditore_un_telefono UNIQUE KEY (telefono);";
            stmt.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void createUKTelefonoCliente() {
        try (Statement stmt = createStatementForDbMagazzino()) {
            String query = "ALTER TABLE magazzino.cliente " +
                    "ADD CONSTRAINT cliente_un_telefono UNIQUE KEY (telefono);";
            stmt.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
