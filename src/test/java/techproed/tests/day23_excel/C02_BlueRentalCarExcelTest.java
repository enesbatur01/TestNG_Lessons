package techproed.tests.day23_excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalCarPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;

public class C02_BlueRentalCarExcelTest {
    @Test
    public void test01() {
        //BlueRentalCar sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        //Login buttonuna tıklayalım
        BlueRentalCarPage blueRentalCarPage = new BlueRentalCarPage();
        blueRentalCarPage.loginButton.click();
        //Excel dosyasındaki herhangi bir email ve password ile login olalım
        ExcelReader excelReader = new ExcelReader(ConfigReader.getProperty("smokeTestDataExcelPath"),ConfigReader.getProperty("smokeTestDataExcelSheetName"));
        blueRentalCarPage.email.sendKeys(excelReader.getCellData(1,0));
        blueRentalCarPage.password.sendKeys(excelReader.getCellData(1,1), Keys.ENTER);
        //Girilen email ile giriş yapıldığını doğrulayın
        blueRentalCarPage.loginVerify.click();
        blueRentalCarPage.profile.click();
        Assert.assertEquals(blueRentalCarPage.profileEmail.getText(),excelReader.getCellData(1,0));
        //sayfayı kapatalım
        Driver.closeDriver();
    }
}
