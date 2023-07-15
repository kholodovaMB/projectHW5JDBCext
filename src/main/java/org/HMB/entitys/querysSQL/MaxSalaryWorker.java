package org.HMB.entitys.querysSQL;

public class MaxSalaryWorker {
    private String name;
    private int maxSalaryWorker;

    public MaxSalaryWorker(String name, int maxSalaryWorker) {
        this.name = name;
        this.maxSalaryWorker = maxSalaryWorker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxSalaryWorker() {
        return maxSalaryWorker;
    }

    public void setMaxSalaryWorker(int maxSalaryWorker) {
        this.maxSalaryWorker = maxSalaryWorker;
    }

    @Override
    public String toString() {
        return "MaxSalaryWorker{" +
                "name='" + name + '\'' +
                ", maxSalaryWorker=" + maxSalaryWorker +
                '}';
    }
}
