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
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String command = request.getParameter("command");
        String destination;

        if (command == null) {
            command = "";
        }
        switch (command) {
            case "Zoeken":
                destination = zoek(request, response);
                break;
            case "overview":
                destination = overview(request, response);
                break;
            case "voegtoe":
                destination = voegtoe(request, response);
                break;
            case "verwijder":
                destination = verwijder(request, response);
                break;
            case "verwijderBevestigd":
                destination = "verwijder.jsp";
                break;
            default:
                destination = "index.jsp";
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private String verwijder(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("verwijder") != null) {
            Student student = studentDB.vindStudent(request.getParameter("naam"), request.getParameter("voornaam"));
            studentDB.verwijderStudent(student);
            return overview(request, response);
        }else {
            return "index.jsp";
        }

    }

    private String voegtoe(HttpServletRequest request, HttpServletResponse response) {

        String naamFromParameter = request.getParameter("naam");
        String vnaamFromParameter = request.getParameter("vnaam");
        String leeftijdFromParameter = request.getParameter("leeftijd");
        String studieRichtingFromParameter = request.getParameter("studierichting");

        if (naamFromParameter.trim().isEmpty() || vnaamFromParameter.trim().isEmpty() || leeftijdFromParameter.trim().isEmpty() || studieRichtingFromParameter.trim().isEmpty()){
            request.setAttribute("nietok", "U vulde niet alle velden in");
            return "studentForm.jsp?command=voegtoe";
        }else {
            studentDB.voegStudentToe(new Student(naamFromParameter, vnaamFromParameter, studieRichtingFromParameter, Integer.parseInt(leeftijdFromParameter)));
            request.setAttribute("database", studentDB.getStudentslijst());
            return overview(request, response);
        }
    }

    private String overview(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("database", studentDB.getStudentslijst());
        return "studentOverzichtDynamisch.jsp";
    }

    private String zoek(HttpServletRequest request, HttpServletResponse response) {

        String naamFromParameter = request.getParameter("naam");
        String voornaamFromParameter = request.getParameter("voornaam");

        if (naamFromParameter.trim().isEmpty() || voornaamFromParameter.trim().isEmpty()) {
            return "nietGevonden.jsp";
        }
        if (studentDB.vindStudent(naamFromParameter, voornaamFromParameter) == null) {
            return "nietGevonden.jsp";
        }else {

            Student student = studentDB.vindStudent(naamFromParameter, voornaamFromParameter);

            request.setAttribute("Naam", student.getNaam());
            request.setAttribute("Voornaam", student.getVoornaam());
            request.setAttribute("Leeftijd", student.getLeeftijd());
            request.setAttribute("Studierichting", student.getStudierichting());

            return "gevonden.jsp";
        }
    }
}
