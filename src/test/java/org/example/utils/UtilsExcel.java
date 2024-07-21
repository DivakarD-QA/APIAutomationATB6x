package org.example.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UtilsExcel {
// It will be used who - DataProvider of the TestNG
    // Object[][]

    String FILE_NAME = "src/test/resources/TestData.xlsx";
    public Workbook book;
    public Sheet sheet;

    @DataProvider
    public Object[][] getdata(){

        return getTestData("Sheet1");
    }

    public Object[][] getTestData(String sheetName)  {

        FileInputStream file = null;

        try {
            file = new FileInputStream(FILE_NAME);

        }
        catch ( FileNotFoundException e){
            e.printStackTrace();
        }

        try{
            book = WorkbookFactory.create(file);
        } catch (IOException e){
            throw new RuntimeException(e);
        }

        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for (int i=0; i< sheet.getLastRowNum(); i++) {
            for (int j=0 ; j < sheet.getRow(0).getLastCellNum(); j++){
                data[i][j] = sheet.getRow(i+1).getCell(j).toString();
            }
        }

        return data;


    }
}
