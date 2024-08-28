package com.curabook.tests;

import com.curabook.pages.BasePage;
import com.curabook.models.AppointmentData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AppointmentTest {
    WebDriver driver;
    BasePage basePage;

    // Setup method to initialize WebDriver and navigate to the homepage
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        basePage = new BasePage(driver);
        driver.get("https://curabook.com");
        basePage.clickMakeAppointmentButton();
    }

    // Test case for successfully booking an appointment
    @Test
    public void testSuccessfulAppointment() {
        AppointmentData appointment = new AppointmentData();
        appointment.setFacility("Seoul CURA Healthcare Center");
        appointment.setHealthcareProgram("Medicaid");
        appointment.setDate("04/01/2023");
        appointment.setComment("Just first common test case");
        appointment.setBooked(true);

        basePage.selectFacility(appointment.getFacility());
        basePage.checkHospitalReadmission();
        basePage.selectHealthcareProgram(appointment.getHealthcareProgram());
        basePage.insertVisitDate(appointment.getDate());
        basePage.insertComment(appointment.getComment());
        basePage.clickBookAppointmentButton();

        Assert.assertTrue(basePage.isAppointmentConfirmed());
    }

    // Teardown method to close the browser after the test is completed
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
