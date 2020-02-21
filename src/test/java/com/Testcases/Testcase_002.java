package com.Testcases;

import com.Base.ConfigVariables;
import com.Base.OpenBrowser;
import com.pages.SignInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
//Take screenshot for failure test cases
@Listeners(com.utilities.listeners.class)
public class Testcase_002 extends OpenBrowser {
    WebDriver driver;
    SignInPage SP = new SignInPage();
    ConfigVariables CV =new ConfigVariables();
    Logger log = Logger.getLogger(Testcase_002.class);
    public Testcase_002() throws FileNotFoundException {
    }
    @BeforeMethod
    public void BrowserSetUp() throws IOException {
        //SetBrowser();
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("http://automationpractice.com/index.php?");
        driver.manage().window().maximize();

        System.out.println("Url opened");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }
    @Test(enabled=true)
    public void Signinbutton() throws InterruptedException, IOException {
        //SP= new SignInPage();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
        Thread.sleep(5000);
       log.info("Sign in button clicked");
        System.out.println("Sign in button clicked");
        Thread.sleep(5000);
        // TO CLICK BUTTON USING JAVASCRIPT EXECUTOR
         WebElement lgnbutton =  driver.findElement(By.xpath("//input[@name='email_create']"));

     JavascriptExecutor js = (JavascriptExecutor)driver;
       js.executeScript("arguments[0].click;",lgnbutton);
        System.out.println(" Email button clicked");
        //lgnbutton.sendKeys(CV.email());
       lgnbutton.sendKeys(SP.setemail(configemail));
       log.error("This is error");
        System.out.println("Email  entered successfully");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//i[@class='icon-user left']")).click();
        System.out.println(" create account button clicked");
        // ENTERING DETAILS
        driver.findElement(By.xpath("//form[@id='account-creation_form']//div//div//label//div//span//input[@id='id_gender1']")).click();
        System.out.println("radio button clicked");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@name='customer_firstname']")).sendKeys("george");
        System.out.println("Name entered successfully");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@name='customer_lastname']")).sendKeys("callio");
        System.out.println("LastName entered successfully");
        driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys("malineni2");
        System.out.println("password entered successfully");
       // SELECTING DATE BY USING SELECT COMMAND FROM DROP DOWN LIST
        Select dates = new Select(driver.findElement(By.xpath("//select[@id='days']")));
        dates.selectByValue("16");
        // dates.selectByIndex(16);
        System.out.println("day selected");
        Select month = new Select(driver.findElement(By.xpath("//select[@id='months']")));
        month.selectByValue("3");
        month.selectByIndex(3);
        System.out.println("month selected");
        Select year = new Select(driver.findElement(By.xpath("//select[@id='years']")));
        year.selectByValue("1982");
        // year.selectByIndex(3);
        System.out.println("year selected");

    }
    @AfterMethod
    public void teardown() {
        driver.close();
        System.out.println("Browser closed");
    }
}
