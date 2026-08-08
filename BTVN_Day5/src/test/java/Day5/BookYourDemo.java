package Day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static Utils.ExcelUtils.readExcelData;

public class BookYourDemo {
    private static final String EXCEL_PATH = "Book1.xlsx";
    private static final String SHEET_NAME = "Sheet1";
    private static final String BOOK_URL = "https://saucelabs.com/request-demo";

    public static void main(String[] args) throws InterruptedException {
        List<Map<String, String>> testData = readExcelData(EXCEL_PATH, SHEET_NAME);
        WebDriver driver;
        for (int i = 0; i < testData.size(); i++) {
            Map<String, String> row = testData.get(i);
            // Tắt cảnh báo pass của chrome
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);

            String businessEmail = row.get("Business email");
            if (businessEmail == null) businessEmail = "";
            String firstName = row.get("First name");
            if (firstName == null) firstName = "";
            String lastName = row.get("Last name");
            if (lastName == null) lastName = "";
            String company = row.get("Company");
            if (company == null) company = "";
            String phoneNumber = row.get("Phone number");
            if (phoneNumber == null) phoneNumber = "";
            String country = row.get("Country");
            if (country == null) country = "";
            String useCase = row.get("Use case");
            if (useCase == null) useCase = "";
            String comments = row.get("Comments");
            if (comments == null) comments = "";
            System.out.println("Đang thử điền form thứ: " + (i + 1));
            driver.get(BOOK_URL);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

            // Business Email
            WebElement Email =  driver.findElement(By.id("Business-Email"));
            Email.sendKeys(businessEmail);

            //First Name
            List<WebElement> firstNameList = driver.findElements(By.id("First Name"));
            if (!firstNameList.isEmpty()
                    && firstNameList.get(0).isDisplayed()
                    && firstNameList.get(0).isEnabled()) {
                firstNameList.get(0).sendKeys(firstName);
            }
            // Last Name
            List<WebElement> lastNameList = driver.findElements(By.id("Last Name"));
            if (!lastNameList.isEmpty()
                    && lastNameList.get(0).isDisplayed()
                    && lastNameList.get(0).isEnabled()) {
                lastNameList.get(0).sendKeys(lastName);
            }

            //Phone
            List<WebElement> phoneList = driver.findElements(By.id("Phone"));
            if (!phoneList.isEmpty()
                    && phoneList.get(0).isDisplayed()
                    && phoneList.get(0).isEnabled()) {
                phoneList.get(0).sendKeys(phoneNumber);
            }

            //Country
            List<WebElement> countryList = driver.findElements(By.id("Country"));
            if (!countryList.isEmpty()
                    && countryList.get(0).isDisplayed()
                    && countryList.get(0).isEnabled()
                    && !country.isEmpty()) {
                Select countrySelect = new Select(countryList.get(0));
                countrySelect.selectByVisibleText(country);
            }
            // Company
            WebElement companyField = driver.findElement(By.id("Company"));
            if (companyField.isDisplayed()
                    && companyField.isEnabled()) {
                companyField.sendKeys(company);
            }

            // Use Case dropdown
            WebElement useCaseField = driver.findElement(By.id("Use-Case"));
            if (useCaseField.isDisplayed()
                    && useCaseField.isEnabled()
                    && !useCase.isEmpty()) {
                Select useCaseSelect = new Select(useCaseField);
                useCaseSelect.selectByVisibleText(useCase);
            }


            // Comments
            WebElement commentsField = driver.findElement(By.id("Comments"));
            if (commentsField.isDisplayed()
                    && commentsField.isEnabled()) {
                commentsField.sendKeys(comments);
            }

            // Submit
            WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
            submit.click();
            Thread.sleep(5000);
            driver.quit();

        }
    }
}