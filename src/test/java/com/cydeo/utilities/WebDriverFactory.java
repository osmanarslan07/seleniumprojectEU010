package com.cydeo.utilities;

//// TASK: NEW METHOD CREATION
//// Method name : getDriver
//// Static method
//// Accepts String arg: browserType
////   - This arg will determine what type of browser is opened
////   - if "chrome" passed --> it will open Chrome browser
////   - if "firefox" passed --> it will open firefox browser
//// RETURN TYPE: "WebDriver"


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    public static WebDriver getDriver(String browserType){
        if (browserType.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();

        }

        if (browserType.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();

        }


        return null;
    }

    public static void main(String[] args) {

        getDriver("chrome");
        getDriver("firefox");

    }



}
