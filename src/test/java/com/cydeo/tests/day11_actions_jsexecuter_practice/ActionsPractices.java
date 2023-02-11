package com.cydeo.tests.day11_actions_jsexecuter_practice;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsPractices {
    @Test
    public void test_4_and_5_test(){
        //TC #4: Scroll practice
        //1- Open a Chrome browser
        //2- Go to: https://practice.cydeo.com/
        Driver.getDriver().get("https://practice.cydeo.com/");

        //3- Scroll down to “Powered by CYDEO”
        //Create objects of Actions and pass our "driver" instance
        Actions actions = new Actions(Driver.getDriver());
        BrowserUtils.sleep(2);

        //Locating cydeo link to be able to pass in the actions method
        WebElement cydeoLink = Driver.getDriver().findElement(By.xpath("//a[.='CYDEO']"));
        //4- Scroll using Actions class “moveTo(element)” method
        actions.moveToElement(cydeoLink).perform();


        //5- Scroll back up to “Home” link using PageUP button
        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP ).perform();

        Driver.closeDriver();

    }


    @Test
    public void test2(){
        Driver.getDriver().get("https://practice.cydeo.com/");
        BrowserUtils.sleep(2);
        Driver.closeDriver();
    }

    @Test
    public void test3(){
        Driver.getDriver().get("https://practice.cydeo.com/");
        BrowserUtils.sleep(2);
        Driver.closeDriver();
    }


    @Test
    public void test4(){
        Driver.getDriver().get("https://practice.cydeo.com/");
        BrowserUtils.sleep(2);
        Driver.closeDriver();
    }


    @Test
    public void test5(){
        Driver.getDriver().get("https://practice.cydeo.com/");
        BrowserUtils.sleep(2);
        Driver.closeDriver();
    }



}
