package pageobjects.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class searchResultPage {
    WebDriver driver;
    By searchResultSelector = By.cssSelector("[data-component-type='s-search-result']");

    public searchResultPage(WebDriver driver){
        this.driver = driver;
    }

    public void openResult(int index){
        List<WebElement> listOfResults = driver.findElements(searchResultSelector);
        listOfResults.get(index).click();
    }
}
