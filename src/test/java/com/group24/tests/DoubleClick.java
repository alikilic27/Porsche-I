package com.group24.tests;

import com.group24.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DoubleClick extends TestBase {
    @Test
    public void test(){
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
        WebElement element= driver.findElement(By.xpath("//p[@id='demo']"));
        Actions actions= new Actions(driver);
        actions.doubleClick(element).perform();
        Assert.assertTrue(element.getAttribute("style").contains("red"));


    }
}
