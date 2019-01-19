package com.group24.tests;

import com.group24.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDrop extends TestBase {
    //@Test
    public void test(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        WebElement draggable= driver.findElement(By.id("draggable"));
        WebElement target= driver.findElement(By.id("droptarget"));
        actions.dragAndDrop(draggable,target).perform();
        Assert.assertTrue(driver.findElement(By.id("droptarget")).getText().contains("great"));
    }
    //@Test
    public void test2(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        WebElement draggable= driver.findElement(By.id("draggable"));
        WebElement target= driver.findElement(By.id("droptarget"));
        actions.clickAndHold(draggable).moveToElement(target).release().build().perform();
    }
}
