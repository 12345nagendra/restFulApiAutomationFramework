package main.java.utils.excelUtility;

import main.java.utils.CommonUtility;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;

public class ExcelUtility {
    public static void readExcel(){
        String filePath = "src/test/java/resources/testDataCsv/testData.xlsx";
        Workbook workbook = null;
        CommonUtility.getInputStreamForFile(ExcelUtility.class.getClassLoader(),"testDataCsv/testData.xlsx");
        try(InputStream fis = new FileInputStream(filePath)){
            if(filePath.endsWith(".xls")){
                workbook = new HSSFWorkbook(fis);
            } else if (filePath.endsWith("xlsx")) {
                workbook = new XSSFWorkbook(fis);
            } else {
                throw new RuntimeException("The file format is not right");
            }
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.rowIterator();
            while(rowIterator.hasNext()){
                Iterator<Cell> cellIterator = rowIterator.next().cellIterator();
                while (cellIterator.hasNext()){
                    System.out.print(getCellValue(cellIterator) + "\t");
                }
                System.out.println();
            }
        }
        catch (Exception e){
            System.out.println(e.getStackTrace());
        }

    }

    public static Object getCellValue(Iterator<Cell> cellIterator){
        Cell next = cellIterator.next();
        CellType cellType = next.getCellType();
        switch (cellType){
            case NUMERIC:
                return next.getNumericCellValue();
            case STRING:
                return next.getStringCellValue();
        }
        return null;
    }
}
