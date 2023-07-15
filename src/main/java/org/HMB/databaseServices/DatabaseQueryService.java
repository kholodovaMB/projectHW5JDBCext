package org.HMB.databaseServices;
import org.HMB.entitys.querysSQL.*;
import org.HMB.fileReaderSQL.FileReaderSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    private final Connection connection;

    public DatabaseQueryService(Connection connection) {
        this.connection = connection;
    }
    public List<MaxProjectCountClient> findMaxProjectsClient(){
        String sqlFile = "./sql/find_max_projects_client.sql";
        String sqlQuery = new FileReaderSQL().readSQLFile(sqlFile);
        List<MaxProjectCountClient> maxProjectCountClients = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
           ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()){
                String name = rs.getString("name");
                int projectCount = rs.getInt("project_count");
                MaxProjectCountClient client = new MaxProjectCountClient(name, projectCount);
                maxProjectCountClients.add(client);
            }
        } catch (
                SQLException e){
            e.printStackTrace();
        }
        return maxProjectCountClients;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker(){
        String sqlFile = "./sql/find_max_salary_worker.sql";
        String sqlQuery = new FileReaderSQL().readSQLFile(sqlFile);
        List<MaxSalaryWorker> maxSalaryWorker = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()){
                String name = rs.getString("name");
                int maxSalary = rs.getInt("salary");
                MaxSalaryWorker worker = new MaxSalaryWorker(name, maxSalary);
                maxSalaryWorker.add(worker);
            }
        } catch (
                SQLException e){
            e.printStackTrace();
        }
        return maxSalaryWorker;
    }

    public List<LongestProject> findLongestProject(){
        String sqlFile = "./sql/find_longest_project.sql";
        String sqlQuery = new FileReaderSQL().readSQLFile(sqlFile);
        List<LongestProject> maxLongestProjects = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()){
                String name = rs.getString("name");
                int monthCount = rs.getInt("month_count");
                LongestProject project = new LongestProject(name, monthCount);
                maxLongestProjects.add(project);
            }
        } catch (
                SQLException e){
            e.printStackTrace();
        }
        return maxLongestProjects;
    }

    public List<YoungestEldestWorkers> findLYoungestEldestWorkers(){
        String sqlFile = "./sql/find_youngest_eldest_workers.sql";
        String sqlQuery = new FileReaderSQL().readSQLFile(sqlFile);
        List<YoungestEldestWorkers> youngestEldestWorkers = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()){
                String type = rs.getString("type");
                String name = rs.getString("name");
                LocalDate birthday = rs.getDate("birthday").toLocalDate();
                YoungestEldestWorkers typeWorkers = new YoungestEldestWorkers(type, name, birthday);
                youngestEldestWorkers.add(typeWorkers);
            }
        } catch (
                SQLException e){
            e.printStackTrace();
        }
        return youngestEldestWorkers;
    }

    public List<ProjectsPrices> findProjectPrices(){
        String sqlFile = "./sql/print_project_prices.sql";
        String sqlQuery = new FileReaderSQL().readSQLFile(sqlFile);
        List<ProjectsPrices> projectsPrices = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()){
                int id = rs.getInt("id");
                Long price = rs.getLong("price");
                ProjectsPrices projectPrice = new ProjectsPrices(id, price);
                projectsPrices.add(projectPrice);
            }
        } catch (
                SQLException e){
            e.printStackTrace();
        }
        return projectsPrices;
    }
}
