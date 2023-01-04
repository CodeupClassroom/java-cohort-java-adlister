package cookies_lecture;

import mvc_lecture.dao.DaoFactory;
import mvc_lecture.dao.Products;
import mvc_lecture.models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/cookies/submit")
public class CookieServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/cookies/cookie.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();

        String cookieName = req.getParameter("name");

        System.out.println("This is before we set the cookie name into the session: " + cookieName);

        session.setAttribute("storedCookie", cookieName);

        resp.sendRedirect("/cookies/show");

    }

}
