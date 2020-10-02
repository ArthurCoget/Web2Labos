package view;

import model.LetterTeller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Occurences")
public class Servlet extends HttpServlet {
    LetterTeller letterTeller = new LetterTeller();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String woordFromParameter = request.getParameter("woord");
        char letterFromParameter = request.getParameter("letter").charAt(0);

        request.setAttribute("aantal",letterTeller.letterTellen(letterFromParameter, woordFromParameter));

        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request,response);


    }
}
