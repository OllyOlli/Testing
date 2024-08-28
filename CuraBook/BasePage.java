package com.curabook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;

    // Constructor for initializing WebDriver
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators for web elements
    private By makeAppointmentButton = By.id("btn-make-appointment");
    private By loginButton = By.id("btn-login");
    private By facilityFieldSelect = By.id("combo_facility");
    private By hospitalReadmissionCheckbox = By.id("chk_hospotal_readmission");
    
    // Locator for healthcare program radio button (Medicaid, Medicare, etc.)
    private By healthcareProgramRadio(String program) {
        return By.xpath("//label[text()='" + program + "']");
    }
    
    private By visitDateInput = By.name("visit_date");
    private By commentInput = By.xpath("//textarea[@placeholder='Comment']");
    private By bookAppointmentButton = By.id("btn-book-appointment");
    private By appointmentConfirmationHeader = By.xpath("//h2[text()='Appointment Confirmation']");

    // Method to click the "Make Appointment" button
    public void clickMakeAppointmentButton() {
        driver.findElement(makeAppointmentButton).click();
    }

    // Method for logging in with username and password
    public void login(String username, String password) {
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    // Method to select a facility from the dropdown
    public void selectFacility(String facility) {
        driver.findElement(facilityFieldSelect).sendKeys(facility);
    }

    // Method to check the "Hospital Readmission" checkbox
    public void checkHospitalReadmission() {
        driver.findElement(hospitalReadmissionCheckbox).click();
    }

    // Method to select a healthcare program
    public void selectHealthcareProgram(String program) {
        driver.findElement(healthcareProgramRadio(program)).click();
    }

    // Method to enter a visit date
    public void insertVisitDate(String date) {
        driver.findElement(visitDateInput).sendKeys(date);
    }

    // Method to enter a comment
    public void insertComment(String comment) {
        driver.findElement(commentInput).sendKeys(comment);
    }

    // Method to click the "Book Appointment" button
    public void clickBookAppointmentButton() {
        driver.findElement(bookAppointmentButton).click();
    }

    // Method to check if the appointment confirmation header is displayed
    public boolean isAppointmentConfirmed() {
        return driver.findElement(appointmentConfirmationHeader).isDisplayed();
    }
}
