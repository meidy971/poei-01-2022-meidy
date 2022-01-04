import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class tp1 {

    @Test
    public void test1(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.fr");
        driver.manage().window().maximize();
        // Fermer les cookies
        WebElement buttonCookies = driver.findElement(By.id("sp-cc-accept"));
        buttonCookies.click();
        WebElement barreRecherche = driver.findElement(By.id("twotabsearchtextbox"));
        barreRecherche.sendKeys("machine à raclette");
        barreRecherche.sendKeys(Keys.ENTER);

        //*[@id="twotabsearchtextbox"]
        ///html/body/div[1]/header/div/div[1]/div[2]/div/form/div[3]/div[1]/input
        //driver.findElement(By.name("field-keywords"));
        //driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        //driver.findElement(By.xpath("//*[@name='field-keywords']"));
        //driver.findElement(By.cssSelector("[cel_widget_id][role]"));
        //driver.quit();
    }

    @Test
    public void test2(){

    }
}
