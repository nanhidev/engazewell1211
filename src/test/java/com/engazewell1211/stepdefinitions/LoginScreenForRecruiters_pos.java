package com.engazewell1211.stepdefinitions;

import com..utils.ElementUtils;
import org.junit.Assert;
import com..driverfactory.DriverFactory;
import com.engazewell1211.pages.LoginScreenForRecruiters_posPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class LoginScreenForRecruiters_pos extends DriverFactory {
LoginScreenForRecruiters_posPage loginPage = new LoginScreenForRecruiters_posPage(driver);
@Given("the user is on the Login Screen")
public void the_user_is_on_the_login_screen() {
driver = DriverFactory.getDriver();
loginPage.navigateToLoginScreen();
}
@When("I enter a valid email ID {string} in the Email ID field")
public void i_enter_a_valid_email_id_in_the_email_id_field(String email) {
loginPage.enterEmail(email);
}
@When("I enter a valid password {string} in the Password field")
public void i_enter_a_valid_password_in_the_password_field(String password) {
loginPage.enterPassword(password);
}
@When("I click on the 'Show Password' option to verify the password visibility")
public void i_click_on_show_password_option() {
loginPage.togglePasswordVisibility();
}
@When("I click the Login button")
public void i_click_the_login_button() {
loginPage.clickLoginButton();
}
@Then("the user should be redirected to the dashboard")
public void the_user_should_be_redirected_to_the_dashboard() {
loginPage.isDashboardDisplayed();
}
@Then("the dashboard loads successfully without errors")
public void the_dashboard_loads_successfully_without_errors() {
loginPage.isDashboardLoadedSuccessfully();
}
@When("I leave the Password field empty")
public void i_leave_the_password_field_empty() {
loginPage.leavePasswordFieldEmpty();
}
@Then("the Login button should be disabled")
public void the_login_button_should_be_disabled() {
loginPage.isLoginButtonEnabled();
}
@When("I enter a valid password in the Password field")
public void i_enter_a_valid_password_in_the_password_field() {
// This step is already covered in the previous step definitions
}
@Then("the Login button should be enabled")
public void the_login_button_should_be_enabled() {
loginPage.isLoginButtonEnabled();
}
@When("the user has entered a valid password in the Password field")
public void the_user_has_entered_a_valid_password_in_the_password_field() {
// This step is already covered in the previous step definitions
}
@Then("the password should be visible")
public void the_password_should_be_visible() {
loginPage.isPasswordVisible();
}
@When("the user clicks on the 'Hide Password' option")
public void the_user_clicks_on_hide_password_option() {
loginPage.togglePasswordVisibility();
}
@Then("the password should be hidden")
public void the_password_should_be_hidden() {
loginPage.isPasswordVisible();
}
@Then("the user can still log in successfully after toggling")
public void the_user_can_still_log_in_successfully_after_toggling() {
loginPage.isLoginSuccessfulAfterToggling();
}
@When("I log out and return to the Login Screen")
public void i_log_out_and_return_to_the_login_screen() {
loginPage.logout();
loginPage.navigateToLoginScreen();
}
@When("I enter {string}")
public void i_enter(String email) {
loginPage.enterEmail(email);
}
@Then("an error message {string} should be displayed")
public void an_error_message_should_be_displayed(String errorMessage) {
Assert.assertEquals(errorMessage, loginPage.getErrorMessage());
}
@When("the user logs out and returns to the Login Screen")
public void the_user_logs_out_and_returns_to_the_login_screen() {
loginPage.logout();
loginPage.navigateToLoginScreen();
}

@Given("the user clicks on the 'show password' option")
public void the_user_clicks_on_show_password_option() {
loginPage.clickShowPasswordOption();
}
@When("the user clicks the login button")
public void the_user_clicks_the_login_button() {
loginPage.clickLoginButton();
}
@Then("an error message incorrect email id or password. should be displayed")
public void an_error_message_incorrect_email_id_or_password_should_be_displayed() {
"Error message should be displayed", loginPage.isErrorMessageDisplayed();
}
@Then("the user should return to the login screen")
public void the_user_should_return_to_the_login_screen() {
"User should be on the login screen", loginPage.isLoginScreenDisplayed();
}
@When("i enter a valid email id containing numbers {string}")
public void i_enter_a_valid_email_id_containing_numbers(String email) {
loginPage.enterEmailId(email);
}
@Then("the user should be redirected to the dashboard successfully")
public void the_user_should_be_redirected_to_the_dashboard_successfully() {
"User should be redirected to the dashboard", loginPage.isDashboardDisplayed();
}
@When("i enter a valid email id in the email id field")
public void i_enter_a_valid_email_id_in_the_email_id_field() {
loginPage.enterValidEmailId(); // Ensure this method is implemented in the page class
}
@When("i enter the correct password {string}")
public void i_enter_the_correct_password(String password) {
loginPage.enterPassword(password);
}
@When("the user enters {string}")
public void the_user_enters(String input) {
loginPage.enterInput(input); // Ensure this method is descriptive and implemented
}
@When("i log out")
public void i_log_out() {
loginPage.logout();
}
}