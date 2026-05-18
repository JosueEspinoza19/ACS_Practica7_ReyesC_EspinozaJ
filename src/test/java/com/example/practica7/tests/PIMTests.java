package com.example.practica7.tests;

import com.example.practica7.base.BaseTest;
import com.example.practica7.pages.DashboardPage;
import com.example.practica7.pages.LoginPage;
import com.example.practica7.pages.PIMPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PIMTests extends BaseTest {

    @Test(description = "TC-05: Search an existing employee by name")
    public void tc05_SearchEmployeeByName() {
        new LoginPage(driver).login("Admin", "admin123");

        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.clickPIMModule();

        PIMPage pimPage = new PIMPage(driver);
        pimPage.searchEmployee("Jeffrey");

        Assert.assertTrue(pimPage.areResultsDisplayed(), "The results container should be visible.");
        Assert.assertTrue(pimPage.isEmployeeShownInResults("Jeffrey Ray"), "The searched employee should appear in the results.");
    }
}