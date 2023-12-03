package techproed.tests.day25_xmlfiles_paralleltesting;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalCarPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C03_DataProviderParallelTest {

    @DataProvider(parallel = true)
    public static Object[][] information() {
        return new Object[][]{
                {"ayhancan@bluerentalcars.com", "ayhan"},
                {"beyhancan@bluerentalcars.com", "beyhan"},
                {"seyhan@bluerentalcars.com", "seyhan"},
                {"johnson@bluerentalcars.com", "johnson"}
        };
    }

    @Test(dataProvider = "information",invocationCount = 2)
    public void test01(String email ,String password) {

/*
       BlueRentalCar Sayfasına Gidelim
       Login butonuna tıklayalım
       Dataprovider Kullanarak verilen email ve password bilgileri ile login olalım
       Sayfayı kapatalım

           {"ayhancan@bluerentalcars.com", "ayhan"},
          {"beyhancan@bluerentalcars.com", "beyhan"},
          {"seyhan@bluerentalcars.com", "seyhan"},
          {"johnson@bluerentalcars.com", "johnson"}
*/
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        BlueRentalCarPage blueRentalCarPage = new BlueRentalCarPage();
        blueRentalCarPage.loginButton.click();
        blueRentalCarPage.email.sendKeys(email);
        blueRentalCarPage.password.sendKeys(password, Keys.ENTER);
        Driver.closeDriver();
    }
}