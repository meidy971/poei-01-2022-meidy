package pageobjects.apple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    By iphonePriceHeader = By.cssSelector(".rs-bag-button-header [data-autom=bag-header]");
    By iphoneInfoPrice = By.cssSelector(".rs-iteminfo-price > p");
    By itemName = By.cssSelector(".rs-iteminfo-title [data-autom=bag-item-name]");
    By itemSubTotal = By.cssSelector(".rs-summary-value[data-autom=bagrs-summary-subtotalvalue]");
    By itemTotal = By.cssSelector(".rs-summary-value[data-autom=bagtotalvalue] ");

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    public String getProductItem(int index){
        return driver.findElements(itemName).get(index).getText();
    }
    public String getCartTitle(){
        return driver.findElement(iphonePriceHeader).getText();
    }
    public String getProductPrice(int index){
        return driver.findElements(iphoneInfoPrice).get(index).getText();
    }
    public String getSubTotal(){
        return driver.findElement(itemSubTotal).getText();
    }
    public String getTotal(){
        return driver.findElement(itemTotal).getText();
    }
}
