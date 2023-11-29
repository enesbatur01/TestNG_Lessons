package techproed.tests.day21_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage;
import techproed.utilities.Driver;

public class C03_PageKullanimi {
    @Test
    public void test01() {
        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //kullaniciAdi, kullaniciSifre, submitButton elementlerini locate edelim login olalım
        OpenSourcePage openSourcePage = new OpenSourcePage();
        //kullanici=Admin
        openSourcePage.userName.sendKeys("Admin");
        //kullaniciSifre=admin123
        openSourcePage.password.sendKeys("admin123");
        openSourcePage.loginButton.click();
        //Login Testinin basarili oldugunu test edelim
        Assert.assertTrue(openSourcePage.dashBoard.isDisplayed());
        //sayfayı kapatalim
        Driver.closeDriver();

    }
}
