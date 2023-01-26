package com.cydeo.tests.day7_webtables_utilities_javafaker;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class T1_WindowHandling {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        //1. Create new test and make set ups
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @Test
    public void window_handling_test(){
        //2. Go to : https://www.amazon.com
        driver.get("https://www.amazon.com");

        //3. Copy paste the lines from below into your class
        ((JavascriptExecutor) driver).executeScript("window.open('https://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://facebook.com','_blank');");

        //4. Create a logic to switch to the tab where Etsy.com is open
        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String each : allWindowHandles) {
            driver.switchTo().window(each);
            System.out.println("Current Url: " + driver.getCurrentUrl());
            if (driver.getCurrentUrl().contains("etsy")){
                break;
            }
        }

        //5. Assert: Title contains “Etsy”
        String actualTitle = driver.getTitle();
        String expectedInitle = "Etsy";


        Assert.assertTrue(actualTitle.contains(expectedInitle));
        //Lines to be pasted:


        //Examples for preceding and following siblings
        //https://practice.cydeo.com/dropdown
        // ex 1 #locate month May using its value
        //   (//option[@value='4'])[1]        // for xpath index numbers starts from 1

        // ex 2 #locate month of March using May locator as a base and use sibling method
        //   (//option[@value='4'])[1]preceding-sibling::option[2]  --> for March

        // ex 3 #locate month of October using May locator as a base and use sibling method
        //      (//option[@value='4'])[1]following-sibling::option[5]


    }


}
