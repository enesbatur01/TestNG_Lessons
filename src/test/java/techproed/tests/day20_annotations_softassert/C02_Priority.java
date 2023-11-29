package techproed.tests.day20_annotations_softassert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_Priority {
    WebDriver driver;


    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    //Default olarak sifir oldugu icin ikinci olarak bu method calisti
    @Test
    public void youtubeTest() {
        driver.get("https://youtube.com");
    }

    //priority 2 oldugu icin en son bu method calisti
    @Test(priority = 2)
    public void amazonTest() {
        driver.get("https://amazon.com");
    }

    //prioritysi en kücük olan test methodu bu oldugu icin en önce bu calisti
    @Test(priority = -1)
    public void facebookTest() {
        driver.get("https://facebook.com");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
