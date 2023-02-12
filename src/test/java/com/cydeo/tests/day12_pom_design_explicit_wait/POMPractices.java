package com.cydeo.tests.day12_pom_design_explicit_wait;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class POMPractices {

    LibraryLoginPage libraryLoginPage = new LibraryLoginPage();
    Faker faker = new Faker();

    @Test(priority = 0)
    public void required_field_error_message_test(){

        //TC #1: Required field error message test
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com
        Driver.getDriver().get("https://library1.cydeo.com");

        //3- Do not enter any information
        //4- Click to “Sign in” button
        BrowserUtils.sleep(2);
        libraryLoginPage = new LibraryLoginPage();
        BrowserUtils.sleep(2);
        libraryLoginPage.signInButton.click();

        //5- Verify expected error is displayed:
        //Expected: This field is required.

        Assert.assertTrue(libraryLoginPage.fieldRequiredErrorMessage.isDisplayed());

        Driver.closeDriver();

    }

    @Test (priority = 1)
    public void invalid_email_format_error_message_test(){

        //1- Open a Chrome browser
        //2- Go to: https://library1.cydeo.com
        Driver.getDriver().get("https://library1.cydeo.com");
        libraryLoginPage = new LibraryLoginPage();
        faker = new Faker();
        //3- Enter invalid email format
        BrowserUtils.sleep(2);
        libraryLoginPage.inputUsername.sendKeys(faker.letterify("??????"));
        BrowserUtils.sleep(2);
        libraryLoginPage.signInButton.click();
        //4- Verify expected error is displayed:
        //Expected: Please enter a valid email address.

        Assert.assertTrue(libraryLoginPage.enterValidEmailErrorMessage.isDisplayed());
        Driver.closeDriver();

    }

    @Test(priority = 2)
    public void library_negative_login_test(){

        //1- Open a Chrome browser
        //2- Go to: https://library1.cydeo.com
        Driver.getDriver().get("https://library1.cydeo.com");
        libraryLoginPage = new LibraryLoginPage();
        faker = new Faker();

        //3- Enter incorrect username or incorrect password
        BrowserUtils.sleep(2);
        libraryLoginPage.inputUsername.sendKeys(faker.letterify("?????@????"));
        BrowserUtils.sleep(2);
        libraryLoginPage.inputPassword.sendKeys(faker.numerify("#####"));
        BrowserUtils.sleep(2);
        libraryLoginPage.signInButton.click();
        BrowserUtils.sleep(2);

        //4- Verify title expected error is displayed:
        //Expected: Sorry, Wrong Email or Password

        Assert.assertTrue(libraryLoginPage.wrongEmailOrPasswordErrorMessage.isDisplayed());
        Driver.closeDriver();

    }


}
