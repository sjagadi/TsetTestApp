package com.tset.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.time.Duration;


public class BaseTest {
    public static WebDriver driver = null;
    public static PropertyReader properties = PropertyReader.getInstance();

    public static void initialization() {
        if(properties.getProperty("browser").equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", properties.getProperty("chromeDriverPath"));
            driver = new ChromeDriver();
        } else if (properties.getProperty("browser").equalsIgnoreCase("chrome")) {
            driver = new FirefoxDriver();
        }
        else {
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.get(properties.getProperty("applicationUrl"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(properties.getProperty("timeout"))));
    }

    public static void cleanup(){
        driver.quit();
    }
}
