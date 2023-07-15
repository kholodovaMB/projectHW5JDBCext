package org.HMB.entitys.querysSQL;

public class ProjectsPrices {

    private int id;
    private Long price;

    public ProjectsPrices(int id, Long price) {
        this.id = id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProjectsPrices{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }
}
