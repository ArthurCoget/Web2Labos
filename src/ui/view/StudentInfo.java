package ui.view;

import domain.db.StudentDB;
import domain.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/StudentInfo")
public class StudentInfo extends HttpServlet {

    private final StudentDB studentDB = new StudentDB();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String guessVoornaamFromParameter = request.getParameter("voornaam");
        String guessNaamFromParameter = request.getParameter("naam");

        if (guessNaamFromParameter == null || guessNaamFromParameter.trim().isEmpty()) {
            if (guessVoornaamFromParameter == null || guessVoornaamFromParameter.trim().isEmpty()) {
                RequestDispatcher view = request.getRequestDispatcher("nietGevonden.jsp");
                view.forward(request, response);
            }else {
                RequestDispatcher view = request.getRequestDispatcher("nietGevonden.jsp");
                view.forward(request, response);
            }
        }else {
            if (guessVoornaamFromParameter == null || guessVoornaamFromParameter.trim().isEmpty()) {
                RequestDispatcher view = request.getRequestDispatcher("nietGevonden.jsp");
                view.forward(request, response);
            } else {
                if (studentDB.vindStudent(guessNaamFromParameter, guessVoornaamFromParameter) == null) {
                    RequestDispatcher view = request.getRequestDispatcher("nietGevonden.jsp");
                    view.forward(request, response);
                } else {
                    Student student = studentDB.vindStudent(guessNaamFromParameter, guessVoornaamFromParameter);
                    request.setAttribute("Naam", student.getNaam());
                    request.setAttribute("Voornaam", student.getVoornaam());
                    request.setAttribute("Leeftijd", student.getLeeftijd());
                    request.setAttribute("Studierichting", student.getStudierichting());

                    RequestDispatcher view = request.getRequestDispatcher("gevonden.jsp");
                    view.forward(request, response);
                }
            }
        }


    }
}
