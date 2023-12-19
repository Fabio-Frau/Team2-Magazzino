package DBManager;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbCallProcedures {

    public static CallableStatement createCallableStatementForDbMagazzino(String procedureCall) {
        try (Connection conn = DbManager.createConnectionForDbMagazzino()){

            return conn.prepareCall(procedureCall);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void callInsertProdottoIntoCarrello(int idcarrello, int idprodotto, int idcliente) {
        try (Connection conn = DbManager.createConnectionForDbMagazzino()) {
            CallableStatement cs = conn.prepareCall("CALL insertProdottoIntoCarrello(?,?,?)");

            cs.setInt("idcarrello", idcarrello);
            cs.setInt("idprodotto", idprodotto);
            cs.setInt("idcliente", idcliente);

            cs.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
