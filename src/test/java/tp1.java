import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class tp1 {

    WebDriver driver;
    
    @BeforeMethod
    public void setup(){

        driver = new ChromeDriver();
        driver.get("https://www.amazon.fr");
        driver.manage().window().maximize();
        WebElement buttonCookies = driver.findElement(By.id("sp-cc-accept"));
        buttonCookies.click();

    }

    @Test
    public void test1(){

        WebElement barreRecherche = driver.findElement(By.id("twotabsearchtextbox"));
        barreRecherche.sendKeys("machine à raclette");
        barreRecherche.sendKeys(Keys.ENTER);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //*[@id="twotabsearchtextbox"]
        ///html/body/div[1]/header/div/div[1]/div[2]/div/form/div[3]/div[1]/input
        //driver.findElement(By.name("field-keywords"));
        //driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        //driver.findElement(By.xpath("//*[@name='field-keywords']"));
        //driver.findElement(By.cssSelector("[cel_widget_id][role]"));
        driver.quit();
    }

    @Test
    public void test2(){

        WebElement barreRecherche = driver.findElement(By.id("twotabsearchtextbox"));
        barreRecherche.sendKeys("machine à raclette");
        barreRecherche.sendKeys(Keys.ENTER);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement selectionnerProduit = driver.findElement(By.cssSelector("[cel_widget_id='MAIN-SEARCH_RESULTS-5']"));
        selectionnerProduit.click();
        WebElement boutonAjouter = driver.findElement(By.id("add-to-cart-button"));
        boutonAjouter.click();
        driver.quit();

    }
}
