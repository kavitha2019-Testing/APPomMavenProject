package com.Testcases;

import com.Base.OpenBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Testcase_003 {
    OpenBrowser OB = new OpenBrowser();
    WebDriver driver;
    public Testcase_003() throws IOException {
    }
    @BeforeSuite
    public void  beforeuite(){
        System.out.println("before suite method executed");
    }
@BeforeTest
public void beforetest(){
    System.out.println(" before test method executed");
}

@BeforeClass
public void beforeclass(){
    System.out.println(" before class method executed");
}

    @BeforeMethod
    public void BrowserSetUp() throws IOException {
        //SetBrowser();
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("http://automationpractice.com/index.php?");
        System.out.println("Url opened");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }
    @Test
    public  void SelectDress() throws InterruptedException {
        driver.findElement(By.xpath("//div[@id='block_top_menu']//ul//li//a[@title='Women']")).click();
        System.out.println("Women icon selected");
        Thread.sleep(20000);
        driver.findElement(By.xpath("//a[@title='Return to Home']")).click();
        System.out.println("Return home page selected");
    }
    @Test
        public void  selectTshirt() throws InterruptedException {
        driver.findElement(By.xpath("//div[@id='block_top_menu']//ul//li[3]//a[@title='T-shirts']")).click();
        System.out.println("T-shirts icon selected");
        Thread.sleep(10000);
        driver.findElement(By.xpath("//div[@id='uniform-layered_id_attribute_group_1']")).click();
        Boolean b1 = driver.findElement(By.xpath("//div[@id='uniform-layered_id_attribute_group_1']")).isEnabled();
        System.out.println("small size selected : " + b1);
        Assert.assertFalse(b1);
    }
        @Test
          public void SelectTshirtSize() throws InterruptedException {
            driver.findElement(By.xpath("//div[@id='block_top_menu']//ul//li[3]//a[@title='T-shirts']")).click();
            System.out.println("T-shirts icon selected");
        driver.findElement(By.xpath("//div[@id='uniform-layered_id_attribute_group_2']")).click();
        Boolean b2 = driver.findElement(By.xpath("//div[@id='uniform-layered_id_attribute_group_2']")).isDisplayed();
        System.out.println(" Medium size selected:" + b2);
        Thread.sleep(10000);
        driver.findElement(By.xpath("//a[@title='Return to Home']")).click();
        System.out.println("Return home page selected");
    }
    @AfterMethod
    public void teardown() {
        driver.close();
        System.out.println("Browser closed");
    }
    @AfterClass
    public void Afterclass(){
        System.out.println(" Afterclass method executed");
    }
    @AfterTest
    public void  aftertest(){
        System.out.println("After test method executed");
    }
    @AfterSuite
    public void  aftersuite(){
        System.out.println("After suite method executed");
    }

    }
