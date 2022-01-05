import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class tp1 {

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.get("https://www.amazon.fr");
        driver.manage().window().maximize();
        WebElement buttonCookies = driver.findElement(By.id("sp-cc-accept"));
        buttonCookies.click();

    }

    @AfterMethod
    public void teardown(){

        driver.quit();

    }

    @Test
    public void test1(){

        WebElement barreRecherche = driver.findElement(By.id("twotabsearchtextbox"));
        barreRecherche.sendKeys("machine à raclette");
        barreRecherche.sendKeys(Keys.ENTER);

    }

    @Test
    public void test2(){

        WebElement barreRecherche = driver.findElement(By.id("twotabsearchtextbox"));
        barreRecherche.sendKeys("machine à raclette");
        barreRecherche.sendKeys(Keys.ENTER);
        WebElement selectionnerProduit = driver.findElement(By.cssSelector("[data-cel-widget='search_result_1']"));
        selectionnerProduit.click();
        WebElement boutonAjouter = driver.findElement(By.id("add-to-cart-button"));
        boutonAjouter.click();
    }
}
