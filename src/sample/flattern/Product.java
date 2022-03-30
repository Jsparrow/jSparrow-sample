package sample.flattern;

import java.math.BigDecimal;

public class Product {

    private BigDecimal price;
    private String name;
    private String description;

    public Product(BigDecimal price, String name, String description) {
        this.price = price;
        this.name = name;
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
