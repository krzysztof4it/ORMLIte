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
        String databaseUrl = "jdbc:sqlite:database"; /*SQLite */
        String databaseUrlH2 = "jdbc:h2:./database";


        /*jdbc - sterownik
        * sqllite - typ bazy
        * baza - nazwa bazy danych
        * + hasło i użytkownik
        * */


        // create a connection source to our database, driver, login, pass
        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl, login, pass);

        // instantiate the DAO to handle Account with String id - operacje na DB
        Dao<Account,String> accountDao = DaoManager.createDao(connectionSource, Account.class);
        // if you need to create the 'accounts' table make this call
        TableUtils.createTable(connectionSource, Account.class);



        Account account = new Account();
        account.setName("Jim Smith");
        account.setPassword("pass");

        // persist the account object to the database
        accountDao.create(account);



        // close the connection source - zamknięcie połaczenia z DB
        connectionSource.close();








    }
}
