package com.group24.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class FirstTestNG {
       WebDriver driver;

           @BeforeClass
           public void setUp(){
           WebDriverManager.chromedriver().setup();
           }

           @BeforeMethod
           public void setDriver(){
               driver= new ChromeDriver();
           }

           @Test(priority = 0)
           public void radioButton(){
               driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
               driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwRadioButton");
               WebElement radioFootball= driver.findElement(By.xpath("//input[@id='gwt-debug-cwRadioButton-sport-Football-input']"));
               WebElement radioBasketball= driver.findElement(By.xpath("//input[@id='gwt-debug-cwRadioButton-sport-Basketball-input']"));
               Assert.assertTrue(radioFootball.isSelected());
               Assert.assertFalse(radioBasketball.isSelected());

           }


           @Test(priority = 1)
           public void checkBox(){
               driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
               driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
               WebElement checkMonday= driver.findElement(By.xpath("//input[@id='gwt-debug-cwCheckBox-Monday-input']"));
               Assert.assertFalse(checkMonday.isSelected());
               checkMonday.click();
               Assert.assertTrue(checkMonday.isSelected());
           }
           @AfterMethod
           public void cleanUp(){
               driver.close();
           }
           @AfterClass
           public void shutOff(){
               System.out.println("Report");
       }


}
