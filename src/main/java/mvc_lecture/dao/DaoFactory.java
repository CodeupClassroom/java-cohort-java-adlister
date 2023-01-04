package mvc_lecture.dao;

import mvc_lecture.Config;

import java.sql.SQLException;

public class DaoFactory {

    private static Products productsDao;


    public static Products getProductsDao() throws SQLException {
        Config configObj = new Config();
        if (productsDao == null) {
            productsDao = new MySQLProducts(configObj); //go get THIS implementation [ArrayListProducts()] for our purposes DaoFactory!
        }
        return productsDao;
    }

}
