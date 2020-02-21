package com.pages;

import com.Base.ConfigVariables;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;

public class SignInPage extends ConfigVariables {
    WebDriver driver;
    @FindBy(xpath = "//input[@name='email_create']")
    WebElement mail;
    private Object String;


    public SignInPage(WebDriver driver) throws FileNotFoundException {
        super();
        PageFactory.initElements(driver, this);
    }

    public SignInPage() throws FileNotFoundException {
        super();

    }

    public  String setemail(String configemail){
        mail.sendKeys("configemail");

        return configemail;
    }
}