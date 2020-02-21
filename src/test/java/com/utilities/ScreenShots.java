package com.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShots {
    WebDriver driver;
    public void captureScreen(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
       File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
      //  File target = new File(System.getProperty("user.dir") + "/Screenshots/" +"Testfail_this.getclass().getname()/"+
       //         "-"+".jpg");

        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }
    public void captureScreen1( WebDriver driver,String methodName) throws IOException {
        TakesScreenshot ts1 = (TakesScreenshot) driver;
        File source1 = ts1.getScreenshotAs(OutputType.FILE);
        // File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
        File target1 = new File(System.getProperty("user.dir") + "/Screenshots/" + methodName +
                "-"+".jpg");

        FileUtils.copyFile(source1, target1);
        System.out.println("Screenshot1 taken");
}
}
