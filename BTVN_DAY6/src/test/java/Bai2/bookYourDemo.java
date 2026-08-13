package Bai2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static Action.Action.*;
import static UI.bookDemo.*;

public class bookYourDemo {
    WebDriver driver;

    String validEmail = "automation.test@example.com";
    String validFirstName = "John";
    String validLastName = "Doe";
    String validCompany = "Automation Test Company";
    String validPhone = "1234567890";
    String validCountry = "United States";
    String validState = "California";
    String validUseCase = "Mobile App Distribution";
    String validComment = "This is a Selenium test.";

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://saucelabs.com/request-demo");
    }

    @Test
    public void testPageTitle() {
        Assert.assertEquals(driver.getTitle(), "Book a Demo | Sauce Labs", "Title is incorrect!");
    }

    @Test
    public void testPageURL() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://saucelabs.com/request-demo", "URL is incorrect!");
    }

    @Test
    public void testEmailDisplayed() {
        Assert.assertTrue(isDisplayed(EMAIL_FIELD), "Email field is not displayed!");
    }

    @Test
    public void testInvalidEmail() {
        enterEmail(driver, "abc");
        Assert.assertFalse(isDisplayed(FIRST_NAME), "First Name should not be displayed!");
        Assert.assertFalse(isDisplayed(LAST_NAME), "Last Name should not be displayed!");
        Assert.assertFalse(isDisplayed(PHONE_NUMBER), "Phone should not be displayed!");
    }

    @Test
    public void testEmailWithoutAt() {
        enterEmail(driver, "automation.testgmail.com");
        Assert.assertFalse(isDisplayed(FIRST_NAME), "First Name should not be displayed!");
    }

    @Test
    public void testEmailWithoutDomain() {
        enterEmail(driver, "automation.test@");
        Assert.assertFalse(isDisplayed(FIRST_NAME), "First Name should not be displayed!");
    }

    @Test
    public void testEmailDoubleAt() {
        enterEmail(driver, "automation@@gmail.com");
        Assert.assertFalse(isDisplayed(FIRST_NAME), "First Name should not be displayed!");
    }

    @Test
    public void testEmailWithSpace() {
        enterEmail(driver, "automation test@gmail.com");
        Assert.assertFalse(isDisplayed(FIRST_NAME), "First Name should not be displayed!");
    }

    @Test
    public void testEmptyEmail() {
        enterEmail(driver, "");
        Assert.assertFalse(isDisplayed(FIRST_NAME), "First Name should not be displayed!");
    }

    @Test
    public void testValidEmail() {
        enterEmail(driver, validEmail);
        Assert.assertTrue(isDisplayed(FIRST_NAME), "First Name should be displayed!");
    }

    @Test
    public void testFirstNameDisplayed() {
        enterEmail(driver, validEmail);
        Assert.assertTrue(isDisplayed(FIRST_NAME), "First Name is not displayed!");
    }

    @Test
    public void testLastNameDisplayed() {
        enterEmail(driver, validEmail);
        Assert.assertTrue(isDisplayed(LAST_NAME), "Last Name is not displayed!");
    }

    @Test
    public void testCompanyDisplayed() {
        enterEmail(driver, validEmail);
        Assert.assertTrue(isDisplayed(COMPANY), "Company is not displayed!");
    }

    @Test
    public void testPhoneDisplayed() {
        enterEmail(driver, validEmail);
        Assert.assertTrue(isDisplayed(PHONE_NUMBER), "Phone is not displayed!");
    }

    @Test
    public void testCountryDisplayed() {
        enterEmail(driver, validEmail);
        Assert.assertTrue(isDisplayed(COUNTRY), "Country is not displayed!");
    }

    @Test
    public void testStateDisplayed() {
        enterEmail(driver, validEmail);
        Assert.assertTrue(isDisplayed(STATE), "State is not displayed!");
    }

    @Test
    public void testUseCaseDisplayed() {
        enterEmail(driver, validEmail);
        Assert.assertTrue(isDisplayed(USE_CASE), "Use Case is not displayed!");
    }

    @Test
    public void testCommentDisplayed() {
        enterEmail(driver, validEmail);
        Assert.assertTrue(isDisplayed(COMMENT), "Comment is not displayed!");
    }

    @Test
    public void testEmptyFirstName() {
        enterEmail(driver, validEmail);
        enterLastName(driver, validLastName);
        enterCompany(driver, validCompany);
        enterPhone(driver, validPhone);
        clickSubmit(driver);
        Assert.assertFalse(isSuccessPage(), "Form should not submit!");
    }

    @Test
    public void testEmptyLastName() {
        enterEmail(driver, validEmail);
        enterFirstName(driver, validFirstName);
        enterCompany(driver, validCompany);
        enterPhone(driver, validPhone);
        clickSubmit(driver);
        Assert.assertFalse(isSuccessPage(), "Form should not submit!");
    }

    @Test
    public void testEmptyCompany() {
        enterEmail(driver, validEmail);
        enterFirstName(driver, validFirstName);
        enterLastName(driver, validLastName);
        enterPhone(driver, validPhone);
        clickSubmit(driver);
        Assert.assertFalse(isSuccessPage(), "Form should not submit!");
    }

    @Test
    public void testEmptyPhone() {
        enterEmail(driver, validEmail);
        enterFirstName(driver, validFirstName);
        enterLastName(driver, validLastName);
        enterCompany(driver, validCompany);
        clickSubmit(driver);
        Assert.assertFalse(isSuccessPage(), "Form should not submit!");
    }

    @Test
    public void testFirstNameOnlySpace() {
        enterEmail(driver, validEmail);
        enterFirstName(driver, "   ");
        enterLastName(driver, validLastName);
        enterCompany(driver, validCompany);
        enterPhone(driver, validPhone);
        clickSubmit(driver);
        Assert.assertFalse(isSuccessPage(), "First Name only spaces should not submit!");
    }

    @Test
    public void testLastNameOnlySpace() {
        enterEmail(driver, validEmail);
        enterFirstName(driver, validFirstName);
        enterLastName(driver, "   ");
        enterCompany(driver, validCompany);
        enterPhone(driver, validPhone);
        clickSubmit(driver);
        Assert.assertFalse(isSuccessPage(), "Last Name only spaces should not submit!");
    }

    @Test
    public void testCompanyOnlySpace() {
        enterEmail(driver, validEmail);
        enterFirstName(driver, validFirstName);
        enterLastName(driver, validLastName);
        enterCompany(driver, "   ");
        enterPhone(driver, validPhone);
        clickSubmit(driver);
        Assert.assertFalse(isSuccessPage(), "Company only spaces should not submit!");
    }

    @Test
    public void testValidFirstName() {
        enterEmail(driver, validEmail);
        enterFirstName(driver, validFirstName);
        Assert.assertEquals(driver.findElement(FIRST_NAME).getAttribute("value"), validFirstName);
    }

    @Test
    public void testValidLastName() {
        enterEmail(driver, validEmail);
        enterLastName(driver, validLastName);
        Assert.assertEquals(driver.findElement(LAST_NAME).getAttribute("value"), validLastName);
    }

    @Test
    public void testValidCompany() {
        enterEmail(driver, validEmail);
        enterCompany(driver, validCompany);
        Assert.assertEquals(driver.findElement(COMPANY).getAttribute("value"), validCompany);
    }

    @Test
    public void testValidPhone() {
        enterEmail(driver, validEmail);
        enterPhone(driver, validPhone);
        Assert.assertEquals(driver.findElement(PHONE_NUMBER).getAttribute("value"), validPhone);
    }

    @Test
    public void testValidCountry() {
        enterEmail(driver, validEmail);
        enterCountry(driver, validCountry);
        Assert.assertTrue(driver.findElement(COUNTRY).getAttribute("value").contains("United"));
    }

    @Test
    public void testValidUseCase() {
        enterEmail(driver, validEmail);
        enterUseCase(driver, validUseCase);
        Assert.assertTrue(driver.findElement(USE_CASE).getAttribute("value").contains("Mobile"));
    }

    @Test
    public void testValidComment() {
        enterEmail(driver, validEmail);
        enterComment(driver, validComment);
        Assert.assertEquals(driver.findElement(COMMENT).getAttribute("value"), validComment);
    }

    @Test
    public void testValidFullForm() {
        enterEmail(driver, validEmail);
        enterFirstName(driver, validFirstName);
        enterLastName(driver, validLastName);
        enterCompany(driver, validCompany);
        enterPhone(driver, validPhone);
        enterCountry(driver, validCountry);
        enterState(driver, validState);
        enterUseCase(driver, validUseCase);
        enterComment(driver, validComment);
        clickSubmit(driver);
        Assert.assertTrue(isSuccessPage(), "Form submission failed!");
    }

    @Test
    public void testEmptyComment() {
        enterEmail(driver, validEmail);
        enterFirstName(driver, validFirstName);
        enterLastName(driver, validLastName);
        enterCompany(driver, validCompany);
        enterPhone(driver, validPhone);
        enterCountry(driver, validCountry);
        enterState(driver, validState);
        enterUseCase(driver, validUseCase);
        clickSubmit(driver);
        Assert.assertTrue(isSuccessPage(), "Form should allow empty Comment!");
    }

    @Test
    public void testRefreshPage() {
        enterEmail(driver, validEmail);
        driver.navigate().refresh();
        Assert.assertEquals(driver.getCurrentUrl(), "https://saucelabs.com/request-demo");
    }

    @Test
    public void testClearEmail() {
        WebElement email = driver.findElement(EMAIL_FIELD);
        email.sendKeys(validEmail);
        email.clear();
        Assert.assertEquals(email.getAttribute("value"), "");
        Assert.assertFalse(isDisplayed(FIRST_NAME), "First Name should not be displayed!");
    }

    @Test
    public void testUppercaseEmail() {
        enterEmail(driver, "AUTOMATION.TEST@EXAMPLE.COM");
        Assert.assertTrue(isDisplayed(FIRST_NAME), "Valid uppercase email should continue!");
    }

    @Test
    public void testEmailWithPlus() {
        enterEmail(driver, "automation+test@example.com");
        Assert.assertTrue(isDisplayed(FIRST_NAME), "Email with + should be accepted!");
    }

    @Test
    public void testEmailWithDot() {
        enterEmail(driver, "automation.test@example.com");
        Assert.assertTrue(isDisplayed(FIRST_NAME), "Email with dot should be accepted!");
    }

    @Test
    public void testSubmitButtonDisplayed() {
        enterEmail(driver, validEmail);
        Assert.assertTrue(isDisplayed(SUBMIT), "Submit button is not displayed!");
    }

    @Test
    public void testAllFieldsDisplayedAfterValidEmail() {
        enterEmail(driver, validEmail);
        Assert.assertTrue(isDisplayed(FIRST_NAME));
        Assert.assertTrue(isDisplayed(LAST_NAME));
        Assert.assertTrue(isDisplayed(COMPANY));
        Assert.assertTrue(isDisplayed(PHONE_NUMBER));
        Assert.assertTrue(isDisplayed(COUNTRY));
        Assert.assertTrue(isDisplayed(STATE));
        Assert.assertTrue(isDisplayed(USE_CASE));
        Assert.assertTrue(isDisplayed(COMMENT));
    }

    @Test
    public void testCompleteBookDemoFlow() {
        enterEmail(driver, validEmail);
        enterFirstName(driver, validFirstName);
        enterLastName(driver, validLastName);
        enterCompany(driver, validCompany);
        enterPhone(driver, validPhone);
        enterCountry(driver, validCountry);
        enterState(driver, validState);
        enterUseCase(driver, validUseCase);
        enterComment(driver, validComment);
        clickSubmit(driver);
        Assert.assertTrue(isSuccessPage(), "Book Demo was not successful!");
    }

    public boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isSuccessPage() {
        try {
            return driver.findElement(SUCCESS_MESSAGE).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}