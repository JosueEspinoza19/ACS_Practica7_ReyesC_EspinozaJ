package com.example.practica7.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PIMPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By employeeNameInput = By.xpath("//label[text()='Employee Name']/ancestor::div[2]//input");
    private By searchButton = By.cssSelector("button[type='submit']");
    private By tableResultsContainer = By.className("orangehrm-container");

    public PIMPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void searchEmployee(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(employeeNameInput)).sendKeys(name);
        driver.findElement(searchButton).click();
    }

    public boolean areResultsDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(tableResultsContainer)).isDisplayed();
    }
}