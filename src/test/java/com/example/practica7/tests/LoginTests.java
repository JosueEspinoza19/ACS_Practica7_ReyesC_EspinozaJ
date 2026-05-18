package com.example.practica7.tests;

import com.example.practica7.base.BaseTest;
import com.example.practica7.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(description = "TC-01: Successful login with valid credentials")
    public void tc01_SuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");
        Assert.assertTrue(driver.getCurrentUrl().contains("/dashboard/index"), "No se redirigió al Dashboard.");
    }

    @Test(description = "TC-02: Failed login with invalid password")
    public void tc02_InvalidPasswordLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "incorrecta");
        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid credentials");
    }
}