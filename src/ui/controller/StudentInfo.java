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
import java.util.ArrayList;

@WebServlet("/StudentInfo")
public class StudentInfo extends HttpServlet {

    private final StudentDB studentDB = new StudentDB();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        } else {
            return "index.jsp";
        }

    }

    private String voegtoe(HttpServletRequest request, HttpServletResponse response) {

        Student student = new Student();

        ArrayList<String> errors = new ArrayList<String>();

        setNaam(student, request, errors);
        setVoornaam(student, request, errors);
        setLeeftijd(student, request, errors);
        setStudieRichting(student, request, errors);

        if (errors.size() == 0) {
            try {
                studentDB.voegStudentToe(student);
                request.setAttribute("database", studentDB.getStudentslijst());
                return overview(request, response);
            } catch (IllegalArgumentException exc) {
                errors.add(exc.getMessage());
            }
        }
        request.setAttribute("errors", errors);
        return "studentForm.jsp?command=voegtoe";
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
        } else {

            Student student = studentDB.vindStudent(naamFromParameter, voornaamFromParameter);

            request.setAttribute("Naam", student.getNaam());
            request.setAttribute("Voornaam", student.getVoornaam());
            request.setAttribute("Leeftijd", student.getLeeftijd());
            request.setAttribute("Studierichting", student.getStudierichting());

            return "gevonden.jsp";
        }
    }

    private void setNaam(Student student, HttpServletRequest request, ArrayList<String> errors) {

        String naam = request.getParameter("naam");

        try {
            student.setNaam(naam);
            request.setAttribute("OldName", naam);
        } catch (IllegalArgumentException exception) {
            errors.add(exception.getMessage());
        }

    }

    private void setVoornaam(Student student, HttpServletRequest request, ArrayList<String> errors) {

        String naam = request.getParameter("vnaam");

        try {
            student.setVoornaam(naam);
            request.setAttribute("OldVoorname", naam);
        } catch (IllegalArgumentException exception) {
            errors.add(exception.getMessage());
        }

    }

    private void setLeeftijd(Student student, HttpServletRequest request, ArrayList<String> errors) {

        String naam = request.getParameter("leeftijd");

        try {
            student.setLeeftijd(naam);
            request.setAttribute("OldAge", naam);
        } catch (IllegalArgumentException exception) {
            errors.add(exception.getMessage());
        }

    }

    private void setStudieRichting(Student student, HttpServletRequest request, ArrayList<String> errors) {

        String naam = request.getParameter("studierichting");

        try {
            student.setStudierichting(naam);
            request.setAttribute("OldStudierichting", naam);
        } catch (IllegalArgumentException exception) {
            errors.add(exception.getMessage());
        }

    }
}
