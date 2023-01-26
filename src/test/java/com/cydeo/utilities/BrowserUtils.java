package com.cydeo.utilities;

/*
In this class only general utility methods that are not related to some specific page.
 */

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

public class BrowserUtils {

    /*
    This method will accept int (in seconds) and execute Thread.sleep
    for given duration
     */
    public static void sleep(int second){
        second *=1000;

        try{
            Thread.sleep(second);
        }catch (InterruptedException e){

        }
    }

    public static void switchWindowAndVerify(WebDriver driver, String expectedInUrl, String expectedInTitle){
        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String each : allWindowHandles) {

            driver.switchTo().window(each);

            System.out.println("Current Url: " + driver.getCurrentUrl());

            if (driver.getCurrentUrl().contains(expectedInUrl)){
                break;
            }
        }

        //5. Assert: Title contains “Etsy”
        String actualTitle = driver.getTitle();


        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }



}
