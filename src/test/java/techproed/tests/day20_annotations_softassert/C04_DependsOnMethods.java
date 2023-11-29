package techproed.tests.day20_annotations_softassert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C04_DependsOnMethods {

    /*
    Test NG de DependsOnMethod özelliğini kullanarak bazı testlerin bağımlı olduğu diğer testlerin başarılı
    olma durumuna gmre çalıştırabilirsiniz.
    DependsOnMethod bağlandığı testin sonucuna bakar, Passed olursa çalışır fail olursa hiç çalışmaz
     */


    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void test01() {

        //amazon sayfasina gidiniz
        driver.get("https://amazon.com");

        //arama kutusunda iphone aratiniz
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iphone");
        searchBox.submit();
    }


    @Test(dependsOnMethods = "test01")
    public void test02() {

        //sonuc yazisinin iphone icerdigini test edelim
        String sonucYazisi =driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]")).getText();
        Assert.assertTrue(sonucYazisi.contains("iphone"));

    }


    @AfterClass
    public void afterClass() {
        driver.close();
    }
}