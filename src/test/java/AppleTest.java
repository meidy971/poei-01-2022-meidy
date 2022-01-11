import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.amazon.mainPage;
import pageobjects.apple.*;

public class AppleTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.apple.com/fr/");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void teardown() {
        //driver.quit();
    }

    @Test
    public void iphoneAddToCartPriceTest() {
        // Arrange
        String expectedProductName = "iPhone 13 Pro Max 256 Go Bleu Alpin";
        String expectedPrice = "1 379,00 €";

        // Act
        MainPage mainPage = new MainPage(driver);
        mainPage.openIphonePage();

        IphonePage iphonePage = new IphonePage(driver);
        iphonePage.openIphone13ProPage();

        Iphone13ProPage iphone13ProPage = new Iphone13ProPage(driver);
        iphone13ProPage.buy();

        BuyIphone13ProPage buyIphone13ProPage = new BuyIphone13ProPage(driver);
        buyIphone13ProPage.selectIphone13ProMax();
        buyIphone13ProPage.selectBlueAlpin();
        buyIphone13ProPage.select256Go();
        buyIphone13ProPage.noAppleTradeIn();
        buyIphone13ProPage.addToCart();

        ConfirmationAddToCartPage confirmationAddToCartPage = new ConfirmationAddToCartPage(driver);
        confirmationAddToCartPage.openCartPage();

        CartPage cartPage = new CartPage(driver);
        String productItem = cartPage.getProductItem(0);
        String cartTitle = cartPage.getCartTitle();
        String productPrice = cartPage.getProductPrice(0);
        String subTotal = cartPage.getSubTotal();
        String total = cartPage.getTotal();

        // Assert
        Assert.assertEquals(expectedProductName, productItem);
        Assert.assertEquals(expectedProductName, cartTitle);
        Assert.assertEquals(expectedPrice, productPrice);
        Assert.assertEquals(expectedPrice, subTotal);
        Assert.assertEquals(expectedPrice, total);
    }
}
