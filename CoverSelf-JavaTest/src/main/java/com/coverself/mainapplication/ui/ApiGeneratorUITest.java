package com.coverself.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ApiGeneratorUITest {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeClass
    public void setUp() {

        driver = new ChromeDriver();
        homePage = new HomePage(driver);
    }

    @Test
    public void testApiGeneratorUI() {

        homePage.fillDataAndGenerateAPI();


        String apiUrl = homePage.getApiEndpointUrl();
        Assert.assertNotNull(apiUrl, "API endpoint URL is empty");


        int rowCount = homePage.getPreviewTableRowCount();
        Assert.assertEquals(rowCount, 5, "Unexpected number of rows in preview table");
    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}
