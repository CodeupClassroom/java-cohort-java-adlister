package jdbc_lecture;
import java.sql.*;

import com.mysql.cj.jdbc.Driver;

public class CodeRunner {

    //java_cohort_example_db name of our db
    //products name of our table
    public static void main(String[] args) throws SQLException {


        DriverManager.registerDriver(new Driver()); //Make a driver < a new Driver please

        Connection connectionObj = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_cohort_example_db ?allowPublicKeyRetrieval=true&useSSL=false",
                "root",
                "codeup");

        Statement statementObj = connectionObj.createStatement(); //Connection object - let's make a STATEMENT object to execute some queries (SELECT * from TABLE for example)

//        System.out.println(statementObj.execute("INSERT INTO products (name, price) VALUES ('flux capacitors', 19999.99)"));

        System.out.println(statementObj.executeUpdate("DELETE FROM products where name = 'flux capacitors'"));

        //SELECT all records FROM products
        //See in our terminal > product.name + " is this much " + product.price

        //First: We need our query and we need to save the returning resultSet object
        ResultSet resultSetObj = statementObj.executeQuery("SELECT * from products");

        //Second: We got a RESULTSET back - now to open up our resultset and do things with what is inside

        while (resultSetObj.next()) { //WHILE it is true there is something NEXT in our resultSet object. . .

            System.out.println("I found these products:");
            System.out.println("Our first product is " + resultSetObj.getString("name")); //grab this column by name and bring it in as this datatype

            System.out.println("The price of that product was:" + resultSetObj.getDouble("price")); //grab this column by name and bring it in as this datatype

            System.out.println("~~~~~~~~~~~");

        }

        //Okay - what if I ADD A NEW RECORD and want access to those new primary key ids for those records?

        //You can do it! We just need to add in an OPTION to the .executeUpdate method. .

        String insertQuery = "INSERT INTO products (name, price) VALUES ('little tiny grill', 399.99)";

        statementObj.executeUpdate(insertQuery, Statement.RETURN_GENERATED_KEYS);

        //Okay - NOW, after the STATEMENT is executed. .
        // . . what was that ID you generated for it?

        ResultSet resultSetObj2 = statementObj.getGeneratedKeys();

        if (resultSetObj2.next()) { //IF there is a record in my result set. .

            System.out.println("Inserted a new record! New id: " + resultSetObj2.getLong(1));
        }

    }
}
