package com.tset.pages;

import com.tset.base.BaseTest;
import com.tset.utils.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PriceComponentsPage extends BaseTest {
    @FindBy(id = "base-edit-icon")
    protected WebElement editBasePriceIcon;

    @FindBy(id = "base-value-input")
    protected WebElement basePriceValueTextBox;

    @FindBy(id = "BasePrice")
    protected WebElement basePriceLabel;

    @FindBy(xpath = "//div[contains(text(), 'Total')]/span")
    protected WebElement totalValue;

    @FindBy(xpath = "//div[@id='BasePrice']//div[@class='text-right']")
    protected WebElement basePriceValue;

    @FindBy(id = "ghost-label-input")
    protected WebElement componentTextBox;

    @FindBy(xpath = "//input[contains(@id, 'label-input') and contains(@class, 'yellow')]")
    protected WebElement updateComponentTextBox;

    @FindBy(id = "ghost-value-input")
    protected WebElement componentPriceTextBox;


    @FindBy(xpath = "//input[contains(@id, 'value-input') and not(@id = 'ghost-value-input')]")
    protected WebElement updateComponentPriceTextBox;

    @FindBy(id = "base-check-icon")
    protected WebElement saveBaseComponentCheckIcon;

    @FindBy(id = "ghost-check-icon")
    protected WebElement saveComponentCheckIcon;

    @FindBy(xpath = "//span[contains(@id, 'check-icon') and not(contains(@style, 'display: none;'))]")
    protected WebElement updateComponentCheckIcon;

    @FindBy(xpath = "//p[contains(@class, 'text-red')]")
    protected WebElement errorMessagePlaceHolder;


    public PriceComponentsPage(){
        PageFactory.initElements(driver, this);
    }

    public double updateBasePrice(double basePrice) {
        Utilities.moveToElement(basePriceLabel);
        editBasePriceIcon.click();
        Utilities.enterText(basePriceValueTextBox, Double.toString(basePrice));
        saveBaseComponentCheckIcon.click();
        return Double.parseDouble(basePriceValue.getText());
    }

    public double addNewComponent(String component, double price) {
        Utilities.enterText(componentTextBox, component);
        Utilities.enterText(componentPriceTextBox, Double.toString(price));
        saveComponentCheckIcon.click();
        return getComponentPrice(component);
    }

    public void removeComponent(String component) {
        WebElement element = driver.findElement(By.xpath("//span[text()='" + component + "']"));
        Utilities.moveToElement(element);
        Utilities.webElement("//span[text()='" + component + "']/../..//i[@class='fas fa-trash-alt']").click();
    }

    public String updateComponentWithInvalidName(String component, String componentName) {
        Utilities.moveToElement(Utilities.webElement("//span[text()='" + component + "']"));
        Utilities.webElement("//span[text()='" + component + "']/../..//i[@class='fas fa-pencil-alt']").click();
        Utilities.enterText(updateComponentTextBox, componentName);
        String errorMessage = errorMessagePlaceHolder.getText();
        updateComponentCheckIcon.click();
        return errorMessage;
    }

    public String updateComponentWithInvalidPrice(String component, double componentValue) {
        Utilities.moveToElement(Utilities.webElement("//span[text()='" + component + "']"));
        Utilities.webElement("//span[text()='" + component + "']/../..//i[@class='fas fa-pencil-alt']").click();
        Utilities.enterText(updateComponentPriceTextBox, Double.toString(componentValue));
        String errorMessage = errorMessagePlaceHolder.getText();
        updateComponentCheckIcon.click();
        return errorMessage;
    }

    public double updatePriceWithValidValue(String component, double componentValue) {
        Utilities.moveToElement(Utilities.webElement("//span[text()='" + component + "']"));
        Utilities.webElement("//span[text()='" + component + "']/../..//i[@class='fas fa-pencil-alt']").click();
        Utilities.enterText(updateComponentPriceTextBox, Double.toString(componentValue));
        updateComponentCheckIcon.click();
        return Double.parseDouble(Utilities.webElement("//span[text()='" + component + "']/../..//div[@class='text-right']").getText());
    }

    public double getTotalValue() {
        return Double.parseDouble(totalValue.getText());
    }

    public boolean componentExist(String component) {
        boolean elementExist = false;
        int componentCount = driver.findElements(By.xpath("//span[text()='" + component + "']")).size();
        if (componentCount == 1) {
            elementExist = true;
        }
        return elementExist;
    }

    public double getComponentPrice(String component) {
        return Double.parseDouble(Utilities.webElement("//span[text()='" + component + "']/../..//div[@class='text-right']").getText());
    }
}
