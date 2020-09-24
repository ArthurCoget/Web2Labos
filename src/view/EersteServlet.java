package view;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet("/DynamischePagina")
public class EersteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"nl\">");
        out.println("<head>");
        out.println("<body>");
        out.println("<header>");
        out.println("<h1>Nu wordt alles geschreven met out.println</h1>");
        out.println("</header>");
        out.println("<article>");
        Random random = new Random();
        int randomInt = random.nextInt(10000);
        out.println("<p>Dit is een random gegenereerd nummer: " + randomInt +"!</p>");
        out.println("<a href=\"index.html\">Home</a>");
        out.println("</article>");
        out.println("</body>");
        out.println("</html>");
    }
}
