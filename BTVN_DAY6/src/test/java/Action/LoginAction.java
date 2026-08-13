package Action;

import UI.LoginPageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginAction {
    public static void performLogin(WebDriver driver, String username, String password) {
        WebElement userInp = driver.findElement(LoginPageUI.USERNAME_FIELD);
        WebElement passInp = driver.findElement(LoginPageUI.PASSWORD_FIELD);
        WebElement loginBtn = driver.findElement(LoginPageUI.LOGIN_BUTTON);

        userInp.sendKeys(username);
        passInp.sendKeys(password);
        loginBtn.click();
    }
}
