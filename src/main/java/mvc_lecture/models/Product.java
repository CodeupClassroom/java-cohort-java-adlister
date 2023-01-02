package mvc_lecture.models;

import java.io.Serializable;

public class Product implements Serializable {

    //Product bean - an entity that would have a corresponding table in a full MySQL example - for now, it is a model that will use local arraylists
    private String name;
    private double price;


    public Product() {
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
