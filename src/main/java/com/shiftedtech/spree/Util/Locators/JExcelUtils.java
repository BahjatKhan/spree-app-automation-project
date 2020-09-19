package com.shiftedtech.spree.Util.Locators;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import java.io.File;
import java.util.Arrays;

public class JExcelUtils {


    public JExcelUtils(){
    }

    public static Object[] getData(String fileName, int sheetIndex){
        Object[] testData = null;
        File inputFile = new File(fileName);
        if(inputFile.exists()) {
            Workbook workBook = null;
            try {

                workBook = Workbook.getWorkbook(inputFile);
                Sheet[] sheets = workBook.getSheets();
                Sheet sheet = sheets[sheetIndex];

                System.out.println("Loading Sheet: " + sheet.getName());
                testData = new Object[sheet.getRows() - 1];
                if (sheet.getRows() > 0) {
                    for (int i = 1; i < sheet.getRows(); i++) {
                        Object dataRow[] = new Object[sheet.getColumns()];
                        for(int j = 0; j < sheet.getColumns() ; j++){
                            Cell cell = sheet.getCell(j, i);
                            String cellData = cell.getContents();
                            dataRow[j] = cellData;
                        }
                        System.out.println(Arrays.deepToString(dataRow));
                        testData[i - 1] = dataRow;
                    }
                }
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
        else{
            System.out.println("File: " + fileName + " not found");
        }
        return testData;
    }

}
