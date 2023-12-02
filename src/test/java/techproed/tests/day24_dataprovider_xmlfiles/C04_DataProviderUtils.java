package techproed.tests.day24_dataprovider_xmlfiles;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.DataProviderPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.DataProviderUtilities;
import techproed.utilities.Driver;

public class C04_DataProviderUtils {

    @Test(dataProvider = "positiveTestData",dataProviderClass = DataProviderUtilities.class)
    public void test01(int ageData) {

        //https://dataprovider.netlify.app/ adresine gidelim
        Driver.getDriver().get(ConfigReader.getProperty("netlifyUrl"));
        //BlackBoxTesting techniques ile otomasyon test yapalim
        DataProviderPage dataProviderPage = new DataProviderPage();
        dataProviderPage.searcBox.sendKeys(String.valueOf(ageData),Keys.TAB, Keys.ENTER);
        Assert.assertTrue(dataProviderPage.positiveVerifyMessage.isDisplayed());
        Driver.closeDriver();


    }
}
