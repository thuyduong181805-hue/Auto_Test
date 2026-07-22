package Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test_demo {
    static WebDriver driver = null;
    public static void main(String[] args){ // dòng này có thể viết main rồi click tap
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("https://www.saucedemo.com/");
        WebElement inputUsername = driver.findElement(By.id("user-name"));
        inputUsername.sendKeys("standard_user");

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("secret_sauce");

        WebElement buttonLogin = driver.findElement(By.id("login-button"));
        buttonLogin.click();
        driver.quit();
    }

}
