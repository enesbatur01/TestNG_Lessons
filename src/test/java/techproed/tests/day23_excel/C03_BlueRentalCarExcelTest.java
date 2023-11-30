package techproed.tests.day23_excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalCarPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;

public class C03_BlueRentalCarExcelTest {
    BlueRentalCarPage blueRentalCarPage;

    @Test
    public void test01() {
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        ExcelReader excelReader = new ExcelReader(ConfigReader.getProperty("smokeTestDataExcelPath"), ConfigReader.getProperty("smokeTestDataExcelSheetName"));
        blueRentalCarPage = new BlueRentalCarPage();
        for (int i = 1; i < excelReader.rowCount(); i++) {
            String mail = excelReader.getCellData(i, 0);
            String password = excelReader.getCellData(i, 1);

            blueRentalCarPage.loginButton.click();
            blueRentalCarPage.email.sendKeys(mail);
            blueRentalCarPage.password.sendKeys(password, Keys.ENTER);
            blueRentalCarPage.loginVerify.click();
            Assert.assertTrue(blueRentalCarPage.loginVerify.isDisplayed());
            blueRentalCarPage.logout.click();
            blueRentalCarPage.okButton.click();
        }
    }
}
