package DBManager;

import Prodotti.TipoProdotto;

import java.math.BigDecimal;
import java.sql.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;

public class DbManager {
    private static final String DB_URL_ROOT = "jdbc:mysql://localhost:3306/mysql";
    private static final String USER_ROOT = "root";
    private static final String PASSWORD_ROOT = "Nerissa3091?";

    private static final String DB_URL_MAGAZZINO = "jdbc:mysql://localhost:3306/magazzino";
    private static final String USER_MAGAZZINO = "developer";
    private static final String PASSWORD_MAGAZZINO = "Nerissa3091?";

    public static void grantPrivilegeToDeveloper() {
        try (Statement stmt = createStatementForDbRoot()){
            String query = "GRANT ALL PRIVILEGES ON magazzino.* TO 'developer'@'localhost'";
            stmt.execute(query);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static Statement createStatementForDbRoot () {
        try {
            Connection conn = DriverManager.getConnection(DB_URL_ROOT, USER_ROOT, PASSWORD_ROOT);
            return conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static Statement createStatementForDbMagazzino () {
        try {
            Connection conn = DriverManager.getConnection(DB_URL_MAGAZZINO, USER_MAGAZZINO, PASSWORD_MAGAZZINO);
            return conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection createConnectionForDbMagazzino() {
        try {
            return DriverManager.getConnection(DB_URL_MAGAZZINO, USER_MAGAZZINO, PASSWORD_MAGAZZINO);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public static void initDb () {
        DbCreateSchema.createDb();
        DbManager.grantPrivilegeToDeveloper();
        DbCreateSchema.createClienteTab();
        DbCreateSchema.createVenditoreTab();
        DbCreateSchema.createProdottoTab();
        DbCreateSchema.addColumnDisp();
        DbCreateSchema.createDettaglioOrdineTab();
        DbCreateSchema.createOrdineTab();
        //DbCreateSchema.createOrdineFinalizzatoTab();
        DbCreateSchema.createProdottoCarelloTab();
        DbCreateSchema.createCarrelloClienteTab();
        DbCreateSchema.addDisponibilita();
        DbCreateSchema.createFkProdottoVenditore();
        DbCreateSchema.createFkDettaglioOrdineProdotto();
        DbCreateSchema.createFkDettaglioOrdineOrdine();
        DbCreateSchema.createFkOrdineCliente();
//        DbCreateSchema.createFkOrdineFinalizzatoProdotto();
//        DbCreateSchema.createFkOrdineFinalizzatoCliente();
        DbCreateSchema.createFkCarrelloClienteCliente();
        DbCreateSchema.createFkProdottoCarrello_CarrelloCliente();
        DbCreateSchema.createFkProdottoCarrelloProdotto();
        DbCreateSchema.createUKDettaglioProdotto();
        DbCreateSchema.createUKEmailCliente();
        DbCreateSchema.createUKEmailVenditore();
        DbCreateSchema.createUKTelefonoCliente();
        DbCreateSchema.createUKTelefonoVenditore();
       // DbCreateSchema.createUKOrdineFinalizzato();
        DbPopulate.populateVenditore();
        DbPopulate.populateCliente();
        DbPopulate.populateProdotto();
//        DbPopulate.populateOrdineFinalizzato();
        DbPopulate.populateOrdine();
        DbPopulate.populateDettaglioOrdine();
        DbPopulate.populateCarrelloCliente();
        DbPopulate.populateProdottoCarrello();
        DbCreateSchema.createProcedureInsertProdottoIntoCarrello();
    }



}
