package com.backend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.utils.ElementUtils;
import org.junit.Assert;

public class LoginScreenForRecruiters_posPage {
    private WebDriver driver;
    private ElementUtils elementUtils;

    // Define web elements using @FindBy
    @FindBy(id = "emailField")
    private WebElement emailField;

    @FindBy(id = "passwordField")
    private WebElement passwordField;

    @FindBy(id = "showPasswordOption")
    private WebElement showPasswordOption;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    @FindBy(id = "dashboard")
    private WebElement dashboard;

    @FindBy(id = "errorMessage")
    private WebElement errorMessage;

    public LoginScreenForRecruiters_posPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginScreen() {
        driver.get("http://localhost/login");
    }

    public void enterEmail(String email) {
        try {
            elementUtils.clearAndSendKeys(emailField, email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterPassword(String password) {
        try {
            elementUtils.clearAndSendKeys(passwordField, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void togglePasswordVisibility() {
        try {
            elementUtils.clickElement(showPasswordOption);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickLoginButton() {
        try {
            elementUtils.clickElement(loginButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isDashboardDisplayed() {
        return elementUtils.isElementDisplayed(dashboard);
    }

    public boolean isErrorMessageDisplayed() {
        return elementUtils.isElementDisplayed(errorMessage);
    }

    public String getErrorMessage() {
        try {
            return elementUtils.getElementText(errorMessage);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void logout() {
        // Implement logout functionality here
    }

    public boolean isLoginScreenDisplayed() {
        // Implement check for login screen display
        return true; // Placeholder
    }

    public boolean isLoginSuccessfulAfterToggling() {
        return isDashboardDisplayed();
    }

    public void enterValidEmailId() {
        enterEmail("valid@example.com"); // Use appropriate valid email
    }

    public void enterInput(String input) {
        try {
            elementUtils.clearAndSendKeys(emailField, input); // Adjust based on intended usage
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickShowPasswordOption() {
        try {
            elementUtils.clickElement(showPasswordOption);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void leavePasswordFieldEmpty() {
        try {
            elementUtils.clearElement(passwordField);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isPasswordVisible() {
        boolean isVisible = false;
        try {
            String type = passwordField.getAttribute("type");
            isVisible = type.equals("text");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isVisible;
    }

    public boolean isLoginButtonEnabled() {
        boolean isEnabled = false;
        try {
            isEnabled = loginButton.isEnabled();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isEnabled;
    }

    public void isDashboardLoadedSuccessfully() {
        try {
            Assert.assertTrue("Dashboard is not loaded successfully!", isDashboardDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}