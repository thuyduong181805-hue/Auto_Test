package Bai1;

import Action.LoginAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //driver = new ChromeDriver();
        //driver.manage().window().maximize();
        //driver.get("https://www.saucedemo.com/");
        ChromeOptions options = new ChromeOptions();

        // Tắt các thông báo/cảnh báo của Chrome
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void testLoginFunctionality() {

        // Kiểm tra tiêu đề trang
        String expectedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(
                actualTitle,
                expectedTitle,
                "Page title is incorrect"
        );

        // Kiểm tra URL
        String expectedURL = "https://www.saucedemo.com/";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(
                actualURL,
                expectedURL,
                "Page URL is incorrect!"
        );

        // Thực hiện login bằng Action
        LoginAction.performLogin(
                driver,
                "standard_user",
                "secret_sauce"
        );

        // Kiểm tra sau khi login thành công
        String expectedHomePageURL =
                "https://www.saucedemo.com/inventory.html";

        String actualHomePageURL = driver.getCurrentUrl();

        Assert.assertEquals(
                actualHomePageURL,
                expectedHomePageURL,
                "Login failed - Inventory page URL is incorrect!"
        );

        // Kiểm tra logo trên trang Home
        WebElement appLogo =
                driver.findElement(By.className("app_logo"));

        Assert.assertTrue(
                appLogo.isDisplayed(),
                "App logo is not displayed in inventory page!"
        );

        // Kiểm tra có ít nhất 1 sản phẩm hiển thị
        int itemCount = driver.findElements(
                By.className("inventory_item")
        ).size();

        Assert.assertTrue(
                itemCount > 0,
                "No products displayed on inventory page!"
        );
    }


    @Test
    public void testLoginWithInvalidUsername() {

        // Username sai + Password đúng
        LoginAction.performLogin(
                driver,
                "wrong_user",
                "secret_sauce"
        );

        // Tìm thông báo lỗi
        WebElement errorMessage =
                driver.findElement(
                        By.xpath("//h3[@data-test='error']")
                );

        // Kiểm tra error hiển thị
        Assert.assertTrue(
                errorMessage.isDisplayed(),
                "Error message is not displayed!"
        );

        // Kiểm tra nội dung error
        String expectedErrorMessage =
                "Epic sadface: Username and password do not match any user in this service";

        String actualErrorMessage =
                errorMessage.getText();

        Assert.assertEquals(
                actualErrorMessage,
                expectedErrorMessage,
                "Error message is incorrect!"
        );
    }



    @Test
    public void testLoginWithInvalidPassword() {

        // Username đúng + Password sai
        LoginAction.performLogin(
                driver,
                "standard_user",
                "wrong_password"
        );

        // Tìm thông báo lỗi
        WebElement errorMessage =
                driver.findElement(
                        By.xpath("//h3[@data-test='error']")
                );

        // Kiểm tra error hiển thị
        Assert.assertTrue(
                errorMessage.isDisplayed(),
                "Error message is not displayed!"
        );

        // Kiểm tra nội dung error
        String expectedErrorMessage =
                "Epic sadface: Username and password do not match any user in this service";

        String actualErrorMessage =
                errorMessage.getText();

        Assert.assertEquals(
                actualErrorMessage,
                expectedErrorMessage,
                "Error message is incorrect!"
        );
    }


    @Test
    public void testLoginWithInvalidUsernameAndPassword() {

        // Username sai + Password sai
        LoginAction.performLogin(
                driver,
                "wrong_user",
                "wrong_password"
        );

        // Tìm thông báo lỗi
        WebElement errorMessage =
                driver.findElement(
                        By.xpath("//h3[@data-test='error']")
                );

        // Kiểm tra error hiển thị
        Assert.assertTrue(
                errorMessage.isDisplayed(),
                "Error message is not displayed!"
        );

        // Kiểm tra nội dung error
        String expectedErrorMessage =
                "Epic sadface: Username and password do not match any user in this service";

        String actualErrorMessage =
                errorMessage.getText();

        Assert.assertEquals(
                actualErrorMessage,
                expectedErrorMessage,
                "Error message is incorrect!"
        );
    }

    @Test
    public void testLoginWithEmptyUsername() {

        // Username sai + Password sai
        LoginAction.performLogin(
                driver,
                "",
                "wrong_password"
        );

        // Tìm thông báo lỗi
        WebElement errorMessage =
                driver.findElement(
                        By.xpath("//h3[@data-test='error']")
                );

        // Kiểm tra error hiển thị
        Assert.assertTrue(
                errorMessage.isDisplayed(),
                "Error message is not displayed!"
        );

        // Kiểm tra nội dung error
        String expectedErrorMessage =
                "Epic sadface: Username is required";

        String actualErrorMessage =
                errorMessage.getText();

        Assert.assertEquals(
                actualErrorMessage,
                expectedErrorMessage,
                "Error message is incorrect!"
        );
    }


    @Test
    public void testLoginWithEmptyPassword() {

        //Password rỗng
        LoginAction.performLogin(
                driver,
                "standard_user",
                ""
        );

        // Tìm thông báo lỗi
        WebElement errorMessage =
                driver.findElement(
                        By.xpath("//h3[@data-test='error']")
                );

        // Kiểm tra error hiển thị
        Assert.assertTrue(
                errorMessage.isDisplayed(),
                "Error message is not displayed!"
        );

        // Kiểm tra nội dung error
        String expectedErrorMessage =
                "Epic sadface: Password is required";

        String actualErrorMessage =
                errorMessage.getText();

        Assert.assertEquals(
                actualErrorMessage,
                expectedErrorMessage,
                "Error message is incorrect!"
        );
    }


    @Test
    public void testLoginWithEmptyUsernameAndPassword() {

        // Username sai + Password sai
        LoginAction.performLogin(
                driver,
                "",
                ""
        );

        // Tìm thông báo lỗi
        WebElement errorMessage =
                driver.findElement(
                        By.xpath("//h3[@data-test='error']")
                );

        // Kiểm tra error hiển thị
        Assert.assertTrue(
                errorMessage.isDisplayed(),
                "Error message is not displayed!"
        );

        // Kiểm tra nội dung error
        String expectedErrorMessage =
                "Epic sadface: Username is required";

        String actualErrorMessage =
                errorMessage.getText();

        Assert.assertEquals(
                actualErrorMessage,
                expectedErrorMessage,
                "Error message is incorrect!"
        );
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
