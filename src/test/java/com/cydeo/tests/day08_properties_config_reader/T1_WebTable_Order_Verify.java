package com.cydeo.tests.day08_properties_config_reader;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_WebTable_Order_Verify {

    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        //1. Create new test and make set ups
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/web-tables");


    }

    @Test
    public void order_name_verify_test(){

        //Locate the cell that has Bob Martin text in it
        WebElement bobMartinCell =
                driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']"));


        //2. Verify Bob’s name is listed as expected.
        //Expected: “Bob Martin”
        String expectedBobName = "Bob Martin";
        String actualBobName = bobMartinCell.getText();

        Assert.assertEquals(actualBobName,expectedBobName);

        //3. Verify Bob Martin’s order date is as expected
        //Expected: 12/31/2021

        //alternative locator to bobMartinDateCell = "//td[.='Bob Martin']/../td[5]"
        WebElement bobMartinDateCell =
                driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']/following-sibling::td[3]"));

        String expectedDate = "12/31/2021";
        String actualDate = bobMartinDateCell.getText();

        Assert.assertEquals(actualDate,expectedDate);
    }



}
