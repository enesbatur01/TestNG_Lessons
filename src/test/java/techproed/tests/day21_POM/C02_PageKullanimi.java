package techproed.tests.day21_POM;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import techproed.pages.AmazonPage;
import techproed.utilities.Driver;

public class C02_PageKullanimi {
    @Test(groups = "smoke")
    public void test01() {

        //amazon sayfasina gidelim
        Driver.getDriver().get("https://amazon.com");
        Driver.getDriver().navigate().refresh();
        Driver.getDriver().navigate().refresh();


        //arama kutusunda iphone aratalim
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.searcBox.sendKeys("iphone", Keys.ENTER);



    }
}
