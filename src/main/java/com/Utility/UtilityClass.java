package com.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.facebook.BaseClass;
import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.MediaEntityBuilder;

public class UtilityClass extends BaseClass {
    public void failedTest(String FTname){
        TakesScreenshot ts=(TakesScreenshot)driver;
        File SFile = ts.getScreenshotAs(OutputType.FILE);
        File DFile = new File(".\\FB.ScreenShots\\"+FTname+".png");
        try {
            FileHandler.copy(SFile,DFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String TestDataPath="C:\\Users\\HP\\eclipse-workspace\\src\\test\\java\\Selenium\\PageObjectModel_Facebook\\src\\main\\java\\com\\Testdata\\FacebookSheet.xlsx";


    static Workbook book;
    static org.apache.poi.ss.usermodel.Sheet sheet;

    public static Object[][]getTestData(String SheetName){
        FileInputStream file=null;
        try {
            file=new FileInputStream(TestDataPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            book= WorkbookFactory.create(file);
        } catch (EncryptedDocumentException | IOException e) {
            e.printStackTrace();
        }
        sheet = book.getSheet(SheetName);
        Object [][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for(int i=0; i<sheet.getLastRowNum();i++) {
            for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
                data[i][k] = sheet.getRow(i+1).getCell(k).toString();
            }
        }
        return data;
    }
}