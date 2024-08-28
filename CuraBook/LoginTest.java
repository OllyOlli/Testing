package com.curabook.tests;

import com.curabook.pages.LoginPage;
import com.curabook.models.UserData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

    // Setup method to initialize WebDriver and navigate to the homepage
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.get("https://curabook.com");
    }

    // Test case for logging in with valid credentials
    @Test
    public void testValidLogin() {
        UserData user = new UserData();
        user.setUsername("John Doe");
        user.setPassword("ThisIsNotAPassword");
        user.setUrl("/#appointment");

        loginPage.loginWithCredentials(user.getUsername(), user.getPassword());

        // Verify that the user is navigated to the correct URL after login
        Assert.assertEquals(driver.getCurrentUrl(), user.getUrl());
    }

    // Teardown method to close the browser after the test is completed
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
