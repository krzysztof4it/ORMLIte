package pl.krzysztof4it;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Krzysztof on 2017-08-04.
 */

public class Main {

    public static void main(String[] args) throws SQLException, IOException, ParseException {

        String login = "admin";
        String pass= "admin";



        // this uses h2 but you can change it to match your database
        String databaseUrl = "jdbc:sqlite:databaseBook2"; /*SQLite */
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


        /*Insert data*/

        Book book = new Book();
        book.setTitle("Władce Pierścieni");
        book.setIsbn("1111");
        book.setAddedDate(new Date());

        SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/DD");
        String dateInString = "2012/05/05";
        Date date = sdf.parse(dateInString);

        book.setDateRelease(date);
        book.setRating("1");
        book.setBorrowed(true);
        book.setPrice(22.50);

        /*Object DAO and ID type*/
        Dao<Book, Integer> dao = DaoManager.createDao(connectionSource, Book.class);


        dao.create(book);
        System.out.println(book);

        book.setTitle("Hobbit");
        dao.update(book);
        System.out.println("Po update " + book);
        dao.delete(book);
        System.out.println("Po delete " + book);

        book = dao.queryForId(book.getId());
        System.out.println("Po query " + book);

        // close the connection source - zamknięcie połaczenia z DB
        connectionSource.close();









    }
}
