package techproed.tests.day23_excel;

import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.ExcelReader;

public class C01_ExcelTest {
    @Test
    public void test01() {
        String path = ConfigReader.getProperty("smokeTestDataExcelPath");
        String sheetName=ConfigReader.getProperty("smokeTestDataExcelSheetName");
        ExcelReader excelReader = new ExcelReader(path,sheetName);
        System.out.println(excelReader.getCellData(0,0));
        System.out.println(excelReader.getCellData(0,1));

        String email = excelReader.getCellData(1,0);
        String password = excelReader.getCellData(1,1);
        System.out.println(email+password);
    }
}
