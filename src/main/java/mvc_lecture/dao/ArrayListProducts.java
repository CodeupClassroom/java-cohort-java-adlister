package mvc_lecture.dao;

import mvc_lecture.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ArrayListProducts implements Products {
    //DAO - import the interface [has no details of HOW to do things] here

    //The DAO here will provide the HOW to do things - in this local example, it answers the question: "How do I interact with Product objects coming from an ArrayList datasource?"

    //Set up an ArrayList of products :D
    private List<Product> products = new ArrayList();


    //Now: A constructor to put THREE PRODUCT OBJECTS inside of our arraylist to begin [test data, hard code data]

    public ArrayListProducts(){
        insert(new Product("generator", 499.99));
        insert(new Product("snow plow", 199.99));
        insert(new Product("flux capacitors", 4999.99));

    }

    @Override
    public List<Product> all() {
        return this.products;
    }

    @Override
    public void insert(Product product) {
            this.products.add(product);
    }
}
