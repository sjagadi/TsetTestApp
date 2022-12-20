package com.tset.utils;

import com.tset.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Utilities extends BaseTest {
    public static void moveToElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public static void enterText(WebElement textBox, String textToEnter){
        textBox.click();
        textBox.clear();
        textBox.sendKeys(textToEnter);
    }

    public static WebElement webElement(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }
}
