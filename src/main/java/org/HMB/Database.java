package org.HMB;

import org.HMB.dataBaseConfigurate.ConfigurateDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class Database {
    private static final Database INSTANCE = new Database();
    private Connection connection;
    private Database(){
        if (Objects.isNull(connection)) {
            try {
                Class.forName("org.h2.Driver");
                connection = DriverManager.getConnection(ConfigurateDB.connectionURL);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static Database getInstance(){
        return INSTANCE;
    }
    public Connection getConnection(){
        return connection;
    }
    public void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
