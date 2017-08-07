package pl.krzysztof4it;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Krzysztof on 2017-08-07.
 * Classa = Database:
 * + @DatabaseTable
 * + @DatabaseField(generatedId = true) - one filed in table
 * + empty constructor
 *
 */

@DatabaseTable(tableName = "books") /* adnotacja - tabela bazy danych */
public class Book {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "TITLE")
    private String title;

    @DatabaseField(columnName = "PRICE")
    private double price;




    public Book() {
    }
}
