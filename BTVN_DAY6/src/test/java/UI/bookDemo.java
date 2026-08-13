package UI;

import org.openqa.selenium.By;

public class bookDemo {
    public static final By EMAIL_FIELD = By.id("Business-Email");
    public static final By FIRST_NAME = By.id("First Name");
    public static final By LAST_NAME = By.id("Last Name");
    public static final By COMPANY = By.id("Company");
    public static final By PHONE_NUMBER = By.id("Phone");
    public static final By COUNTRY = By.id("Country");
    public static final By STATE = By.id("State");
    public static final By USE_CASE = By.id("Use-Case");
    public static final By COMMENT = By.id("Comments");
    public static final By SUBMIT = By.xpath("//button[@type='submit']");
    public static final By SUCCESS_MESSAGE =
            By.xpath("//h1[normalize-space()='Thanks for reaching out!']");
}
