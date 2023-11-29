package techproed.tests.day20_annotations_softassert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;

public class C03_Ignore {
    WebDriver driver;


    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test @Ignore
    public void youtubeTest() {
        driver.get("https://youtube.com");
        /*
     @Ignore annotation i bu testin calistirilirken görmezden gelmek icin kullanilir, Bu notasyona sahip test methodu calistirilmaz
     */
    }


    @Test(enabled=false)
    public void amazonTest() {
        driver.get("https://amazon.com");
        /*
            @Test(enabled = false) parametresi bu testin devre disi birakilmasini saglar
            Bu yöntem kalici olarak devre disi birakmak icin kullanilr
         */
    }
    @Test
    public void facebookTest() {
        driver.get("https://facebook.com");
        boolean dosyaYolu=false;

        if (dosyaYolu==true){
            System.out.println("testi çalıştır");
        }else {
            throw new SkipException("Excel dosyası bağlantısında dosya bulunamadı");
        }
        /*
        Bu testte SkipException kullanarak testin çalıştırılmasını run time da dynamic olarak durdurabiliriz
        SkipException fırlatıldığında test "Skipped" olarak işaretlenir dolayısıyla bu yöntem testin belirli
        koşullar altında atlanması gerektiğinde kullanılabilir
         */
    }


        @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
