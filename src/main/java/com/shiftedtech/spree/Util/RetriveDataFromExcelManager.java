package com.shiftedtech.spree.Util;

import com.shiftedtech.spree.Util.Locators.JExcelUtils;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;

public class RetriveDataFromExcelManager {


    public static Object[] provideExcelData() {


        Object[] testData = null;

        JExcelUtils excel= new JExcelUtils();


        String fileName = System.getProperty("user.dir") + "/src/test/resources/SpreeDataDrivenTest.xls";

        int sheetIndex=0;
        testData=JExcelUtils.getData(fileName,sheetIndex);




        return testData;




          /*  Object[] testData= null;
            String fileName=System.getProperty("user.dir")+"/src/test/resources/SpreeDataDrivenTest.xls";

            File inputFile= new File(fileName);

            if (inputFile.exists()){

                Workbook workbook=null;
                try{
                    workbook=Workbook.getWorkbook(inputFile);
                    Sheet[] sheets=workbook.getSheets();
                    Sheet sheet =sheets[0];

                    System.out.println("Loading Sheet : "+sheet.getName());
                    testData = new Object[sheet.getRows()-1];

                    if (sheet.getRows()>0){
                        for (int i=1;i<sheet.getRows();i++){

                            Cell emailCell=sheet.getCell(0,i);
                            String email=emailCell.getContents();

                            Cell passwordCell=sheet.getCell(1,i);
                            String password= passwordCell.getContents();

                            Object dataRow[]=new Object[] {email,password};

                            testData[i-1] = dataRow;

                        }


                    }

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (BiffException e) {
                    e.printStackTrace();
                }


            }
                    return testData;
        }

*/


    }
}