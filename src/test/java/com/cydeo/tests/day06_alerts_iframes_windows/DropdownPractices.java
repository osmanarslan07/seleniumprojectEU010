package com.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropdownPractices {

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/dropdown
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @AfterMethod
    public void teardownMethod(){
        driver.quit();
    }

    @Test (priority = 1)
    public void dropdown_task5() throws InterruptedException {
        //TC #5: Selecting state from State dropdown and verifying result


        //we located the dropdown and it is ready to use
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        //3. Select Illinois
        Thread.sleep(1000);
        stateDropdown.selectByVisibleText("Illinois");
        //4. Select Virginia
        Thread.sleep(1000);
        stateDropdown.selectByValue("VA");
        //5. Select California
        Thread.sleep(1000);
        stateDropdown.selectByIndex(5);
        //6. Verify final selected option is California.
        String expectedOptionText = "California";
        String actualOptionText = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualOptionText,expectedOptionText);

        //Use all Select options. (visible text, value, index)
    }

    @Test (priority = 2)
    public void dropdown_Task6() throws InterruptedException {

        //Select “December 1st, 1924” and verify it is selected.
        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));


        //Select year using : visible text
        //Thread.sleep(2000);
        yearDropdown.selectByVisibleText("1924");
        //Select month using : value attribute
        //Thread.sleep(2000);
        monthDropdown.selectByValue("11");
        //Select day using : index number
        //Thread.sleep(2000);
        dayDropdown.selectByIndex(0);

        //creating expected values
        String expectedYear =   "1924";
        String expectedMonth = "December";
        String expectedDay = "1";

        //getting actual values from browser
        String actualYear = yearDropdown.getFirstSelectedOption().getText();
        String actualMonth = monthDropdown.getFirstSelectedOption().getText();
        String actualDay = dayDropdown.getFirstSelectedOption().getText();

        //create assertions
        Assert.assertTrue(actualYear.equals(expectedYear));
        Assert.assertEquals(expectedMonth,actualMonth);
        Assert.assertEquals(expectedDay,actualDay);


    }

    @Test (priority = 3)
    public void dropdown_Task7() throws InterruptedException {

        //Click to non-select dropdown
        Thread.sleep(2000);
        WebElement nonSelectDropdown = driver.findElement(By.xpath("//a[@class='btn btn-secondary dropdown-toggle']"));
        nonSelectDropdown.click();

        //4. Select Facebook from dropdown
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@href='https://www.facebook.com/']")).click();

        //5. Verify title is “Facebook - Log In or Sign Up”
        Thread.sleep(2000);
        String expectedTitle = "Facebook – log in or sign up";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.equals(expectedTitle));



    }



}
