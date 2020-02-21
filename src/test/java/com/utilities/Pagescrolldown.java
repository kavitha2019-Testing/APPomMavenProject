package com.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Pagescrolldown {
    WebDriver driver;
    public  void scrolldown(WebDriver Ldriver){
        this.driver = Ldriver;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                //page scroll by vertical
                //js.executeScript("window.scrollBy(0,1000)");
        //This will scroll the page till the element is found
       // js.executeScript("arguments[0].scrollIntoView();", Element);
        //This will scroll the web page till end.
        //js.executeScript("window.scrollTo(0, document.body.scrollHeight)")

    }
}
