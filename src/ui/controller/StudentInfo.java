package ui.controller;

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


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String naamFromParameter = request.getParameter("naam");
        String vnaamFromParameter = request.getParameter("vnaam");
        String leeftijdFromParameter = request.getParameter("leeftijd");
        String studieRichtingFromParameter = request.getParameter("studierichting");

        if (naamFromParameter.trim().isEmpty() || vnaamFromParameter.trim().isEmpty() || leeftijdFromParameter.trim().isEmpty() || studieRichtingFromParameter.trim().isEmpty()){
            request.setAttribute("nietok", "U vulde niet alle velden in");
            RequestDispatcher view = request.getRequestDispatcher("studentForm.jsp");
            view.forward(request, response);
        }else {
            studentDB.voegStudentToe(new Student(naamFromParameter, vnaamFromParameter, studieRichtingFromParameter, Integer.parseInt(leeftijdFromParameter)));
            request.setAttribute("database", studentDB.getStudentslijst());
            RequestDispatcher view = request.getRequestDispatcher("studentOverzichtDynamisch.jsp");
            view.forward(request, response);
        }

    }

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
