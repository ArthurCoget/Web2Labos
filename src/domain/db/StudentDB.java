package domain.db;

import domain.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDB {
    private final List<Student> students;

    public StudentDB() {
        students = new ArrayList<>();

        Student jongen = new Student();
        jongen.setNaam("Jongen");
        jongen.setVoornaam("Greetje");
        jongen.setStudierichting("Toegepaste Informatica");
        jongen.setLeeftijd("23");

        voegStudentToe(jongen);

        Student melearts = new Student();
        melearts.setNaam("Melaerts");
        melearts.setVoornaam("Kristien");
        melearts.setStudierichting("Chemie");
        melearts.setLeeftijd("21");

        voegStudentToe(melearts);

        Student steegmans = new Student();
        steegmans.setNaam("Steegmans");
        steegmans.setVoornaam("Elke");
        steegmans.setLeeftijd("16");
        steegmans.setStudierichting("Vroedkunde");

        voegStudentToe(steegmans);

        Student vanHee = new Student();
        vanHee.setNaam("Van Hee");
        vanHee.setVoornaam("Jan");
        vanHee.setStudierichting("Verpleegkunde");
        vanHee.setLeeftijd("18");

        voegStudentToe(vanHee);
    }

    public void voegStudentToe(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student mag niet leeg zijn");
        }
        for (Student a : students) {
            if (a.getVoornaam().equals(student.getVoornaam()) && a.getNaam().equals(student.getNaam())) {
                throw new IllegalArgumentException("Deze student bestaat al");
            }
        }
        students.add(student);
    }
    public List<Student> getStudentslijst() {
        return students;
    }

    public Student vindStudent(String naam, String voornaam) {
        if (naam == null || naam.trim().isEmpty()) {
            throw new IllegalArgumentException("Geef een naam in");
        }
        if (voornaam == null || voornaam.trim().isEmpty()) {
            throw new IllegalArgumentException("Geef een voornaam in");
        }
        for (Student student : students) {
            if (student.getNaam().equals(naam) && student.getVoornaam().equals(voornaam)) {
                return student;
            }
        }
        return null;
    }

    public void verwijderStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Geef een echte student in");
        }
        students.removeIf(a -> a == student);
    }
}
