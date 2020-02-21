package com.Testcases;

import com.Base.OpenBrowser;
import com.utilities.Pagescrolldown;
import com.utilities.ScreenShots;
import com.utilities.WaitTime;
import com.utilities.listeners;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

//@Listeners(com.utilities.listeners.class)
public class Testcase_001  extends   OpenBrowser  {

    WebDriver driver;
    Pagescrolldown PS = new Pagescrolldown();
    ScreenShots ss = new ScreenShots();
    WaitTime WT = new WaitTime();
   // OpenBrowser OB = new OpenBrowser();
    public Testcase_001() throws FileNotFoundException {
    }
    @BeforeMethod
    public void BrowserSetUp() throws IOException {
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
       driver.get("http://automationpractice.com/index.php?");
        System.out.println("Url opened");
        driver.manage().timeouts().implicitlyWait(WT.implicitwaittime(), TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }
    @Test(groups ={"some"})
    public void title(){
        // driver.getTitle();
        System.out.println("Url title is :" + driver.getTitle());
        //Assert.assertFalse(Boolean.parseBoolean("f"));
        
    }

    @Test(groups = {"more"})
    public void pintlogo() throws InterruptedException, IOException {
        boolean b = driver.findElement(By.xpath("//img[@class='logo img-responsive']")).isDisplayed();
        ss.captureScreen(driver,"test1");
        System.out.println("print logo  is :" + b);

    }

    @Test(groups = {"more"})
    public void Contactus() throws InterruptedException {
        Thread.sleep(15000);
        //XPATH USING CONTAINS
        driver.findElement(By.xpath("//a[contains(@title,'Contact Us')]")).click();
        System.out.println("contact us selected");
        Thread.sleep(5000);
        // SELECTING VALUE FROM DROP DOWN LIST
        Select heading = new Select(driver.findElement(By.xpath("//select[@id='id_contact']")));
        heading.selectByValue("2");
        Assert.assertFalse(false);
    }
    @Test (groups ={"some"})
    public void scrolldownpage() throws InterruptedException {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight");
        Thread.sleep(5000);
         PS.scrolldown(driver);
        Thread.sleep(50000);
        System.out.println(" page scroll down");
    }

    @AfterMethod
    public void teardown() {
        driver.close();
        System.out.println("Browser closed");
    }
}
