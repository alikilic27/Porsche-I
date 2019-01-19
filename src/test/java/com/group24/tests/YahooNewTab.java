package com.group24.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class YahooNewTab {
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
    public void yahooNewTagTest(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.yahoo.com/");
        WebElement searchInput= driver.findElement(By.xpath("//input[@id='uh-search-box']"));
        searchInput.sendKeys("booking.com"+ Keys.ENTER);
       // driver.findElement(By.xpath("//button[@id='uh-search-button']")).click();
        driver.findElement(By.linkText("Booking.com - Official Site")).click();
        Set<String> windowHandles= driver.getWindowHandles();
        for(String ls:windowHandles){
            driver.switchTo().window(ls);
            if(driver.getTitle().contains("Booking")){
                break;
            }
        }
        Assert.assertTrue(driver.getTitle().contains("Booking"));



    }
}
