package Day3;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class BrowerCommands {
    static WebDriver driver = null;
    public static void main(String[] args) throws InterruptedException { // dòng này có thể viết main rồi click tap
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://saucelabs.com/request-demo");
        // driver.navigate().to("https://saucelabs.com/request-demo");
        // driver.navigate().back();// quay li trang
       //  driver.navigate().forward(); //cuxng quay lại nhng là quay lại trang 2
        // driver.navigate().refresh();
       //  String url = driver.getCurrentUrl();
       //  System.out.printf("String url là:" + url);
        //WebElement element = driver.findElement(By.id("Company"));
        //element.sendKeys("aaaaaaa");
        //WebElement element = driver.findElement(By.xpath("//h3[@class='form-card__heading']")); //texxt tuoeng ddoosi
        //System.out.printf("get text :" +element.getText());
        //WebElement element = driver.findElement(By.xpath("//h3[@class='form-card__heading']")); //partiaLinkTexxt: texxt tuoeng ddoosi
        //System.out.printf("get text :" +element.getText());
       // WebElement checkbox1 = driver.findElement(By.id("uploadfile_0"));
        //partiaLinkTexxt: texxt tuoeng ddoosi
        WebElement useCase = driver.findElement(By.xpath("//select[@id='Use-Case']"));
        useCase.click();
        Thread.sleep(5000);
        WebElement optionUseCase = driver.findElement(By.xpath("//option[@value='Mobile App Distribution']"));
        optionUseCase.click();
    }
}
