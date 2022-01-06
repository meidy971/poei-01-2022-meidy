import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class UberEatsTests {
    WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = new ChromeDriver();
        driver.get("https://www.ubereats.com/fr");
        driver.manage().window().maximize();
        WebElement buttonCookies = driver.findElement(By.cssSelector("button[class='bc gh gi gl bj bk bl bm bn bo bt bu ba bb']"));
        buttonCookies.click();

    }

    @Test
    public void addBurgerTest(){

        // Arrange
        String keyword = "La Défense";
        By searchBarSelector = By.id("location-typeahead-home-input");
        By categoryBurger = (By.cssSelector("[alt=Burgers]"));
        By kingMarcel = By.cssSelector("a[href='/fr/store/king-marcel-nanterre/07TTIgUiQPWyz4uq4_H35w'] > h3");
        By burgerChoice = By.cssSelector("[alt='Le Marcel Jackson']");
        By addToCartButton = By.cssSelector(".spacer._24 + button.b8");
        By cartSelector = By.cssSelector("button[aria-label='checkout'] > div");
        int timeoutSearchLoad = 10;
        String expectedCartItems = "1";

        // Act
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSearchLoad));

        WebElement barreRecherche = driver.findElement(searchBarSelector);
        barreRecherche.sendKeys( keyword);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        barreRecherche.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.elementToBeClickable(categoryBurger));
        driver.findElement(categoryBurger).click();

        wait.until(ExpectedConditions.elementToBeClickable(kingMarcel));
        driver.findElement(kingMarcel).click();

        wait.until(ExpectedConditions.elementToBeClickable(burgerChoice));
        driver.findElement(burgerChoice).click();

        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        driver.findElement(addToCartButton).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(addToCartButton));

        // Assert
        WebElement cart = driver.findElement(cartSelector);
        Assert.assertTrue(cart.getText().contains(expectedCartItems), "The cart does not have 1 something in it");

    }

    @AfterMethod
    public void teardown(){

        //driver.quit();

    }

}
