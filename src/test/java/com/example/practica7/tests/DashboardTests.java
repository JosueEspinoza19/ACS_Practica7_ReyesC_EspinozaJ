package com.example.practica7.tests;

import com.example.practica7.base.BaseTest;
import com.example.practica7.pages.DashboardPage;
import com.example.practica7.pages.PIMPage;
import com.example.practica7.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTests extends BaseTest {

    @Test(description = "TC-03: Navigate to PIM internal module")
    public void tc03_NavigateToPIM() {
        new LoginPage(driver).login("Admin", "admin123");
        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.clickPIMModule();
        Assert.assertTrue(driver.getCurrentUrl().contains("/pim/viewEmployeeList"), "La URL del módulo PIM es incorrecta.");
    }

    @Test(description = "TC-04: Validate dashboard key elements")
    public void tc04_ValidateDashboardElements() {
        new LoginPage(driver).login("Admin", "admin123");
        DashboardPage dashboard = new DashboardPage(driver);

        Assert.assertTrue(dashboard.isLogoDisplayed(), "The OrangeHRM logo should be visible.");
        Assert.assertTrue(dashboard.isWidgetDisplayed(), "The Time at Work widget should be visible.");
    }

    @Test(description = "TC-06: Logout successfully")
    public void tc06_LogoutSuccessfully() {
        new LoginPage(driver).login("Admin", "admin123");
        DashboardPage dashboard = new DashboardPage(driver);

        dashboard.logout();

        Assert.assertTrue(driver.getCurrentUrl().contains("/auth/login"), "The session should return to the login page.");
    }
}