import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.amazon.*;
import pageobjects.apple.MainPage;

import java.net.MalformedURLException;
import java.net.URL;

public class amazonTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        URL seleniumGridUrl = null;
        try {
            seleniumGridUrl = new URL("http://127.0.0.1:4444");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new RemoteWebDriver(seleniumGridUrl, chromeOptions);
        driver.get("https://www.amazon.fr");
        driver.manage().window().maximize();

        // Fermer les cookies
        driver.findElement(By.id("sp-cc-accept")).click();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void laptopAddToCartPriceTest() {
        // Arrange
        String productName = "ASUS Chromebook CZ1000DVA-L30037";
        String expectedPrice = "297,69 €";

        // Act
        mainPage mainpage = new mainPage(driver);
        mainpage.searchProduct(productName);

        searchResultPage searchresultpage = new searchResultPage(driver);
        searchresultpage.openResult(0);

        productPage productpage = new productPage(driver);
        productpage.addToCart();
        productpage.noCoverage();

        confirmationAddToCartPage confirmationaddtocartpage = new confirmationAddToCartPage(driver);
        confirmationaddtocartpage.openCart();

        cartPage cartpage = new cartPage(driver);
        String productPrice = cartpage.getProductPrice((0));
        String activeCartSubtotal = cartpage.getActiveCartSubtotal();
        String buyboxCartSubtotal = cartpage.getBuyboxCartSubtotal();

        // Assert
        Assert.assertEquals(productPrice, expectedPrice);
        Assert.assertEquals(productPrice, activeCartSubtotal);
        Assert.assertEquals(productPrice, buyboxCartSubtotal);
    }

    @Test
    public void machineARacletteTest() {
        // Arrange
        String productName = "Machine a raclette";

        // Act
        mainPage mainPage = new mainPage(driver);
        mainPage.searchProduct(productName);

        // Assert

    }

    @Test
    public void passedTest() {
        MainPage mainPage = new MainPage(driver);

        Assert.assertTrue(true);
    }
}