package com.shiftedtech.spree.Util;

import org.openqa.selenium.By;

import java.beans.FeatureDescriptor;
import java.io.*;
import java.nio.file.Files;
import java.util.Properties;

 public class PropertyFileObjectRepoManager {

    public static PropertyFileObjectRepoManager instance ;

    private Properties prop = null;

    private PropertyFileObjectRepoManager() {


    }

    public static PropertyFileObjectRepoManager getInstance() {

        if (instance == null) {

            instance = new PropertyFileObjectRepoManager();
        }
        return instance;
    }


    public void reset() {
        prop = new Properties();

    }


    public void load(String... files) {

        for (String FirstFile :files ){

            File rawFile = new File (FirstFile);

            FileInputStream processedFile=null;

            if (rawFile.exists()){
            try {

                processedFile = new FileInputStream(rawFile);

                prop.load(processedFile);

            } catch (IOException e) {
                e.printStackTrace();
            }
            finally{

                if (processedFile != null){

                    try {
                        processedFile.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            }else {

                throw new RuntimeException ("This file is not available :" + rawFile);

            }

        }

        }

        public String get (String Key){
        String value = prop.getProperty(Key);
        return value;
    }

    public String getLocatorFirst (String Key) {

        String locator = null;
        String value = get(Key);

        if (value != null) {
            String part[] = value.split(":");

            if (part != null && part.length > 0) {
                locator = part[0];
            }
        }
        return locator;
    }

    public String getLocatorSecond(String Key ){

        String locator = null;
        String value = get(Key);

        //String part[];
        if (value != null ){

            String part[] = value.split(":");

             if (part != null && part.length>0){
                 locator= part[1];
             }


        }
        return locator;


    }


    public By getLocator(String key ){

        By by =null;

        String LocatorType= getLocatorFirst(key);

        String Locator= getLocatorSecond(key);

        if(LocatorType.equalsIgnoreCase("LINK_TEXT")){
            by=By.linkText(Locator);
        }else if(LocatorType.equalsIgnoreCase("NAME")){
            by=By.name(Locator);
        }else if(LocatorType.equalsIgnoreCase("ID")){
            by=By.id(Locator);
        }else if(LocatorType.equalsIgnoreCase("CSS")){
            by=By.cssSelector(Locator);
        }else if(LocatorType.equalsIgnoreCase("XPATH")){
            by=By.xpath(Locator);
        }else if(LocatorType.equalsIgnoreCase("PARTIAL_LINK_TEXT")){
            by=By.partialLinkText(Locator);
        }else if(LocatorType.equalsIgnoreCase("TAG_NAME")){
            by=By.tagName(Locator);
        }else if(LocatorType.equalsIgnoreCase("CLASS_NAME")){
            by=By.className(Locator);
        }

        return by;

    }







}













