package cookies_lecture;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookies/show")
public class RedirectCookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cookieName = (String) req.getSession().getAttribute("storedCookie");

        System.out.println("Hello - it's me, the session! Here's the cookieName:" + cookieName);

        req.setAttribute("viewCookie", cookieName);
        req.getRequestDispatcher("/cookies/showCookie.jsp").forward(req, resp);
    }

}
