package com.Base;

import com.utilities.WaitTime;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class OpenBrowser {
    public static WebDriver driver;
    // WaitTime WT = new WaitTime();
     public  Properties prop;
   ConfigVariables CV = new ConfigVariables();
    public String configemail = CV.email();

    public OpenBrowser() throws FileNotFoundException {
        Properties prop;
                try{
                prop  = new Properties();
                File src= new File("./Configurations/config.properties");
                FileInputStream fp = new FileInputStream(src);
                prop.load(fp);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public void SetBrowser() {
        String B = prop.getProperty("browser");
        if (B.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NONE);
            options.addArguments("enable-automation");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-browser-side-navigation");
            options.addArguments("--disable-gpu");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        } else if (B.equals("IE")) {
            System.setProperty("webdriver.ie.driver", prop.getProperty("IEpath"));
            driver = new InternetExplorerDriver();
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        } else if (B.equals("Firefox")) {
            System.setProperty("webdriver.gecko.driver", prop.getProperty("Firefoxpath "));
            driver = new FirefoxDriver();
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
    }
}


