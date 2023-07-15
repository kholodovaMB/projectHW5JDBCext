package org.HMB.entitys.querysSQL;

public class LongestProject {
    private String name;
    private int monthCount;

    public LongestProject(String name, int monthCount) {
        this.name = name;
        this.monthCount = monthCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMounthCount() {
        return monthCount;
    }

    public void setMounthCount(int mounthCount) {
        this.monthCount = mounthCount;
    }

    @Override
    public String toString() {
        return "LongestProject{" +
                "name='" + name + '\'' +
                ", mounthCount=" + monthCount +
                '}';
    }
}
