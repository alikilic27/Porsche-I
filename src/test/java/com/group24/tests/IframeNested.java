package com.group24.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframeNested {
    @Test
    public void nestedFrame(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        WebElement topFrameParent= driver.findElement(By.xpath("//frame[@name='frame-top']"));
        driver.switchTo().frame(topFrameParent);
        WebElement childFrameMiddle= driver.findElement(By.xpath("//frame[@name='frame-middle']"));
        driver.switchTo().frame(childFrameMiddle);
        Assert.assertEquals(driver.findElement(By.xpath("//div[.='MIDDLE']")).getText(), "MIDDLE");
        driver.switchTo().defaultContent();
        WebElement bottomFrameParent= driver.findElement(By.xpath("//frame[@name='frame-bottom']"));
        driver.switchTo().frame(bottomFrameParent);
        Assert.assertEquals(driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]")).getText(),"BOTTOM");
    }
}
