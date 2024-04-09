package com.coverself.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }


    private WebElement nameField() {
        return driver.findElement(By.xpath("//*[@id='input_name--0']"));
    }

    private WebElement orderCountField() {
        return driver.findElement(By.xpath("//*[@id='input_name--1']"));
    }

    private WebElement emailField() {
        return driver.findElement(By.xpath("//*[@id='input_name--2']"));
    }

    private WebElement productIdField() {
        return driver.findElement(By.xpath("//*[@id='input_name--3']"));
    }

    private WebElement generateApiButton() {
        return driver.findElement(By.xpath("//p[contains(text(),'Generate API')]"));
    }

    private WebElement endpointUrlInput() {
        return driver.findElement(By.xpath("//*[@id='input_api_name--0']"));
    }

    private WebElement previewTable() {
        return driver.findElement(By.xpath("//div[@id='table-generated_table']"));
    }

    private WebElement addColumnButton() {
        return driver.findElement(By.xpath("//*[contains(text(),'Add Column')]"));
    }


    public void fillDataAndGenerateAPI() {

        fillDataField(nameField(), "Name", "People", "Full Name");


        clickAddColumnButton();


        fillDataField(orderCountField(), "OrderCount", "Number", "Random");


        clickAddColumnButton();


        fillDataField(emailField(), "Email", "People", "Email Address");


        clickAddColumnButton();


        fillDataField(productIdField(), "ProductId", "Number", "Product ID");


        clickAddColumnButton();


        clickGenerateAPI();
    }

    private void fillDataField(WebElement element, String value, String mainOption, String subOption) {
        element.sendKeys(value);

        WebElement mainDropdown = driver.findElement(By.id("input-control-component__input"));
        new Select(mainDropdown).selectByVisibleText(mainOption);


        mainDropdown.click();


        WebElement peopleOption = driver.findElement(By.xpath("//*[text()='People']"));
        peopleOption.click();


        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()="Full Name"]"));

        WebElement subDropdown = driver.findElement(By.By.xpath("//*[text()="Full Name"]"));
        new Select(subDropdown).selectByVisibleText(subOption);
    }

    private void clickAddColumnButton() {
        addColumnButton().click();
    }

    public String getApiEndpointUrl() {
        return endpointUrlInput().getAttribute("value");
    }

    public int getPreviewTableRowCount() {
        return previewTable().findElements(By.Name("table-results-counter")).size();
    }
}
