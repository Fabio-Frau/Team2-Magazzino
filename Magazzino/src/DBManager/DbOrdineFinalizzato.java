package DBManager;

import java.sql.Statement;
import java.time.OffsetDateTime;


import static DBManager.DbManager.createStatementForDbMagazzino;

public class DbOrdineFinalizzato {

    public static void ordineFinalizzato (String id_of, String id_cliente, String id_prodotto, OffsetDateTime data_esecuzione){
        try (Statement stmt = createStatementForDbMagazzino()) {
            String data = data_esecuzione.toString();
            String query = "INSERT INTO ordine_finalizzato (id_of, id_cliente, id_prodotto, data )" +
                    " VALUES ( '"+ id_of + " ',' " +   id_cliente + " ',' " + id_prodotto + " ',' " + data +" ');";
            //System.out.println(query);
            stmt.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
