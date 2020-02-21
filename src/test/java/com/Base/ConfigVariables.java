package com.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigVariables {

    Properties prop;
    public ConfigVariables() throws FileNotFoundException {
        try{
            prop  = new Properties();
            File src= new File("./Configurations/config.properties");
            FileInputStream fp = new FileInputStream(src);
            prop.load(fp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  String email () {
        String getemail = prop.getProperty("Email");
        return getemail;
    }
    public String  URL(){
        String geturl = prop.getProperty("URL");
        return geturl;
    }
}
