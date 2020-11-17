package domain.model;

public class Student {
    private String naam, voornaam;
    private String studierichting;
    private String leeftijd;

    public Student() {

    }

    public static boolean isValidString(String input) {
        return (input != null) && !(input.trim().isEmpty());
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        if (naam == null || naam.trim().isEmpty()) {
            throw new IllegalArgumentException("Vul een naam in!");
        }
        try {
            Double.parseDouble(naam);
            throw new IllegalArgumentException("This is a number not a name!");
        } catch (NumberFormatException exc) {
            this.naam = naam;
        }

    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        if (voornaam == null || voornaam.trim().isEmpty()) {
            throw new IllegalArgumentException("Vul een voornaam in!");
        }
        try {
            Double.parseDouble(voornaam);
            throw new IllegalArgumentException("This is a number not a voorname!");
        } catch (NumberFormatException exc) {
            this.voornaam = voornaam;
        }
    }

    public String getStudierichting() {
        return studierichting;
    }

    public void setStudierichting(String studierichting) {
        if (studierichting == null || studierichting.trim().isEmpty()) {
            throw new IllegalArgumentException("Vul een studierichting in!");
        }
        try {
            Double.parseDouble(studierichting);
            throw new IllegalArgumentException("This is a number not a studierichting!");
        } catch (NumberFormatException exc) {
            this.studierichting = studierichting;
        }
    }

    public String getLeeftijd() {
        return leeftijd;
    }

    public static boolean isValidLeeftijd(int leeftijd) {
        return leeftijd > 0;
    }

    public void setLeeftijd(String leeftijd) {
        if (leeftijd == null || leeftijd.trim().isEmpty()) {
            throw new IllegalArgumentException("Vul een leeftijd in!");
        }
        try {
            Double.parseDouble(leeftijd);
            this.leeftijd = leeftijd;

        } catch (NumberFormatException exc) {
            throw new IllegalArgumentException("Geef de leeftijd in getal vorm");
        }
    }
}
