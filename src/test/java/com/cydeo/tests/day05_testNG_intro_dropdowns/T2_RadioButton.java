package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T2_RadioButton {

    public static void main(String[] args) throws InterruptedException {

        //TC #2: Radiobutton handling
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");
        //3. Click to “Hockey” radio button
        Thread.sleep(2000);
        WebElement hockeyBtn = driver.findElement(By.xpath("//input[@id='hockey']"));
        hockeyBtn.click();
        //4. Verify “Hockey” radio button is selected after clicking.
        System.out.println("hockeyBtn.isSelected(), expecting true = " + hockeyBtn.isSelected());
        if (hockeyBtn.isSelected()){
            System.out.println("Button is selected. Verification PASSED!");
        }else {
            System.out.println("Button is NOT selected. Verification FAILED!!!");

        }
        Thread.sleep(2000);
        driver.close();
        //USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS



    }
}
