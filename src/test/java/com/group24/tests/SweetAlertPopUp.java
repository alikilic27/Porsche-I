package com.group24.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SweetAlertPopUp {
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
    public void htmlPopUpTest(){
        driver.get("https://sweetalert.js.org/");
        driver.findElement(By.xpath("(//button[@class='preview'])[2]")).click();
        driver.findElement(By.xpath("//button[.='OK']")).click();
    }
    @Test
    public void jsPopUpTest() throws InterruptedException {
        driver.get("https://sweetalert.js.org/");
        driver.findElement(By.xpath("(//button[@class='preview'])[1]")).click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();

    }

}
