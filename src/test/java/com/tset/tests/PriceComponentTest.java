package com.tset.tests;

import com.tset.base.BaseTest;
import com.tset.utils.Constants;
import com.tset.pages.PriceComponentsPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.text.DecimalFormat;

import static com.tset.utils.Constants.scrapSurchargeValue;

public class PriceComponentTest {
    PriceComponentsPage priceComponentsPage;
    @BeforeClass
    public void setup(){
        BaseTest.initialization();
        priceComponentsPage = new PriceComponentsPage();
    }

    @Test (priority = 1)
    public void updateBasePriceTest() {
        Constants.basePrice = 5.0;
        double actualBasePrice = priceComponentsPage.updateBasePrice(Constants.basePrice);
        Assert.assertEquals(actualBasePrice, Constants.basePrice);
    }

    @Test (priority = 2)
    public void addComponentsTest() {
        Assert.assertEquals(priceComponentsPage.addNewComponent(Constants.alloySurcharge, Constants.alloySurchargePrice), Constants.alloySurchargePrice);
        Assert.assertEquals(priceComponentsPage.addNewComponent(Constants.scrapSurcharge, scrapSurchargeValue), scrapSurchargeValue);
        DecimalFormat df = new DecimalFormat("0.00");
        Assert.assertEquals(priceComponentsPage.addNewComponent(Constants.internalSurcharge, Constants.internalSurchargeValue), Double.parseDouble(df.format(Constants.internalSurchargeValue)));
        Assert.assertEquals(priceComponentsPage.addNewComponent(Constants.externalSurcharge, Constants.externalSurchargeValue), Constants.externalSurchargeValue);
        Assert.assertEquals(priceComponentsPage.addNewComponent(Constants.storageSurcharge, Constants.storageSurchargeValue), Constants.storageSurchargeValue);
        double totalValue = Constants.basePrice + Constants.alloySurchargePrice + scrapSurchargeValue + Double.parseDouble(df.format(Constants.internalSurchargeValue))
                        + Constants.externalSurchargeValue + Constants.storageSurchargeValue;
        Assert.assertEquals(priceComponentsPage.getTotalValue(), Double.parseDouble(df.format(totalValue)));
    }

    @Test (priority = 3)
    public void removeComponentTest() {
        priceComponentsPage.removeComponent(Constants.internalSurcharge);
        Assert.assertFalse(priceComponentsPage.componentExist(Constants.internalSurcharge));
    }


    @Test (priority = 4)
    public void updateComponentWithInvalidNameTest() {
        String expectedErrorMessage = "This label is too short!";
        String actualErrorMessage = priceComponentsPage.updateComponentWithInvalidName(Constants.storageSurcharge, "T");
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
        Assert.assertTrue(priceComponentsPage.componentExist(Constants.storageSurcharge));
    }

    @Test (priority = 5)
    public void updateComponentWithInvalidPriceTest() {
        Constants.storageSurchargeValue = -2.15;
        String expectedErrorMessage = "Cannot be negative!";
        String actualErrorMessage = priceComponentsPage.updateComponentWithInvalidPrice(Constants.storageSurcharge, Constants.storageSurchargeValue);
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
        Assert.assertNotEquals(priceComponentsPage.getComponentPrice(Constants.storageSurcharge), Constants.storageSurchargeValue);
    }

    @Test (priority = 6)
    public void updatePriceWithValidValueTest() {
        Constants.alloySurchargePrice = 1.79;
        Assert.assertEquals(priceComponentsPage.updatePriceWithValidValue(Constants.alloySurcharge, Constants.alloySurchargePrice), Constants.alloySurchargePrice);
    }

    @AfterClass
    public void tearDown(){
        BaseTest.cleanup();
    }
}
