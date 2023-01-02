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


@WebServlet("/products/create")
public class CreateProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get request - get the FORM to the VIEW that will be SUBMITTED for a new product

        //things we need: logic to serve up a JSP
        req.getRequestDispatcher("/products/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //Okay - I want to INSERT a product into our data source

        //.insert() < Products >> ArrayListProducts >> daoFactory

        Products productsDao = DaoFactory.getProductsDao(); //Go GET that implementation / check for DAO object in existence

        //Method is expecting a product object (insert(Product product) for reference)

        String name = req.getParameter("name"); //Form had an input for the name

        double price = Double.parseDouble(req.getParameter("price")); //Form had an input for the price - we parse into a double data type

        //The name and price are good -  but it is NOT a product object yet :(

        Product newProduct = new Product(name, price); //An object named "newProduct" is of the Product datatype and instantiated from the Product constructor

        productsDao.insert(newProduct); //Object from above line sent as argument

        resp.sendRedirect("/products"); //When process is finished - redirect over to an endpoint named 'products' where the doGet on that servlet will respond




    }
}
