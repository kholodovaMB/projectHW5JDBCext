package org.HMB.databaseServices;

import org.HMB.Database;
import org.HMB.fileReaderSQL.FileReaderSQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {
    public static void main(String[] args) {
        String sqlFile = "./sql/init_db.sql";
        String sqlQuery = new FileReaderSQL().readSQLFile(sqlFile);

        Connection connection = Database.getInstance().getConnection();
        try (Statement statement = connection.createStatement()) {
            statement.execute(sqlQuery);
        } catch (SQLException e){
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
