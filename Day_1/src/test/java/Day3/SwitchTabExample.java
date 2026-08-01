package Day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class SwitchTabExample {
    static WebDriver driver = null;

    public static void main(String[] args) { // dòng này có thể viết main rồi click tap
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://saucelabs.com/request-demo");
        // Mo trang web Đầu
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://translate.google.com.vn/?sl=auto&tl=vi&op=translate");
        driver.switchTo().window(tabs.get(0));
    }
}
