package mvc_lecture.dao;

import mvc_lecture.Config;
import mvc_lecture.models.Product;

import java.sql.*;

import com.mysql.cj.jdbc.Driver;

import java.util.ArrayList;
import java.util.List;

public class MySQLProducts implements Products{

    //MySQL implementation of the Products interface

    //What do I need to talk to MySQL -
    //i. Driver
    //ii. Connection //config file got this

    private Connection connectionObj;

    public MySQLProducts() throws SQLException {
    }

    public MySQLProducts(Config configObject) throws SQLException, SQLException {
        DriverManager.registerDriver(new Driver());
        this.connectionObj = DriverManager.getConnection(
                configObject.getUrl(),
                configObject.getUser(),
                configObject.getPassword()
        );
    }

    //iii. Statements
    //iv. ResultSet From the Statement obj

    @Override
    public List<Product> all() throws SQLException {
        //What do I need to make an all() method work with this method signature
        //I need to return a List<ProductObjs>
        Statement statementObj = connectionObj.createStatement();
        //executeStatements?? ResultSet. .
        ResultSet resultSetObj = statementObj.executeQuery("SELECT * from products");

        //Can I use my result set to make some objects?
        List<Product> myProducts = new ArrayList();

        //Can I add.. my objects to an arrayList. . and return the list
        while(resultSetObj.next()){
          myProducts.add(
                  new Product(resultSetObj.getString("name"), resultSetObj.getDouble("price")

                  )
          );

        }

        return myProducts;
    }

    @Override
    public void insert(Product product) {

    }

}
