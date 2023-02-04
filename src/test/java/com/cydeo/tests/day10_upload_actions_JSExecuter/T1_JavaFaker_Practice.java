package com.cydeo.tests.day10_upload_actions_JSExecuter;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_JavaFaker_Practice {

    @Test
    public void JavaFakerPractice(){
        WebDriver driver = Driver.getDriver();
        driver.get(ConfigurationReader.getProperty("registration.form.url"));
        Faker faker = new Faker();

        //3. Enter first name
        WebElement firstNameBox = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstNameBox.sendKeys(faker.name().firstName());

        //4. Enter last name
        WebElement lastNameBox = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastNameBox.sendKeys(faker.name().lastName().replaceAll("\'",""));

        //5. Enter username
        WebElement userNameBox = driver.findElement(By.xpath("//input[@name='username']"));
        //userNameBox.sendKeys(faker.name().username().replaceAll(".",""));
        String user = faker.bothify("helpdesk###");
        userNameBox.sendKeys(user);

        //6. Enter email address
        WebElement emailBox = driver.findElement(By.xpath("//input[@name='email']"));
        emailBox.sendKeys(user + "@email.com");


        //7. Enter password
        WebElement passwordBox = driver.findElement(By.xpath("//input[@name='password']"));
        passwordBox.sendKeys(faker.internet().password());

        //8. Enter phone number
        WebElement phoneBox = driver.findElement(By.xpath("//input[@name='phone']"));
        phoneBox.sendKeys(faker.numerify("###-###-####"));

        //9. Select a gender from radio buttons
        WebElement genderBox = driver.findElement(By.xpath("//input[@value='female']"));
        genderBox.click();

        //10. Enter date of birth
        WebElement dateOfBirthBox = driver.findElement(By.xpath("//input[@name='birthday']"));
        dateOfBirthBox.sendKeys("02/08/2000");

        //11. Select Department/Office
        Select departmentDropdown = new Select(driver.findElement(By.xpath("//select[@name='department']")));
        departmentDropdown.selectByIndex(faker.number().numberBetween(1,9));

        //12. Select Job Title
        Select jobTitleDropdown = new Select(driver.findElement(By.xpath("//select[@name='job_title']")));
        jobTitleDropdown.selectByIndex(faker.number().numberBetween(1,8));

        //13. Select programming language from checkboxes
        WebElement selectProgrammingLanguages = driver.findElement(By.xpath("//input[@class='form-check-input'][1]"));
        selectProgrammingLanguages.click();

        //14. Click to sign up button
        WebElement signUpButton = driver.findElement(By.xpath("//div[@class='col-sm-9 col-sm-offset-3']/button"));
        signUpButton.click();

        //15. Verify success message “You’ve successfully completed registration.” is displayed.
        WebElement successMessage = driver.findElement(By.xpath("//div[@id='content']//p[.=\"You've successfully completed registration!\"]"));
        String actualMessage = "You've successfully completed registration!";

        Assert.assertEquals(successMessage.getText(),actualMessage);




    }


}
