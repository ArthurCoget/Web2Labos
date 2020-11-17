import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ServerSideValidation {
    private WebDriver driver;
    private static final String url = "http://localhost:8080/r0753230_ServerSideValidation_war_exploded/studentForm.jsp";

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\Ucll 2020-2021\\Webontwikkeling 2\\Chromedriver + Selenium + jstl\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get(url);
    }

    @After
    public void clean() {
        driver.quit();
    }

    @Test
    public void notEverythingIsFilledIn() {
        driver.findElement(By.id("leeftijd")).sendKeys("23");
        driver.findElement(By.id("bewaar")).click();

        assertEquals("Voeg een student toe", driver.findElement(By.tagName("h1")).getText());

        assertEquals("23", driver.findElement(By.id("leeftijd")).getAttribute("value"));

        ArrayList<WebElement> h2 = (ArrayList<WebElement>) driver.findElements(By.tagName("h2"));
        assertTrue(webListReader(h2, "Vul een naam in!"));
        assertTrue(webListReader(h2, "Vul een voornaam in!"));
        assertTrue(webListReader(h2,"Vul een studierichting in!"));

    }

    @Test
    public void nothingIsFilledIn() {

        driver.findElement(By.id("bewaar")).click();

        assertEquals("Voeg een student toe", driver.findElement(By.tagName("h1")).getText());

        ArrayList<WebElement> h2 = (ArrayList<WebElement>) driver.findElements(By.tagName("h2"));
        assertTrue(webListReader(h2, "Vul een naam in!"));
        assertTrue(webListReader(h2, "Vul een voornaam in!"));
        assertTrue(webListReader(h2, "Vul een leeftijd in!"));
        assertTrue(webListReader(h2,"Vul een studierichting in!"));

    }

    private boolean webListReader(ArrayList<WebElement> h2, String s) {
        for (WebElement webElement : h2) {
            if (webElement.getText().equals(s)) {
                return true;
            }
        }
        return false;
    }


    @Test
    public void numberFilledInTheName() {
        driver.findElement(By.id("naam")).sendKeys("1234");
        driver.findElement(By.id("voornaam")).sendKeys("Mathias");
        driver.findElement(By.id("leeftijd")).sendKeys("25");
        driver.findElement(By.id("studierichting")).sendKeys("Chemie");
        driver.findElement(By.id("bewaar")).click();

        assertEquals("Voeg een student toe", driver.findElement(By.tagName("h1")).getText());
        assertEquals("This is a number not a name!", driver.findElement(By.tagName("h2")).getText());

        assertEquals("Mathias", driver.findElement(By.id("voornaam")).getAttribute("value"));
        assertEquals("25", driver.findElement(By.id("leeftijd")).getAttribute("value"));
        assertEquals("Chemie", driver.findElement(By.id("studierichting")).getAttribute("value"));
    }

    @Test
    public void numberFilledInStudieRichting() {
        driver.findElement(By.id("naam")).sendKeys("Devos");
        driver.findElement(By.id("voornaam")).sendKeys("Mathias");
        driver.findElement(By.id("leeftijd")).sendKeys("25");
        driver.findElement(By.id("studierichting")).sendKeys("12");
        driver.findElement(By.id("bewaar")).click();

        assertEquals("Voeg een student toe", driver.findElement(By.tagName("h1")).getText());
        assertEquals("This is a number not a studierichting!", driver.findElement(By.tagName("h2")).getText());
        assertEquals("Mathias", driver.findElement(By.id("voornaam")).getAttribute("value"));
        assertEquals("25", driver.findElement(By.id("leeftijd")).getAttribute("value"));
        assertEquals("Devos", driver.findElement(By.id("naam")).getAttribute("value"));
    }

    @Test
    public void validStudentVoegToe() {
        driver.findElement(By.id("naam")).sendKeys("Engels");
        driver.findElement(By.id("voornaam")).sendKeys("Yago");
        driver.findElement(By.id("leeftijd")).sendKeys("20");
        driver.findElement(By.id("studierichting")).sendKeys("Computersience");
        driver.findElement(By.id("bewaar")).click();

        assertEquals("Overzicht studenten", driver.findElement(By.tagName("h1")).getText());
    }

    @Test
    public void voegEenAlBestaandeStudentToe() {
        driver.findElement(By.id("naam")).sendKeys("Steegmans");
        driver.findElement(By.id("voornaam")).sendKeys("Elke");
        driver.findElement(By.id("leeftijd")).sendKeys("16");
        driver.findElement(By.id("studierichting")).sendKeys("Vroedkunde");
        driver.findElement(By.id("bewaar")).click();

        assertEquals("Voeg een student toe", driver.findElement(By.tagName("h1")).getText());
        assertEquals("Deze student bestaat al", driver.findElement(By.tagName("h2")).getText());
    }

}
