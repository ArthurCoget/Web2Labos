package ui.view;

import sun.plugin2.message.CookieOpMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String command = "";
        String destination;

        if (request.getParameter("command") != null) {
            command = request.getParameter("command");
        }

        switch (command) {
            case "Send":
                destination = form(request, response);
                break;
            case "more":
                destination = "more.jsp";
                break;
            default:
                destination = showIndex(request);
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private String showIndex(HttpServletRequest request) {
        Cookie cookie = getCookies(request);
        if (cookie != null && cookie.getValue().equals("yes")) {
            request.setAttribute("quote", "true");
        }else {
            request.setAttribute("quote", "false");
        }

        return "index.jsp";
    }

    private String form(HttpServletRequest request, HttpServletResponse response) {

        String quote;

        Cookie cookie = new Cookie("quote", "no");

        if (request.getParameter("quote") == null || request.getParameter("quote").trim().isEmpty()) {
            quote = "";
        }else {
            quote = request.getParameter("quote");
        }

        request.setAttribute("quote", "false");

        if (quote.equals("yes")) {
            request.setAttribute("quote", "true");
            cookie.setValue("yes");
        }
        response.addCookie(cookie);
        return "index.jsp";
    }

    private Cookie getCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return null;
        }
        for (Cookie cookie : cookies){
            if (cookie.getName().equals("quote")){
                return cookie;
            }
        }
        return null;
    }
}
