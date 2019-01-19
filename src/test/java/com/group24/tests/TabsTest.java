package com.group24.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class TabsTest {
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
    public void tabTest(){
        driver.get("https://the-internet.herokuapp.com/windows");
        System.out.println(driver.getWindowHandles().size());

        driver.findElement(By.xpath("//*[.='Click Here']")).click();
        System.out.println(driver.getWindowHandles().size());

        Set<String> windowHandles= driver.getWindowHandles();

        for(String ls:windowHandles){
            driver.switchTo().window(ls);
            if(driver.getCurrentUrl().contains("New")){
                break;
            }

        }
        Assert.assertNotEquals(driver.getTitle(), "The Internet");
        System.out.println(driver.getTitle());








    }
}
