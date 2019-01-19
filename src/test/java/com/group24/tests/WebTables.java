package com.group24.tests;

import com.group24.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class WebTables extends TestBase {
   // @Test
    public void printWholeTable(){
        login();
        WebElement table= driver.findElement(By.id("ctl00_MainContent_orderGrid"));
        System.out.println(table.getText());
    }
    //@Test
    public void printHeaders(){
        login();
        List<WebElement> headers= driver.findElements(By.xpath("//tbody//th"));
        for (WebElement h: headers){
            System.out.println(h.getText());
        }
        // determining how many columns we have in our current table
        System.out.println("columns number: "+ headers.size());
    }
   // @Test
    // printing all rows or any row
    public void printAllRows(){
        login();
        List<WebElement> rows= driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr"));
        // printing all rows
        for (WebElement r: rows){
            System.out.println(r.getText());
        }
        System.out.println("----------------------------------");
        // printing all cells in second row
        System.out.println(rows.get(1).getText());
        System.out.println("----------------------------------");
        // printing the number of rows
        System.out.println("number of rows: "+ rows.size());
    }
   // @Test
    public void printAllCells(){
        login();
        List<WebElement> cells= driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td"));
        for (WebElement c: cells){
            System.out.println(c.getText());
        }
        // print certain cell in a certain row(2nd cell in 2nd row)
        List<WebElement> cells2ndRow= driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr[2]//td"));
        System.out.println(cells2ndRow.get(1).getText());
    }
    @Test
    public void printByCordinates(){
        login();
        System.out.println(locateElementByCordinates(3,5).getText());
        System.out.println(locateElementByCordinates(8,2).getText());
    }

    public WebElement locateElementByCordinates(int row, int col){
        return driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr["+row+"]//td["+col+"]"));
    }
    //@Test
    public void deleteRowByName(){
        login();
        List<WebElement> rows= driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr"));
        for (int i = 0; i <rows.size() ; i++) {
            if(rows.get(i).getText().contains("Steve Johns")){
                locateElementByCordinates(i+1,1).click();
                driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();
        }
        }
    }
    //@Test
    public void printAllNames(){
        login();
        for (int i = 2; i < 10 ; i++) {
            System.out.println(locateElementByCordinates(i,2).getText());
        }
    }
    @Test
    public void deleteByPaymentMethod(){
        login();
        List<WebElement> rows= driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr"));
        for (int i = 0; i < rows.size(); i++) {
            if(rows.get(i).getText().contains("MasterCard")){
                locateElementByCordinates(i+1,1).click();
            }
        }
        driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();
    }
}
