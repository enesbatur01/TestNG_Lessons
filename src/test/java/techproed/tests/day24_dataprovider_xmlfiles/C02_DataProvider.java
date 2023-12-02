package techproed.tests.day24_dataprovider_xmlfiles;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.AmazonPage;
import techproed.pages.GooglePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C02_DataProvider {
 /*
    1) Bir data provideri birden fazla test methodu icin kullanmak mumkundür

    2) Bir data provideri belli methodlara özel olarak specificlesitirebiliriz
    Bunu yapmak icin @DataProvider(name = "googleurunler") seklinde parantez icinde name parametresi tanimlariz
    bu sekilde vermis olduguumz isim dataproviderin kendi ismini gecersiz kilar yani artik bu isim gecerli olur
    böylece bu dataprovider sadece bu isme sahip olan test methoduna data provide eder
     */

    @DataProvider(name="googleproducts")
    public static Object[][] products() {
        return new Object[][]{
                {"Hundai i20"},
                {"Tesla tuscon"},
                {"Laptop"},
        };
    }

    @DataProvider
    public static Object[][] amazonproducts() {
        return new Object[][]{
                {"Hundai i20"},
                {"Tesla tuscon"},
                {"Laptop"},
        };
    }

    @Test(dataProvider = "googleproducts")
    public void test01(String data) {
        //Google sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));
        //DataProvider ile istediğimiz arac isimlerini aratalım
        new GooglePage().searchBox.sendKeys(data, Keys.ENTER);

        //sayfayı kapatalım
        Driver.closeDriver();

    }



    @Test(dataProvider = "amazonproducts")
    public void test02(String data) {
        //amazon sayfasına gidelim,
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        //aramakutusunda dataprovider'dan gelen verileri aratalım
        new AmazonPage().searcBox.sendKeys(data,Keys.ENTER);
        //sayfayı kapatınız
        Driver.closeDriver();

    }
}
