package com.Testcases;

import com.Base.OpenBrowser;
import com.pages.SignInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SignInpageTest extends OpenBrowser {
    WebDriver driver;
    SignInPage SP1 = new SignInPage();

    public SignInpageTest() throws FileNotFoundException {
    }


    @BeforeMethod
    public void BrowserSetUp1() throws IOException {
        //SetBrowser();
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        driver.manage().window().maximize();
        System.out.println("Url opened");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }

    @Test
    public void craeteaccount() throws InterruptedException {
        WebElement lgnbutton =  driver.findElement(By.xpath("//input[@name='email_create']"));
//        lgnbutton = SP.setemail(configemail);
       JavascriptExecutor js = (JavascriptExecutor)driver;
      js.executeScript("arguments[0].click;",lgnbutton);
        Thread.sleep(5000);
        String  spemail= SP1.setemail(prop.getProperty("Email"));
        lgnbutton.sendKeys(spemail);
        Thread.sleep(5000);
        System.out.println("Email  entered successfully");
        driver.findElement(By.xpath("//i[@class='icon-user left']")).click();
        System.out.println(" create account button clicked");
        // ENTERING DETAILS
    }
    @AfterMethod
    public void teardown(){
        driver.close();
        System.out.println(" Browser closed");
    }
}
