package com.coverself.ui;

import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openUrl(String url) {
        driver.get("https://retool.com/api-generator");
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void closeBrowser() {
        driver.quit();
    }
}
