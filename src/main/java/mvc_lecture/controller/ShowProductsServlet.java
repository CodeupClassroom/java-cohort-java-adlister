package mvc_lecture.controller;

import mvc_lecture.dao.DaoFactory;
import mvc_lecture.dao.Products;
import mvc_lecture.models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ShowProductsServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //I want to talk to the ALL method - the ALL method is in Products > implemented by ArrayListProducts > instantiated in DaoFactory

        //If I want a specific Data Access Object - I need to talk to my Factory!
        Products productDao = DaoFactory.getProductsDao(); //DaoFactory, go RUN this method (method > IF DAO EXISTS, gimme, IF DAO NOT EXISTS, create and gimme)

        //So now I've got a DAO - what do I do with it? We have a perfectly good ALL method we wrote :D
        List<Product> myProducts = productDao.all(); //Go run that ALL method and come back with the results of what the implementation tells you to do

        req.setAttribute("productsList", myProducts);

        req.getRequestDispatcher("/products/index.jsp").forward(req, resp);

    }

}
