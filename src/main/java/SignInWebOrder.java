import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignInWebOrder {
    public static void main(String[] args) throws InterruptedException {
          WebDriverManager.chromedriver().setup();
          WebDriver driver= new ChromeDriver();
          driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
          driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        WebElement inputEmail= driver.findElement(By.xpath("//input[@class='txt' and @type= 'text']"));
        inputEmail.sendKeys("Tester");
        WebElement inputPassword= driver.findElement(By.xpath("//input[@id = 'ctl00_MainContent_password']"));
        inputPassword.sendKeys("test");
        WebElement signInButton= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        signInButton.click();

        WebElement checkAllButton= driver.findElement(By.xpath("//a[@id='ctl00_MainContent_btnCheckAll']"));
        checkAllButton.click();
        Thread.sleep(2000);

        WebElement firstCheckBox= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl02_OrderSelector']"));
        System.out.println(firstCheckBox.isSelected());
        Thread.sleep(2000);
        WebElement secondCheckBox= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl03_OrderSelector']"));
        System.out.println(secondCheckBox.isSelected());
        Thread.sleep(2000);
        WebElement thirdCheckBox= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl04_OrderSelector']"));
        System.out.println(thirdCheckBox.isSelected());


        WebElement uncheckAll= driver.findElement(By.xpath("//a[@id='ctl00_MainContent_btnUncheckAll']"));
        uncheckAll.click();

        firstCheckBox= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl02_OrderSelector']"));
        System.out.println(firstCheckBox.isSelected());
        secondCheckBox= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl03_OrderSelector']"));
        System.out.println(secondCheckBox.isSelected());
        thirdCheckBox= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl04_OrderSelector']"));
        System.out.println(thirdCheckBox.isSelected());


    }
}
