package case_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HapplyCase {
    static WebDriver driver = null;
    public static void main(String[] args) throws InterruptedException { // dòng này có thể viết main rồi click tap
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://saucelabs.com/request-demo");
        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys("thuyduong181805@gmail.com");
        WebElement firstName = driver.findElement(By.xpath("//input[@id='First Name']"));
        firstName.sendKeys("Nguyen");
        WebElement lastName = driver.findElement(By.xpath("//input[@id='Last Name']"));
        lastName.sendKeys("Duong");
        WebElement company = driver.findElement(By.xpath("//input[@id='Company']"));
        company.sendKeys("ABC");
        WebElement phoneNumber = driver.findElement(By.xpath("//input[@id='Phone']"));
        phoneNumber.sendKeys("0333358255");
        WebElement country = driver.findElement(By.xpath("//select[@id='Country']"));
        country.click();
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0, 250).perform();
        WebElement optionCountry = driver.findElement(By.xpath("//option[@value='Vietnam']"));
        optionCountry.click();
        WebElement useCase = driver.findElement(By.xpath("//select[@id='Use-Case']"));
        useCase.click();
        WebElement optionUseCase = driver.findElement(By.xpath("//option[@value='Mobile App Distribution']"));
        optionUseCase.click();
        WebElement comments = driver.findElement(By.xpath("//textarea[@id='Comments']"));
        comments.sendKeys("ABC");
        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
        submit.click();
    }
}
