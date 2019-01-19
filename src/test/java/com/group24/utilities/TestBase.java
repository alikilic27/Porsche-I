package com.group24.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class TestBase {
    protected WebDriver driver;
    protected SoftAssert softAssert;
    protected Actions actions;

    @BeforeClass
    public void setUpBrowser(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setUpDriver() throws InterruptedException {
        driver= new ChromeDriver();
        softAssert= new SoftAssert();
        actions= new Actions(driver);
        Thread.sleep(2000);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
        softAssert.assertAll();
    }
    public void login(){
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test"+ Keys.ENTER);
    }


}
