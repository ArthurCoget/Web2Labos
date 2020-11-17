package ui.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class BookShopTest {
    private WebDriver driver;
    @Before
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "D:\\Ucll 2020-2021\\Webontwikkeling 2\\Chromedriver + Selenium + jstl\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/r0753230_SeleniumTesten_war_exploded/");
    }

    @After
    public void clean() {
        driver.quit();
    }

    @Test
    public void navigateToThePageByCheckingTheTitle() {
        String title = driver.findElement(By.tagName("h2")).getText();
        assertEquals("Book info", title);
    }
    @Test
    public void testFormWhenWeFillInNothing() {

        driver.findElement(By.id("title")).sendKeys("");
        driver.findElement(By.id("price")).sendKeys("");
        driver.findElement(By.id("number")).sendKeys("");
        driver.findElement(By.id("calculate")).click();

        assertEquals("Vul alle velden in.", driver.findElement(By.tagName("p")).getText());

    }

    @Test
    public void testFormWith_AllesKomtGoed_10_7() {

        driver.findElement(By.id("title")).sendKeys("Alles Komt Goed");
        driver.findElement(By.id("price")).sendKeys("10");
        driver.findElement(By.id("number")).sendKeys("7");
        driver.findElement(By.id("calculate")).click();

        assertEquals("Voor 7 exemplaren van het boek Alles Komt Goed moet je €70 betalen.", driver.findElement(By.tagName("p")).getText());
    }

}
