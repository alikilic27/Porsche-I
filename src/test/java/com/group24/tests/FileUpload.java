package com.group24.tests;

import com.group24.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUpload extends TestBase {
    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement upload= driver.findElement(By.id("file-upload"));
        String path= "/Users/khazar/Downloads/text.txt";
        upload.sendKeys(path);
        driver.findElement(By.id("file-submit")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//h3[.='File Uploaded!']")).getText(), "File Uploaded!");




    }
}
