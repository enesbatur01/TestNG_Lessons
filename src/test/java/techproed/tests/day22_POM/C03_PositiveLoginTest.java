package techproed.tests.day22_POM;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalCarPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C03_PositiveLoginTest {
    @Test
    public void test01() {

        //Name: US100201_Admin_Login
        //Description:
        //Admin bilgileriyle giriş
        //Acceptance Criteria:
        //Admin olarak, uygulamaya giriş yapabilmeliyim
        //email : ada@ada.com
        //password: 12345
        //https://www.bluerentalcars.com/
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        BlueRentalCarPage blueRentalCarPage = new BlueRentalCarPage();
        blueRentalCarPage.loginButton.click();
        blueRentalCarPage.email.sendKeys(ConfigReader.getProperty("blueRentalEmail"));
        blueRentalCarPage.password.sendKeys(ConfigReader.getProperty("blueRentalPassword"), Keys.ENTER);
        ReusableMethods.visibleWait(blueRentalCarPage.loginVerify,15);
        ReusableMethods.screenShot("BlueRentalLoginVerify");
        Assert.assertTrue(blueRentalCarPage.loginVerify.isDisplayed());
        Driver.closeDriver();

    }
}
