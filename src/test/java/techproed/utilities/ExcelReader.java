package techproed.utilities;

import net.bytebuddy.implementation.bytecode.Throw;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
    Workbook workbook;
    Sheet sheet;
    Row row;


    //Bu classtan object oluşturmamızın amacı excel dosyasını okumaktır
    public ExcelReader(String filePath, String sheetName) {

        try{
            FileInputStream fis = new FileInputStream(filePath);
            workbook=WorkbookFactory.create(fis);
            sheet =workbook.getSheet(sheetName);
        } catch (IOException e){
            throw  new RuntimeException(e);
        }

    }
    //Satir ve sutun indexlerini girerek ilgili cell datasını string olarak return eder
    public String getCellData(int row, int column){
        Cell cell = sheet.getRow(row).getCell(column);
        return cell.toString();
    }
    //Satır sayısını index olarak verir
    public int rowCount (){
        return sheet.getLastRowNum();
    }
}
