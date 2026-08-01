package Day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.text.Element;

public class UploadFile {
    static WebDriver driver = null;

    public static void main(String[] args) throws InterruptedException { // dòng này có thể viết main rồi click tap
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/upload/");
        String filePath = "D:\\auto_test\\Day_1\\BTNV Day 2_Bù bài 1 thiếu.docx";
        WebElement element = driver.findElement(By.id("uploadfile_0"));
        element.sendKeys(filePath);
        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkbox.click();
        WebElement submit = driver.findElement(By.xpath("//button[@type='button']"));
        submit.click();
        Thread.sleep(5000);
        WebElement in = driver.findElement(By.xpath("//h3[@id='res']")); //partiaLinkTexxt: texxt tuoeng ddoosi
        System.out.printf("get text :" +in.getText());
    }
}
