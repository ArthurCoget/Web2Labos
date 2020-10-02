package domain.db;

import domain.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDB {
    private final List<Student> students;

    public StudentDB() {
        students = new ArrayList<>();
        this.voegToe(new Student("Jongen", "Greetje", "Toegepaste Informatica", 23));
        this.voegToe(new Student("Melaerts", "Kristien", "Chemie", 21));
        this.voegToe(new Student("Steegmans", "Elke", "Vroedkunde", 16));
        this.voegToe(new Student("Van Hee", "Jan", "Verpleegkunde", 18));
    }

    public void voegToe(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student mag niet leeg zijn");
        }
        else {
            students.add(student);
        }
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
}
