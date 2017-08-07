package pl.krzysztof4it;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Krzysztof on 2017-08-04.
 */

public class Main {

    public static void main(String[] args) throws SQLException, IOException {

        String login = "admin";
        String pass= "admin";



        // this uses h2 but you can change it to match your database
        String databaseUrl = "jdbc:sqlite:databaseBook"; /*SQLite */
        String databaseUrlH2 = "jdbc:h2:./databaseBook";


        /*jdbc - sterownik
        * sqllite - typ bazy
        * baza - nazwa bazy danych
        * + hasło i użytkownik
        * */


        // create a connection source to our database, driver, login, pass
        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl, login, pass);


        //TableUtils.dropTable(connectionSource, Book.class, true);
        TableUtils.createTableIfNotExists(connectionSource, Book.class); /*tworzy jeśli nie istnieje*/
        // TableUtils.createTable(connectionSource, Book.class); /*create DB from Book class*/



        // close the connection source - zamknięcie połaczenia z DB
        connectionSource.close();








    }
}
