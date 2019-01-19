package com.group24.tests;

import com.group24.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AmazonHovers extends TestBase {
    @Test
    public void test(){
        driver.get("https://www.amazon.com/");
        actions.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Hello')]"))).perform();
        driver.findElement(By.xpath("//span[contains(text(),'Your Hearts')]")).click();
    }
}
