import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class amazonTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
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
    public void nintendoSwitchAddToCartPriceTest() {
        // Arrange
        String productName = "Nintendo Switch OLED";

        // Act
        mainPage mainpage = new mainPage(driver);
        mainpage.searchProduct(productName);

        searchResultPage searchresultpage = new searchResultPage(driver);
        searchresultpage.openResult(0);

        // Assert
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
}