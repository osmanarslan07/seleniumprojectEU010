package com.cydeo.tests.day02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_CydeoVerifications {

    public static void main(String[] args) {

        //TC #1: Cydeo practice tool verifications
        WebDriverManager.chromedriver().setup();

        //1. Open Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to https://practice.cydeo.com
        driver.navigate().to("https://practice.cydeo.com");

        //3. Verify URL contains
        //Expected: cydeo
        String expectedURL = "cydeo";
        String actualURL = driver.getCurrentUrl();

        if (actualURL.contains(expectedURL)){
            System.out.println("Actual URL is the same with Expected URL. Test PASSED!");
        }else {
            System.out.println("Actual URL is NOT the same with Expected URL. Test FAILED!");
        }

        //4. Verify title:
        //Expected: Practice

        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Actual Title is the same with Expected Title. Test PASSED!");
        }else {
            System.out.println("Actual Title is NOT the same with Expected Title. Test FAILED!");
        }

        driver.close();





    }



}
