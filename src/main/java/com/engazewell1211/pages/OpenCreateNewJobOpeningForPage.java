package com.backend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.utils.ElementUtils;
import org.junit.Assert;
import java.util.List;

public class OpenCreateNewJobOpeningForPage {
    private WebDriver driver;
    private ElementUtils elementUtils;

    public OpenCreateNewJobOpeningForPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "addJobOpeningButton")
    private WebElement addJobOpeningButton;

    @FindBy(id = "createNewJobOpeningForm")
    private WebElement createNewJobOpeningForm;

    @FindBy(id = "jobTitleField")
    private WebElement jobTitleField;

    @FindBy(id = "jobDescriptionField")
    private WebElement jobDescriptionField;

    @FindBy(id = "jobRequirementsField")
    private WebElement jobRequirementsField;

    @FindBy(id = "saveButton")
    private WebElement saveButton;

    @FindBy(id = "cancelButton")
    private WebElement cancelButton;

    @FindBy(id = "successMessage")
    private WebElement successMessage;

    @FindBy(className = "mandatoryField")
    private List<WebElement> mandatoryFields;

    @FindBy(className = "formField")
    private List<WebElement> allFormFields;

    public void navigateToJobOpeningScreen() {
        driver.get("http://localhost/jobOpening");
    }

    public void clicksAddJobOpeningButton() {
        try {
            elementUtils.clickElement(addJobOpeningButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isCreateNewJobOpeningFormDisplayed() {
        try {
            return elementUtils.isElementDisplayed(createNewJobOpeningForm);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void fillJobTitle(String jobTitle) {
        try {
            elementUtils.clearAndSendKeys(jobTitleField, jobTitle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fillJobDescription(String jobDescription) {
        try {
            elementUtils.clearAndSendKeys(jobDescriptionField, jobDescription);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fillJobRequirements(String jobRequirements) {
        try {
            elementUtils.clearAndSendKeys(jobRequirementsField, jobRequirements);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clicksSaveButton() {
        try {
            elementUtils.clickElement(saveButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isJobOpeningSavedSuccessfully() {
        try {
            return elementUtils.isElementDisplayed(successMessage);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isUserOnJobOpeningScreen() {
        return driver.getCurrentUrl().contains("jobOpening");
    }

    public void clicksCancelButton() {
        try {
            elementUtils.clickElement(cancelButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void areMandatoryFieldsDisplayed() {
        try {
            Assert.assertFalse("Mandatory fields are not displayed.", mandatoryFields.isEmpty());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void areAllFieldsPresent() {
        try {
            Assert.assertFalse("Not all form fields are present.", allFormFields.isEmpty());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void areSaveAndCancelButtonsDisplayed() {
        try {
            Assert.assertTrue("Save button is not displayed.", elementUtils.isElementDisplayed(saveButton));
            Assert.assertTrue("Cancel button is not displayed.", elementUtils.isElementDisplayed(cancelButton));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void areMandatoryFieldsClearlyMarked() {
        try {
            for (WebElement field : mandatoryFields) {
                Assert.assertTrue("Mandatory field is not clearly marked.", field.getAttribute("class").contains("required"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void areFieldsResetToDefault() {
        try {
            Assert.assertTrue("Job Title field is not empty.", jobTitleField.getText().isEmpty());
            Assert.assertTrue("Job Description field is not empty.", jobDescriptionField.getText().isEmpty());
            Assert.assertTrue("Job Requirements field is not empty.", jobRequirementsField.getText().isEmpty());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fillMandatoryFieldsWithValidData() {
        fillJobTitle("Valid Job Title");
        fillJobDescription("Valid Job Description");
        fillJobRequirements("Valid Job Requirements");
    }

    public void fillAllFieldsWithValidData() {
        fillJobTitle("Valid Job Title");
        fillJobDescription("Valid Job Description");
        fillJobRequirements("Valid Job Requirements");
    }

    public void fillMandatoryFieldsWithValidDataAndSomeOptionalFields() {
        fillJobTitle("Valid Job Title");
        fillJobDescription("Valid Job Description");
    }

    public boolean isJobOpeningCreated() {
        return successMessage.getText().contains("Job opening created successfully");
    }
}