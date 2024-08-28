package com.curabook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    // Constructor to use methods from BasePage
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Method to log in using provided credentials
    public void loginWithCredentials(String username, String password) {
        login(username, password);
    }
}
