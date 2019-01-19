package com.group24.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NotificationMessage {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
    }

    @AfterMethod
    public void cleanUp() throws InterruptedException {
        Thread.sleep(3000);
        //driver.close();
    }
    @Test
    public void notificationTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/notification_message_rendered");
        WebElement clickHere= driver.findElement(By.linkText("Click here"));
        int count=0;
        clickHere.click();
        Thread.sleep(3000);
        while(!driver.findElement(By.xpath("//div[@id='flash']")).getText().contains(" successful")){

            Thread.sleep(2000);
            clickHere=driver.findElement(By.linkText("Click here"));
            clickHere.click();
            count++;
        }
        System.out.println(driver.findElement(By.xpath("//div[@id='flash']")).getText()+" times looping "+count+1 +" times");
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='flash']")).getText().contains(" successful"));
    }
}
