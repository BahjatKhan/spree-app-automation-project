package com.shiftedtech.spree.Util.Locators;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {


    // Using commons-lang3.version >>>>>>>> 3.9        //Using poi-ooxml.version >>>>>> 4.1.1

    private Workbook workbook;

    public ExcelReader(String... files) {

        for (String file : files) {
            File inputFile = new File(file);
            if (inputFile.exists()) {
                try {
                    FileInputStream fileStream = new FileInputStream(inputFile);
                    if (FilenameUtils.getExtension(file).equals("xls")) {

                        workbook = new HSSFWorkbook(fileStream);}

                        else if(FilenameUtils.getExtension(file).equals("xlsx")){

                                    workbook = new XSSFWorkbook(fileStream);



                        }else{
                            throw new RuntimeException("File extension is not supported this time !");
                    }


                    }catch(FileNotFoundException e){
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            else{
                throw new RuntimeException("This file "+file+"does not exist");
            }

        }

    }
    public String[] getExcelRowData(String sheetName, int row) {
        String[] data = null;
        if (workbook != null) {
            int sheetIndex = workbook.getSheetIndex(sheetName);
            data = getExcelRowData(sheetIndex, row);
        }
        return data;
    }

    /**
     * Get the data from a specific row of specific excel sheet as specified in the method params
     * Excel sheet is specified by the sheet number, which is 0 based.
     * @param sheetNumber
     * @param row
     * @return String[]
     */
    public String[] getExcelRowData(int sheetNumber, int row) {
        String[] data = null;
        if (workbook != null) {
            Sheet sheet = workbook.getSheetAt(sheetNumber);
            if (sheet != null) {
                int cols = sheet.getRow(row).getPhysicalNumberOfCells();
                data = new String[cols];
                for (int i = 0; i < cols; i++) {
                    Cell cell = sheet.getRow(row).getCell(i);
                    String cellData = getData(cell).toString();
                    data[i] = cellData;
                }
            }
        }
        return data;
    }

    /**
     * Get the data from a specific column of specific excel sheet as specified in the method params
     * Excel sheet is specified by the sheet name
     * @param sheetName
     * @param col
     * @return String[]
     */
    public String[] getExcelColData(String sheetName, int col) {
        String[] data = null;
        if (workbook != null) {
            int sheetIndex = workbook.getSheetIndex(sheetName);
            data = getExcelColData(sheetIndex, col);
        }
        return data;
    }

    /**
     * Get the data from a specific column of specific excel sheet as specified in the method params
     * Excel sheet is specified by the sheet number, which is 0 based.
     * @param sheetNumber
     * @param col
     * @return String[]
     */
    public String[] getExcelColData(int sheetNumber, int col) {
        String[] data = null;
        if (workbook != null) {
            Sheet sheet = workbook.getSheetAt(sheetNumber);
            if (sheet != null) {
                int rows = sheet.getLastRowNum() + 1;
                data = new String[rows];
                for (int i = 0; i < rows; i++) {
                    Cell cell = sheet.getRow(i).getCell(col);
                    String cellData = getData(cell).toString();
                    data[i] = cellData;
                }
            }
        }
        return data;
    }

    /**
     * Get the data from a cell of specific excel sheet as specified in the method params
     * @param sheetName
     * @param row
     * @param col
     * @return String
     */
    public String getExcelCellData(String sheetName, int row, int col) {
        String data = null;
        if (workbook != null) {
            int sheetIndex = workbook.getSheetIndex(sheetName);
            data = getExcelCellData(sheetIndex, row, col);
        }
        return data;
    }

    /**
     * Get the data from a cell of specific excel sheet as specified in the method params
     * @param sheetNumber
     * @param row
     * @param col
     * @return String
     */
    public String getExcelCellData(int sheetNumber, int row, int col) {
        String data = null;
        if (workbook != null) {
            Sheet sheet = workbook.getSheetAt(sheetNumber);
            if (sheet != null) {
                Cell cell = sheet.getRow(row).getCell(col);
                data = getData(cell).toString();
            }
        }
        return data;
    }

    /**
     * Get all the data from specified excel file and create an two dimensional array
     * @param sheetName
     * @return String[][]
     */
    public String[][] getExcelSheetData(String sheetName) {
        String[][] data = null;
        if (workbook != null) {
            int sheetIndex = workbook.getSheetIndex(sheetName);
            data = getExcelSheetData(sheetIndex);
        }
        return data;
    }

    /**
     * Get all the data from specified excel file and create an two dimensional array
     * @param sheetIndex
     * @return String[][]
     */
    public String[][] getExcelSheetData(int sheetIndex) {
        String[][] data = null;
        if (workbook != null) {
            Sheet sheet = workbook.getSheetAt(sheetIndex);
            if (sheet != null) {
                int rows = sheet.getLastRowNum() + 1;
                int cols = sheet.getRow(sheet.getLastRowNum()).getPhysicalNumberOfCells();
                data = new String[rows][cols];
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        Cell cell = sheet.getRow(i).getCell(j);
                        String cellData = getData(cell).toString();
                        data[i][j] = cellData;
                    }
                }
            }
        }
        return data;
    }

    /**
     * Get all the data except the header row from specified excel file and create an two dimensional array
     * @param sheetName
     * @param skipHeaderRow
     * @return String[][]
     */
    public String[][] getExcelSheetData(String sheetName, boolean skipHeaderRow) {
        String[][] data = null;
        if (workbook != null) {
            int sheetIndex = workbook.getSheetIndex(sheetName);
            data = getExcelSheetData(sheetIndex, skipHeaderRow);
        }
        return data;
    }

    /**
     * Get all the data except the header row from specified excel file and create an two dimensional array
     * @param sheetIndex
     * @param skipHeaderRow
     * @return String[][]
     */
    public String[][] getExcelSheetData(int sheetIndex, boolean skipHeaderRow) {
        String[][] data = null;
        if (workbook != null) {
            Sheet sheet = workbook.getSheetAt(sheetIndex);
            if (sheet != null) {
                if (skipHeaderRow) {
                    int rows = sheet.getLastRowNum();
                    int cols = sheet.getRow(sheet.getLastRowNum()).getPhysicalNumberOfCells();
                    data = new String[rows][cols];
                    for (int i = 1; i <= rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            Cell cell = sheet.getRow(i).getCell(j);
                            String cellData = getData(cell).toString();
                            data[i - 1][j] = cellData;
                        }
                    }
                } else {
                    int rows = sheet.getLastRowNum() + 1;
                    int cols = sheet.getRow(sheet.getLastRowNum()).getPhysicalNumberOfCells();
                    data = new String[rows][cols];
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            Cell cell = sheet.getRow(i).getCell(j);
                            String cellData = getData(cell).toString();
                            data[i][j] = cellData;
                        }
                    }
                }
            }
        }
        return data;
    }

    /**
     * Helper method to get the data based on the value type from cell
     * @param cell
     * @return
     */
    private Object getData(Cell cell) {
        Object result = null;
        if (cell != null) {
            switch (cell.getCellTypeEnum()) {
                case NUMERIC:
                    result = "" + cell.getNumericCellValue();
                    break;
                case STRING:
                    result = "" + cell.getStringCellValue();
                    break;
                case BLANK:
                    result = "";
                    break;
                default: {
                    System.out.println("******************************************************************");
                    System.out.println("Cell [" + cell.getRowIndex() + "," + cell.getColumnIndex() + "]");
                    System.out.println("Cell Type: " + cell.getCellTypeEnum());
                    System.out.println("Cell Type is not supported");
                    System.out.println("Using default as BLANK");
                    System.out.println("******************************************************************");
                    result = "";
                    break;
                }
            }
        }
        return result;
    }

    public int getNumberOfSheets(){
        int count = workbook.getNumberOfSheets();
        return count;
    }

}

























