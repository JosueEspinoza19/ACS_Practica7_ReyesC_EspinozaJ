package com.example.practica7.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DashboardPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By pimMenuOption = By.xpath("//span[text()='PIM']");
    private By mainLogo = By.cssSelector(".oxd-brand-banner img");
    private By userDropdown = By.className("oxd-userdropdown-tab");
    private By logoutLink = By.xpath("//a[text()='Logout']");
    private By timeAtWorkWidget = By.xpath("//p[text()='Time at Work']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickPIMModule() {
        wait.until(ExpectedConditions.elementToBeClickable(pimMenuOption)).click();
    }

    public boolean isLogoDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(mainLogo)).isDisplayed();
    }

    public boolean isWidgetDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(timeAtWorkWidget)).isDisplayed();
    }

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(userDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
    }
}