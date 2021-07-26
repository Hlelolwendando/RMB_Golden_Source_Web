package com.rmb.golden.source.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import static com.rmb.golden.source.utilities.TestConstants.*;


public class DataProviderConfig {
    Properties properties;
    public  DataProviderConfig(){
        File fileConfig = new File("./Config/Config.properties");
        try{
            FileInputStream inputStream = new FileInputStream(fileConfig);
            properties = new Properties();
            properties.load(inputStream);
        }
        catch (Exception e){
            System.out.println("Not Able to load Config File" + e.getMessage());
        }
    }
    public String getDataFromConfig(String keyToSearch){
      return properties.getProperty(keyToSearch);
    }
    public  String getBrowser(){
        return properties.getProperty("defaultBrowser");
    }
    public  String getFireFoxBrowser(){
        return  properties.getProperty("fireFox");
    }
    public  String getEdgeBrowser(){
        return  properties.getProperty("edge");
    }
    public String getStringURL(){
        return  properties.getProperty("testUrl");
    }
    public String getUsername(){
        return  properties.getProperty("username");
    }
}
