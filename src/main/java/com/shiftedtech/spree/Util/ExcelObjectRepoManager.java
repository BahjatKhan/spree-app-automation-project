package com.shiftedtech.spree.Util;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class ExcelObjectRepoManager implements IObjectRepoApplication {

    private static ExcelObjectRepoManager instance= null;
    private Properties prop= new Properties();

    private HashMap<Object,Object> properties= null;

    private ExcelObjectRepoManager(){

    }
    public static ExcelObjectRepoManager getInstance(){

        if(instance==null){
            instance = new ExcelObjectRepoManager();

        }
        return instance;

    }


    public void load(String...FileNames){

        for(String FileName:FileNames){

            File inputFile= new File(FileName);

            if(inputFile.exists()){
            try {
                Workbook inputWorkbook=Workbook.getWorkbook(inputFile);
                Sheet sheet= inputWorkbook.getSheet(0);
                for (int i =0 ; i<sheet.getRows(); i++) {
//                    for (int j = 0; j < sheet.getColumns(); j++) {
//
//
//                        Cell cell = sheet.getCell(i, j);
//
//
//
//
//
//
//                        Object value = cell.getContents();
//
//
//
//                    }
                    Cell keyCell=sheet.getCell(1,i);
                    String key=keyCell.getContents();

                    Cell locatorCell=sheet.getCell(2,i);
                    String getLocatorKey=locatorCell.getContents();

                    Cell locatorCellTwo=sheet.getCell(3,i);
                    String getLocator=locatorCellTwo.getContents();

                    System.out.println(key+"="+getLocatorKey+"+"+getLocator);




                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (BiffException e) {
                e.printStackTrace();
            }}else {
                System.out.println("Error !");
                System.out.println("File : "+inputFile+" doesnt exists !");
            }

        }
    }
    public void reset (){

        prop = new Properties();
    }

    @Override
    public By getLocator(String key) {
        return null;
    }

    public String get (String Key){
        String value = prop.getProperty(Key);
        return value;

    }

//    public String getLocator (String key){
//        String val = get(key);
//        if (val!=null){
//          //  String part[]= part.split
//        }
//        return val;
//    }

}
