package org.HMB.databaseServices;

import org.HMB.Database;
import org.HMB.fileReaderSQL.FileReaderSQL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseInsertService {
    public static String [] clientsNew = {"HP", "Lenovo", "Canon"};
    public static String[][] projectsNew = {
            {"9", "2023-06-01", "2024-09-30"},
            {"10", "2023-07-15", "2023-12-28"},
            {"11", "2023-07-01", "2024-11-15"}
    };
    public static String[][] workersNew = {
            {"Olena", "1994-09-12", "Trainee", "900"},
            {"Pavel","1984-07-20","Middle","4300"}
    };

    public static int[][] projectWorker = {
            {14,11},
            {15,7},
            {15,13},
            {16,14}
    };
    public static void main(String[] args) {

        try (Connection connection = Database.getInstance().getConnection()) {

            connection.setAutoCommit(false);

            try {
                insertClient(connection, clientsNew);
                insertWorker(connection, workersNew);
                connection.commit();

                System.out.println("Data insert");
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
            } finally {
                connection.setAutoCommit(true);
            }
            insertProjects(connection, projectsNew);
            insertProjectWorker(connection, projectWorker);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertClient(Connection connection, String[] clients) throws SQLException {
        String sqlFile = "./sql/insert_client.sql";
        String sqlQuery = new FileReaderSQL().readSQLFile(sqlFile);
        try (PreparedStatement clientStatement = connection.prepareStatement(sqlQuery)) {
            for (String client : clients) {
                clientStatement.setString(1, client);
                clientStatement.addBatch();
            }
            clientStatement.executeBatch();
        }
    }

    private static void insertProjects(Connection connection, String[][] projects) throws SQLException {
        String sqlFile = "./sql/insert_project.sql";
        String sqlQuery = new FileReaderSQL().readSQLFile(sqlFile);
        try (PreparedStatement projectStatement = connection.prepareStatement(sqlQuery)) {
            for (String[] projectData : projects) {
                projectStatement.setInt(1, Integer.parseInt(projectData[0]));
                projectStatement.setDate(2, Date.valueOf(projectData[1]));
                projectStatement.setDate(3, Date.valueOf(projectData[2]));
                projectStatement.addBatch();
            }
            projectStatement.executeBatch();
        }
    }

    private static void insertWorker(Connection connection, String[][] workers) throws SQLException {
        String sqlFile = "./sql/inserr_worker.sql";
        String sqlQuery = new FileReaderSQL().readSQLFile(sqlFile);
        try (PreparedStatement workerStatement = connection.prepareStatement(sqlQuery)) {
            for (String[] worker : workers) {
                workerStatement.setString(1, worker[0]);
                workerStatement.setDate(2, Date.valueOf(worker[1]));
                workerStatement.setString(3, worker[2]);
                workerStatement.setInt(4,Integer.parseInt(worker[3]));
                workerStatement.addBatch();
            }
            workerStatement.executeBatch();
        }
    }

    private static void insertProjectWorker(Connection connection, int[][] projectWorker) throws SQLException {
        String sqlFile = "./sql/insert_project_worker.sql";
        String sqlQuery = new FileReaderSQL().readSQLFile(sqlFile);
        try (PreparedStatement PWStatement = connection.prepareStatement(sqlQuery)) {
            for (int [] wp : projectWorker) {
                PWStatement.setInt(1, wp[0]);
                PWStatement.setInt(2, wp[1]);
                PWStatement.addBatch();
            }
            PWStatement.executeBatch();
        }
    }
}
