import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class cartPage {
    WebDriver driver;

    By productPriceSelector = By.cssSelector("span.sc-product-price");
    By activeCartSubtotalSelector = By.cssSelector("#sc-subtotal-amount-activecart > span");
    By buyboxCartSubtotalSelector = By.cssSelector("#sc-subtotal-amount-buybox > span");

    public cartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductPrice(int index) {
        return driver.findElements(productPriceSelector).get(index).getText();
    }

    public String getActiveCartSubtotal() {
        return driver.findElement(activeCartSubtotalSelector).getText();
    }

    public String getBuyboxCartSubtotal() {
        return driver.findElement(buyboxCartSubtotalSelector).getText();
    }

}