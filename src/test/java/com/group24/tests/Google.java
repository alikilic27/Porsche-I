package com.group24.tests;

import com.group24.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Google extends TestBase {
    @Test
    public void checkTitle(){
        driver.get("https://www.google.com/");
        softAssert.assertTrue(driver.getTitle().contains("Googlee"));
        System.out.println("Hello");

    }

}
