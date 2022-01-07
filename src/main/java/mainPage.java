import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class mainPage {
    WebDriver driver;
    int timeoutSearch = 5;
    By searchBarSelector = By.id("twotabsearchtextbox");
    By searchResultSelector = By.cssSelector("[data-component-type='s-search-result']");

    public mainPage(WebDriver driver){
        this.driver = driver;
    }

    public void searchProduct(String productName){
        // Trouver et intéragir avec l'élément
        driver.findElement(searchBarSelector).sendKeys(productName + Keys.ENTER);

        // Attendre que l'action soit fini
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSearch));
        wait.until(ExpectedConditions.elementToBeClickable(searchResultSelector));



    }
}
