package com.shiftedtech.spree.Util.Locators;

import com.shiftedtech.spree.Util.ExcelObjectRepoManager;

public class ExtentReportManager {

    public static ExtentReportManager instance;

    private ExtentReportManager(){

    }
    public static ExtentReportManager getInstance(){

            if(instance==null){
                instance = new ExtentReportManager();
            }

        return instance;
    }

}
