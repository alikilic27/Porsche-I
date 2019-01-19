package com.group24.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IframeTest {
    @Test
    public void Iframe(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement iframe= driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe);


        driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys("Hello group 24");
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//a[.='Elemental Selenium']")).click();
    }

}
