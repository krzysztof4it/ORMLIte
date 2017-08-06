package pl.krzysztof4it;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Krzysztof on 2017-08-04.
 */
@DatabaseTable(tableName = "accounts")
public class Account {

    @DatabaseField(id = true)
        private String name;

        @DatabaseField(canBeNull = false)
        private String password;
        Account() {
            // all persisted classes must define a no-arg constructor with at least package visibility
        }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
