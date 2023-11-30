package techproed.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {
    private Driver() {
        /*
        POM de Driver classindan object olusturarak getDriver methodu kullanimini engellemeliyiz
        Bu nedenle singleton pattern kullanimi benimsenmistir
        Singleton Pattern : Bir classin farkli classlardan object olusturarak kullanilmasini engellemek icin kullanilir
        bu yüzden constructor i private yaptik
         */
    }

    static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {
            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                default:
                    driver = new ChromeDriver();

            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }
    /*
    Driver i her cagirdigimizda yeni bir pencere acmammasi icin bir if bloğu ile ayarlama yaptik
     if(driver==null) ile eger driver a deger atanmamis ise driver i baslat dedik, driver acik iken tekrar cagrilirsa
     driver a deger atanmis oldugu icin if block calismayacak ve dolayisiyla bu method mevcut driver i tekar return edecek
     Böylece ayni driver uzerinden test senaryolarimiza devam edebileceğiz
     */

    /*
    Page Object Model de driver icin TestBase classina extends yaparak kullanmak yerine Driver classi olusturularak bu classtan
    static method araciligi ile driver olusturup kullanmak tercih edilir
     */

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }

}
