import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstSeleniumClass {
    public static void main(String[] args) throws InterruptedException {

          WebDriverManager.chromedriver().setup();
          WebDriver driver = new ChromeDriver();
          driver.get("http://a.testaddressbook.com/");
          driver.manage().window().fullscreen();
          driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

          WebElement signIn= driver.findElement(By.id("sign-in"));
          signIn.click();

            WebElement inputEmail= driver.findElement(By.xpath("//*[@id=\"session_email\"]"));
              inputEmail.sendKeys("kexesobepu@zsero.com");
              WebElement inputPassword= driver.findElement(By.xpath("//input[@id='session_password']"));
              inputPassword.sendKeys("password");
              WebElement signInButton= driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
              signInButton.click();
              WebElement nameCheck= driver.findElement(By.xpath("//span[@class='navbar-text']"));
              String expected= "kexesobepu@zsero.com";
              String actual= nameCheck.getText();
              if(expected.equals(actual)){
                  System.out.println("PASS");
              }else{
                  System.out.println("FAIL");
              }

// break untill 2:30 EST



    }
}
