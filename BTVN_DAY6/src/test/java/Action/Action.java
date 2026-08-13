package Action;

import org.openqa.selenium.WebDriver;

import static UI.bookDemo.*;

public class Action {

    // =========================
    // EMAIL
    // =========================

    public static void enterEmail(
            WebDriver driver,
            String email) {

        driver.findElement(EMAIL_FIELD)
                .sendKeys(email);
    }


    // =========================
    // FIRST NAME
    // =========================

    public static void enterFirstName(
            WebDriver driver,
            String firstName) {

        driver.findElement(FIRST_NAME)
                .sendKeys(firstName);
    }


    // =========================
    // LAST NAME
    // =========================

    public static void enterLastName(
            WebDriver driver,
            String lastName) {

        driver.findElement(LAST_NAME)
                .sendKeys(lastName);
    }


    // =========================
    // COMPANY
    // =========================

    public static void enterCompany(
            WebDriver driver,
            String company) {

        driver.findElement(COMPANY)
                .sendKeys(company);
    }


    // =========================
    // PHONE
    // =========================

    public static void enterPhone(
            WebDriver driver,
            String phone) {

        driver.findElement(PHONE_NUMBER)
                .sendKeys(phone);
    }


    // =========================
    // COUNTRY
    // =========================

    public static void enterCountry(
            WebDriver driver,
            String country) {

        driver.findElement(COUNTRY)
                .sendKeys(country);
    }


    // =========================
    // STATE
    // =========================

    public static void enterState(
            WebDriver driver,
            String state) {

        driver.findElement(STATE)
                .sendKeys(state);
    }


    // =========================
    // USE CASE
    // =========================

    public static void enterUseCase(
            WebDriver driver,
            String useCase) {

        driver.findElement(USE_CASE)
                .sendKeys(useCase);
    }


    // =========================
    // COMMENT
    // =========================

    public static void enterComment(
            WebDriver driver,
            String comment) {

        driver.findElement(COMMENT)
                .sendKeys(comment);
    }


    // =========================
    // SUBMIT
    // =========================

    public static void clickSubmit(WebDriver driver) {

        driver.findElement(SUBMIT).click();
    }


    // =========================
    // FULL FORM
    // =========================

    public static void fillForm(
            WebDriver driver,
            String email,
            String firstName,
            String lastName,
            String company,
            String phoneNumber,
            String country,
            String state,
            String useCase,
            String comment) {

        if (email != null && !email.isEmpty())
            enterEmail(driver, email);

        if (firstName != null && !firstName.isEmpty())
            enterFirstName(driver, firstName);

        if (lastName != null && !lastName.isEmpty())
            enterLastName(driver, lastName);

        if (company != null && !company.isEmpty())
            enterCompany(driver, company);

        if (phoneNumber != null && !phoneNumber.isEmpty())
            enterPhone(driver, phoneNumber);

        if (country != null && !country.isEmpty())
            enterCountry(driver, country);

        if (state != null && !state.isEmpty())
            enterState(driver, state);

        if (useCase != null && !useCase.isEmpty())
            enterUseCase(driver, useCase);

        if (comment != null && !comment.isEmpty())
            enterComment(driver, comment);
    }
}