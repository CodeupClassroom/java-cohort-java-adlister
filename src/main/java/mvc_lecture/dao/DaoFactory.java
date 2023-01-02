package mvc_lecture.dao;

public class DaoFactory {

    private static Products productsDao;

    public static Products getProductsDao() {
        if (productsDao == null) {
            productsDao = new ArrayListProducts(); //go get THIS implementation [ArrayListProducts()] for our purposes DaoFactory!
        }
        return productsDao;
    }

}
