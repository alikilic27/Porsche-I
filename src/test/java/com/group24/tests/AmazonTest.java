package com.group24.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmazonTest {
    WebDriver driver;
    Select select;

    @BeforeClass
    public void setDriver(){

        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setUp(){
        driver= new ChromeDriver();
    }
    @Test
    public void dropBox(){
        driver.get("https://www.amazon.com/");
        WebElement dropBox= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select = new Select(dropBox);

        Assert.assertEquals(select.getFirstSelectedOption().getText(),"All Departments");
        List<WebElement> listOptions= select.getOptions();
        listOptions.remove(15);
        listOptions.remove(15);
        listOptions.remove(15);
        listOptions.remove(15);
        listOptions.remove(15);
        listOptions.remove(0);

       String[] arr= new String[listOptions.size()];
       String[] arrWhichWillBeSorted=new String[listOptions.size()];
        for(int i=0; i<arr.length; i++){
            arr[i]=listOptions.get(i).getText();
            arrWhichWillBeSorted[i]= listOptions.get(i).getText();
        }
        Arrays.sort(arrWhichWillBeSorted);

        Assert.assertEquals(arrWhichWillBeSorted,arr);


    }
}
