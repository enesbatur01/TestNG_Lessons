package techproed.tests.day22_POM;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalCarPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C04_NegativeLoginTest {
    @Test
    public void test01() {
        //Name:
        //US100208_Negative_Login
        //Description:
        //Kullanimda olmayan kullanıcı adi ve şifre ile giriş yapilamamali
        //Acceptance Criteria
        //Customer email: fake@bluerentalcars.com
        //Customer password: fakepass
        //Error:
        //User with email fake@bluerentalcars.com not found
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        BlueRentalCarPage blueRentalCarPage = new BlueRentalCarPage();
        blueRentalCarPage.loginButton.click();
        blueRentalCarPage.email.sendKeys(ConfigReader.getProperty("blueRentalNegativeEmail"));
        blueRentalCarPage.password.sendKeys(ConfigReader.getProperty("blueRentalNegativePassword"), Keys.ENTER);
        ReusableMethods.visibleWait(blueRentalCarPage.failLoginMessage,15);
        ReusableMethods.screenShotOfWebElement(blueRentalCarPage.failLoginMessage);
        Assert.assertTrue(blueRentalCarPage.failLoginMessage.isDisplayed());
        Driver.closeDriver();
    }
}
