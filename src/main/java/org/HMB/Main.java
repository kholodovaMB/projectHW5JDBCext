package org.HMB;

import org.HMB.databaseServices.DatabaseQueryService;
import org.HMB.entitys.querysSQL.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        Connection connection = Database.getInstance().getConnection();
        DatabaseQueryService service = new DatabaseQueryService(connection);

        List<MaxProjectCountClient> maxProjectsClients = service.findMaxProjectsClient();
        if (!Objects.isNull(maxProjectsClients)) {
            for (MaxProjectCountClient client : maxProjectsClients) {
                System.out.println(client.toString());
            }
        } else {
            System.out.println("result not found");
        }

        List<MaxSalaryWorker> maxSalaryWorkers = service.findMaxSalaryWorker();
        if (!Objects.isNull(maxSalaryWorkers)){
            for (MaxSalaryWorker worker : maxSalaryWorkers) {
                System.out.println(worker.toString());
            }
        } else {
            System.out.println("result not found");
        }

        List<LongestProject> maxLongestProjects = service.findLongestProject();
        if (!Objects.isNull(maxLongestProjects)) {
            for (LongestProject project : maxLongestProjects) {
                System.out.println(project.toString());
            }
        } else {
            System.out.println("result not found!");
        }

        List<YoungestEldestWorkers> typeWorkers = service.findLYoungestEldestWorkers();
        if (!Objects.isNull(maxSalaryWorkers)) {
            for (YoungestEldestWorkers type : typeWorkers) {
                System.out.println(type.toString());
            }
        } else {
            System.out.println("result not found");
        }

        List<ProjectsPrices> projectsPrices = service.findProjectPrices();
        if(!Objects.isNull(projectsPrices)) {
            for (ProjectsPrices price : projectsPrices) {
                System.out.println(price.toString());
            }
        } else {
            System.out.println("result not found");
        }

        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}