package utils;

import driver.DriverManager;
import io.cucumber.java.an.E;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {
    //WebDriver driver;

    public ExcelReader(){
       // this.driver = DriverManager.getDriver();
    }

    public static void main(String[] args) throws IOException {
        ExcelReader e = new ExcelReader();
        e.readExcel();
    }
    public void readExcel() throws IOException {
        String path = System.getProperty("user.dir") + "/src/main/java/testData/testdata.xlsx";
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);

        for(Row row: sheet){
            for(Cell cell:row){
                if(cell.getStringCellValue().contains("nikhil")){
                    System.out.println(cell);
                }
            }
        }
        fis.close();
        workbook.close();
    }
}
