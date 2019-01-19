package com.group24.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DefaultIframeTest {
    @Test
    public void nestedFrame() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
        System.out.println(driver.findElement(By.xpath("//p[@id='demo']/..")).getText());

    }
}
